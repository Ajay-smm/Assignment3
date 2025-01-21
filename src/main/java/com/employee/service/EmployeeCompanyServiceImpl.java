package com.employee.service;
import com.employee.entity.Employee;
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
    public String saveEmployeeCompany(Employee employee, String location) {
        EmployeeCompany employeeCompany = new EmployeeCompany();
        //employeeCompany.setEmployeeId(employee.getId());
        employeeCompany.setEmployeeName(employee.getName());

        employeeCompany.setLocation(location);
        employeeCompanyRepository.save(employeeCompany);
        return "data posted successfully";
    }

    @Override
    public EmployeeCompany getEmployeeCompanyById(ObjectId id) {
        EmployeeCompany employeeCompany = employeeCompanyRepository.findById(id).orElse(null);
        if (employeeCompany == null) {
            throw new RuntimeException("Employee company not found with id: " + id);
        }

         return employeeCompany;
    }
    @Override
    public String updateEmployeeCompanyDetailsById(ObjectId id,  EmployeeCompany updatedEmployeeCompany) {
        EmployeeCompany existingEmployeeCompany = employeeCompanyRepository.findById(id).orElse(null);

        if (existingEmployeeCompany == null) {
            throw new RuntimeException("Employee not found with id: " + id);
        }

        if (updatedEmployeeCompany.getEmployeeName() != null) {
            existingEmployeeCompany.setEmployeeName(updatedEmployeeCompany.getEmployeeName());
        }
        if (updatedEmployeeCompany.getLocation() != null) {
            existingEmployeeCompany.setLocation(updatedEmployeeCompany.getLocation());
        }

        employeeCompanyRepository.save(existingEmployeeCompany);

        return "Employee updated successfully";
    }

    @Override
    public String deleteEmployeeCompanyDetailsById(ObjectId id) {

        EmployeeCompany existingEmployeeCompany = employeeCompanyRepository.findById(id).orElse(null);

        if (existingEmployeeCompany == null) {
            throw new RuntimeException("employee not found with id: " + id);
        }

        employeeCompanyRepository.deleteById(id);

        return " Employee deleted successfully";
    }

    @Override
    public EmployeeCompany getEmployeeCompanyDetailsByLocation(String location){
        return employeeCompanyRepository.findByLocation(location);

    }



}
