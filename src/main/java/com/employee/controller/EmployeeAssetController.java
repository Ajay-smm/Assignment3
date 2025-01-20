package com.employee.controller;
import com.employee.entity.Employee;
import com.employee.entity.EmployeeAsset;
import com.employee.service.EmployeeAssetService;
import com.employee.service.EmployeeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/employeeasset")
public class EmployeeAssetController {

    @Autowired
    EmployeeAssetService employeeAssetService;
    @Autowired
    EmployeeService employeeService;


    @GetMapping("/getassetdetails")
    public EmployeeAsset getAEmployeeAssetById(@RequestParam ObjectId id) {
        return employeeAssetService.getEmployeeAsset(id);
    }

    @PostMapping("/postassetdetails")
    public String createEmployeeAssetDetails(@RequestParam String name, @RequestParam Integer asset) {

        Employee employee = employeeService.findByName(name);
        if(employee == null) {
            return "Employee not found with name: "+name;
        }
        return employeeAssetService.saveEmployeeAsset(employee, asset);
    }

    @PutMapping("/updateassetdetails")
    public String updateEmployeeAssetDetails(@RequestParam ObjectId id, @RequestBody EmployeeAsset updatedEmployeeAsset) {

        return employeeAssetService.updateEmployeeAsset(id, updatedEmployeeAsset);
    }


    @DeleteMapping("/deleteassetdetails")
    public String deleteEmployeeAssetDetails(@RequestParam ObjectId id) {

        return employeeAssetService.deleteEmployeeAsset(id);
    }

    @GetMapping("/getemployeebyname")
    public List<EmployeeAsset> getEmployeeByLocation(@RequestParam String name) {

        return employeeAssetService.getEmployeeByName(name);
    }


}
