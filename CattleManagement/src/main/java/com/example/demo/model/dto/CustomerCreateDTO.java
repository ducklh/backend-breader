package com.example.demo.model.dto;

public class CustomerCreateDTO {
    String fullName;
    String address;
    String createDate;
    String phone;
    String email;
    Boolean gender;
    String message;
    int province;
    int district;
    int ward;

    public CustomerCreateDTO(String fullName, String address, String createDate, String phone, String email, Boolean gender, String message, int province, int district, int ward) {
        this.fullName = fullName;
        this.address = address;
        this.createDate = createDate;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.message = message;
        this.province = province;
        this.district = district;
        this.ward = ward;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public int getWard() {
        return ward;
    }

    public void setWard(int ward) {
        this.ward = ward;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
