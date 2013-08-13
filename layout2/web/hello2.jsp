<%-- 
    Document   : index
    Created on : Mar 11, 2009, 3:57:13 PM
    Author     : hantsy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<stripes:layout-render name="/layouts/default.jsp">
    <jsp:useBean id="user" scope="page" class="tutorial.action.UserSession"/>
    <stripes:layout-component name="pageTitle">
        <c:if test="${user.logined}">
            Welcome back, ${user.username}
        </c:if>
        <c:if test="${!user.logined}">
            Welcome, Guest! 
        </c:if>
    </stripes:layout-component>
    <stripes:layout-component name="content">
        <stripes:form beanclass="tutorial.action.HelloActionBean" method="post">
            <div><stripes:text name="message"/></div>
            <div><stripes:submit name="sayHello" value="Say Hello"/></div>
        </stripes:form>
    </stripes:layout-component>
</stripes:layout-render>
