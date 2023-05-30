package com.example.javafx_project.entities;

import java.io.Serializable;

public class Producer implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String CIN;
    private String address;
    private Integer phoneNumber;

    public Producer() {
    }

    public Producer(Integer id, String name, String CIN, String address, Integer phoneNumber) {
        this.id = id;
        this.name = name;
        this.CIN = CIN;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Producer(String name, String CIN, String address, Integer phoneNumber) {
        this.name = name;
        this.CIN = CIN;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", CIN='" + CIN + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
