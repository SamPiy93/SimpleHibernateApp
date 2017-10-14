<%-- 
    Document   : index
    Created on : Oct 11, 2017, 9:31:57 AM
    Author     : Sameera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <style>
            #control-div div{
                float: left;
                margin: 2% auto;
            }
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
            <center><h1><span style="margin-right: 2%" class="glyphicon glyphicon-home" aria-hidden="true"></span>ABC Company</h1></center>
        </div>
        <div id="control-div" class="col-md-8" style="margin: 0 auto; float: none">
            <div class="col-md-2"><input type="button" class="btn btn-primary" value="View Employees" onclick="window.location.href = 'viewemployee'"/></div>
            <div class="col-md-2"><input type="button" class="btn btn-primary" value="Add Employees" onclick="window.location.href = 'saveemployee'"/></div>
            <div class="col-md-2"><input type="button" class="btn btn-primary" value="Edit Employees" onclick="window.location.href = 'updateemployee'"/></div>
            <div class="col-md-2"><input type="button" class="btn btn-primary" value="Add Role" onclick="window.location.href = 'saverole'"/></div>
            <div class="col-md-2"><input type="button" class="btn btn-primary" value="Edit Role" onclick="window.location.href = 'updaterole'"/></div>
            <div class="col-md-2"><input type="button" class="btn btn-primary" value="Add Task" onclick="window.location.href = 'savetask'"/></div>
            <div class="col-md-2"><input type="button" class="btn btn-primary" value="Edit Task" onclick="window.location.href = 'updatetask'"/></div>
        </div>
        <div id="result-view">
            <h2></h2>
        </div>
    </body>
</html>
