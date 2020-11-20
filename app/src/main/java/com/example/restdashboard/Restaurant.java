package com.example.restdashboard;

public class Restaurant {

    private String rest_name;
    private String rest_tag;

    public Restaurant(String rest_name, String rest_tag) {
        this.rest_name = rest_name;
        this.rest_tag = rest_tag;
    }

    public String getRest_name() {
        return rest_name;
    }

    public void setRest_name(String rest_name) {
        this.rest_name = rest_name;
    }

    public String getRest_tag() {
        return rest_tag;
    }

    public void setRest_tag(String rest_tag) {
        this.rest_tag = rest_tag;
    }
}
