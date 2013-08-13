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
        <title>Download File Page</title>
    </head>
    <body>
        <h1>Download File!</h1>
        <div><stripes:errors/></div>
        <div>Fedora BackGround:</div>
        <stripes:link beanclass="tutorial.action.DownloadActionBean">
            <img src="${pageContext.servletContext.contextPath}/public/Fedora.png" style="border:0; width:25pt; height:20pt"/>
            <stripes:param name="filename" value="fedora-bg.png"/>
        </stripes:link>
    </body>
</html>
