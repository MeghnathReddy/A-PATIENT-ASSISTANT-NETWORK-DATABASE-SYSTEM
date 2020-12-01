<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Query Result</title>
</head>
 <body>
 <%@page import="client_db.DataHandler"%>
 <%@page import="java.sql.ResultSet"%>
 <%@page import="java.sql.Array"%>
 <%
 // The handler is the one in charge of establishing the connection.
 DataHandler handler = new DataHandler();
 // Get the attribute values passed from the input form.
 String T_Name = request.getParameter("T_Name");
 String Type = request.getParameter("Type");
 String Date_T = request.getParameter("Date_T");
 /*
 * If the user hasn't filled out all the time, movie name and duration. This is very
simple checking.
 */
 if (T_Name.equals("") || Type.equals("") || Date_T.equals("")) {
 response.sendRedirect("add_movie_form.jsp");
 } else {
 int Date_T1 = Integer.parseInt(Date_T);

 // Now perform the query with the data from the form.
 boolean success = handler.addMovie(T_Name, Type, Date_T1);
 if (!success) { // Something went wrong
%>
<h2>There was a problem inserting the Team</h2>
 <%
 } else { // Confirm success to the user
 %>
 <h2>Team Table:</h2>
 <ul>
 <li>T_Name: <%=T_Name%></li>
 <li>Type : <%=Type%></li>
 <li>Date_T: <%=Date_T%></li>

 </ul>
 <h2>Was successfully inserted.</h2>

 <a href="get_all_movies.jsp">See Teams Table.</a>
 <%
 }
 }
 %>
 </body>
</html>