<%-- 
    Document   : saveEmployee
    Created on : Oct 12, 2017, 10:20:51 PM
    Author     : Sameera
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <style>
            body { 
                background: url(1.jpg) no-repeat center center fixed; 
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
            }
            .jumbotron{
                margin-bottom: 0px;
            }
        </style>
    </head>
    <body>
        <div class="jumbotron">
            <center><h1><a href="/HRManagementSystem"><span style="margin-right: 2%" class="glyphicon glyphicon-home" aria-hidden="true"></span></a>ABC Company</h1></center>
            <center><h2>Create Employee</h2></center>
        </div>
        <div class="col-md-6 input-group" style="width: 50%; margin:2% auto">
            <form action="saveemployee" method="post">
                <div class="col-md-6">
                    <input class="form-control" type="text" name="name" id="name" required="required" placeholder="Enter Employee Name">
                </div>
                <div class="col-md-6">
                    <c:if test="${roleList != null}">
                        <select class="form-control" name="role-selection">
                            <c:forEach items="${roleList}" var="role">                            
                                <option value="${role.roleid},${role.title}">${role.title}</option>
                            </c:forEach>
                        </select>
                    </c:if>
                </div>
                <div>
                    <center>
                        <input style="margin: 10px auto; width: 50%" class="btn btn-primary" type="submit" name="submit" id="submit" value="Create Employee">
                    </center>
                </div>
            </form>
        </div>
    </body>
</html>
