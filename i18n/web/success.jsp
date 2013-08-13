<%-- 
    Document   : success
    Created on : Mar 15, 2009, 7:38:07 PM
    Author     : hantsy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Result Page</title>
    </head>
    <body>
        <h1>Registered Successfully!</h1>
        <div>Your username is: ${actionBean.username}. </div>
        <div>Free subscription: ${actionBean.subscriptionEnabled}</div>
    </body>
</html>
