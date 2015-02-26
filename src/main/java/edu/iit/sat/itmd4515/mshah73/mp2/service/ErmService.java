/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mshah73.mp2.service;

import edu.iit.sat.itmd4515.mshah73.mp2.model.Employee;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author mshah73
 */
public interface ErmService {
    Collection<Employee> findEmployee();
    Employee findEmployee(Long id);
    Boolean saveEmployee(Employee employee);
}
