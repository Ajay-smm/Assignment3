package com.employee.service;
import com.employee.entity.Employee;
import com.employee.entity.EmployeeAsset;
import org.bson.types.ObjectId;
import java.util.List;


public interface EmployeeAssetService {

    String saveEmployeeAsset(Employee name, Integer asset);
    EmployeeAsset getEmployeeAsset(ObjectId id);
    String updateEmployeeAsset( ObjectId id,  EmployeeAsset updatedEmployeeAsset);
    String deleteEmployeeAsset(ObjectId id);
    List<EmployeeAsset> getEmployeeByName(String name);




}