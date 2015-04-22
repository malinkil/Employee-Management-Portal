/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.malinkil.mp2.web;

import edu.iit.sat.itmd4515.malinkil.mp2.model.Employee;
import edu.iit.sat.itmd4515.malinkil.mp2.service.Service;
import edu.iit.sat.itmd515.malinkil.mp2.util.WebUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mithun.alinkil
 * Class consists of switch case for create, update and delete also 
 * consists of server side validation of inputs
 */
@WebServlet(name = "EmployeeController", urlPatterns = 
        {"/employee","/employees","/create","/home","/save","/updateRequest","/update","/deleteRequest"})
public class EmployeeController extends HttpServlet {

    @Inject
    private Service svc;

    private static final Logger LOG
            = Logger.getLogger(EmployeeController.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LOG.info("Inside doGet");

        Map<String,String> messages = new HashMap<>();
        Date dbDate = null;
        request.setAttribute("messages", messages);
        
        switch (request.getServletPath()) {
            case "/employees":
                LOG.info("Dispatching to /employees");
                request.setAttribute("employees", svc.findEmployee());
                request.getRequestDispatcher("/WEB-INF/webpages/employeeInfo/employeeList.jsp").forward(request, response);
                break;
            case "/employee":
                LOG.info("Dispatching to /employee");
                
                if(WebUtil.isEmpty(request.getParameter("id"))){
                    LOG.warning("No ID passed .");
                    messages.put("Error", "Please enter ID.");
                    throw new ServletException("No ID. Try again!");
                }
                
                Long id = Long.parseLong(request.getParameter("id"));
                request.setAttribute("employee", svc.findEmployee(id));
                request.getRequestDispatcher("/WEB-INF/webpages/employeeInfo/employeeData.jsp").forward(request, response);
                break;
                       /**
                 * Create new employee details.
                 * 
                 */
                
            case "/create":
         
                LOG.info("Dispatching to /createEMployee");
                request.getRequestDispatcher("/WEB-INF/webpages/newEmployee/createEmployee.jsp").forward(request, response);
                break;
            case "/home":
                LOG.info("Dispatching to /home");
                
                request.getRequestDispatcher("/WEB-INF/webpages/homepage/home.jsp").forward(request, response);
                break;
            case "/updateRequest":
                LOG.info("Dispatching to /updateRequest");
                
                if(WebUtil.isEmpty(request.getParameter("id"))){
                    LOG.warning("No ID passed.");
                    messages.put("No ID Error", "This is a     from your controller.  Please enter an ID.");
                    throw new ServletException("No ID was passed.  Try again!");
                }
                
                Long updateId = Long.parseLong(request.getParameter("id"));
                request.setAttribute("upEmployee", svc.findEmployee(updateId));
                request.getRequestDispatcher("/WEB-INF/webpages/updateEmployee/updateEmp.jsp").forward(request, response);
                break;
            case "/update":
                LOG.info("Dispatching to /update");
                
                if(WebUtil.isEmpty(request.getParameter("id"))){
                 LOG.warning("ID was not passed as a parameter.");
                 messages.put("Error", "Please enter ID.");
                 throw new ServletException("No ID.Try again!");
             }

               Long updateActId = Long.parseLong(request.getParameter("id"));
                
                String upFname = request.getParameter("first_name");
                String upLname = request.getParameter("last_name");
                String upDname = request.getParameter("dept_name");
                
                Employee upEmp = new Employee(updateActId,upFname,upLname,upDname);
                
                Boolean upResult = svc.updateEmployee(upEmp);
                
                request.setAttribute("updateEmployee", upResult);
                request.setAttribute("employees", svc.findEmployee());
                request.getRequestDispatcher("/WEB-INF/webpages/employeeInfo/employeeList.jsp").forward(request, response);
                break;
            case "/deleteRequest":
                LOG.info("Inside /deleteRequest");
                
                if(WebUtil.isEmpty(request.getParameter("id"))){
                    LOG.warning("No ID .");
                    messages.put("Error", "Please enter an ID.");
                    throw new ServletException("No ID. Try again!");
                }
                
                Long deleteId = Long.parseLong(request.getParameter("id"));
                boolean isDeleted = svc.deleteEmployee(deleteId);
                request.setAttribute("delEmpoloyee", isDeleted);
                request.setAttribute("employees", svc.findEmployee());
                request.getRequestDispatcher("/WEB-INF/webpages/employeeInfo/employeeList.jsp").forward(request, response);
                break;
                
            case "/save":
                LOG.info("Dispatching to /save");
                String fname = request.getParameter("first_name");
                String lname = request.getParameter("last_name");
                String dname = request.getParameter("dept_name");
                String gender = request.getParameter("gender");
                String date = request.getParameter("date");
                
                
                LOG.info("fname "+fname);
                LOG.info("Date "+date);

                
                if(fname.isEmpty() || lname.isEmpty() || dname.isEmpty() || gender == null  || date.isEmpty() )
                {
                    if(fname.isEmpty()){request.setAttribute("fnameReq","true");}
                    if(lname.isEmpty()){request.setAttribute("lnameReq","true");}
                    if(dname.isEmpty()){request.setAttribute("dnameReq","true");}
                    if(gender == null){request.setAttribute("genderReq","true");}
                    if(date.isEmpty()){request.setAttribute("dateReq","true");}
                    
                    request.getRequestDispatcher("/WEB-INF/webpages/newEmployee/createEmployee.jsp").forward(request, response);
  
                }
                else
                {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                    {
                        try {
                            date = dateFormat.format(dateFormat.parse(date));
                        } catch (ParseException ex) {
                            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }


                    Employee emp = new Employee(fname,lname,dname,gender,date);

                    Boolean result = svc.saveEmployee(emp);
                    if(result){
                        request.setAttribute("newEmp",result);
                        request.getRequestDispatcher("/WEB-INF/webpages/newEmployee/createEmployee.jsp").forward(request, response);

                    }
                }
                break;
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * 
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
