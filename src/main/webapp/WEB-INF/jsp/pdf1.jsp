
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title style="text-align: center;">PDF 1</title>

    </head>
    <body>

        <c:forEach items="${allInputModels}" var="i">
            <c:set var="cvID" value="${i.cvID}"/>                       
            <c:set var="cvID2" value="${inputCheck.cvID}"/>

            <c:if test="${cvID == cvID2}">
                <c:if test="${not empty pdf1}">                            

                    <img style="box-shadow: 10px 10px 5px #888888;/*float: left;*/margin-left: 25%;" src="<c:url value="C:/Users/Korisnik/Documents/NetBeansProjects/NewCV_6/src/main/webapp/resources/uploadedFiles/${i['pdf1']}" />" />

                </c:if>
            </c:if>
        </c:forEach>

    </body>
</html>
