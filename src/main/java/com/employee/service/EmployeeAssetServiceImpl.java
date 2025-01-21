package com.employee.service;
import com.employee.entity.Employee;
import com.employee.entity.EmployeeAsset;
import com.employee.repository.EmployeeAssetRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeAssetServiceImpl implements EmployeeAssetService {
    @Autowired
    EmployeeAssetRepository employeeAssetRepository;




    @Override
    public String saveEmployeeAssetDetails(Employee employee, Integer asset) {
        EmployeeAsset employeeAsset = new EmployeeAsset();
        //employeeAsset.setEmployeeId(employee.getId());
        employeeAsset.setName(employee.getName());

        employeeAsset.setAsset(asset);
        employeeAssetRepository.save(employeeAsset);
        return "data posted successfully";
    }



    @Override
    public EmployeeAsset getEmployeeAssetDetailsById(ObjectId id) {
        EmployeeAsset employeeAsset = employeeAssetRepository.findById(id).orElse(null);
        if (employeeAsset == null) {
            throw new RuntimeException("Employee company not found with id: " + id);
        }

        return employeeAsset;
    }
    @Override
    public String updateEmployeeAssetDetailsById(ObjectId id,  EmployeeAsset updatedEmployeeAsset) {
        EmployeeAsset existingEmployeeAsset = employeeAssetRepository.findById(id).orElse(null);

        if (existingEmployeeAsset == null) {
            throw new RuntimeException("Employee not found with id: " + id);
        }

        if (updatedEmployeeAsset.getName() != null) {
            existingEmployeeAsset.setName(updatedEmployeeAsset.getName());
        }
        if (updatedEmployeeAsset.getAsset() != null) {
            existingEmployeeAsset.setAsset(updatedEmployeeAsset.getAsset());
        }

        employeeAssetRepository.save(existingEmployeeAsset);

        return "Employee updated successfully";
    }

    @Override
    public String deleteEmployeeAssetDetailsById(ObjectId id) {

        EmployeeAsset existingEmployeeAsset = employeeAssetRepository.findById(id).orElse(null);

        if (existingEmployeeAsset == null) {
            throw new RuntimeException("employee not found with id: " + id);
        }

        employeeAssetRepository.deleteById(id);

        return " Employee deleted successfully";
    }

    @Override
    public List<EmployeeAsset> getEmployeeAssetDetailsByName(String name){
        return employeeAssetRepository.findByName(name);

    }



}
