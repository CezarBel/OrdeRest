package com.example.orderrest;

public class UserHelperClass {
    String email,phoneNo,password,id;

    public UserHelperClass() {
    }

    public UserHelperClass(String email, String phoneNo, String password,String id) {
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
