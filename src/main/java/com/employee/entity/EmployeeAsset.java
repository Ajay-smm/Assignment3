package com.employee.entity;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "EmployeeAsset")
public class EmployeeAsset {
    @Id
    private  ObjectId id;


   private String name;
    private Integer asset;

    public EmployeeAsset() {

    }

    public ObjectId getId() {

        return id;
    }

    public void setId(ObjectId id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Integer getAsset() {

        return asset;
    }

    public void setAsset(Integer asset) {

        this.asset = asset;
    }


}
