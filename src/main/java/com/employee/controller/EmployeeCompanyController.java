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


    @GetMapping("/getadata")
    public EmployeeCompany getAEmployeeCompanyById(@RequestParam ObjectId id) {
        return employeeCompanyService.getEmployeeCompany(id);
    }

    /*@PostMapping("/postadata")
    public String createEmployeeCompanyDetails(@RequestBody EmployeeCompany employeeCompany) {

        return employeeCompanyService.saveEmployeeCompany(employeeCompany);
    }*/

    @PostMapping("/postadata")
    public String createEmployeeCompanyDetails(@RequestParam String name, @RequestParam String location) {

        return employeeCompanyService.saveEmployeeCompany(name, location);
    }




    @PutMapping("/updateadata")
    public String updateEmployeeCompanyDetails(@RequestParam ObjectId id, @RequestBody EmployeeCompany updatedEmployeeCompany) {

        return employeeCompanyService.updateEmployeeCompany(id, updatedEmployeeCompany);
    }



    @DeleteMapping("/deleteadata")
    public String deleteEmployeeCompanyDetails(@RequestParam ObjectId id) {

        return employeeCompanyService.deleteEmployeeCompany(id);
    }

    @GetMapping("/getemployeebylocation")
    public EmployeeCompany getEmployeeByLocation(@RequestParam String location) {

        return employeeCompanyService.getEmployeeByLocation(location);
    }


}
