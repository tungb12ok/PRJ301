<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<!DOCTYPE html>
<html>
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search result</title>
  </head>
  <body>
     <%
       Job x = (Job) request.getAttribute("x");
     %>    
     <h2>Job found:</h2>
     <h3>No: <%= x.getNo() %> </h3>
     <h3>Job Title: <%= x.getJob_Title() %> </h3>
     <h3>Company: <%= x.getCompany() %> </h3>
     <h3>Year Of Experience: <%= x.getYear_Of_Experience() %> </h3>
     <h3>Description: <%= x.getDiscription() %> </h3>
     <a href="delete2?rollno=<%=x.getNo() %>"> Confirm to delete </a>
     <p><button onclick='window.history.go(-1);'>Back to previous page</button>
     <p><a href="index.html">Back to homepage</a>
  </body>
</html>
