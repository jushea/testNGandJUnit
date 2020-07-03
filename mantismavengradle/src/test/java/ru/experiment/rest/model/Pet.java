package ru.experiment.rest.model;

import java.util.ArrayList;

public class Pet {
    public Integer id;
    public String name;
    public String status;
    public Category category;
    public ArrayList<String> photoUrls;
    public ArrayList<Tag> tags;
    public Pet() {

    }

//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public int getId() {
//        return id;
//    }
}
