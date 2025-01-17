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


    @GetMapping("/getadata")
    public EmployeeAsset getAEmployeeAssetById(@RequestParam ObjectId id) {
        return employeeAssetService.getEmployeeAsset(id);
    }

    @PostMapping("/postadata")
    public String createEmployeeAssetDetails(@RequestParam String name, @RequestParam Integer asset) {

        return employeeAssetService.saveEmployeeAsset(name, asset);
    }

    @PutMapping("/updateadata")
    public String updateEmployeeAssetDetails(@RequestParam ObjectId id, @RequestBody EmployeeAsset updatedEmployeeAsset) {

        return employeeAssetService.updateEmployeeAsset(id, updatedEmployeeAsset);
    }


    @DeleteMapping("/deleteadata")
    public String deleteEmployeeAssetDetails(@RequestParam ObjectId id) {

        return employeeAssetService.deleteEmployeeAsset(id);
    }

    @GetMapping("/getemployeebyname")
    public List<EmployeeAsset> getEmployeeByLocation(@RequestParam String name) {

        return employeeAssetService.getEmployeeByName(name);
    }


}
