package com.employee.service;
import com.employee.entity.EmployeeReview;
import org.bson.types.ObjectId;
import java.util.List;


public interface EmployeeReviewService {

    String saveEmployeeReview(String name,  Integer review);
    EmployeeReview getEmployeeReview(ObjectId id);
    String updateEmployeeReview( ObjectId id,  EmployeeReview updatedEmployeeReview);
    String deleteEmployeeReview(ObjectId id);
    List<EmployeeReview> getEmployeeTopReviews();




}