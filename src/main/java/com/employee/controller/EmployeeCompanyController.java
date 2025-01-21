package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.entity.EmployeeCompany;
import com.employee.service.EmployeeCompanyService;
import com.employee.service.EmployeeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employee-company")
public class EmployeeCompanyController {

    @Autowired
    EmployeeCompanyService employeeCompanyService;

    @Autowired
    EmployeeService employeeService;



    @GetMapping("/get-company-details")
    public EmployeeCompany getAEmployeeCompanyDetailsById(@RequestParam String id) {
        ObjectId objectId = new ObjectId(id);
        return employeeCompanyService.getEmployeeCompanyById(objectId);
    }

    @PostMapping("/post-company-details")
    public String createEmployeeCompanyDetails(@RequestParam String name, @RequestParam String location) {
        Employee employee = employeeService.findByName(name);
        if (employee == null) {
            return "Employee not found with name: " + name;
        }
        return employeeCompanyService.saveEmployeeCompany(employee, location);
    }



    @PutMapping("/update-company-details")
    public String updateEmployeeCompanyDetailsById(@RequestParam ObjectId id, @RequestBody EmployeeCompany updatedEmployeeCompany) {

        return employeeCompanyService.updateEmployeeCompanyDetailsById(id, updatedEmployeeCompany);
    }



    @DeleteMapping("/delete-company-details")
    public String deleteEmployeeCompanyDetails(@RequestParam ObjectId id) {

        return employeeCompanyService.deleteEmployeeCompanyDetailsById(id);
    }

    @GetMapping("/get-employee-details-by-location")
    public EmployeeCompany getEmployeeByLocation(@RequestParam String location) {

        return employeeCompanyService.getEmployeeCompanyDetailsByLocation(location);
    }








}
