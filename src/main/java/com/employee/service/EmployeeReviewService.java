package com.employee.service;
import com.employee.entity.Employee;
import com.employee.entity.EmployeeReview;
import org.bson.types.ObjectId;
import java.util.List;


public interface EmployeeReviewService {

    String createEmployeeReviewDetails(Employee employee, Integer review);
    EmployeeReview getEmployeeReviewDetailsById(ObjectId id);
    String updateEmployeeReviewDetailsById( ObjectId id,  EmployeeReview updatedEmployeeReview);
    String deleteEmployeeReviewDetailsById(ObjectId id);
    List<EmployeeReview> getEmployeeReviewHighToLow();




}