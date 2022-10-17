package com.Employee.gradle;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int EmpId;
    private String EmpName;
    private String EmpAdd;

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmpId=" + EmpId +
                ", EmpName='" + EmpName + '\'' +
                ", EmpAdd='" + EmpAdd + '\'' +
                '}';
    }

    public Employee(int empId, String empName, String empAdd) {
        EmpId = empId;
        EmpName = empName;
        EmpAdd = empAdd;
    }

    public int getEmpId() {
        return EmpId;
    }

    public void setEmpId(int empId) {
        EmpId = empId;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }

    public String getEmpAdd() {
        return EmpAdd;
    }

    public void setEmpAdd(String empAdd) {
        EmpAdd = empAdd;
    }
}
