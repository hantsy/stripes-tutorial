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
        <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/prototype-1.6.0.3.js">
        </script>
        <script language="Javascript" type="text/javascript">
            function refresh(){
                new Ajax.Updater('verifycode-content',
                '${pageContext.servletContext.contextPath}/Register.action?refresh',
                { method: 'get' }
            );
            }



            function checkUserExist(){
                var username=$('username');
                $('username-error').innerHTML="";
                console.log("Username @"+username.value);
                console.log("username len#"+username.value.length);
                if(username.value.length>0){
                    new Ajax.Request('${pageContext.servletContext.contextPath}/Register.action?checkUser&username='+username.value, {
                        method:'get',
                        onSuccess: function(transport){

                            var response = transport.responseText || "no response text";
                            console.log("Success! \n\n" + response);
                            if(response=='true'){
                                $('username-error').innerHTML="<font color='red'>用户名已经存在</font>";
                            }else{
                                $('username-error').innerHTML="<font color='green'>用户名可用</font>";
                            }
                        }
                    });
                }
            }

        </script>
    </head>
    <body>
        <h1>User Registeration</h1>
        <div><stripes:errors globalErrorsOnly="true"/></div>
        <div>
            <stripes:form beanclass="tutorial.action.RegisterActionBean">
                <div>Username: </div><div> <stripes:text name="username" id="username" onchange="checkUserExist();"/><span id="username-error"><stripes:errors field="username"/></span> </div>
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
                <div><stripes:text name="captchaResponse" id="captchaResponse" size="10"/>
                    <span id="verifycode-content">
                        <img src="${pageContext.servletContext.contextPath}/Captcha.action" alt="jCaptcha image"/>
                    </span>
                    <span><a href="javascript:refresh();">Refresh</a></span>
                    <span id="verifycode-error"><stripes:errors field="register.captcha.error"/></span>
                </div>
                <div><stripes:submit name="register" value="Register Now"/> </div>
            </stripes:form>
        </div>
    </body>
</html>
