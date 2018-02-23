
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New CV</title>

        <spring:url value="/resources/css/bootstrap-datepicker.css" var="datepickerCss" />
        <link href="${datepickerCss}" rel="stylesheet" />
        <spring:url value="/resources/css/fileinput.css" var="fileinputCss" />
        <link href="${fileinputCss}" rel="stylesheet" />
        <spring:url value="/resources/css/newCV.css" var="newCVCss" />
        <link href="${newCVCss}" rel="stylesheet" />

        <spring:url value="/resources/js/jquery-3.1.0.js" var="jquery" />
        <script src="${jquery}"></script>
        <spring:url value="/resources/js/bootstrap-datepicker.js" var="datepicker" />
        <script src="${datepicker}"></script>
        <spring:url value="/resources/js/fileinput.js" var="fileinput" />
        <script src="${fileinput}"></script>
        <spring:url value="/resources/js/newCV.js" var="newCVJS" />
        <script src="${newCVJS}"></script>

        <!--         Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!--         Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!--         Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

        <script src="https://cdn.ckeditor.com/4.7.1/standard/ckeditor.js"></script>

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
            <form:form class="well form-horizontal" style="background: none;  background-image: none;" action="newCV" method="post" name="newCVForm" commandName="newcV" enctype="multipart/form-data" >
                <fieldset>

                    <legend>Fill out your new CV</legend>

                    <div class="form-group">
                        <label class="col-md-4 control-label">CV Name</label>  
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-file"></i></span>
                                    <form:input path="cvName" class="form-control" type="text" id="cvName" name="cvName" placeholder="CV name will help you easily find your CV" />
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label">Name</label>  
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <!--<input  name="first_name" placeholder="First Name" class="form-control"  type="text">-->
                                <form:input path="name" class="form-control" type="text" id="name" name="name" placeholder="Name" />
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" >Date of birth</label> 
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                    <form:input path="dateOfBirth" name="dateOfBirth" class="datepicker2 form-control"  placeholder="Date Of Birth" readonly="true" />
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label">Place Of Birth</label>  
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span>
                                    <form:input path="placeOfBirth" class="form-control" id="placeOfBirth" type="text" name="placeOfBirth" placeholder="Place Of Birth" />
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label">Citizenship</label>  
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-globe"></i></span>
                                    <form:input path="citizenship" class="form-control" type="text" name="citizenship" placeholder="Citizenship" />
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label">E-Mail</label>  
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                                    <form:input path="email" class="form-control" type="text" name="email" placeholder="Email" />
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label">Phone #</label>  
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                                    <form:input path="phoneNumber" class="form-control" type="text" name="phoneNumber" placeholder="Phone Number"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label">Address</label>  
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                                    <form:input path="adress" class="form-control" name="adress" placeholder="Adress"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label">City</label>  
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span>
                                <form:input path="city" class="form-control" type="text" name="city" placeholder="City"/><br/>
                            </div>
                        </div>
                    </div>

                    <div class="row">    
                        <div class="col-xs-12 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">  
                            <p><strong>Your picture for CV</strong></p>         
                            <div class="input-group image-preview">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-picture"></i></span>
                                <input type="text" class="form-control image-preview-filename" disabled="disabled">
                                <span class="input-group-btn">
                                    <button type="button" class="btn btn-default image-preview-clear" style="display:none;">
                                        <span class="glyphicon glyphicon-remove"></span> Clear
                                    </button>
                                    <div class="btn btn-default image-preview-input">
                                        <span class="glyphicon glyphicon-folder-open"></span>
                                        <span class="image-preview-input-title">Browse</span>
                                        <input type="file" accept="image/png, image/jpeg, image/gif, image/bmp" name="images"/>
                                    </div>
                                </span>
                            </div> 
                        </div>
                    </div><br/>

                    <div class="form-group">
                        <label class="col-md-4 control-label">Language</label>  
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-text-background"></i></span>
                                    <form:input path="language1" class="form-control" type="text" id="language1" name="language1" placeholder="Language" />
                            </div>
                        </div>
                    </div>

                    <div class="form-group"> 
                        <label class="col-md-4 control-label">Language level</label>
                        <div class="col-md-4 selectContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>

                                <form:select path="languageLevel1" class="form-control selectpicker" type="text" id="languageLevel1" name="languageLevel1" placeholder="Language level" >
                                    <form:option value="" label="Please select level of knowledge"/>
                                    <form:option value="Native language" label="Native language"/>
                                    <form:option value="A1" label="A1"/>
                                    <form:option value="A2" label="A2"/>
                                    <form:option value="B1" label="B1"/>
                                    <form:option value="B2" label="B2"/>
                                    <form:option value="C1" label="C1"/>
                                    <form:option value="C2" label="C2"/>
                                </form:select>
                            </div>
                        </div>
                    </div>
                    <div id="divLanguage2">

                        <div class="form-group">
                            <label class="col-md-4 control-label">Language</label>  
                            <div class="col-md-4 inputGroupContainer">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-text-background"></i></span>
                                        <form:input path="language2" class="form-control" type="text" id="language2" name="language2" placeholder="Language" />
                                </div>
                            </div>
                        </div>

                        <div class="form-group"> 
                            <label class="col-md-4 control-label">Language level</label>
                            <div class="col-md-4 selectContainer">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>

                                    <form:select path="languageLevel2" class="form-control selectpicker" type="text" id="languageLevel2" name="languageLevel2" placeholder="Language level" >
                                        <form:option value="" label="Please select level of knowledge"/>
                                        <form:option value="Native language" label="Native language"/>
                                        <form:option value="A1" label="A1"/>
                                        <form:option value="A2" label="A2"/>
                                        <form:option value="B1" label="B1"/>
                                        <form:option value="B2" label="B2"/>
                                        <form:option value="C1" label="C1"/>
                                        <form:option value="C2" label="C2"/>
                                    </form:select>
                                </div>
                            </div>
                        </div>

                    </div> <!-- end divLanguage2 -->


                    <div id="divLanguage3">

                        <div class="form-group">
                            <label class="col-md-4 control-label">Language</label>  
                            <div class="col-md-4 inputGroupContainer">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-text-background"></i></span>
                                        <form:input path="language3" class="form-control" type="text" id="language3" name="language3" placeholder="Language" />
                                </div>
                            </div>
                        </div>

                        <div class="form-group"> 
                            <label class="col-md-4 control-label">Language level</label>
                            <div class="col-md-4 selectContainer">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>

                                    <form:select path="languageLevel3" class="form-control selectpicker" type="text" id="languageLevel3" name="languageLevel3" placeholder="Language level" >
                                        <form:option value="" label="Please select level of knowledge"/>
                                        <form:option value="Native language" label="Native language"/>
                                        <form:option value="A1" label="A1"/>
                                        <form:option value="A2" label="A2"/>
                                        <form:option value="B1" label="B1"/>
                                        <form:option value="B2" label="B2"/>
                                        <form:option value="C1" label="C1"/>
                                        <form:option value="C2" label="C2"/>
                                    </form:select>
                                </div>
                            </div>
                        </div>

                    </div> <!-- end divLanguage3 -->

                    <div id="divLanguage4">

                        <div class="form-group">
                            <label class="col-md-4 control-label">Language</label>  
                            <div class="col-md-4 inputGroupContainer">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-text-background"></i></span>

                                    <form:input path="language4" class="form-control" type="text" id="language4" name="language4" placeholder="Language" />
                                </div>
                            </div>
                        </div>

                        <div class="form-group"> 
                            <label class="col-md-4 control-label">Language level</label>
                            <div class="col-md-4 selectContainer">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>

                                    <form:select path="languageLevel4" class="form-control selectpicker" type="text" id="languageLevel4" name="languageLevel4" placeholder="Language level" >
                                        <form:option value="" label="Please select level of knowledge"/>
                                        <form:option value="Native language" label="Native language"/>
                                        <form:option value="A1" label="A1"/>
                                        <form:option value="A2" label="A2"/>
                                        <form:option value="B1" label="B1"/>
                                        <form:option value="B2" label="B2"/>
                                        <form:option value="C1" label="C1"/>
                                        <form:option value="C2" label="C2"/>
                                    </form:select>
                                </div>
                            </div>
                        </div>

                    </div> <!-- end divLanguage4 -->   

                    <div class="form-group">
                        <label class="col-md-4 control-label">Something About Me</label>  
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-briefcase"></i></span>

                                <form:textarea  path="somethingAboutMe" class="form-control" id="somethingAboutMe" name="somethingAboutMe" placeholder="Something About Me"></form:textarea>
                                    <script>
                                        CKEDITOR.replace('somethingAboutMe');
                                    </script>
                                </div>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-md-4 control-label">Work experience</label>  
                            <div class="col-md-4 inputGroupContainer">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-briefcase"></i></span>

                                <form:input id="dayPicker" path="firstDayJob1"  name="firstDayJob1" class="datepicker form-control"  placeholder="First Day" readonly="true" />
                                <form:input id="dayPicker" path="lastDayJob1"  name="lastDayJob1" class="datepicker form-control"  placeholder="Last Day" readonly="true" />
                                <form:textarea  path="workExperience1" class="form-control" id="workExperience1" name="workExperience1" placeholder="Work Experience"></form:textarea>
                                </div>
                            </div>
                        </div>

                        <div id="divJob2">
                            <div class="form-group">
                                <label class="col-md-4 control-label">Work experience</label>  
                                <div class="col-md-4 inputGroupContainer">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-briefcase"></i></span>

                                    <form:input id="dayPicker" path="firstDayJob2"  name="firstDayJob2" class="datepicker form-control"  placeholder="First Day" readonly="true" />
                                    <form:input id="dayPicker" path="lastDayJob2"  name="lastDayJob2" class="datepicker form-control"  placeholder="Last Day" readonly="true" />
                                    <form:textarea  path="workExperience2" class="form-control" id="workExperience2" name="workExperience1" placeholder="Work Experience"></form:textarea>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- end divJob2 -->

                        <div id="divJob3">
                            <div class="form-group">
                                <label class="col-md-4 control-label">Work experience</label>  
                                <div class="col-md-4 inputGroupContainer">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-briefcase"></i></span>

                                    <form:input id="dayPicker" path="firstDayJob3"  name="firstDayJob3" class="datepicker form-control"  placeholder="First Day" readonly="true" />
                                    <form:input id="dayPicker" path="lastDayJob3"  name="lastDayJob3" class="datepicker form-control"  placeholder="Last Day" readonly="true" />
                                    <form:textarea  path="workExperience3" class="form-control" id="workExperience3" name="workExperience1" placeholder="Work Experience"></form:textarea>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- end divJob3 -->

                        <div id="divJob4">
                            <div class="form-group">
                                <label class="col-md-4 control-label">Work experience</label>  
                                <div class="col-md-4 inputGroupContainer">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-briefcase"></i></span>

                                    <form:input id="dayPicker" path="firstDayJob4"  name="firstDayJob4" class="datepicker form-control"  placeholder="First Day" readonly="true" />
                                    <form:input id="dayPicker" path="lastDayJob4"  name="lastDayJob4" class="datepicker form-control"  placeholder="Last Day" readonly="true" />
                                    <form:textarea  path="workExperience4" class="form-control" id="workExperience4" name="workExperience1" placeholder="Work Experience"></form:textarea>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- end divJob4 -->


                        <div class="form-group">
                            <label class="col-md-4 control-label">Education</label>  
                            <div class="col-md-4 inputGroupContainer">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-education"></i></span>

                                <form:input id="dayPicker" path="firstDaySchool1"  name="firstDaySchool1" class="datepicker form-control"  placeholder="First Day" readonly="true" />
                                <form:input id="dayPicker" path="lastDaySchool1"  name="lastDaySchool1" class="datepicker form-control"  placeholder="Last Day" readonly="true" />
                                <form:textarea id="education1" class="form-control" path="education1" name="education1" placeholder="Education"></form:textarea>
                                </div>
                            </div>
                        </div>

                        <div id="divSchool2">
                            <div class="form-group">
                                <label class="col-md-4 control-label">Education</label>  
                                <div class="col-md-4 inputGroupContainer">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-education"></i></span>

                                    <form:input id="dayPicker" path="firstDaySchool2"  name="firstDaySchool2" class="datepicker form-control"  placeholder="First Day" readonly="true" />
                                    <form:input id="dayPicker" path="lastDaySchool2"  name="lastDaySchool2" class="datepicker form-control"  placeholder="Last Day" readonly="true" />
                                    <form:textarea id="education2" class="form-control" path="education2" name="education2" placeholder="Education"></form:textarea>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- end divSchool2 -->

                        <div id="divSchool3">
                            <div class="form-group">
                                <label class="col-md-4 control-label">Education</label>  
                                <div class="col-md-4 inputGroupContainer">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-education"></i></span>

                                    <form:input id="dayPicker" path="firstDaySchool3"  name="firstDaySchool3" class="datepicker form-control"  placeholder="First Day" readonly="true" />
                                    <form:input id="dayPicker" path="lastDaySchool3"  name="lastDaySchool3" class="datepicker form-control"  placeholder="Last Day" readonly="true" />
                                    <form:textarea id="education3" class="form-control" path="education3" name="education3" placeholder="Education"></form:textarea>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- end divSchool3 -->

                        <div id="divSchool4">
                            <div class="form-group">
                                <label class="col-md-4 control-label">Education</label>  
                                <div class="col-md-4 inputGroupContainer">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-education"></i></span>

                                    <form:input id="dayPicker" path="firstDaySchool4"  name="firstDaySchool4" class="datepicker form-control"  placeholder="First Day" readonly="true" />
                                    <form:input id="dayPicker" path="lastDaySchool4"  name="lastDaySchool4" class="datepicker form-control"  placeholder="Last Day" readonly="true" />
                                    <form:textarea id="education4" class="form-control" path="education4" name="education4" placeholder="Education"></form:textarea>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- end divSchool4 -->

                        <div id="divCourses1">
                            <div class="form-group">
                                <label class="col-md-4 control-label">Courses</label>  
                                <div class="col-md-4 inputGroupContainer">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-education"></i></span>

                                    <form:textarea id="courses1" class="form-control" path="courses1" name="courses1" placeholder="Courses"></form:textarea>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- end divCourses1 -->

                        <div id="divCourses2">
                            <div class="form-group">
                                <label class="col-md-4 control-label">Courses</label>  
                                <div class="col-md-4 inputGroupContainer">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-education"></i></span>

                                    <form:textarea id="courses2" class="form-control" path="courses2" name="courses2" placeholder="Courses"></form:textarea>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- end divCourses2 -->

                        <div id="divCourses3">
                            <div class="form-group">
                                <label class="col-md-4 control-label">Courses</label>  
                                <div class="col-md-4 inputGroupContainer">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-education"></i></span>

                                    <form:textarea id="courses3" class="form-control" path="courses3" name="courses3" placeholder="Courses"></form:textarea>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- end divCourses3 -->

                        <div id="divCourses4">
                            <div class="form-group">
                                <label class="col-md-4 control-label">Courses</label>  
                                <div class="col-md-4 inputGroupContainer">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-education"></i></span>

                                    <form:textarea id="courses4" class="form-control" path="courses4" name="courses4" placeholder="Courses"></form:textarea>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- end divCourses4 -->  

                        <div id="divCertificates1">
                            <div class="form-group">
                                <label class="col-md-4 control-label"><p style="color:#4A0612;">Certificates, diplomas, etc ...IMAGES ONLY</p></label>  
                                <div class="col-md-4 inputGroupContainer">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-education"></i></span>
                                        <input id="duplicater0" name="pdfs1" type="file" class="file" multiple data-show-upload="false" data-show-caption="true" onclick="duplicate(this.id)">
                                    </div>
                                </div>
                            </div>
                        </div> <!-- end divCertificates1 -->

                        <div id="divCertificates2">
                            <div class="form-group">
                                <label class="col-md-4 control-label"><p style="color:#4A0612;">Certificates, diplomas, etc ...IMAGES ONLY</p></label>  
                                <div class="col-md-4 inputGroupContainer">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-education"></i></span>
                                        <input id="certificates2" name="pdfs2" type="file" class="file" multiple data-show-upload="false" data-show-caption="true">
                                    </div>
                                </div>
                            </div>
                        </div> <!-- end divCertificates2 -->

                        <div id="divCertificates3">
                            <div class="form-group">
                                <label class="col-md-4 control-label"><p style="color:#4A0612;">Certificates, diplomas, etc ...IMAGES ONLY</p></label>  
                                <div class="col-md-4 inputGroupContainer">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-education"></i></span>
                                        <input id="certificates3" name="pdfs3" type="file" class="file" multiple data-show-upload="false" data-show-caption="true">
                                    </div>
                                </div>
                            </div>
                        </div> <!-- end divCertificates3 -->

                        <div id="divCertificates4">
                            <div class="form-group">
                                <label class="col-md-4 control-label"><p style="color:#4A0612;">Certificates, diplomas, etc ...IMAGES ONLY</p></label>  
                                <div class="col-md-4 inputGroupContainer">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-education"></i></span>
                                        <input id="certificates4" name="pdfs4" type="file" class="file" multiple data-show-upload="false" data-show-caption="true">
                                    </div>
                                </div>
                            </div>
                        </div> <!-- end divCertificates4 -->

                        <div id="divSkill1">
                            <div class="form-group">
                                <label class="col-md-4 control-label">Skills</label>  
                                <div class="col-md-4 inputGroupContainer">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-education"></i></span>

                                    <form:textarea id="skill1" class="form-control" path="skill1" name="skill1" placeholder="Skills"></form:textarea>
                                        <script>
                                            CKEDITOR.replace('skill1');
                                        </script>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- end divSkill1 -->


                        <!-- Button -->
                        <div class="form-group">
                            <label class="col-md-4 control-label"></label>
                            <div class="col-md-4">
                            <form:button id="save" type="submit"  class="btn btn-warning"> Save </form:button>
                            <form:button  class="btn btn-danger" onclick="history.go(-1); return false;"> Cancel</form:button>

                            </div>
                        </div>

                    </fieldset>
            </form:form>

        </div><!-- /.container -->

    </body>
</html>
