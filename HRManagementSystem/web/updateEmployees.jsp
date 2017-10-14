<%-- 
    Document   : updateEmployee
    Created on : Oct 13, 2017, 11:21:55 PM
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
            <center><h2>Update Employees</h2></center>
        </div>
        <div class="col-md-6 input-group" style="width: 50%; margin:2% auto">
            <c:if test="${empList != null}">
            <table class="table table-stiped">
                <thead><th colspan="3">EMPLOYEE DETAILS</th><th colspan="3">UPDATE EMPLOYEE DETAILS</th></thead>
                <tr><th hidden="hidden"></th><th>Employee Name</th><th>Current Role</th><th>Assigned Tasks</th><th>Select New Role</th><th>Select New Tasks/Remove Tasks</th><th></th></tr>
                        <c:forEach items="${empList}" var="emp">
                    <form action="updateemployee" method="post">
                        <tr>
                            <td hidden="hidden"><input type="hidden" name="employeeid" id="employeeid" value="${emp.employeeid},${emp.name}"></td>
                            <td>${emp.name}</td>
                            <td>${emp.role.title}</td>
                            <td>
                                <c:if test="${emp.tasks != null}">
                                    <table>
                                        <c:forEach items="${emp.tasks}" var="task">
                                            <tr>
                                                <td>${task.description}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </c:if>
                            </td>
                            <td>
                                <c:if test="${roleList != null}">
                                    <select id="modify-role-selection" name="modify-role-selection">
                                        <option selected="selected" value="${emp.role.roleid},${emp.role.title}">${emp.role.title}</option>
                                        <c:forEach items="${roleList}" var="role">
                                            <c:if test="${role.employee == null}">
                                                <option value="${role.roleid},${role.title}">${role.title}</option>
                                            </c:if>
                                        </c:forEach>
                                        <option value="0,\"\"">--remove role--</option>
                                    </select>
                                </c:if>
                            </td>
                            
                            <td>
                                <c:if test="${taskList != null}">
                                    <table>
                                        <c:forEach items="${taskList}" var="task">
                                            <tr>
                                                <td>
                                                    <input cla type="checkbox" name="modify-task" value="${task.taskid},${task.description}" 
                                                           <c:if test="${task.employee != null && task.employee.employeeid == emp.employeeid}">
                                                               checked="checked"
                                                           </c:if> 
                                                           <c:if test="${task.employee != null && task.employee.employeeid != emp.employeeid}">
                                                               checked="checked"
                                                               disabled="disabled"
                                                           </c:if> 
                                                           >${task.description}
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </c:if>
                            </td>
                            <td>
                                <input class="btn btn-primary" type="submit" name="submit" value="update" />
                            </td>
                               </tr>
                    </form>
                </c:forEach>
            </table>
        </c:if>
        </div>
    </body>
</html>
