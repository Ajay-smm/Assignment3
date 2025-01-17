package com.employee.service;
import com.employee.entity.EmployeeCompany;
import com.employee.repository.EmployeeCompanyRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCompanyServiceImpl implements EmployeeCompanyService {
    @Autowired
    EmployeeCompanyRepository employeeCompanyRepository;

    @Override
    public String saveEmployeeCompany(String name, String location) {

        EmployeeCompany employeeCompany = new EmployeeCompany();
        employeeCompany.setName(name);
        employeeCompany.setLocation(location);

        employeeCompanyRepository.save(employeeCompany);
        return "data posted successfully";

    }


    @Override
    public EmployeeCompany getEmployeeCompany (ObjectId id) {
        EmployeeCompany employeeCompany = employeeCompanyRepository.findById(id).orElse(null);

        if (employeeCompany != null) {
            return employeeCompany;
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }

    }

    @Override
    public String updateEmployeeCompany(ObjectId id,  EmployeeCompany updatedEmployeeCompany) {
        EmployeeCompany existingEmployeeCompany = employeeCompanyRepository.findById(id).orElse(null);

        if (existingEmployeeCompany == null) {
            throw new RuntimeException("Employee not found with id: " + id);
        }

        if (updatedEmployeeCompany.getName() != null) {
            existingEmployeeCompany.setName(updatedEmployeeCompany.getName());
        }
        if (updatedEmployeeCompany.getLocation() != null) {
            existingEmployeeCompany.setLocation(updatedEmployeeCompany.getLocation());
        }

        employeeCompanyRepository.save(existingEmployeeCompany);

        return "Employee updated successfully";
    }

    @Override
    public String deleteEmployeeCompany(ObjectId id) {

        EmployeeCompany existingEmployeeCompany = employeeCompanyRepository.findById(id).orElse(null);

        if (existingEmployeeCompany == null) {
            throw new RuntimeException("employee not found with id: " + id);
        }

        employeeCompanyRepository.deleteById(id);

        return " Employee deleted successfully";
    }

    @Override
    public EmployeeCompany getEmployeeByLocation(String location){
          return employeeCompanyRepository.findByLocation(location);

    }



}
