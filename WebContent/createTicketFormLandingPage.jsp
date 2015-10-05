<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/mystyle.css" rel="stylesheet" type="text/css" />
<title>Welcome!</title>
</head>
<body>
	<div id="wrapper">
		<%@include file="Header.jsp"%>
		<div></div>
		<div id="contains_body">
			<div id="LeftLinks">
				<%@ include file="LeftLinks.jsp"%>
			</div>
			<div id="body_content" align="center">
				<%@ include file="CreateTicket.jsp"%>
			</div>
		</div>
	</div>
</body>
</html>