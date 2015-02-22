/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mshah73.mp2.repository.jdbc;

import edu.iit.sat.itmd4515.mshah73.mp2.model.Employee;
import edu.iit.sat.itmd4515.mshah73.mp2.repository.EmployeeRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 *
 * @author spyrisos
 */
@JdbcEmployeeRepository
public class JdbcEmployeeRepositoryImpl implements EmployeeRepository {

    @Resource(lookup = "jdbc/msshah73Mp2DS")
    private DataSource dataSource;

    public JdbcEmployeeRepositoryImpl() {
    }

    @Override
    public Collection<Employee> findAll() {

        List<Employee> customers = new ArrayList<>();

        try (Connection c = dataSource.getConnection()) {

            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select * from employees");

            while (rs.next()) {
                customers.add(new Employee(rs.getLong("emp_no"),
                        rs.getString("first_name"),
                        rs.getString("last_name")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(JdbcEmployeeRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (customers.isEmpty()) {
            return null;
        } else {
            return customers;
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
    public void save(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
