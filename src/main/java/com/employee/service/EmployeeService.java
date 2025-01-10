package com.employee.service;
import com.employee.entity.Employee;
import org.bson.types.ObjectId;

import java.util.List;

public interface EmployeeService {

    String saveEmployee(Employee employee);
    Employee getAEmployee(ObjectId id);
    String updateEmployee( ObjectId id,  Employee updatedEmployee);
    String deleteEmployee(ObjectId id);
    Employee topEmployee();




}