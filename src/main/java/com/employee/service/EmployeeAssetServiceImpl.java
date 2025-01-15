package com.employee.service;
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
    public String saveEmployeeAsset(EmployeeAsset employeeAsset) {

        employeeAssetRepository.save(employeeAsset);
        return "data posted successfully";

    }


    @Override
    public EmployeeAsset getEmployeeAsset (ObjectId id) {
        EmployeeAsset employeeAsset = employeeAssetRepository.findById(id).orElse(null);

        if (employeeAsset != null) {
            return employeeAsset;
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }

    }

    @Override
    public String updateEmployeeAsset(ObjectId id,  EmployeeAsset updatedEmployeeAsset) {
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
    public String deleteEmployeeAsset(ObjectId id) {

        EmployeeAsset existingEmployeeAsset = employeeAssetRepository.findById(id).orElse(null);

        if (existingEmployeeAsset == null) {
            throw new RuntimeException("employee not found with id: " + id);
        }

        employeeAssetRepository.deleteById(id);

        return " Employee deleted successfully";
    }

    @Override
    public List<EmployeeAsset> getEmployeeByName(String name){
        return employeeAssetRepository.findByName(name);

    }



}
