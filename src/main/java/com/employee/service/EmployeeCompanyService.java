package com.employee.service;

import com.employee.entity.EmployeeCompany;
import org.bson.types.ObjectId;



public interface EmployeeCompanyService {

    String saveEmployeeCompany(EmployeeCompany employeeCompany);
    EmployeeCompany getEmployeeCompany(ObjectId id);
    String updateEmployeeCompany( ObjectId id,  EmployeeCompany updatedEmployeeCompany);
    String deleteEmployeeCompany(ObjectId id);
    EmployeeCompany getEmployeeByLocation(String location);




}