<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/mystyle.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Ticket Success</title>
</head>
<body>
<div id="wrapper">
		<%@include file="Header.jsp"%>
		<div id="contains_body">
			<div id="LeftLinks">
				<%@ include file= "LeftLinks.jsp"%>
			</div>
			<div id="body_content" align="center">
				<table align="center">
					<tr> 
						<td><p align="center"> Unable to create Ticket. Try again! </p></td>
					</tr>
					<tr>
					<td><a href="createTicketFormLandingPage.jsp"><p style="text-align:center">Back</p></a>
					</tr>
				</table>
			</div>
		</div>
</div>
</body>
</html>