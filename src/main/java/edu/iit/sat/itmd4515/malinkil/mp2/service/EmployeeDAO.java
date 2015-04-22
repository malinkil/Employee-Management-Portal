 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.malinkil.mp2.service;

import edu.iit.sat.itmd4515.malinkil.mp2.model.Employee;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 * 
 *
 * @author mithun.alinkil
 */
@Stateless
public class EmployeeDAO {

    
    public List<Employee> findEmployees() {
        //JDBC work here
        // return List<Customer>
        return null;
    }
}
