<%-- 
    Document   : index
    Created on : Mar 11, 2009, 3:57:13 PM
    Author     : hantsy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%@taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Stripes!</h1>
        <stripes:form beanclass="tutorial.action.HelloActionBean" method="post">
            <div><stripes:text name="message"/></div>
            <div><stripes:submit name="sayHello" value="Say Hello"/></div>
        </stripes:form>
    </body>
</html>
