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
@RequestMapping("/employee-asset")
public class EmployeeAssetController {

    @Autowired
    EmployeeAssetService employeeAssetService;

    @Autowired
    EmployeeService employeeService;



    @GetMapping("/get-asset-details")
    public EmployeeAsset getAEmployeeAssetDetailsById(@RequestParam String id) {
        ObjectId objectId = new ObjectId(id);
        return employeeAssetService.getEmployeeAssetDetailsById(objectId);
    }

    @PostMapping("/post-asset-details")
    public String createEmployeeAssetDetails(@RequestParam String name, @RequestParam Integer asset) {
        Employee employee = employeeService.findByName(name);
        if (employee == null) {
            return "Employee not found with name: " + name;
        }
        return employeeAssetService.saveEmployeeAssetDetails(employee, asset);
    }



    @PutMapping("/update-asset-details")
    public String updateEmployeeAssetDetailsById(@RequestParam ObjectId id, @RequestBody EmployeeAsset updatedEmployeeAsset) {

        return employeeAssetService.updateEmployeeAssetDetailsById(id, updatedEmployeeAsset);
    }



    @DeleteMapping("/delete-asset-details")
    public String deleteEmployeeAssetDetailsById(@RequestParam ObjectId id) {

        return employeeAssetService.deleteEmployeeAssetDetailsById(id);
    }

    @GetMapping("/get-asset-details-by-name")
    public List<EmployeeAsset> getEmployeeAssetDetailsByName(@RequestParam String name) {

        return employeeAssetService.getEmployeeAssetDetailsByName(name);
    }

}
