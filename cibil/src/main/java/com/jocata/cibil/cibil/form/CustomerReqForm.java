package com.jocata.cibil.cibil.form;

public class CustomerReqForm {
    private String customerId;
    private String fullName;
    private String dob;
    private String gender;
    private String pan;
    private String mobile;
    private String email;
    private String aadhar;
    private CreditReportsReqForm report;

    private AddressReqForm address;

    public void setReport(CreditReportsReqForm report) {
        this.report = report;
    }

    public CreditReportsReqForm getReport() {
        return report;
    }

    public AddressReqForm getAddress() {
        return address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getAadhar() {
        return aadhar;
    }

    public String getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPan() {
        return pan;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setAddress(AddressReqForm address) {
        this.address = address;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }
}
