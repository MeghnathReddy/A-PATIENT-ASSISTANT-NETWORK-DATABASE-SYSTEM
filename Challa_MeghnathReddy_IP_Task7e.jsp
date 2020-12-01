<!DOCTYPE html>
<html>
 <head>
 <meta charset="UTF-8">
 <title>Add Team</title>
 </head>
 <body>
 <h2>Add a new Team</h2>
 <!--
 Form for collecting user input for the new Team record.
 Upon form submission, add_movie.jsp file will be invoked.
 -->
 <form action=" add_movie.jsp">
 <!-- The form organized in an HTML table for better clarity. -->
 <table border=1>
 <tr>
 <th colspan="2">Enter the new Team data:</th>
 </tr>
 <tr>
 <td>Team Name:</td>
 <td><div style="text-align: center;">
 <input type=text name=T_Name>
 </div></td>
 </tr>
 <tr>
 <td>Team Type:</td>
 <td><div style="text-align: center;">
 <input type=text name=Type>
 </div></td>
 </tr>
 <tr>
 <td>Date:</td>
 <td><div style="text-align: center;">
 <input type=text name=Date_T>
 </div></td>
 </tr>
 <tr>

 <tr>
 <td><div style="text-align: center;">
 <input type=reset value=Clear>
 </div></td>
 <td><div style="text-align: center;">
 <input type=submit value=Insert>
 </div></td>
 </tr>
 </table>
 </form>
 </body>
</html>