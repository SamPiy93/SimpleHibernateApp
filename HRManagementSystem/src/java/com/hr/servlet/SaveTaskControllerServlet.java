/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.servlet;

import com.hr.helper.HRHelper;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hr.models.Role;
import com.hr.models.Task;

/**
 *
 * @author Sameera
 */
public class SaveTaskControllerServlet extends HttpServlet implements RequestResponseInterface{
    private HRHelper hRHelper = new HRHelper();
    /**
     * Method to handle GET requests and responses
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws IOException
     * @throws ServletException 
     */
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        RequestDispatcher rd = httpServletRequest.getRequestDispatcher("addTasks.jsp");
        rd.forward(httpServletRequest, httpServletResponse);
    }
    /**
     * Method to handle POST request and responses
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws IOException 
     */
    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String description = httpServletRequest.getParameter("description");
        Task task = new Task();
        task.setDescription(description);
        hRHelper.saveTask(task);
        httpServletResponse.sendRedirect("updatetask");
    }
}
