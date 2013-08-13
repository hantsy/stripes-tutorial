<%-- 
    Document   : index
    Created on : Mar 11, 2009, 3:57:13 PM
    Author     : hantsy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<stripes:layout-render name="/layouts/default.jsp">
    <stripes:layout-component name="content">
        <stripes:form beanclass="tutorial.action.HelloActionBean" method="post">
            <div><stripes:text name="message"/></div>
            <div><stripes:submit name="sayHello" value="Say Hello"/></div>
        </stripes:form>
    </stripes:layout-component>
</stripes:layout-render>
