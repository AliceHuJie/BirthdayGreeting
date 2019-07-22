package com.hujie;

import java.util.Date;

class Person {
    private String last_name;
    private String first_name;
    private Date date_of_birth;
    private String email;

    Person(String last_name, String first_name, Date date_of_birth, String email) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.date_of_birth = date_of_birth;
        this.email = email;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
