package com.project.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;

import com.project.utilities.ConnectionUtil;

/** Description of <code>Ticket</code> class. 
* <p>
* This class models the ticket. It has a method <code> createDBEntry() </code> and the following fields - 
* <br>
* <code> ticketID </code> - Automatically generated and incremented ticketID in the  database.
* <br>
* <code> ticketDate </code> - The date ticket was created.
* <br>
* <code> bugTitle </code> - The title of the bug.
* <br>
* <code> bugDescription </code> - The description of the bug.
* <br>
* <code> projectName </code> - The name of the project for which bug was observed.
* <br>
* <code> projectVersion </code> - The version of the project for which bug was observed.
* <br>
* <code> assignedToDevName </code> - The Developer's name to whom the ticket will be assigned.
* <br>
* <code> ticketPriority </code> - The priority of the ticket.
* <br>
* <code> ticketStatus </code> - The current status of the ticket.
* <br>
* <code> comments </code> - Comments for the bug observed.
* <br>
* <code> targetDueDate </code> - Date by which the ticket is expected to be closed.
* <br>
* <code> resolvedDate </code> - Date when the ticket is actually closed.
* <br>
* <code> TicketCreatedBy </code> - The tester's EmployeeID who created the ticket.
* <p>
* @author Poorva Jambhale
* @version 1.0 May 1, 2015.
*/

public class Ticket {
	
	private int ticketId;
	private Date ticketDate;
	private String bugTitle;
	private String bugDescription;
	private String bugCategory;
	private String projectName; 
	private String projectVersion;
	private String assignedToDevName;
	private String ticketPriority;
	private String ticketStatus;
	private String comments;
	private Date targetDueDate;
	private Date resolvedDate;
	private String TicketCreatedBy;
	
	public static final String TICKET_STATUS_OPEN = "Open";
	public static final String TICKET_STATUS_CLOSED = "Closed";
	
	/** Description of <code>Ticket()</code> constructor. 
	 * The constructor is called when a new ticket is created. It assigns the <code> ticketStatus = Open </code> 
	 * as every new ticket is initially open until it is worked upon and closed.
	 * @param none
	 */
	public Ticket() {
		ticketStatus = TICKET_STATUS_OPEN;
	}
	
	/** Description of <code>getticketId()</code> method. 
	 * The is a getter method for ticketID.
	 * @param none
	 * @return ticketID
	 */
    public int getticketId() {
    	return ticketId;
    }
    
	/** Description of <code>setticketId()</code> method. 
	 * The is a setter method for ticketId.
	 * @param ticketID
	 * @return void
	 */
    public void setticketId(int ticketId) {
		this.ticketId = ticketId;
	}
    
	/** Description of <code>getTicketDate()</code> method. 
	 * The is a getter method for ticketDate.
	 * @param none
	 * @return ticketDate
	 */
	public Date getTicketDate() {
		return ticketDate;
	}
	
	/** Description of <code>setTicketDate()</code> method. 
	 * The is a setter method for ticketDate.
	 * @param ticketDate
	 * @return void
	 */
	public void setTicketDate(Date ticketDate) {
		this.ticketDate = ticketDate;
	}
	
	/** Description of <code>getBugTitle()</code> method. 
	 * The is a getter method for bugTitle.
	 * @param none
	 * @return bugTitle
	 */
	public String getBugTitle() {
		return bugTitle;
	}
	
	/** Description of <code>setBugTitle()</code> method. 
	 * The is a setter method for bugTitle.
	 * @param bugTitle
	 * @return void
	 */
	public void setBugTitle(String bugTitle) {
		this.bugTitle = bugTitle;
	}
	
	/** Description of <code>getBugDescription()</code> method. 
	 * The is a getter method for bugDescription.
	 * @param none
	 * @return bugDescription
	 */
	public String getBugDescription() {
		return bugDescription;
	}
	
	/** Description of <code>setBugDescription()</code> method. 
	 * The is a setter method for bugDescription.
	 * @param bugDescription
	 * @return void
	 */
	public void setBugDescription(String bugDescription) {
		this.bugDescription = bugDescription;
	}
	
	/** Description of <code>getBugCategory()</code> method. 
	 * The is a getter method for bugCategory.
	 * @param none
	 * @return bugCategory
	 */
	public String getBugCategory() {
		return bugCategory;
	}
	
	/** Description of <code>setBugCategory()</code> method. 
	 * The is a setter method for bugCategory.
	 * @param bugCategory
	 * @return void
	 */
	public void setBugCategory(String bugCategory) {
		this.bugCategory = bugCategory;
	}
	
	/** Description of <code>getProjectName()</code> method. 
	 * The is a getter method for projectName.
	 * @param none
	 * @return projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	
	/** Description of <code>setProjectName()</code> method. 
	 * The is a setter method for projectName.
	 * @param projectName
	 * @return void
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	/** Description of <code>getProjectVersion()</code> method. 
	 * The is a getter method for projectVersion.
	 * @param none
	 * @return projectVersion
	 */
	public String getProjectVersion() {
		return projectVersion;
	}
	
	/** Description of <code>setProjectVersion()</code> method. 
	 * The is a setter method for projectVersion.
	 * @param projectVersion
	 * @return void
	 */
	public void setProjectVersion(String projectVersion) {
		this.projectVersion = projectVersion;
	}
	
