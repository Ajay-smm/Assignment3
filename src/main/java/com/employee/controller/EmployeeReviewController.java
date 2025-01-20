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
@RequestMapping("/employeereview")
public class EmployeeReviewController {

    @Autowired
    EmployeeReviewService employeeReviewService;


    @Autowired
    EmployeeService employeeService;



    @GetMapping("/getemployeereview")
    public EmployeeReview getAEmployeeReviewById(@RequestParam ObjectId id) {
        return employeeReviewService.getEmployeeReview(id);
    }

/*    @PostMapping("/postadata")
    public String createEmployeeReviewDetails(@RequestParam String name, @RequestParam Integer review) {

        return employeeReviewService.saveEmployeeReview(name,review);
    }*/


    @PostMapping("/postemployeereview")
    public String createEmployeeAssetDetails(@RequestParam String name, @RequestParam Integer review) {

        Employee employee = employeeService.findByName(name);
        if(employee == null) {
            return "Employee not found with name: "+name;
        }
        return employeeReviewService.saveEmployeeReview(employee, review);
    }






    @PutMapping("/updateemployeereview")
    public String updateEmployeeReviewDetails(@RequestParam ObjectId id, @RequestBody EmployeeReview updatedEmployeeReview) {

        return employeeReviewService.updateEmployeeReview(id, updatedEmployeeReview);
    }


    @DeleteMapping("/deleteemployeereview")
    public String deleteEmployeeReviewDetails(@RequestParam ObjectId id) {

        return employeeReviewService.deleteEmployeeReview(id);
    }

    @GetMapping("/gettopreviews")
    public List<EmployeeReview> getEmployeeTopReviews() {

        return employeeReviewService.getEmployeeTopReviews();
    }


}
