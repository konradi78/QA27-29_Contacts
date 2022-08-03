package com.telrun.qa2729.contacts.models;

public class Contact {

    private  String name;
    private  String sureName;
    private  String phone;
    private  String email;
    private  String address;
    private  String description;

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Contact setSureName(String sureName) {
        this.sureName = sureName;
        return this;
    }

    public Contact setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }

    public Contact setAddress(String address) {
        this.address = address;
        return this;
    }

    public Contact setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getSureName() {
        return sureName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }
}