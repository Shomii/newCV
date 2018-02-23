
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Curriculum vitae</title>

        <spring:url value="/resources/css/mdb.css" var="mdbCss" />
        <link href="${mdbCss}" rel="stylesheet" />


        <style>
            body {
                background:url(resources/css/background.png) no-repeat center center fixed;       
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
            }
        </style>

    </head>
    
    <body>           

        <div class="container">
            <div class="cta animated fadeInDown">
                <button style="margin: 15% 30%;" class="btn btn-primary btn-rounded" onclick="location.href = '${pageContext.request.contextPath}/newCV'"><h1>NEW CV</h1></button>
                <button style="margin-left: -15%;" class="btn btn-primary btn-rounded" onclick="location.href = '${pageContext.request.contextPath}/archive'"><h1>ARCHIVE</h1></button>
            </div>
        </div>
   

</body>
</html>
