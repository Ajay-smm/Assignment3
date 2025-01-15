package com.employee.controller;

import com.employee.entity.EmployeeAsset;
import com.employee.service.EmployeeAssetService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employeeasset")
public class EmployeeAssetController {

    @Autowired
    EmployeeAssetService employeeAssetService;


    @GetMapping("/getadata/{id}")
    public EmployeeAsset getAEmployeeAssetById(@PathVariable ObjectId id) {
        return employeeAssetService.getEmployeeAsset(id);
    }

    @PostMapping("/postadata")
    public String createEmployeeAssetDetails(@RequestBody EmployeeAsset employeeAsset) {

        return employeeAssetService.saveEmployeeAsset(employeeAsset);
    }

    @PutMapping("/updateadata/{id}")
    public String updateEmployeeAssetDetails(@PathVariable ObjectId id, @RequestBody EmployeeAsset updatedEmployeeAsset) {

        return employeeAssetService.updateEmployeeAsset(id, updatedEmployeeAsset);
    }



    @DeleteMapping("/deleteadata/{id}")
    public String deleteEmployeeAssetDetails(@PathVariable ObjectId id) {

        return employeeAssetService.deleteEmployeeAsset(id);
    }

    @GetMapping("/getemployeebyname")
    public List<EmployeeAsset> getEmployeeByLocation(@RequestParam String name) {

        return employeeAssetService.getEmployeeByName(name);
    }


}
