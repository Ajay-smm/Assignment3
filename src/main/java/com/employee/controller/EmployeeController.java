package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/getemployeedata")
    public Employee getAEmployeeById(@RequestParam ObjectId id)
    {

        return employeeService.getAEmployee(id);
    }

    @PostMapping("/postemployeedata")
    public String createEmployeeDetails(@RequestParam String name, @RequestParam Double salary) {

        return employeeService.saveEmployee(name,salary);
    }

    @PutMapping("/updateemployeedata")
    public String updateEmployeeDetails(@RequestParam ObjectId id, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }



    @DeleteMapping("/deleteemployeedata")
    public String deleteEmployeeDetails(@RequestParam ObjectId id) {

        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/gettopsalary")
    public Employee getTopEmployee()
    {

        return employeeService.topEmployee();
    }


}
