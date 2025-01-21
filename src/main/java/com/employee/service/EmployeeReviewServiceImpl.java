package com.employee.service;
import com.employee.entity.Employee;
import com.employee.entity.EmployeeReview;
import com.employee.repository.EmployeeReviewRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeReviewServiceImpl implements EmployeeReviewService {
    @Autowired
    EmployeeReviewRepository employeeReviewRepository;




    @Override
    public String createEmployeeReviewDetails(Employee employee, Integer review) {
        EmployeeReview employeeReview = new EmployeeReview();
        //employeeCompany.setEmployeeId(employee.getId());

        employeeReview.setName(employee.getName());

        employeeReview.setReview(review);
        employeeReviewRepository.save(employeeReview);
        return "data posted successfully";
    }

    @Override
    public EmployeeReview getEmployeeReviewDetailsById(ObjectId id) {
        EmployeeReview employeeReview = employeeReviewRepository.findById(id).orElse(null);
        if (employeeReview == null) {
            throw new RuntimeException("Employee company not found with id: " + id);
        }

        return employeeReview;
    }
    @Override
    public String updateEmployeeReviewDetailsById(ObjectId id,  EmployeeReview updatedEmployeeReview) {
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
    public String deleteEmployeeReviewDetailsById(ObjectId id) {

        EmployeeReview existingEmployeeReview = employeeReviewRepository.findById(id).orElse(null);

        if (existingEmployeeReview == null) {
            throw new RuntimeException("employee not found with id: " + id);
        }

        employeeReviewRepository.deleteById(id);

        return " Employee deleted successfully";
    }

    @Override
    public List<EmployeeReview> getEmployeeReviewHighToLow() {
        return employeeReviewRepository.findAllByOrderByReviewDesc();

    }





}
