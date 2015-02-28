/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mshah73.mp2.repository;

import edu.iit.sat.itmd4515.mshah73.mp2.model.Employee;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author spyrisos
 */
public interface EmployeeRepository {
    Collection<Employee> findAll();
    Employee findById(Long id);
    Boolean saveEmployeeInfo(Employee employee);
    Boolean updateEmployeeInfo(Employee employee);
    Boolean deleteEmployeeInfo(Long id);
}
