package com.employee.repository;
import com.employee.entity.EmployeeReview;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;


public interface EmployeeReviewRepository  extends MongoRepository<EmployeeReview, ObjectId> {

    List<EmployeeReview> findAllByOrderByReviewDesc();


}
