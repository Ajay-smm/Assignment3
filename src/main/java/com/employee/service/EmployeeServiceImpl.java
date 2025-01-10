package com.employee.service;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public String saveEmployee(Employee employee) {

        employeeRepository.save(employee);
        return "data posted successfully";

    }


    @Override
    public Employee getAEmployee (ObjectId id) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee != null) {
            return employee;
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }

    }


    @Override
    public String updateEmployee(ObjectId id,  Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);

        if (existingEmployee == null) {
            throw new RuntimeException("Employee not found with id: " + id);
        }


        if (updatedEmployee.getName() != null) {
            existingEmployee.setName(updatedEmployee.getName());
        }
        if (updatedEmployee.getSalary() != null) {
            existingEmployee.setSalary(updatedEmployee.getSalary());
        }

        employeeRepository.save(existingEmployee);

        return "Employee updated successfully";
    }


    @Override
    public String deleteEmployee(ObjectId id) {

        Employee existingEmployee = employeeRepository.findById(id).orElse(null);

        if (existingEmployee == null) {
            throw new RuntimeException("employee not found with id: " + id);
        }

        employeeRepository.deleteById(id);

        return " Employee deleted successfully";
    }

    @Override
    public Employee topEmployee() {

        return employeeRepository.findTopByOrderBySalaryDesc();

    }


}
