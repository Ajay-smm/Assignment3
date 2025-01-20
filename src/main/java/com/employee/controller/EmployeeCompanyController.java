package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.entity.EmployeeCompany;
import com.employee.service.EmployeeCompanyService;
import com.employee.service.EmployeeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employeecompany")
public class EmployeeCompanyController {

    @Autowired
    EmployeeCompanyService employeeCompanyService;

    @Autowired
    EmployeeService employeeService;






    @GetMapping("/getcompanydetails")
    public EmployeeCompany getAEmployeeCompanyById(@RequestParam ObjectId id) {
        return employeeCompanyService.getEmployeeCompany(id);
    }

    /*@PostMapping("/postadata")
    public String createEmployeeCompanyDetails(@RequestBody EmployeeCompany employeeCompany) {

        return employeeCompanyService.saveEmployeeCompany(employeeCompany);
    }*/

   /* @PostMapping("/postadata")
    public String createEmployeeCompanyDetails(@RequestParam String name, @RequestParam String location) {

        return employeeCompanyService.saveEmployeeCompany(name, location);
    }*/

    @PostMapping("/postcompanydetails")
    public String createEmployeeCompanyDetails(@RequestParam String name, @RequestParam String location) {

        Employee employee = employeeService.findByName(name);
        if(employee == null) {
            return "Employee not found with name: "+name;
        }
        return employeeCompanyService.saveEmployeeCompany(employee, location);
    }








    @PutMapping("/updatecompanydetails")
    public String updateEmployeeCompanyDetails(@RequestParam ObjectId id, @RequestBody EmployeeCompany updatedEmployeeCompany) {

        return employeeCompanyService.updateEmployeeCompany(id, updatedEmployeeCompany);
    }



    @DeleteMapping("/deletecompanydetails")
    public String deleteEmployeeCompanyDetails(@RequestParam ObjectId id) {

        return employeeCompanyService.deleteEmployeeCompany(id);
    }

    @GetMapping("/getcompanydetailsbylocation")
    public EmployeeCompany getEmployeeByLocation(@RequestParam String location) {

        return employeeCompanyService.getEmployeeByLocation(location);
    }


}
