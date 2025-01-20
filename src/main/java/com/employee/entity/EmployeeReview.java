package com.employee.entity;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "EmployeeReview")
public class EmployeeReview {
    @Id
    private ObjectId id;

    @DBRef
    private Employee name;

    private Integer review;

    public EmployeeReview() {

    }

    public ObjectId getId() {

        return id;
    }

    public void setId(ObjectId id) {

        this.id = id;
    }

    public Employee getName() {

        return name;
    }

    public void setName(Employee name) {

        this.name = name;
    }

    public Integer getReview() {

        return review;
    }

    public void setReview(Integer review) {

        this.review = review;
    }


}
