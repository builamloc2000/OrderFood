package com.example.user_service.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class UserUpdateRequestDTO {

    private String firstName;
    private String lastName;
    private String dob;
    private String email;
    private String phoneNumber;
    private String address;
    private boolean gender;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public boolean isGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}
