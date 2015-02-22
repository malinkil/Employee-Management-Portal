 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mshah73.mp2.service;

import edu.iit.sat.itmd4515.mshah73.mp2.model.Employee;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 * You could just have a JDBC dao class without all the abstraction examples.
 *
 * In that case, EmployeeDAO would have all your JDBC code to fetch, retrieve
 save, delete and build Customer objects to/from the database
 
 In this example, it is presented as a Stateless EJB (just with that one
 annotation @Stateless).  You could then refer to this with @EJB annotation
 in other Servlet code
 *
 * @author spyrisos
 */
@Stateless
public class EmployeeDAO {

    //@Resource(lookup = "jdbc/yourDS")
    //DataSource dataSource;
    
    public List<Employee> findEmployees() {
        //JDBC work here
        // return List<Customer>
        return null;
    }
}
