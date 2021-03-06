/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.malinkil.mp2.repository.jdbc;

import edu.iit.sat.itmd4515.malinkil.mp2.model.Employee;
import edu.iit.sat.itmd4515.malinkil.mp2.repository.EmployeeRepository;
import edu.iit.sat.itmd4515.malinkil.mp2.web.EmployeeController;
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
 * @author mithun.alinkil
 */
@JdbcEmployeeRepository
public class JdbcEmployeeRepositoryImpl implements EmployeeRepository {

    @Resource(lookup = "jdbc/malinkilMp2DS")
    private DataSource dataSource;
    
    private static final Logger LOG
            = Logger.getLogger(EmployeeController.class.getName());

    public JdbcEmployeeRepositoryImpl() {
    }

    /**
     * Method returns employees list from employees table.
     * 
     */
    @Override
    public Collection<Employee> findAll() {

        List<Employee> employee = new ArrayList<>();

        try (Connection c = dataSource.getConnection()) {

            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select  * from employees ORDER BY EMP_NO DESC LIMIT 20;");

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
/**
 * Method returns individual employee details.
 * 
 */
    @Override
    public Employee findById(Long id) {

        try (Connection c = dataSource.getConnection()) {
            PreparedStatement ps = c.prepareStatement("select d.dept_name d_name,e.emp_no e_no,"
            + "e.first_name e_fname,e.last_name e_lname from  departments d  join dept_emp de \n" +
            "on d.dept_no= de.dept_no join employees e on de.emp_no = e.emp_no where e.emp_no=?;");
           
            
            ps.setLong(1, id);
            
           ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Employee(rs.getLong("e_no"),
                        rs.getString("e_fname"),
                        rs.getString("e_lname"),
                rs.getString("d_name"));
            }
            else
            {
                
            Statement s = c.createStatement();
            rs = s.executeQuery("select  * from employees where emp_no="+id);

            while (rs.next()) {
                return new Employee(rs.getLong("emp_no"),
                        rs.getString("first_name"),
                        rs.getString("last_name"), "-----");
            }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(JdbcEmployeeRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
/**
 * Method takes employee data and saves data into employees table
 * 
 */
    @Override
    public Boolean saveEmployeeInfo(Employee employee) {
        
        String fName = null;
        String lName = null;
        String deptName = null;
        String gender = null;
        String bdate = null;
        String currentDate = null;
        
        int emp_id = 0;
        String dept_id = null;
        boolean isSave = false;
        boolean isDepPresent = false;
        
           try (Connection c = dataSource.getConnection()) {
               
            fName = employee.getEmpFirstname();
            lName = employee.getEmpLastName();
            deptName = employee.getDept_name();
            bdate = employee.getEmpBdate();
            gender = employee.getEmpGender();
            Statement statement = c.createStatement();
            
            /**
             * Query to get max id so that new record can be inserted.
             */
            ResultSet rs = statement.executeQuery("select max(emp_no)as maxID from employees;");
             while (rs.next()) {
               emp_id = rs.getInt("maxID");
            }
            
             
             rs = statement.executeQuery("select dept_no from departments where dept_name = '"+deptName+"';");
             
             if(rs.next())
             {
                    dept_id =  rs.getString("dept_no");
                    isDepPresent= true; 
             }
             else
             {      
                    /**
                    * Query to get max department id so that new record can be inserted into department table.
                    */
                   rs = statement.executeQuery("select max(dept_no) Deptid from departments;");

                   while (rs.next()) {
                      dept_id = rs.getString("Deptid");

                      
                      int deptID = Integer.parseInt(dept_id.substring(1));
                       deptID = deptID +1; 
                       dept_id= "d"+deptID;
               }
             }

            
            emp_id= emp_id+1;
            
            currentDate = getCurrentDate();
            
            LOG.info("Date 2"+currentDate);
       
            /**
             * Insert records into employees table.
             */
           statement.executeUpdate("INSERT INTO employees " + "VALUES ("+emp_id +",'"+bdate +"','"+fName +"','"+lName +"','"+gender +"','"+currentDate +"')");
          
           if(!isDepPresent){
             statement.executeUpdate("INSERT INTO departments " + "VALUES ('"+dept_id +"','"+deptName +"')");
           }
            /**
            * To insert record into dept_emp table.
            */
           
           LOG.info("INSERT INTO dept_emp " + " VALUES ("+emp_id +",'"+dept_id +"','"+currentDate +"','"+currentDate +"')");

            statement.executeUpdate("INSERT INTO dept_emp " + " VALUES ("+emp_id +",'"+dept_id +"','"+currentDate +"','"+currentDate +"')");
           
           isSave = true;
                   
           return isSave;

        } catch (SQLException ex) {
            Logger.getLogger(JdbcEmployeeRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isSave;
    }
    
       
/**
 * Method to update employee information.
 * 
 */
    @Override
    public Boolean updateEmployeeInfo(Employee employee) {
        
        String updateFname = null;
        String updateLname = null;
        String updateDeptname = null;
        Long empId; 
        String dept_no = null;
        Boolean isUpdate = false;
        
        try (Connection c = dataSource.getConnection()) {
            
            Statement statement = c.createStatement();
              
            updateFname = employee.getEmpFirstname();
            updateLname = employee.getEmpLastName();
            updateDeptname = employee.getDept_name();
            empId = employee.getEmployeeID();
   
            String getDeptNo = "select dept_no from dept_emp where emp_no ="+empId;
  
           ResultSet rs = statement.executeQuery(getDeptNo);
            
         
            if (rs.next()) {
               dept_no = rs.getString("dept_no");
            }      
            /**
             * Query to update the data in employee and department table.
             */
            String updateEmployee = "update employees set first_name = '"+updateFname+"',last_name = '"+updateLname+"'  where emp_no = "+empId+";";
            String updateDepartment = "update departments set dept_name = '"+updateDeptname+"'  where dept_no = '"+dept_no+"' ";
            
            statement.executeUpdate(updateEmployee);
            statement.executeUpdate(updateDepartment);
            
            isUpdate = true;
            return isUpdate;
            
        } catch (SQLException ex) {
            Logger.getLogger(JdbcEmployeeRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
            

    }  
    @Override
    public Boolean deleteEmployeeInfo(Long empId) {
       
        
        String dept_no = null;
        Boolean isDelete = false;
        
        try (Connection c = dataSource.getConnection()) {
            
            Statement statement = c.createStatement();
            
            
            
            String getDeptNo = "select dept_no from dept_emp where emp_no ="+empId;
  
           ResultSet rs = statement.executeQuery(getDeptNo);
           
            if (rs.next()) {
               dept_no = rs.getString("dept_no");
            }      
            
            /**
             * Delete query to delete row from employee,department  and dep_emp table.
             */
            String deleteEmployee = "delete from employees where emp_no = "+empId+";";
            String deleteDepEmp = "delete from dept_emp where emp_no = "+empId+";";
            String deleteDepartment = "delete from departments where dept_no= '"+dept_no+"'";
            
            
            
            statement.executeUpdate(deleteEmployee);
            statement.executeUpdate(deleteDepEmp);
            statement.executeUpdate(deleteDepartment);
            
            isDelete = true;
            
            return isDelete;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(JdbcEmployeeRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
            

    } 
   
    public String getCurrentDate(){
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            return dateFormat.format(date);

        }
}