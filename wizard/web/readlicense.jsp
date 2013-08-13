<%-- 
    Document   : readlicense
    Created on : Mar 23, 2009, 4:14:17 PM
    Author     : hantsy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Read User License!</h1>
        <stripes:errors/>
        <div style="height:300pt;width:500pt">
            License,License,License,License,License,License,
            License,License,License,License,License,License,
            License,License,License,License,License,License,
            License,License,License,License,License,License,
            License,License,License,License,License,License,
        </div>
        <stripes:form beanclass="tutorial.action.RegisterActionBean">
            <stripes:checkbox name="acceptLicense"/> I have read the license and gree with the content.
            <stripes:submit name="prepareRegister" value="I Agree"/>
        </stripes:form>
    </body>
</html>
