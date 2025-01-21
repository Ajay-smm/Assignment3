package com.employee.controller;

import com.employee.entity.Employee;

import com.employee.entity.EmployeeReview;

import com.employee.service.EmployeeReviewService;
import com.employee.service.EmployeeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee-review")
public class EmployeeReviewController {

    @Autowired
    EmployeeReviewService employeeReviewService;

    @Autowired
    EmployeeService employeeService;



    @GetMapping("/get-review-details-by-id")
    public EmployeeReview getEmployeeReviewDetailsById(@RequestParam String id) {
        ObjectId objectId = new ObjectId(id);
        return employeeReviewService.getEmployeeReviewDetailsById(objectId);
    }

    @PostMapping("/post-review-details")
    public String createEmployeeReviewDetails(@RequestParam String name, @RequestParam Integer review) {
        Employee employee = employeeService.findByName(name);
        if (employee == null) {
            return "Employee not found with name: " + name;
        }
        return employeeReviewService.createEmployeeReviewDetails(employee, review);
    }



    @PutMapping("/update-review-details-by-id")
    public String updateEmployeeReviewDetailsById(@RequestParam ObjectId id, @RequestBody EmployeeReview updatedEmployeeReview) {

        return employeeReviewService.updateEmployeeReviewDetailsById(id, updatedEmployeeReview);
    }



    @DeleteMapping("/delete-review-details-by-id")
    public String deleteEmployeeCompanyDetails(@RequestParam ObjectId id) {

        return employeeReviewService.deleteEmployeeReviewDetailsById(id);
    }

    @GetMapping("/get-reviews-high-to-low")

    public List<EmployeeReview> getEmployeeReviewHighToLow() {

        return employeeReviewService.getEmployeeReviewHighToLow();
    }








}
