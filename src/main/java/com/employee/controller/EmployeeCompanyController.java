package com.employee.controller;

import com.employee.entity.EmployeeCompany;
import com.employee.service.EmployeeCompanyService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employeecompany")
public class EmployeeCompanyController {

    @Autowired
    EmployeeCompanyService employeeCompanyService;


    @GetMapping("/getadata/{id}")
    public EmployeeCompany getAEmployeeCompanyById(@PathVariable ObjectId id) {
        return employeeCompanyService.getEmployeeCompany(id);
    }

    @PostMapping("/postadata")
    public String createEmployeeCompanyDetails(@RequestBody EmployeeCompany employeeCompany) {

        return employeeCompanyService.saveEmployeeCompany(employeeCompany);
    }

    @PutMapping("/updateadata/{id}")
    public String updateEmployeeCompanyDetails(@PathVariable ObjectId id, @RequestBody EmployeeCompany updatedEmployeeCompany) {

        return employeeCompanyService.updateEmployeeCompany(id, updatedEmployeeCompany);
    }



    @DeleteMapping("/deleteadata/{id}")
    public String deleteEmployeeCompanyDetails(@PathVariable ObjectId id) {

        return employeeCompanyService.deleteEmployeeCompany(id);
    }

    @GetMapping("/getemployeebylocation/{location}")
    public EmployeeCompany getEmployeeByLocation(@PathVariable String location) {

        return employeeCompanyService.getEmployeeByLocation(location);
    }


}
