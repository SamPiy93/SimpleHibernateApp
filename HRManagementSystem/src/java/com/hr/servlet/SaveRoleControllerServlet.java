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

/**
 *
 * @author Sameera
 */
public class SaveRoleControllerServlet extends HttpServlet implements RequestResponseInterface{
    private HRHelper hRHelper = new HRHelper();
    /**
     * Method to handle GET requests and responses
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws IOException
     * @throws ServletException 
     */
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        RequestDispatcher rd = httpServletRequest.getRequestDispatcher("addRoles.jsp");
        rd.forward(httpServletRequest, httpServletResponse);
    }
    /**
     * Method to handle POST request and responses
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws IOException 
     */
    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String title = httpServletRequest.getParameter("title");
        Role role = new Role();
        role.setTitle(title);
        hRHelper.saveRole(role);
        httpServletResponse.sendRedirect("updaterole");
    }
}
