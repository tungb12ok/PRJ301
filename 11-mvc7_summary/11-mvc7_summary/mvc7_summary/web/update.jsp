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
         if(x==null) return;
        %>    
        <h2> Update a Job </h2>
        <form action="update" method="POST">
            <p><input type="text" name="No" value="<%= x.getNo()%>" readonly /> 
            <p><input type="text" name="JobTitle" value="<%= x.getJob_Title()%>"/> 
            <p><input type="text" name="Company" value="<%= x.getCompany() %>"/> 
            <p><input type="text" name="YearOfExperiece" value="<%= x.getYear_Of_Experience()%>" readonly /> 
            <p><input type="text" name="Description" value="<%= x.getDescription() %>"/> 
            <p><input type="submit" value="Update"> 
        </form>  
        <p><button onclick='window.history.go(-1);'>Back to previous page</button>
        <p><a href="index.html">Back to homepage</a>
    </body>
</html>
