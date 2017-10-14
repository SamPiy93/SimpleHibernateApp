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
public class UpdateTaskControllerServlet extends HttpServlet implements RequestResponseInterface{
    private HRHelper hRHelper = new HRHelper();
    /**
     * Method to handle GET requests and responses
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws IOException
     * @throws ServletException 
     */
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        List<Task> taskList = hRHelper.getTaskList();
        List<Task> result = new LinkedList<>();
        for(Task task: taskList){
            result.add(task);
        }
        System.out.println("task"+result);
        httpServletRequest.setAttribute("taskList", result);
        RequestDispatcher rd = httpServletRequest.getRequestDispatcher("updateTasks.jsp");
        rd.forward(httpServletRequest, httpServletResponse);
    }
    /**
     * Method to handle POST request and responses
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws IOException 
     */
    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        int taskid = Integer.parseInt(httpServletRequest.getParameter("taskid"));
        int employeeid = 0;
        String description = httpServletRequest.getParameter("description");
        
        Task task = new Task();
        task.setTaskid(taskid);
        task.setDescription(description);
        Employee employee = new Employee();
        if(!httpServletRequest.getParameter("employeeid").equals("")){
            employeeid = Integer.parseInt(httpServletRequest.getParameter("employeeid"));
            employee.setEmployeeid(employeeid);
            task.setEmployee(employee);
        }
        
        hRHelper.saveTask(task);
        httpServletResponse.sendRedirect("updatetask");
    }
}
