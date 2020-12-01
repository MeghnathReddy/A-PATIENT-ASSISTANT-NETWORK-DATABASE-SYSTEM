<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
 <meta charset="UTF-8">
 <title>Teams Table</title>
 </head>
 <body>
 <%@page import="client_db.DataHandler"%>
 <%@page import="java.sql.ResultSet"%>
 <%
 // We instantiate the data handler here, and get all the movies from the database
 final DataHandler handler = new DataHandler();
 final ResultSet movies = handler.getAllMovies();
 %>
 <!-- The table for displaying all the movie records -->
 <table cellspacing="2" cellpadding="2" border="1">
 <tr> <!-- The table headers row -->
 <td align="center">
 <h4>T_Name</h4>
 </td>
 <td align="center">
 <h4>Type</h4>
 </td>
 <td align="center">
 <h4>Date_T</h4>
 
 </td>
 </tr>
 <%
 while(movies.next()) { // For each Teams record returned...
 // Extract the attribute values for every row returned
final String T_Name = movies.getString("T_Name");
final String Type = movies.getString("Type");
final String Date_T = movies.getString("Date_T");
out.println("<tr>"); // Start printing out the new table row
out.println( // Print each attribute value
 "<td align=\"center\">" + T_Name +
 "</td><td align=\"center\"> " + Type +
 "</td><td align=\"center\"> " + Date_T );
 out.println("</tr>");
 }
 
 %>
 </table>
 </body>
</html>