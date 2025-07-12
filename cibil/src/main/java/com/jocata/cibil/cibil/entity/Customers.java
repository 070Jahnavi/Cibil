package com.jocata.cibil.cibil.entity;

import com.jocata.cibil.cibil.form.AddressResForm;
import com.jocata.cibil.cibil.form.CreditReportsResForm;
import jakarta.persistence.*;

import java.sql.Date;
@Entity
@Table(name = "Customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Integer customerId;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "dob")
    private Date dob;
    @Column(name="gender")
    private String gender;
    @Column(name="pan")
    private String pan;
    @Column(name="mobile")
    private String mobile;
    @Column(name="email")
    private String email;
    @Column(name="aadhar")
    private String aadhar;
    @OneToOne
    @JoinColumn(name="report_id")
    private CreditReports report;

    @OneToOne(mappedBy = "customers",cascade = CascadeType.ALL)
    private Address address;




    public CreditReports getReport() {
        return report;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setReport(CreditReports report) {
        this.report = report;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getDob(){
        return dob;
    }

    public String getFullName() {
        return fullName;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAadhar() {
        return aadhar;
    }
}
