
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

    <head>

        <spring:url value="/resources/css/circle.css" var="circleCss" />
        <link href="${circleCss}" rel="stylesheet" />

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title style="text-align: center;">Curriculum vitae</title>

        <style>

            body {
                background:url(resources/css/backgroundCV.png) no-repeat center center fixed;

                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
            }



            #container {
                display: flex; 
            }

        </style>

        <style>.circle-img {width: 250px;height: 250px;overflow: hidden;}</style>
        <style>.circle-img img {height: 100%;transform: translateX(-50%);margin-left: 50%;}</style>
        <style>.info {width: 208px;}</style>
        <style>.headings {color: white; background-color: #07168A;width: 208px;font-size: 20px;}</style>
        <style>#p {color: white;}</style>
        <style>#p-head {color: white;font-size: 18px;}</style>
        <style>p {margin-left: 8px;}</style>
        <style>hr {border: 0;height: 1px;background-image: linear-gradient(to right, rgba(40, 56, 181, 0), rgba(40, 56, 181, 0.75), rgba(40, 56, 181, 0));}</style>
        <style>th {text-align: center;}</style>
        <style>td {text-align: center;}</style>
    </head>
    <body>

        <div id="container" style="margin-left: 30%;">

            <div id='CV1' style="background-color: #2838B5; box-shadow: 10px 10px 5px #888888; width: 208px;float: left;">

                <div class='info'>

                    <h3 style="color: white;text-align: center;padding-top: 10px;margin-top: 0px;">${name}</h3>
                    <c:forEach items="${allInputModels}" var="i">
                        <c:set var="cvID" value="${i.cvID}"/>                       
                        <c:set var="cvID2" value="${inputCheck.cvID}"/>

                        <c:if test="${cvID == cvID2}">

                            <img style="" height="200px" width= "208px" src="<c:url value="/resources/imagess/${i['image']}" />" alt="" />

                        </c:if>

                    </c:forEach>
                    <div style="padding-left: 8px;color: white;background-color: #07168A;font-size: 20px;margin-top: -3px;">Personal info</div>

                    <c:if test="${not empty dateOfBirth}">
                        <p id="p" style="font-weight: bold; margin-top: 13px;font-size: 17px;margin-bottom: 5px;">Date of birth: </p> <br /> 
                        <p id="p" style="margin-top: -15px;margin-bottom: -8px;font-style: italic;">${dateOfBirth}</p><br/>
                    </c:if>
                    <c:if test="${not empty placeOfBirth}">
                        <p id="p" style="font-weight: bold; font-size: 17px;margin-bottom: -3px;margin-top: 5px;">Place of birth: </p> <br /> 
                        <p id="p" style="margin-top: -15px;margin-bottom: -8px;font-style: italic;">${placeOfBirth}</p><br/>
                    </c:if>
                    <c:if test="${not empty citizenship}">
                        <p id="p" style="font-weight: bold; font-size: 17px;margin-bottom: -3px;margin-top: 5px;">Citizenship: </p> <br /> 
                        <p id="p" style="margin-top: -15px;margin-bottom: -8px;font-style: italic;">${citizenship}</p><br/>
                    </c:if>
                    <c:if test="${not empty email}">
                        <p id="p" style="font-weight: bold; font-size: 17px;margin-bottom: -3px;margin-top: 5px;">Email: </p> <br /> 
                        <p id="p" style="margin-top: -15px;margin-bottom: -8px;font-style: italic;">${email}</p><br/>
                    </c:if>
                    <c:if test="${not empty adress}">
                        <p id="p" style="font-weight: bold; font-size: 17px;margin-bottom: -3px;margin-top: 5px;">Address: </p> <br /> 
                        <p id="p" style="margin-top: -15px;margin-bottom: -8px;font-style: italic;">${adress}</p><br/>
                    </c:if>
                    <c:if test="${not empty city}">
                        <p id="p" style="font-weight: bold; font-size: 17px;margin-bottom: -3px;margin-top: 5px;">City: </p> <br /> 
                        <p id="p" style="margin-top: -15px;margin-bottom: -8px;font-style: italic;">${city}</p><br/>
                    </c:if>

                </div>


                <div class='info'>
                    <c:if test="${not empty language1}">
                        <div style="padding-left: 8px;color: white;color: white; background-color: #07168A;width: 201px;font-size: 20px;">Languages</div>
                        <table style="width: 180px;">
                            <thead>
                                <tr>
                                    <th>                             
                                        <p style="font-size: 17px;color: white;margin-top: 10px;margin-bottom: 5px;margin-left: 0px;">${language1}</p>
                                    </c:if>       
                                </th>
                                <th>
                                    <c:if test="${not empty language2}">
                                        <p style="font-size: 17px;color: white;margin-top: 10px;margin-bottom: 5px;margin-left: 0px;">${language2}</p>
                                    </c:if>       
                                </th>
                                <th>
                                    <c:if test="${not empty language3}">
                                        <p style="font-size: 17px;color: white;margin-top: 10px;margin-bottom: 5px;margin-left: 0px;">${language3}</p>
                                    </c:if>       
                                </th>
                                <th>
                                    <c:if test="${not empty language4}">
                                        <p style="font-size: 17px;color: white;margin-top: 10px;margin-bottom: 5px;margin-left: 0px;">${language4}</p>
                                    </c:if>       
                                </th>
                            </tr>

                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <c:if test="${not empty languageLevel1}">
                                        <p style="color: white;margin-top: 5px;margin-bottom: 10px;margin-left: 0px;">${languageLevel1}</p>
                                    </c:if>                        
                                </td>
                                <td>
                                    <c:if test="${not empty languageLevel2}">
                                        <p style="color: white;margin-top: 5px;margin-bottom: 10px;margin-left: 0px;">${languageLevel2}</p>
                                    </c:if>                        
                                </td>
                                <td>
                                    <c:if test="${not empty languageLevel3}">
                                        <p style="color: white;margin-top: 5px;margin-bottom: 10px;margin-left: 0px;">${languageLevel3}</p>
                                    </c:if>                        
                                </td>
                                <td>
                                    <c:if test="${not empty languageLevel4}">
                                        <p style="color: white;margin-top: 5px;margin-bottom: 10px;margin-left: 0px;">${languageLevel4}</p>
                                    </c:if>                        
                                </td>
                            </tr>
                        </tbody>                       
                    </table>
                </div> 

                <div class='info' style="color: white;">
                    <c:if test="${not empty skill1}">
                        <div style="padding-left: 8px;background-color: #07168A;font-size: 20px;margin-top: -3px;">Skills</div>                
                        <p style="margin-top: -15px;margin-bottom: -8px;">${skill1}</p><br/>
                    </c:if>

                </div> 


            </div>

            <div id='CV1' style="float: left; width: 450px;background-color: white;box-shadow: 10px 10px 5px #888888;">
                <div class='someColor3' style="color: #2838B5;">

                    <div style="margin-top: 10px;">${somethingAboutMe}</div>
                </div>
                <hr />
                <div class='someColor3' style="color: #2838B5;">
                    <div style="padding-left: 8px;padding-bottom: 8px;color: #2838B5;width: 208px;font-size: 20px;margin-top: 10px;margin-bottom: 10px;">Experience</div><hr />
                    <c:if test="${not empty firstDayJob1}">                     
                        <p style="color: #2838B5;">${firstDayJob1} - <br/>${lastDayJob1}  </p>                                   
                        <div style="margin-left: 32%;margin-top: -11%;margin-bottom: 26px;">${workExperience1}</div>
                    </c:if>
                    <c:if test="${not empty firstDayJob2}">
                        <p style="color: #2838B5;">${firstDayJob2} -<br/> ${lastDayJob2}  </p>
                        <div style="margin-left: 32%;margin-top: -9%;">${workExperience2}</div>
                    </c:if>
                    <c:if test="${not empty firstDayJob3}">
                        <p style="color: #2838B5;/*float: left;*/">${firstDayJob3} - <br/>${lastDayJob3}  </p>                   
                        <div style="margin-left: 32%;margin-top: -9%;">${workExperience3}</div>
                    </c:if>
                    <c:if test="${not empty firstDayJob4}">
                        <p style="color: #2838B5;/*float: left;*/">${firstDayJob4} -<br/>${lastDayJob4}  </p>
                        <div style="margin-left: 32%;margin-top: -9%;">${workExperience4}</div>
                    </c:if>
                </div>
                <br /><hr />
                <div style="padding-left: 8px;padding-bottom: 8px;color: #2838B5;width: 208px;font-size: 20px;margin-top: 10px;margin-bottom: 10px;">Education</div>
                <hr />
                <div class='someColor4' style="color: #2838B5;">
                    <c:if test="${not empty firstDaySchool1}">  
                        <p style="color: #2838B5;">${firstDaySchool1} -<br/>${lastDaySchool1}  </p>
                        <div style="margin-left: 32%;margin-top: -9%;">${education1}</div>
                    </c:if>
                    <c:if test="${not empty firstDaySchool2}">
                        <p style="color: #2838B5;">${firstDaySchool2} -<br/>${lastDaySchool2}  </p>
                        <div style="margin-left: 32%;margin-top: -9%;">${education2}</div>
                    </c:if>
                    <c:if test="${not empty firstDaySchool3}">
                        <p style="color: #2838B5;">${firstDaySchool3} -<br/>${lastDaySchool3}  </p>
                        <div style="margin-left: 32%;margin-top: -9%;">${education3}</div>
                    </c:if>
                    <c:if test="${not empty firstDaySchool4}">
                        <p style="color: #2838B5;">${firstDaySchool4} -<br/>${lastDaySchool4}  </p>
                        <div style="margin-left: 32%;margin-top: -9%;">${education4}</div>
                    </c:if>
                </div>
                <br /><hr />
                <div style="padding-left: 8px;padding-bottom: 8px;color: #2838B5;width: 208px;font-size: 20px;margin-top: 10px;margin-bottom: 10px;">Courses</div><hr />
                <div class='someColor4' style="color: #2838B5;">
                    <c:if test="${not empty courses1}">  
                        <p style="color: #2838B5;">Course: </p>
                        <div style="margin-left: 32%;margin-top: -8%;">${courses1}</div>
                    </c:if>
                    <div style="margin-left: 32%;margin-top: 7px;">${courses2}</div>
                    <div style="margin-left: 32%;margin-top: 7px;">${courses3}</div>
                    <div style="margin-left: 32%;margin-top: 7px;">${courses4}</div>
                </div> 

                <br /><hr />           
                <div style="padding-left: 8px;padding-bottom: 8px;color: #2838B5;width: 208px;font-size: 20px;margin-top: 10px;margin-bottom: 10px;">Attached files</div><hr />
                <div class='someColor4' style="color: #2838B5;">
                    <c:if test="${not empty pdf1}">  
                        <div style="margin-left: 32%;"> - ${pdf1}</div>
                    </c:if>
                    <c:if test="${not empty pdf2}">  
                        <div style="margin-left: 32%;margin-top: 7px;"> - ${pdf2}</div>
                    </c:if>
                    <c:if test="${not empty pdf3}">  
                        <div style="margin-left: 32%;margin-top: 7px;"> - ${pdf3}</div>
                    </c:if>
                    <c:if test="${not empty pdf4}">  
                        <div style="margin-left: 32%;margin-top: 7px;"> - ${pdf4}</div>
                    </c:if>
                </div>          
            </div> 



        </div> <!-- end container -->

        <div style="float: left;margin-top: 15px; margin-left: 30%;margin-bottom: 15px; color: #2838B5; width: 658px; text-align: center;border: solid 1px #2838B5; background-color: white;box-shadow: 10px 10px 5px #888888;/*height: 900px;*/">
            <h3>Attached files</h3>

        </div>
        <c:forEach items="${allInputModels}" var="i">
            <c:set var="cvID" value="${i.cvID}"/>                       
            <c:set var="cvID2" value="${inputCheck.cvID}"/>

            <c:if test="${cvID == cvID2}">
                <c:if test="${not empty pdf1}">
                    <embed style="box-shadow: 10px 10px 5px #888888;margin-left: 25%;" width="900" height="1200" style="/*border-radius: 50%;*//*border: solid 1px white;*/ /*box-shadow: 0 0 10px #9ecaed*/" src="<c:url value="/resources/uploadedFiles/${i['pdf1']}" />"/>
                </c:if>
                <c:if test="${not empty pdf2}">    
                    <embed style="box-shadow: 10px 10px 5px #888888;margin-left: 25%;" width="900" height="1200" style="/*border-radius: 50%;*//*border: solid 1px white;*/ /*box-shadow: 0 0 10px #9ecaed*/" src="<c:url value="/resources/uploadedFiles/${i['pdf2']}" />"/>
                </c:if>
                <c:if test="${not empty pdf3}">
                    <embed style="box-shadow: 10px 10px 5px #888888;margin-left: 25%;" width="900" height="1200" style="/*border-radius: 50%;*//*border: solid 1px white;*/ /*box-shadow: 0 0 10px #9ecaed*/" src="<c:url value="/resources/uploadedFiles/${i['pdf3']}" />"/>
                </c:if>
                <c:if test="${not empty pdf4}">
                    <embed style="box-shadow: 10px 10px 5px #888888;margin-left: 25%;" width="900" height="1200" style="/*border-radius: 50%;*//*border: solid 1px white;*/ /*box-shadow: 0 0 10px #9ecaed*/" src="<c:url value="/resources/uploadedFiles/${i['pdf4']}" />"/>
                </c:if>
            </c:if>

        </c:forEach>

    </body>

</html>
