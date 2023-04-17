<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Job" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<%
  List<Job> lst = (List<Job>) request.getAttribute("lst");
%>    
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Job</title>
    </head>
    <body>
        <h2> List of Job </h2>
<table border="1">
    <tr>
        <td align="center"> No </td>
        <td align="center"> Job Title </td>
        <td align="center"> Company </td>
        <td align="center"> Year Of Experience </td>
        <td  colspan="2" align="center">  Operator </a> </td>
        <td align="center"> Description </td>
    </tr>
    <%
      for(Job x: lst) {
    %>
    <tr>
        <td><%= x.getNo() %> </td>
        <td><%= x.getJob_Title() %> </td>
        <td><%= x.getCompany() %> </td>
        <td><%= x.getYear_Of_Experience() %> </td>
        <td><a href="update?No=<%=x.getNo() %>">  Edit </a> </td>
        <td><a href="delete1?No=<%=x.getNo() %>">  Delete </a> </td>
        <td><%= x.getDescription() %> </td>
    </tr>  
    <% } %>  
</table>     
<p><button onclick='window.history.go(-1);'>Back to previous page</button>
<p><a href="index.html">Back to homepage</a>
</body>
</html>
