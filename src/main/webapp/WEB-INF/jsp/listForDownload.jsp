
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title style="text-align: center;">listForDownload</title>

        <style>
            a:link, a:visited {
                background-color: #1C8CED;
                color: white;
                width: 450px;
                padding: 14px 25px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
            }


            a:hover, a:active {
                background-color: #0670CC;
            }
        </style>

    </head>
    <body>

        <c:forEach items="${allInputModels}" var="i">
            <c:set var="cvID" value="${i.cvID}"/>                       
            <c:set var="cvID2" value="${inputCheck.cvID}"/>

            <c:if test="${cvID == cvID2}">

                <c:if test="${not empty name}">                            
                    <c:forEach items="${cvs}" var="cv">
                        <c:set var="cvID" value="${cv.cvID}"/>                       
                        <c:set var="cvID2" value="${inputCheck.cvID}"/>
                        <c:if test="${cvID == cvID2}">
                            <a href="${pageContext.request.contextPath}/fileDownloadCV?cvID=${cv.cvID}">CV for ${name}</a>
                        </c:if>
                    </c:forEach>

                </c:if><br/><br/>

                <c:if test="${not empty pdf1}">                            
                    <c:forEach items="${cvs}" var="cv">
                        <c:set var="cvID" value="${cv.cvID}"/>                       
                        <c:set var="cvID2" value="${inputCheck.cvID}"/>
                        <c:if test="${cvID == cvID2}">
                            <a href="${pageContext.request.contextPath}/fileDownload1?cvID=${cv.cvID}">${pdf1}</a>
                        </c:if>
                    </c:forEach>

                </c:if><br/><br/>

                <c:if test="${not empty pdf2}">                            
                    <c:forEach items="${cvs}" var="cv">
                        <c:set var="cvID" value="${cv.cvID}"/>                       
                        <c:set var="cvID2" value="${inputCheck.cvID}"/>
                        <c:if test="${cvID == cvID2}">
                            <a href="${pageContext.request.contextPath}/fileDownload2?cvID=${cv.cvID}">${pdf2}</a>
                        </c:if>
                    </c:forEach>
                </c:if><br/><br/>

                <c:if test="${not empty pdf3}">                            
                    <c:forEach items="${cvs}" var="cv">
                        <c:set var="cvID" value="${cv.cvID}"/>                       
                        <c:set var="cvID2" value="${inputCheck.cvID}"/>
                        <c:if test="${cvID == cvID2}">
                            <a href="${pageContext.request.contextPath}/fileDownload3?cvID=${cv.cvID}">${pdf3}</a>
                        </c:if>
                    </c:forEach>
                </c:if><br/><br/>

                <c:if test="${not empty pdf4}">                            
                    <c:forEach items="${cvs}" var="cv">
                        <c:set var="cvID" value="${cv.cvID}"/>                       
                        <c:set var="cvID2" value="${inputCheck.cvID}"/>
                        <c:if test="${cvID == cvID2}">
                            <a href="${pageContext.request.contextPath}/fileDownload4?cvID=${cv.cvID}">${pdf4}</a>
                        </c:if>
                    </c:forEach>
                </c:if><br/><br/>

            </c:if>
        </c:forEach>

    </body>
</html>
