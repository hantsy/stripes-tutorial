<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<stripes:layout-definition>

    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Stripes Layout Examples </title>
        </head>
        <body>
            <stripes:layout-component name="header">
                <jsp:include page="/layouts/header.jsp"/>
            </stripes:layout-component>

            <stripes:layout-component name="content"/>

            <stripes:layout-component name="header">
                <stripes:layout-render name="/layouts/footer.jsp"/>
            </stripes:layout-component>
        </body>
    </html>
</stripes:layout-definition>
