/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.servlet;

import com.hr.helper.HRHelper;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hr.models.Employee;
import com.hr.models.Role;
import com.hr.models.Task;

/**
 *
 * @author Sameera
 */
public class UpdateEmployeeControllerServlet extends HttpServlet implements RequestResponseInterface{

    private HRHelper hRHelper = new HRHelper();
    /**
     * Method to handle GET requests and responses
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws IOException
     * @throws ServletException 
     */
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        List<Role> roleList = hRHelper.getRoleList();
        List<Employee> employeeList = hRHelper.getEmployeeList();
        List<Task> taskList = hRHelper.getTaskList();;

        httpServletRequest.setAttribute("roleList", roleList);
        httpServletRequest.setAttribute("empList", employeeList);
        httpServletRequest.setAttribute("taskList", taskList);

        RequestDispatcher rd = httpServletRequest.getRequestDispatcher("updateEmployees.jsp");
        rd.forward(httpServletRequest, httpServletResponse);
    }
    /**
     * Method to handle POST request and responses
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws IOException 
     */
    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        int employeeId = Integer.parseInt(httpServletRequest.getParameter("employeeid").split(",")[0]);
        String employeeName = httpServletRequest.getParameter("employeeid").split(",")[1];
        int roleId = Integer.parseInt(httpServletRequest.getParameter("modify-role-selection").split(",")[0]);
        String title = httpServletRequest.getParameter("modify-role-selection").split(",")[1];
        String[] taskArray = httpServletRequest.getParameterValues("modify-task");
        
        int taskId;
        String description;
        List<Task> taskList = new LinkedList();

        Employee employee = new Employee();
        employee.setEmployeeid(employeeId);
        employee.setName(employeeName);
        if (roleId > 0) {
            Role role = new Role();
            role.setRoleid(roleId);
            role.setTitle(title);
            role.setEmployee(employee);

            employee.setRole(role);
        }
        if (taskArray != null) {
            for (int x = 0; x <= taskArray.length - 1; x++) {
                taskId = Integer.parseInt(taskArray[x].split(",")[0]);
                description = taskArray[x].split(",")[1];
                Task task = new Task();
                task.setTaskid(taskId);
                task.setDescription(description);
                task.setEmployee(employee);
//                System.out.println(task.getTaskid());
                taskList.add(task);
            }
        }
        employee.setTasks(taskList);
        
        hRHelper.removeTasksFromEmployeeByEmployeeid(employee);
        hRHelper.saveEmployee(employee);

        httpServletResponse.sendRedirect("updateemployee");
    }
}
