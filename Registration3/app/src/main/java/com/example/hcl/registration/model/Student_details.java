package com.example.hcl.registration.model;

/**
 * Created by hcl on 3/2/18.
 */

public class Student_details {
    public String Name;
    public String email;
    public int mob_number;
    public String address;
    public int id;
    public Student_details(int id,String name, String email, int mob_number, String address) {
        this.Name = name;
        this.id=id;
        this.email = email;
        this.mob_number = mob_number;
        this.address = address;
    }
    public Student_details(String name, String email, int mob_number, String address) {
        this.Name = name;
        this.email = email;
        this.mob_number = mob_number;
        this.address = address;
    }
    public Student_details(){}

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getMob_number() {
        return mob_number;
    }
    public void setMob_number(int mob_number) {
        this.mob_number = mob_number;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
