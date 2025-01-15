package com.employee.entity;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "EmployeeCompany")
public class EmployeeCompany {
    @Id
    private ObjectId id;

    private String name;
    private String location;

    public EmployeeCompany() {

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

    public String getLocation() {

        return location;
    }

    public void setLocation(String location) {

        this.location = location;
    }


}
