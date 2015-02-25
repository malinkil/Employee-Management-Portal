/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mshah73.mp2.repository.jdbc;

import edu.iit.sat.itmd4515.mshah73.mp2.model.Employee;
import edu.iit.sat.itmd4515.mshah73.mp2.repository.EmployeeRepository;
import edu.iit.sat.itmd4515.mshah73.mp2.web.EmployeeController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 *
 * @author mshah
 */
@JdbcEmployeeRepository
public class JdbcEmployeeRepositoryImpl implements EmployeeRepository {

    @Resource(lookup = "jdbc/mshah73Mp2DS")
    private DataSource dataSource;
    
    private static final Logger LOG
            = Logger.getLogger(EmployeeController.class.getName());

    public JdbcEmployeeRepositoryImpl() {
    }

    @Override
    public Collection<Employee> findAll() {

        List<Employee> employee = new ArrayList<>();

        try (Connection c = dataSource.getConnection()) {

            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select * from employees");

            while (rs.next()) {
                employee.add(new Employee(rs.getLong("emp_no"),
                        rs.getString("first_name"),
                        rs.getString("last_name")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(JdbcEmployeeRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (employee.isEmpty()) {
            return null;
        } else {
            return employee;
        }
    }

    @Override
    public Employee findById(Long id) {

        try (Connection c = dataSource.getConnection()) {
            PreparedStatement ps = c.prepareStatement("select * from employees where emp_no = ?");
            ps.setLong(1, id);
 

           ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Employee(rs.getLong("emp_no"),
                        rs.getString("first_name"),
                        rs.getString("last_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JdbcEmployeeRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public Boolean saveEmployeeInfo(Employee employee) {
        
        String fName = null;
        String lName = null;
        String deptName = null;
        String gender = null;
        String bdate = null;
        String currentDate = null;
        
        int id = 0;
        boolean isSave = false;
        
           try (Connection c = dataSource.getConnection()) {
            
            Statement statement = c.createStatement();
            
            ResultSet rs = statement.executeQuery("select * from employees;");

            while (rs.next()) {
               id = rs.getInt("emp_no");
            }
            
            
            
            fName = employee.getEmpFirstname();
            lName = employee.getEmpLastName();
            deptName = employee.getDept_name();
            bdate = employee.getEmpBdate();
            gender = employee.getEmpGender();
            
            LOG.info(gender);
                    
            id= id+1;
            
            currentDate = getCurrentDate();
            
            LOG.info("Date 2"+currentDate);
       
            
           statement.executeUpdate("INSERT INTO employees " + "VALUES ("+id +",'"+bdate +"','"+fName +"','"+lName +"','"+gender +"','"+currentDate +"')");
           isSave = true;
                   
           return isSave;

        } catch (SQLException ex) {
            Logger.getLogger(JdbcEmployeeRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isSave;
    }
    
        /**
         * 
         * Method getCurrentDate which returns current date
         */
        public String getCurrentDate(){
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            return dateFormat.format(date);

        }
    }

