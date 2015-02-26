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
            ResultSet rs = s.executeQuery("select  * from employees ORDER BY EMP_NO DESC LIMIT 100;");

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
        
        int emp_id = 0;
        int dept_id = 0;
        boolean isSave = false;
        
           try (Connection c = dataSource.getConnection()) {
            
            Statement statement = c.createStatement();
            
            /**
             * Query toget max id toinsert new employee record
             */
            ResultSet rs = statement.executeQuery("select * from employees;");
             while (rs.next()) {
               emp_id = rs.getInt("emp_no");
            }
            
            /**
             * Query to get max department id to insert record into department table
             */
            rs = statement.executeQuery("select * from departments;");

            while (rs.next()) {
               dept_id = rs.getInt("dept_no");
            }
            
            
            
            fName = employee.getEmpFirstname();
            lName = employee.getEmpLastName();
            deptName = employee.getDept_name();
            bdate = employee.getEmpBdate();
            gender = employee.getEmpGender();
            
            LOG.info(gender);
            
            /**
             * Make operation of addition(i.e ID +1) on id to insert new row into table
             */
            emp_id= emp_id+1;
            dept_id= dept_id+1;
            
            /**
             * Call method getCurrentdate in order to get current date into  table employees
             */
            currentDate = getCurrentDate();
            
            LOG.info("Date 2"+currentDate);
       
            /**
             * Insert records into employees table
             */
           statement.executeUpdate("INSERT INTO employees " + "VALUES ("+emp_id +",'"+bdate +"','"+fName +"','"+lName +"','"+gender +"','"+currentDate +"')");
          /**
           * Insert records ino departments table
           */
            statement.executeUpdate("INSERT INTO departments " + "VALUES ("+dept_id +",'"+deptName +"')");
           /**
            * Insert record into dept_emp table
            */
           statement.executeUpdate("INSERT INTO dept_emp(emp_no,dept_no)" + "VALUES ("+emp_id +","+dept_id +")");
           
           /**
            * Set the flag true on successful insertion on all three records
            */
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

