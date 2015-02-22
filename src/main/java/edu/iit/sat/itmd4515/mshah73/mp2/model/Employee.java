/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mshah73.mp2.model;

/**
 *
 * @author Maulik
 */
public class Employee {

    private Long employeeID;
    private String empFirstname;
    private String empLastName;
    
    public Employee() {
    }
   
   public Employee(Long employeeID, String empFirstname, String empLastName) {
        this.employeeID = employeeID;
        this.empFirstname = empFirstname;
        this.empLastName = empLastName;
    }

    /**
     * Get the value of empFirstname
     *
     * @return the value of empFirstname
     */
    public String getEmpFirstname() {
        return empFirstname;
    }

    /**
     * Set the value of empFirstname
     *
     * @param empFirstname new value of empFirstname
     */
    public void setEmpFirstname(String empFirstname) {
        this.empFirstname = empFirstname;
    }
    

    /**
     * Get the value of empLastName
     *
     * @return the value of empLastName
     */
    public String getEmpLastName() {
        return empLastName;
    }

    /**
     * Set the value of empLastName
     *
     * @param empLastName new value of empLastName
     */
    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }


    /**
     * Get the value of employeeID
     *
     * @return the value of employeeID
     */
    public Long getEmployeeID() {
        return employeeID;
    }

    /**
     * Set the value of employeeID
     *
     * @param employeeID new value of employeeID
     */
    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeID=" + employeeID + ", empFirstname=" + empFirstname + ", empLastName=" + empLastName + '}';
    }
  
    
}
