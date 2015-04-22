/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.malinkil.mp2.service;

import edu.iit.sat.itmd4515.malinkil.mp2.model.Employee;
import edu.iit.sat.itmd4515.malinkil.mp2.repository.EmployeeRepository;
import edu.iit.sat.itmd4515.malinkil.mp2.repository.jdbc.JdbcEmployeeRepository;
import java.util.Collection;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author mithun.alinkil
 */
public class ServiceImpl implements Service {

    
//    @Inject @SimpleCustomerRepository
    @Inject @JdbcEmployeeRepository
    private EmployeeRepository employeeRepository;

    public ServiceImpl() {
    }
    
    @Override
    public Collection<Employee> findEmployee() {
         return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployee(Long id) {
        return employeeRepository.findById(id);
    }
    
     @Override
    public Boolean saveEmployee(Employee emp) {
        return employeeRepository.saveEmployeeInfo(emp);
    }

    @Override
    public Boolean updateEmployee(Employee upEmployee) {
        return employeeRepository.updateEmployeeInfo(upEmployee);
    }
 @Override
    public Boolean deleteEmployee(Long id) {
        return employeeRepository.deleteEmployeeInfo(id);
    }

    
}
