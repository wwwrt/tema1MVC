<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.example.Door"  %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>All doors page</h1>
<% ArrayList<Door> doors = (ArrayList<Door>) request.getAttribute("doors"); %>
<% int numberOfDoors; %>
<% if (doors != null ) { %>
<% numberOfDoors = doors.size(); %>
<% } else { %>
<%  numberOfDoors = 0; %>
<% } %>

<p> Number of watches: <%= numberOfDoors %></p>

<table border="1">
	<tr>
		<th>ID</th>
		<th>MATERIAL</th>
		<th>HEIGHT</th>
		<th>WIDTH</th>
		<th>INSTALLATION DATE</th>
	</tr>
	
	<% for(Door d : doors) { %>
		<tr>
			<td> <%= d.getId() %> </td>
			<td> <%= d.getMaterial() %> </td>
			<td> <%= d.getHeight() %> </td>
			<td> <%= d.getWidth() %> </td>
			<td> <%= d.getInstallationDate() %> </td>
		</tr>
	<% } %>	
</table>

</body>
</html>