<%-- 
    Document   : index
    Created on : Mar 11, 2009, 3:57:13 PM
    Author     : hantsy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload File Page</title>
    </head>
    <body>
        <h1>Upload File!</h1>
        <div><stripes:errors/></div>
        <c:set var="list" value="<%= new Object[5] %>" scope="page"/>
        <stripes:form beanclass="tutorial.action.MultiUploadActionBean" method="post">
            <c:forEach items="${list}" varStatus="loop">
                <div>File ${loop.index+1}: <stripes:file name="uploadFiles[${loop.index}]"/></div>
            </c:forEach>
            <div><stripes:submit name="upload" value="Upload Now"/></div>
        </stripes:form>
    </body>
</html>
