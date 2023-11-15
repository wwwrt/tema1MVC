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

<h1>Single Watch Page</h1>

<%
Door w = (Door)request.getAttribute("wa");
%>
<% if (w!=null) { %>
<p>Watch id: <%= w.getId() %> </p>
<p>Watch brand: <%= w.getBrand() %> </p>
<p>Watch price: <%= w.getPrice() %> </p>
<%} %>

</body>
</html>