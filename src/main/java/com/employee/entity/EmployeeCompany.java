package com.employee.entity;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "EmployeeCompany")
public class EmployeeCompany {
    @Id
    private ObjectId id;


    private String employeeName;
    private String location;






    public EmployeeCompany() {

    }

    public ObjectId getId() {

        return id;
    }

    public void setId(ObjectId id) {

        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }



    public String getLocation() {

        return location;
    }

    public void setLocation(String location) {

        this.location = location;
    }






}
