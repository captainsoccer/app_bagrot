package com.example.idk_tofes;

public class User {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String userName;

    public User(String name, String email, String password, String phone, String userName) {
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;

        if(email == null || email.isEmpty()) throw new IllegalArgumentException("Email cannot be empty");
        this.email = email;

        if(password == null || password.isEmpty()) throw new IllegalArgumentException("Password cannot be empty");
        this.password = password;

        if(phone == null || phone.isEmpty()) throw new IllegalArgumentException("Phone cannot be empty");
        this.phone = phone;

        if(userName == null || userName.isEmpty()) throw new IllegalArgumentException("Username cannot be empty");
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }
}
