package com.model;

import com.enums.Gender;

/**
 * @author Suraj Maharjan
 * @version project zero 0.1
 * @quote “ Code is like humor. When you have to explain it, it’s bad.” – Cory House
 * @written_on 6/18/21 Friday
 */
public class Customer {
    private Integer id;
    private String fullName;
    private String address;
    private String email;
    private String mobileNumber;
    private Gender gender;



    public Customer(String fullName,
                    String address,
                    String email,
                    String mobileNumber,
                    Gender gender) {
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
    }


    public Customer(Integer id, String fullName,
                    String address, String email,
                    String mobileNumber, Gender gender) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
