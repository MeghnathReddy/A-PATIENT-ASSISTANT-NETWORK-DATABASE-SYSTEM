<!DOCTYPE html>
<html>
 <head>
 <meta charset="UTF-8">
 <title>Team</title>
 </head>
 <body>
 <h2>Found date</h2>
 <!--
 Form for collecting user input for the new Team record.
 Upon form submission, add_movie.jsp file will be invoked.
 -->
 <form action=" add_movie1.jsp">
 <!-- The form organized in an HTML table for better clarity. -->
 <table border=1>
 <tr>
 <th colspan="2">Enter the data:</th>
 </tr>
 <tr>
 <td>Date_T:</td>
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