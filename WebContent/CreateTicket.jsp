<!DOCTYPE html>
<%@page import="com.project.utilities.ConnectionUtil"%>
<html>
<%@page import= "java.sql.Connection"%>
<%@page import= "java.sql.Statement"%>
<%@page import= "java.sql.ResultSet"%>
<%@page import= "com.project.utilities.*"%>

<head>
	<link href="css/mystyle.css" rel="stylesheet" type="text/css" />
	<title>Create new Ticket</title>
	<script type="text/javascript">
	
	function validateCreateTicketForm() {	
		var ticketDate = document.forms["createTicketForm"]["ticketDate"].value;		
		var bugTitle = document.forms["createTicketForm"]["bugTitle"].value;
		var bugDesc = document.forms["createTicketForm"]["bugDesc"].value;
		var bugCategory = document.forms["createTicketForm"]["bugCategory"].value;
	    var projectName = document.forms["createTicketForm"]["projectName"].value;
	    var projectVersion = document.forms["createTicketForm"]["projectVersion"].value;
	    var devName = document.forms["createTicketForm"]["devName"].value;
	    var ticketPriority = document.forms["createTicketForm"]["ticketPriority"].value;
	    var ticketStatus = document.forms["createTicketForm"]["ticketStatus"].value;
		var targetDate = document.forms["createTicketForm"]["targetDate"].value;
			    
	    if (ticketDate == null || ticketDate == "") {
	    	alert("Ticket Date is required!");	
	    	return false;
	    }
	    
	    if (bugTitle == null || bugTitle == "") {
	    	alert("Bug title is required!");
	    	return false;
	    }
	    if (bugDesc== null || bugDesc == ""){
	    	alert("Bug description is required!");
	    	return false;
	    }
	    if (bugCategory == null || bugCategory == ""){
	    	alert("Bug category is required!");
	    	return false;
	    }
	    if (projectName == null || projectName == ""){
	    	alert("Project name is required!"); 
	    	return false;
	    } 
	    if (projectVersion == null || projectVersion == ""){
	    	alert("Project version is required!");  
 	    	return false;
	    }

	    if (devName == null || devName == ""){
	    	alert("Developer's name is required!");
	    	return false;
	    }
	    if (ticketPriority == null || ticketPriority == ""){
	    	alert("Ticket priority is required!");
	    	return false;
	    }
	   	    
	    if (ticketStatus == null || ticketStatus == ""){
	    	alert("Ticket status is required!");
	    	return false;
	    }
	    if (targetDate == null || targetDate == ""){
	    	alert("Target date is required!");
	    	return false;
	    }
	}
	</script>
</head>
<body>
<h2 align="center"><b>Create new ticket</b></h2>
<h5>Fields with <font color="red">*</font> are mandatory</h5>

<form name="createTicketForm" method="post" action="CreateTicketController" onsubmit="return validateCreateTicketForm()">

<table>
	<tr>
		<td align="right">Ticket date: <font color="red">*</font></td>
		<td align="left"><input type="date" name="ticketDate"></td>
	</tr>
	<tr>
		<td align="right">Bug title: <font color="red">*</font></td>
		<td align="left"><input type="text"  maxlength="100" name="bugTitle"></td>
	</tr>
	<tr>
		<td align="right">Bug Description: <font color="red">*</font></td>
		<td align="left"><textarea rows="3" cols="15" maxlength="45" name="bugDesc"></textarea></td>
	</tr>
	<tr>
		<td align="right">Bug Category: <font color="red">*</font></td>
		<td align="left">
		<select name="bugCategory">
			<option value=""></option>
			<option value="UI">UI</option>
			<option value="Business Logic">Business Logic</option>
			<option value="Database">Database</option>
			<option value="Unknown">Unknown</option>
		</select>
		</td>
	</tr>
	<tr>
		<td align="right">Project Name: <font color="red">*</font></td>
		<td align="left"><input type="text" maxlength="100" name="projectName"></td>
	</tr>
	<tr>
		<td align="right">Project release version: <font color="red">*</font></td>
		<td align="left"><input type="text"maxlength="20" name="projectVersion"></td>
	</tr>
	<tr>
		<td align="right">Assigned to: <font color="red">*</font></td> 
		<td>
		<select name="devName">
		<option value="Select one"></option>
		<%
		try	{
					
			Connection conn= ConnectionUtil.getConnection();
			Statement stmt =  conn.createStatement();

			ResultSet rs = stmt.executeQuery("select * from User where employeeID LIKE 't%' OR employeeID LIKE 'd%'");
			while (rs.next()){
				%>
				<option value="<%out.println(rs.getString(4));%>"><%out.println(rs.getString(2).concat(" ").concat(rs.getString(3)).concat(" (").concat(rs.getString(4)).concat(")"));%> </option>				
				<% 	
			}			

			} catch(Exception ex) {
				
		} 
		%>
	</select>
	</td>	
	</tr>
	<tr>
		<td align="right">Ticket Priority: <font color="red">*</font></td>
		<td align="left">
		<select name="ticketPriority">
			<option value=""></option>
			<option value="High">High</option>
			<option value="Medium">Medium</option>
			<option value="Low">Low</option>
		</select>
		</td>
	</tr>
	<tr>
		<td align="right">Ticket Status: <font color="red">*</font></td>
		<td align="left"> <input type="text" name="ticketStatus" value="Open" readonly>
		</td>
	</tr>
	<tr>
		<td align="right">Comments: </td>
		<td align="left"><textarea rows="3" cols="15" maxlength="45" name="comments"></textarea></td>
	</tr>
	<tr>
		<td align="right">Target date: <font color="red">*</font></td>
		<td align="left"><input type="date" name="targetDate"></td>
	</tr>
	<tr>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td align="center"><input type="submit" value="Create Ticket"> </td>
	</tr>
</table>	   
</form>
</body>
</html>
