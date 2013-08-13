<%-- 
    Document   : register
    Created on : Mar 15, 2009, 6:49:59 PM
    Author     : hantsy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
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
                <div>Username: </div><div> <stripes:text name="username"/><stripes:errors field="username"/> </div>
               <div>Password: </div><div><stripes:password name="password"/></div>
               <div>Confirm Password: </div><div><stripes:password name="confirmPassword"/></div>
               <div>Email: </div><div><stripes:text name="email"/></div>
               <div>Birth Date: </div><div><stripes:text name="birthDate"/></div>
               <fieldset>
                   <legend>Address</legend>
                   <div>ZipCode:</div>
                   <div><stripes:text name="address.zipcode"  size="10"/></div>
                   <div>Address Line1: </div>
                   <div><stripes:text name="address.addressLine1"/></div>
                   <div>Address Line2: </div>
                   <div><stripes:text name="address.addressLine2"/></div>
              </fieldset>

               <div>Would like receive our product infomation by email? </div>
               <div><stripes:checkbox name="subscriptionEnabled" value="on"/>If you would like, check on please. It is free.</div>
               <div>Verify Code</div>
               <div><stripes:text name="captchaResponse" size="10"/><img src="${pageContext.servletContext.contextPath}/Captcha.action" alt="jCaptcha image"/><stripes:errors field="register.captcha.error"/></div>
              <div><stripes:submit name="register" value="Register Now"/> </div>
            </stripes:form>
        </div>
    </body>
</html>
