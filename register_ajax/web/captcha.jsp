<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<img src="${pageContext.servletContext.contextPath}/Captcha.action?<%=java.lang.Math.random()%>" alt="jCaptcha image"/>