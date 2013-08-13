<%-- 
    Document   : success
    Created on : Mar 15, 2009, 7:38:07 PM
    Author     : hantsy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Result Page</title>
    </head>
    <body>
        <h1>Uploaded Successfully!</h1>
        <p>File Name is:</p>
        <c:forEach items="${actionBean.uploadFiles}" var="fileVar" varStatus="loop">
            <c:if test="${fileVar !=null}">
                <div>${fileVar.fileName}</div>
            </c:if>
        </c:forEach>
    </body>
</html>
