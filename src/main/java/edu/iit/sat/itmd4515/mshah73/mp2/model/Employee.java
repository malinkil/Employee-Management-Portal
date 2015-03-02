/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mshah73.mp2.model;

import java.util.Date;

/**
 *
 * @author Maulik
 */
public class Employee {

    private Long employeeID;
    private String empFirstname;
    private String empLastName;
    private String empDeptName;
    private String empGender;
    private String empBdate;
   
    
    public Employee() {
    }
   
   public Employee(Long employeeID, String empFirstname, String empLastName,String empDeptName) {
        this.employeeID = employeeID;
        this.empFirstname = empFirstname;
        this.empLastName = empLastName;
        this.empDeptName = empDeptName;
    }
   
    public Employee(Long employeeID, String empFirstname, String empLastName) {
        this.employeeID = employeeID;
        this.empFirstname = empFirstname;
        this.empLastName = empLastName;
       
    }
   
    public Employee(String empFirstname,String empLastName,String empDeptName,String empGender,String empBdate) {
        this.empFirstname = empFirstname;
        this.empLastName = empLastName;
        this.empDeptName = empDeptName;
        this.empGender = empGender;
        this.empBdate = empBdate;
    }
    private String dept_name;

    /**
     * Get the value of empDeptName
     *
     * @return the value of empDeptName.
     */
    public String getDept_name() {
        return empDeptName;
    }

    /**
     * Set the value of empDeptName
     *
     * @param empDeptName new value of empDeptName.
     */
    public void setDept_name(String empDeptName) {
        this.empDeptName = empDeptName;
    }


    /**
     * Get the value of empFirstname
     *
     * @return the value of empFirstname
     */
    public String getEmpFirstname() {
        return empFirstname;
    }

    public String getEmpDeptName() {
        return empDeptName;
    }

    public void setEmpDeptName(String empDeptName) {
        this.empDeptName = empDeptName;
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

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public String getEmpBdate() {
        return empBdate;
    }

    public void setEmpBdate(String empBdate) {
        this.empBdate = empBdate;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeID=" + employeeID + ", empFirstname=" + empFirstname + ", empLastName=" + empLastName + ", empDeptName=" + empDeptName + ", empGender=" + empGender + ", empBdate=" + empBdate + ", dept_name=" + dept_name + '}';
    }

 
  
    
}
