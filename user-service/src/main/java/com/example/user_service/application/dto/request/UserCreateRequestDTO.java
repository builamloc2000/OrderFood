package com.example.user_service.application.dto.request;

public class UserCreateRequestDTO {

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

    public int getAge() {
        return age;
    }

    public boolean isGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }

    public String getLastName() {
        return lastName;
    }
}
