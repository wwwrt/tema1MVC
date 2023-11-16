<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.example.Door" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Single Door Page</h1>

<%
Door d = (Door)request.getAttribute("do");
%>
<% if (d!=null) { %>
<p>Watch id: <%= d.getId() %> </p>
<p>Watch material: <%= d.getMaterial() %> </p>
<p>Watch height: <%= d.getHeight()%> </p>
<p>Watch width: <%= d.getWidth()%> </p>
<p>Watch installation date: <%= d.getInstallationDate() %> </p>

<%} %>

</body>
</html>