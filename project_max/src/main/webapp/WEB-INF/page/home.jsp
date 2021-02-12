<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import ="java.util.ArrayList" %>

<%@page import ="com.java.entity.Stock" %>
<%@page import ="com.java.entity.Addcard" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Medicine list</title>
</head>
<body>
<% ArrayList<Stock> userlist=(ArrayList<Stock>)request.getAttribute("list"); %>

<%
String msg=(String)request.getAttribute("msg");

out.println(msg);
%>	
	<center>
	<h2>Medicine List</h2>

	<table border="1">
	
	
	<tr>
		<th>Id</th>
		<th>Medicine Name</th>
		<th>Description</th>
		<th>Quantity</th>
		<th>Prize</th>
		<th>Total</th>
		
	</tr>
	<%
	
	for(Stock stock:userlist)
	{
	%>
	<tr>
		<td><%out.println(stock.getId()); %></td>
		<td><%out.println(stock.getName()); %></td>
		<td><%out.println(stock.getDescription()); %></td>
		<td><%out.println(stock.getQuantity()); %></td>
		<td><%out.println(stock.getPrize()); %></td>
		<td><%out.println(stock.getTotal()); %></td>
		
		
		<td><a href="deletestock?id=<%=stock.getId() %>">Delete</a></td>
		<td><a href="addcard">Add Card</a></td>
	<td><a href="addmed?id=<%=stock.getId() %>">AddMedicine</a></td>
	
	
	</tr>
	<%
	}
	%>
	</table>
	
	</center>
</body>
</html>