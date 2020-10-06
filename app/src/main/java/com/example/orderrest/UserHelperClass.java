package com.example.orderrest;

public class UserHelperClass {
    String email;
    String userName;
    String phoneNo;
    String password;

    public UserHelperClass() {
    }

    public UserHelperClass(String email, String userName, String phoneNo,String password) {
        this.email = email;
        this.userName = userName;
        this.phoneNo = phoneNo;
        this.password = password;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

}
