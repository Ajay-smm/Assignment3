package com.employee.controller;
import com.employee.entity.EmployeeReview;
import com.employee.service.EmployeeReviewService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/employeereview")
public class EmployeeReviewController {

    @Autowired
    EmployeeReviewService employeeReviewService;


    @GetMapping("/getadata")
    public EmployeeReview getAEmployeeReviewById(@RequestParam ObjectId id) {
        return employeeReviewService.getEmployeeReview(id);
    }

    @PostMapping("/postadata")
    public String createEmployeeReviewDetails(@RequestParam String name, @RequestParam Integer review) {

        return employeeReviewService.saveEmployeeReview(name,review);
    }

    @PutMapping("/updateadata")
    public String updateEmployeeReviewDetails(@RequestParam ObjectId id, @RequestBody EmployeeReview updatedEmployeeReview) {

        return employeeReviewService.updateEmployeeReview(id, updatedEmployeeReview);
    }


    @DeleteMapping("/deleteadata")
    public String deleteEmployeeReviewDetails(@RequestParam ObjectId id) {

        return employeeReviewService.deleteEmployeeReview(id);
    }

    @GetMapping("/gettopreviews")
    public List<EmployeeReview> getEmployeeTopReviews() {

        return employeeReviewService.getEmployeeTopReviews();
    }


}
