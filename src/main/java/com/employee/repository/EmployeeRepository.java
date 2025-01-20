package com.employee.repository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.employee.entity.Employee;
import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, ObjectId> {

    Employee findTopByOrderBySalaryDesc();
    Employee findByName(String name);


}