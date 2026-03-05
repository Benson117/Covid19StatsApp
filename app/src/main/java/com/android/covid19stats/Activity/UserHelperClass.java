package com.android.covid19stats.Activity;


//The class which connects with the Registration class to store information in the FIREBASE REALTIME TIME DATABASE
public class UserHelperClass {

    String fullName, email, password, phone;



    public UserHelperClass() {


    }

    public UserHelperClass(String fullName, String email, String password, String phone) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setfullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}


