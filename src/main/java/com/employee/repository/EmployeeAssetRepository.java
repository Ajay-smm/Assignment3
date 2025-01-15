package com.employee.repository;
import com.employee.entity.EmployeeAsset;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeAssetRepository extends MongoRepository<EmployeeAsset, ObjectId> {

  List<EmployeeAsset> findByName(String name);


}