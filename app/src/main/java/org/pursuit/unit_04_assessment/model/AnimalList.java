package org.pursuit.unit_04_assessment.model;

import java.util.List;

public class AnimalList {

    private String status;
    private List<Animal> message;

    public AnimalList() {}

    public AnimalList(String status, List<Animal> message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public List<Animal> getMessage() {
        return message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(List<Animal> message) {
        this.message = message;
    }
}
