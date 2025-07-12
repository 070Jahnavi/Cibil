package com.jocata.cibil.cibil.form;

import com.jocata.cibil.cibil.entity.Address;
import com.jocata.cibil.cibil.entity.CreditReports;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.sql.Date;

public class CustomerResForm {

    //private String customerId;
    private String fullName;
    private String dob;
    private String gender;
    private String pan;
    private String mobile;
    private String email;
    private String aadhar;
    //private CreditReportsResForm report;

    private AddressResForm address;

    /*public void setReport(CreditReportsResForm report) {
        this.report = report;
    }

    public CreditReportsResForm getReport() {
        return report;
    }*/

    public AddressResForm getAddress() {
        return address;
    }

   /* public String getCustomerId() {
        return customerId;
    }*/

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

    /*public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }*/

    public void setAddress(AddressResForm address) {
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
