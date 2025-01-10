package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/getadata/{id}")
    public Employee getAEmployeeById(@PathVariable ObjectId id)
    {

        return employeeService.getAEmployee(id);
    }

    @PostMapping("/postadata")
    public String createEmployeeDetails(@RequestBody Employee employee) {

        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/updateadata/{id}")
    public String updateEmployeeDetails(@PathVariable ObjectId id, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }



    @DeleteMapping("/deleteadata/{id}")
    public String deleteEmployeeDetails(@PathVariable ObjectId id) {

        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/topsalary")
    public Employee getTopEmployee()
    {

        return employeeService.topEmployee();
    }



}
