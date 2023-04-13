<%-- 
    Document   : new1
    Created on : Dec 28, 2022, 8:09:18 AM
    Author     : hp
--%>
<%!
  int a, b;  
%> 
<%
 int c;
 a=4; b=5;
 c=a+b;
 request.setAttribute("x",a);
 request.setAttribute("y",b);
%>    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
          <%= a %> + <%= b %> = <%= c %>
        </h1>
        <h2>
          <%= a %> + <%= b %> = ${x+y}
        </h2>
    </body>
</html>
