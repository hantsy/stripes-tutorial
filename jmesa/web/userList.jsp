<%-- 
    Document   : userList
    Created on : Mar 22, 2009, 12:56:24 PM
    Author     : hantsy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://stripes.sourceforge.net/stripes.tld" prefix="stripes" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/web.css"></link>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jmesa.css"></link>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.3.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.bgiframe.pack.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.jmesa.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jmesa.js"></script>

        <title>User List Page</title>
    </head>
    <body>
        <h1> User List Page!</h1>
        <stripes:form beanclass="tutorial.action.ListUserActionBean" method="post">
        ${actionBean.html}
        </stripes:form>
        <script type="text/javascript">
            function onInvokeAction(id) {
                createHiddenInputFieldsForLimitAndSubmit(id);
            }
        </script>
    </body>
</html>
