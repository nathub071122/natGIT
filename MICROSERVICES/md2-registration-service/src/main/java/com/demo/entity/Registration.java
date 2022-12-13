//package com.demo.entity;
//import javax.persistence.Column;
//import javax.persistence.Table;
//@Table(name="REGISTRATIONS")
//
//public class Registration {
//    @Column(name="ADMIN_NAME", nullable = false, length = 25)
//    String adminName;
//   @Column(name="EMAIL", nullable = false,length = 25)
//    String email;
//    String phone;
//    String password;
//
//    Registration(){
//        super();
//    }
//    public Registration(String adminName, String email, String phone, String password) {
//        this.adminName = adminName;
//        this.email = email;
//        this.phone = phone;
//        this.password = password;
//    }
//    public String getAdminName() {
//        return adminName;
//    }
//    public void setAdminName(String adminName) {
//        this.adminName = adminName;
//    }
//    public String getEmail() {
//        return email;
//    }
//    public void setEmail(String email) {
//        this.email = email;
//    }
//    public String getPhone() {
//        return phone;
//    }
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//    public String getPassword() {
//        return password;
//    }
//    public void setPassword(String password) {
//        this.password = password;
//    }
//    @Override
//    public String toString() {
//        return "Registration{" +
//                "adminName='" + adminName + '\'' +
//                ", email='" + email + '\'' +
//                ", phone='" + phone + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
//}
