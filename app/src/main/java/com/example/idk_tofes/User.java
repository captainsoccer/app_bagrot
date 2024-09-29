package com.example.idk_tofes;

import androidx.annotation.NonNull;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String userName;

    public User(String name, String email, String password, String phone, String userName) {

        checkName(name);
        this.name = name;

        checkUserName(userName);
        this.userName = userName;

        checkPassword(password);
        this.password = password;

        checkEmail(email);
        this.email = email;

        checkPhone(phone);
        this.phone = phone;
    }

    public User(String user){
        String[] data = user.split("\n");
        name = data[0];
        email = data[1];
        password = data[2];
        phone = data[3];
        userName = data[4];
    }

    @NonNull
    public String toString(){
        return name + "\n" + email + "\n" + password + "\n" + phone + "\n" + userName;
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

    public String getUserName() {
        return userName;
    }

    private void checkName(String name) {
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty");
        else if(name.length() < 3) throw new IllegalArgumentException("Name needs to be at least 3 characters long");
        else if(name.length() > 50) throw new IllegalArgumentException("Name needs to be at most 50 characters long");
        else if (!name.matches("[a-zA-Z ]+")) throw new IllegalArgumentException("Only text is allowed in name");
    }

    private void checkUserName(String userName) {
        if(userName == null || userName.isEmpty()) throw new IllegalArgumentException("Username cannot be empty");
        else if(userName.length() < 3) throw new IllegalArgumentException("Username needs to be at least 3 characters long");
        else if(userName.length() > 50) throw new IllegalArgumentException("Username needs to be at most 50 characters long");
        else if (!userName.matches("[a-zA-Z ]+")) throw new IllegalArgumentException("Only text is allowed in username");
    }

    private void checkPassword(String password) {
        if(password == null || password.isEmpty()) throw new IllegalArgumentException("Password cannot be empty");
        else if(password.length() < 8) throw new IllegalArgumentException("Password needs to be at least 8 characters long");
        else if(password.length() > 50) throw new IllegalArgumentException("Password needs to be at most 50 characters long");
    }

    private void checkEmail(String email) {
        if(email == null || email.isEmpty()) throw new IllegalArgumentException("Email cannot be empty");
        else if(email.length() < 5) throw new IllegalArgumentException("Email needs to be at least 5 characters long");
        else if(email.length() > 50) throw new IllegalArgumentException("Email needs to be at most 50 characters long");
        else if (!email.matches("^(.+)@(.+)$")) throw new IllegalArgumentException("Invalid email");
    }

    private void checkPhone(String phone) {
        if(phone == null || phone.isEmpty()) throw new IllegalArgumentException("Phone cannot be empty");
        else if(phone.length() < 10) throw new IllegalArgumentException("Phone needs to be at least 10 characters long");
        else if(phone.length() > 10) throw new IllegalArgumentException("Phone needs to be at most 10 characters long");
        else if (!phone.matches("[0-9]+")) throw new IllegalArgumentException("Only numbers are allowed in phone number");
    }
}
