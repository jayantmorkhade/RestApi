package com.Employee.gradle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

public class Empcontroller {

    @Autowired
    EmployeeRepository emprepo;
    Optional<Employee> opemployee;

    @PostMapping("/createEmp")
    public Employee saveEmp(@RequestBody Employee employee){
        System.out.println(employee);
        return emprepo.save(employee);
    }
    @GetMapping("/GetEmployee/{EmpId}")
    public String getEmployee(@PathVariable int EmpId) {

       opemployee = emprepo.findById(EmpId);
        if (opemployee.isPresent()) {
            return opemployee.toString();
        } else {

            return "no such element present in  DB";

    }


    }
    @GetMapping("/getAll")
public String getAllEmp(){
       // return emprepo.findAll();
        return CacheManager.cache.values().toString();
    }
@PutMapping("/fullUpdate/{EmpId}")
    public  String fullUpdate(@RequestBody Employee employee,@PathVariable int EmpId){
        System.out.println(employee);
        opemployee=emprepo.findById(EmpId);
    System.out.println(opemployee+"From db");
        if(opemployee.isPresent()){
           Employee TempEmp=opemployee.get();
            TempEmp.setEmpName(employee.getEmpName());
            TempEmp.setEmpAdd(employee.getEmpAdd());
           return emprepo.save(employee).toString();

        }
        else
        {
            return " no such element present in DB";
        }
}
@DeleteMapping("/Delete/{EmpId}")
    public  String delete(@PathVariable int EmpId){
        opemployee=emprepo.findById(EmpId);
        if(opemployee.isPresent()){
            Employee tempEmp= opemployee.get();
            emprepo.delete(tempEmp);
            return "Record is deleted";
        }
        else{
            return " no such element present in DB";
        }

}
}
