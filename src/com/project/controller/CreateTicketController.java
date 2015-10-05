package com.project.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.model.Ticket;
import com.project.utilities.ConnectionUtil;
import com.project.utilities.EmailUtil;


/**
 * The CreateTicketController class is a <code>servlet</code> controller that receives input from the user through 
 * CreateTicket.jsp in the form of HttpServletRequest. It sends the request to <code> createANewTicket() </code> to create a new ticket, 
 * save it to the database. The <code> createANewTicket() </code> method calls the <code> SendEmailToUser()</code> to send an email notification
 * to the developer to whom the new ticket was assigned.
 * <p> The different views are:
 * <ul>
 * 	<li> CreateTicketSuccess.jsp  -- When new ticket is successfully created and saved in the database.
 * 	<li> CreateTicketError.jsp		-- When new ticket creation or saving the ticket to database fails.
 * </ul>
 * 
 * @author Poorva Jambhale
 * @version 1.0 May 1, 2015.
 */
public class CreateTicketController extends HttpServlet{
	 private static final long serialVersionUID = 1L;
	 
	 public CreateTicketController() {
	        super();
	 }
	 
	 /** 
	  * The doPost() method gets the HTTP request  and defines a <code> RequestDispatcher </code>.
	  * It gets the parameters from the <code>createTicket.jsp</code>. It then calls the method <code>createANewTicket()</code> 
	  * to create a new ticket object and calls method <code>createDBEntry()</code>save it to the database.
	  * Once the ticket is saved into database successfully, the request is dispatched <code> CreateTicketSuccess.jsp </code> view.
	  * If not successful, the request is dispatched <code> Error.jsp </code> view with an error message.
	  * @param request, response
	  * @return void
	  * @throws ServletException, IOException
	  */
	 protected void doPost(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
	  
		 RequestDispatcher rd = null;
		 
		 try {
			 
			 	String ticketDateStr = request.getParameter("ticketDate");
			 	String bugTitle  = request.getParameter("bugTitle");
			 	String bugDescription = request.getParameter("bugDesc");
			 	String bugCategory = request.getParameter("bugCategory");		
			 	String projectName = request.getParameter("projectName");
			 	String projectVersion = request.getParameter("projectVersion");
			 	String devName = request.getParameter("devName");
			 	String ticketPriority = request.getParameter("ticketPriority");
			 	String comments = request.getParameter("comments");
			 	String targetDueDateStr = request.getParameter("targetDate");

				HttpSession session = request.getSession();
				String ticketCreatedBy = (String) session.getAttribute("username");
			 	
			 	String result = createANewTicket(ticketDateStr, bugTitle, bugDescription, bugCategory, projectName, projectVersion, devName, ticketPriority, comments, targetDueDateStr, ticketCreatedBy);
				if (result.equals("success")) {
								
					rd = request.getRequestDispatcher("/CreateTicketSuccess.jsp");
					
				} else {
					
					rd = request.getRequestDispatcher("/CreateTicketError.jsp");
				}	 
				
				rd.forward(request, response);
				
	 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

		
	 /**
	  * The method <code>createANewTicket</code> is called by the <code> servlet </code> controller <code>CreateTicketController</code> 
	  * It creates a ticket object. The instance fields of this object 
	  * are set by calling the setter methods in the <code> Ticket </code> model. Then the method <code> createDBEntry() </code> is called 
	  * to save the ticket into the Database. Once the ticket is successfully saved into the Database, the method <code> SendEmailToUser() </code>
	  * is called to send email notification.
	  * @param request - HttpServletRequest.
	  * @return "success" or "error" - String.
	  * @throws Exception.
	  */
	 public String createANewTicket(String ticketDateStr, String bugTitle, String bugDescription, String bugCategory, 
			 	String projectName, String projectVersion, String devName, String ticketPriority, String comments, String targetDueDateStr, String ticketCreatedBy) throws Exception {
		 try {
			 
			 DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
	 
			 Ticket t = new Ticket();
			
			 java.sql.Date ticketDate = new java.sql.Date(format.parse(ticketDateStr).getTime());
			 t.setTicketDate(ticketDate);
				
			 java.sql.Date targetDueDate = new java.sql.Date(format.parse(targetDueDateStr).getTime());
			 t.setTargetDueDate(targetDueDate);
			 
			 t.setBugTitle(bugTitle);
			 t.setBugDescription(bugDescription);
			 t.setBugCategory(bugCategory);
			 t.setProjectName(projectName);	
			 t.setProjectVersion(projectVersion);
			 t.setAssignedToDevName(devName);
			 t.setPriority(ticketPriority);
			 t.setComments(comments);
			 t.setTicketCreatedBy(ticketCreatedBy);

			 int i = t.createDBEntry();

			 if (i != 0) {
				 SendEmailToUser(devName);
				 return "success";
			 } else {
				 return "error";
			 }
		 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 return "error";
		 }		
	 }	

	 /** Description of <code>SendEmailToUser</code> method.
	  * The method <code>SendEmailToUser</code> is called by the <code>createANewTicket</code> method once the ticket is successfully saved into the database.
	  * This method retrieves the emailID from the database of the developer to whom the new ticket was assigned and 
	  * sends and email notification to him saying new ticket was assigned to him.
	  * @param DevEmployeeID
	  * @return void
	  * @throws Exception	
	  */
	 public void SendEmailToUser(String DevEmployeeID) throws Exception{

		 try {

			 StringBuffer strBuf = new StringBuffer();
			 strBuf.append("select email from User where employeeID = '"+ DevEmployeeID +"'");
			 Connection con = ConnectionUtil.getConnection();
			 Statement statement = con.createStatement();
			 ResultSet rs = statement.executeQuery(strBuf.toString());

			 String email="";
			 while (rs.next()) {
				 email = rs.getString("email");
			 }

			 String Emailsubject = "New Ticket is assigned to you.";
			 String EmailContent = "A new ticket was created and assigned to you in the bug tracker.";
			 EmailUtil SendEmailtoUser = new EmailUtil();
			 SendEmailtoUser.SendEmail(email, Emailsubject, EmailContent);

		 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();

		 } catch (Exception e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }	
	 }
}
