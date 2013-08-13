<%-- 
    Document   : userList
    Created on : Mar 22, 2009, 12:56:24 PM
    Author     : hantsy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://stripes.sourceforge.net/stripes.tld" prefix="stripes" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User List Page</title>
    </head>
    <body>
        <h1> User List Page!</h1>
        <display:table id="row" defaultsort="1" name="actionBean.users" pagesize="5" sort="external" size="actionBean.users.fullListSize" partialList="true" requestURI="/ListUser.action">
            <display:column property="id" title="ID" />
            <display:column property="firstname" sortable="true" sortName="firstname" title="First Name" />
            <display:column property="lastname" sortable="true" sortName="lastname" title="Last Name" />
            <display:column title="Action">
                <stripes:link beanclass="tutorial.action.EditUserActionBean" event="edit">
            Edit
            <stripes:param name="id" value="${row.id}"/>
        </stripes:link>&nbsp;
        <stripes:link beanclass="tutorial.action.DeleteUserActionBean" event="delete">
            Delete
            <stripes:param name="id" value="${row.id}"/>
        </stripes:link>
            </display:column>
        </display:table>
    </body>
</html>
