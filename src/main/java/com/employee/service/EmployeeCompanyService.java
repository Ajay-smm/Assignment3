package com.employee.service;


import com.employee.entity.Employee;
import com.employee.entity.EmployeeCompany;
import org.bson.types.ObjectId;



public interface EmployeeCompanyService {


    String saveEmployeeCompany(Employee name, String location);
    EmployeeCompany getEmployeeCompanyById(ObjectId id);

    String updateEmployeeCompanyDetailsById( ObjectId id,  EmployeeCompany updatedEmployeeCompany);
    String deleteEmployeeCompanyDetailsById(ObjectId id);
    EmployeeCompany getEmployeeCompanyDetailsByLocation(String location);




}