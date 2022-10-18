package com.Employee.gradle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class CacheManager {

    public static HashMap<Integer,Employee> cache=new HashMap();

@Autowired
EmployeeRepository emprepo;

@Scheduled(cron = "0 *  * * * *")
    public void loadcache(){
    System.out.println("sarting to Load a cache");
    List<Employee> Emplist=emprepo.findAll();
    Emplist.forEach(employee -> cache.put(employee.getEmpId(),employee));
    System.out.println("end of cache loading");
    }
}
