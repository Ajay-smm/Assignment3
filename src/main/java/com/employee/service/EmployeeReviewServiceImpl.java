package com.employee.service;
import com.employee.entity.Employee;
import com.employee.entity.EmployeeReview;
import com.employee.repository.EmployeeRepository;
import com.employee.repository.EmployeeReviewRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeReviewServiceImpl  implements EmployeeReviewService {
    @Autowired
    EmployeeReviewRepository employeeReviewRepository;


    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public String saveEmployeeReview(Employee employee, Integer review) {
        EmployeeReview employeeReview = new EmployeeReview();
        employeeReview.setName(employee);
        employeeReview.setReview(review);
        employeeReviewRepository.save(employeeReview);
        return "data posted successfully";

    }


    @Override
    public EmployeeReview getEmployeeReview (ObjectId id) {
        EmployeeReview employeeReview = employeeReviewRepository.findById(id).orElse(null);

        if (employeeReview != null) {
            return employeeReview;
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }

    }

    @Override
    public String updateEmployeeReview(ObjectId id,  EmployeeReview updatedEmployeeReview) {
        EmployeeReview existingEmployeeReview = employeeReviewRepository.findById(id).orElse(null);

        if (existingEmployeeReview == null) {
            throw new RuntimeException("Employee not found with id: " + id);
        }

        if (updatedEmployeeReview.getName() != null) {
            existingEmployeeReview.setName(updatedEmployeeReview.getName());
        }
        if (updatedEmployeeReview.getReview() != null) {
            existingEmployeeReview.setReview(updatedEmployeeReview.getReview());
        }

        employeeReviewRepository.save(existingEmployeeReview);

        return "Employee updated successfully";
    }

    @Override
    public String deleteEmployeeReview(ObjectId id) {

        EmployeeReview existingEmployeeReview = employeeReviewRepository.findById(id).orElse(null);

        if (existingEmployeeReview == null) {
            throw new RuntimeException("employee not found with id: " + id);
        }

        employeeReviewRepository.deleteById(id);

        return " Employee deleted successfully";
    }

    @Override
    public List<EmployeeReview> getEmployeeTopReviews(){
        return employeeReviewRepository.findAllByOrderByReviewDesc();

    }






}
