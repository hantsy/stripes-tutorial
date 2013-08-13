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
        <title>Upload File Page</title>
    </head>
    <body>
        <h1>Upload File</h1>
        <div><stripes:errors/></div>
        <stripes:form beanclass="tutorial.action.UploadActionBean" method="post">
            <div><stripes:file name="uploadFile"/></div>
            <div><stripes:submit name="upload" value="Upload Now"/></div>
        </stripes:form>
        <div>
            <stripes:link beanclass="tutorial.action.MultiUploadActionBean">
                Upload more than one files at the same time.
            </stripes:link>
        </div>
    </body>
</html>
