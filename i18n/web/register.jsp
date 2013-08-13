<%-- 
    Document   : register
    Created on : Mar 15, 2009, 6:49:59 PM
    Author     : hantsy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registeration Page</title>
    </head>
    <body>
        <h1>User Registeration</h1>
        <div><stripes:errors globalErrorsOnly="true"/></div>
        <div>
            <stripes:form beanclass="tutorial.action.RegisterActionBean">
                <div><stripes:label name="username"/>: </div><div> <stripes:text name="username"/><stripes:errors field="username"/> </div>
               <div><stripes:label name="password"/>: </div><div><stripes:password name="password"/><stripes:errors field="password"/></div>
               <div><stripes:label name="confirmPassword"/>: </div><div><stripes:password name="confirmPassword"/></div>
               <div><stripes:label name="email"/>: </div><div><stripes:text name="email"/><stripes:errors field="email"/></div>
               <div><stripes:label name="birthDate"/>: </div><div><stripes:text name="birthDate"/><stripes:errors field="birthDate"/></div>
               <fieldset>
                   <legend>Address</legend>
                   <div><stripes:label name="address.zipcode"/>:</div>
                   <div><stripes:text name="address.zipcode"  size="10"/><stripes:errors field="address.zipcode"/></div>
                   <div><stripes:label name="address.addressLine1"/>: </div>
                   <div><stripes:text name="address.addressLine1"/><stripes:errors field="address.addressLine1"/></div>
                   <div><stripes:label name="address.addressLine2"/>: </div>
                   <div><stripes:text name="address.addressLine2"/><stripes:errors field="address.addressLine2"/></div>
              </fieldset>

               <div>Would like receive our product infomation by email? </div>
               <div><stripes:checkbox name="subscriptionEnabled" value="on"/>If you would like, check on please. It is free.</div>
               <div><stripes:submit name="register"/> </div>
            </stripes:form>
        </div>
    </body>
</html>
