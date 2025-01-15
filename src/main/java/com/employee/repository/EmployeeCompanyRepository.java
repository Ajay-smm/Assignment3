package com.employee.repository;
import com.employee.entity.EmployeeCompany;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCompanyRepository extends MongoRepository<EmployeeCompany, ObjectId> {

    EmployeeCompany findByLocation(String location);


}