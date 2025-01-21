package com.employee.service;
import com.employee.entity.Employee;
import com.employee.entity.EmployeeAsset;
import com.employee.entity.EmployeeCompany;
import org.bson.types.ObjectId;

import java.util.List;

public interface EmployeeAssetService {

    String saveEmployeeAssetDetails(Employee name, Integer asset);
    EmployeeAsset getEmployeeAssetDetailsById(ObjectId id);

    String updateEmployeeAssetDetailsById( ObjectId id,  EmployeeAsset updatedEmployeeAsset);
    String deleteEmployeeAssetDetailsById(ObjectId id);
    List<EmployeeAsset> getEmployeeAssetDetailsByName(String name);




}