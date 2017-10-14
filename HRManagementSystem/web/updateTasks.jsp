<%-- 
    Document   : updateTasks
    Created on : Oct 11, 2017, 11:40:58 PM
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
            <center><h2>Update Tasks</h2></center>
        </div>
        <div class="col-md-6 input-group" style="width: 50%; margin:2% auto">
            <c:if test="${taskList != null}">
            <table class="table table-stiped">
                <thead><th>Task ID</th><th>Description</th><th>Employee</th><th></th></thead>
                        <c:forEach items="${taskList}" var="task">
                    <tr>
                    <form action="updatetask" method="post">
                        <td><input type="text" style="border: 0px; background: none" name="taskid" id="taskid" value="${task.taskid}" readonly="readonly"></td>
                        <td><input type="text" class="form-control" name="description" id="description" value="${task.description}" placeholder="modify task description"></td>
                        <td><input type="text" style="border: 0px; background: none" value="${task.employee.name}" readonly="readonly"><input type="hidden" style="border: 0px" name="employeeid" id="employeeid" value="${task.employee.employeeid}" readonly="readonly"></td>
                        <td><input type="submit" class="btn btn-primary" name="submit" value="modify"></td>
                    </form>
                </tr>
            </c:forEach>
        </table>
    </c:if>
        </div>
</body>
</html>
