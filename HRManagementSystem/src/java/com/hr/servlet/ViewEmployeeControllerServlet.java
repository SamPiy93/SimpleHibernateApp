/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hr.helper.HRHelper;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Request;
import com.hr.models.Employee;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Sameera
 */
public class ViewEmployeeControllerServlet extends HttpServlet implements RequestResponseInterface{

    private HRHelper hRHelper = new HRHelper();
    /**
     * Method to handle GET requests and responses
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws IOException
     * @throws ServletException 
     */
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        List<Employee> employeeList = hRHelper.getEmployeeList();
        List<Employee> result = new LinkedList<>();
        for(Employee emp: employeeList){
            result.add(emp);
        }
        httpServletRequest.setAttribute("empList", result);
        RequestDispatcher rd = httpServletRequest.getRequestDispatcher("displayEmployees.jsp");
        rd.forward(httpServletRequest, httpServletResponse);
    }
    /**
     * Method to handle POST request and responses
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws IOException 
     */
    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.getWriter().print("POST RESPONSE");
    }
}
