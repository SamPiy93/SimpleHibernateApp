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
import org.json.simple.JSONObject;

/**
 *
 * @author Sameera
 */
public class SaveEmployeeControllerServlet extends HttpServlet implements RequestResponseInterface{

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
        List<Role> result = new LinkedList<>();
        for(Role role : roleList){
            if (role.getEmployee() == null) {
                result.add(role);
            }
        }
        httpServletRequest.setAttribute("roleList", result);
        RequestDispatcher rd = httpServletRequest.getRequestDispatcher("addEmployee.jsp");

        rd.forward(httpServletRequest, httpServletResponse);
    }
    /**
     * Method to handle POST request and responses
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws IOException 
     */
    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String name = httpServletRequest.getParameter("name");
        int roleid = Integer.parseInt(httpServletRequest.getParameter("role-selection").split(",")[0]);
        String title = httpServletRequest.getParameter("role-selection").split(",")[1];
        Role role = new Role();
        role.setRoleid(roleid);
        role.setTitle(title);
        
        Employee employee = new Employee();
        employee.setName(name);
        employee.setRole(role);
        hRHelper.saveEmployee(employee);
        httpServletResponse.sendRedirect("viewemployee");
    }
}