	/** Description of <code>getAssignedToDevName()</code> method. 
	 * The is a getter method to get developer's name.
	 * @param none
	 * @return assignedToDevName
	 */
	public String getAssignedToDevName() {
		return assignedToDevName;
	}
	
	/** Description of <code>setAssignedToDevName()</code> method. 
	 * The is a setter method for setting developer's name.
	 * @param assignedToDevName
	 * @return void
	 */
	public void setAssignedToDevName(String assignedToDevName) {
		this.assignedToDevName = assignedToDevName;
	}
	
	/** Description of <code>getPriority()</code> method. 
	 * The is a getter method to get priority of the ticket.
	 * @param none
	 * @return ticketPriority
	 */
	public String getPriority() {
		return ticketPriority;
	}
	
	
	/** Description of <code>setPriority()</code> method. 
	 * The is a setter method for setting ticket priority.
	 * @param priority
	 * @return void
	 */
	public void setPriority(String priority) {
		this.ticketPriority = priority;
	}
	
	/** Description of <code>getStatus()</code> method. 
	 * The is a getter method to get status of the ticket.
	 * @param none
	 * @return ticketStatus
	 */
	public String getStatus() {
		return ticketStatus;
	}
	
	/** Description of <code>setStatus()</code> method. 
	 * The is a setter method for setting ticket status.
	 * @param status
	 * @return void
	 */
	public void setStatus(String status) {
		this.ticketStatus = status;
	}
	
	/** Description of <code>getComments()</code> method. 
	 * The is a getter method to get comments of the ticket.
	 * @param none
	 * @return comments
	 */
	public String getComments() {
		return comments;
	}
	
	/** Description of <code>setComments()</code> method. 
	 * The is a setter method for setting ticket comments.
	 * @param comments
	 * @return void
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	/** Description of <code>getTargetDueDate()</code> method. 
	 * The is a getter method to get targetDueDate of the ticket.
	 * @param none
	 * @return targetDueDate
	 */
	public Date getTargetDueDate() {
		return targetDueDate;
	}
	
	/** Description of <code>setTargetDueDate()</code> method. 
	 * The is a setter method for setting ticket targetDueDate.
	 * @param targetDueDate
	 * @return void
	 */
	public void setTargetDueDate(Date targetDueDate) {
		this.targetDueDate = targetDueDate;
	}
	
	/** Description of <code>getResolvedDate()</code> method. 
	 * The is a getter method for setting ticket resolvedDate.
	 * @param none
	 * @return resolvedDate
	 */
	public Date getResolvedDate() {
		return resolvedDate;
	}
	
	/** Description of <code>setResolvedDate()</code> method. 
	 * The is a setter method for setting ticket resolvedDate.
	 * @param targetDueDate
	 * @return void
	 */
	public void setResolvedDate(Date resolvedDate) {
		this.resolvedDate = resolvedDate;
	}
	
	/** Description of <code>getTicketCreatedBy()</code> method. 
	 * The is a getter method for setting TicketCreatedBy.
	 * @param none
	 * @return TicketCreatedBy
	 */
	public String getTicketCreatedBy() {
		return TicketCreatedBy;
	}
	
	/** Description of <code>setTicketCreatedBy()</code> method. 
	 * The is a setter method for setting TicketCreatedBy.
	 * @param TicketCreatedBy
	 * @return void
	 */
	public void setTicketCreatedBy(String TicketCreatedBy) {
		this.TicketCreatedBy =TicketCreatedBy ;
	}
	
	 /** Description of <code>createDBEntry</code> method.
	  * The method <code>createDBEntry</code> is called by the <code> servlet </code> controller <code>CreateTicketController</code> 
	  * It builds a strBuf using parameters of the ticket object as SQL query.
	  * It connects to the MySQL database and then executes the query. 
	  * The result is that the entries by the user in the jsp are saved in the database.
	  * @param none 
	  * @return i - Integer value for success or failure.
	  */
	public int createDBEntry() {
		int i = 0;
		try {
			Connection con;
			con = ConnectionUtil.getConnection();
			Statement statement = con.createStatement();

			StringBuffer strBuf = new StringBuffer();
			strBuf.append("insert into Ticket(ticketID,");
			strBuf.append("ticketDate, ");
			strBuf.append("bugTitle, ");
			strBuf.append("bugDescription, ");
			strBuf.append("bugCategory, ");
			strBuf.append("projectName, ");
			strBuf.append("projectVersion, ");
			strBuf.append("assignedToDev, ");
			strBuf.append("priority, ");
			strBuf.append("status, ");
			strBuf.append("comments, ");
			strBuf.append("targetDueDate, ");
			strBuf.append("ticketCreatedBy ");	
			strBuf.append(") values (last_insert_id(), ");
			strBuf.append("'" + this.ticketDate + "', ");
			strBuf.append("'" + this.bugTitle + "', ");				
			strBuf.append("'" + this.bugDescription + "', ");
			strBuf.append("'" + this.bugCategory + "', ");
			strBuf.append("'" + this.projectName + "', ");
			strBuf.append("'" + this.projectVersion + "', ");
			strBuf.append("'" + this.assignedToDevName + "', ");
			strBuf.append("'" + this.ticketPriority + "', ");
			strBuf.append("'" + this.ticketStatus + "', ");
			strBuf.append("'" + this.comments + "', ");
			strBuf.append("'" + this.targetDueDate + "', ");
			strBuf.append("'" + this.TicketCreatedBy + "'");
			strBuf.append(")");

			i = statement.executeUpdate(strBuf.toString());		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
}