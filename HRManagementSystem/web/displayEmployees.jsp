<%-- 
    Document   : displayEmployees
    Created on : Oct 11, 2017, 8:13:28 PM
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
            <center><h2>Employee Details</h2></center>
        </div>
        <div class="col-md-6 input-group" style="width: 50%; margin:2% auto">
            <c:if test="${empList != null}">
            <table class="table table-stiped">
                <thead><th>EMP ID</th><th>EMP NAME</th><th>EMP ROLE</th><th>EMP TASKS</th></thead>
                        <c:forEach items="${empList}" var="emp">
                    <tr>
                        <td>${emp.employeeid}</td>
                        <td>${emp.name}</td>
                        <td>${emp.role.title}</td>
                        <td>
                            <c:if test="${emp.tasks != null}">
                                <table>
                                    <c:forEach items="${emp.tasks}" var="task">
                                        <!--<td>${task.taskid}</td>-->
                                        <tr>
                                            <td>${task.description}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        </div>
    </body>
</html>
