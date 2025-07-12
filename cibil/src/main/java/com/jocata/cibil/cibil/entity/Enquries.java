package com.jocata.cibil.cibil.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "Enquries")
public class Enquries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enqury_id")
    private Integer enquryId;
    @Column(name="enqury_date")
    private Date enquryDate;
    @Column(name="member_name")
    private String memberName;
    @Column(name="enquiry_purpose")
    private String enquryPurpose;
    @Column(name="enquiry_amount")
    private BigDecimal enquryAmount;
    @ManyToOne
    @JoinColumn(name = "report_id")
    private CreditReports report;



    public Integer getEnquryId() {
        return enquryId;
    }

    public void setEnquryId(Integer enquryId) {
        this.enquryId = enquryId;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberName() {
        return memberName;
    }

    public CreditReports getReport() {
        return report;
    }

    public void setReport(CreditReports report) {
        this.report = report;
    }

    public Date getEnquryDate() {
        return enquryDate;
    }

    public void setEnquryDate(Date enquryDate) {
        this.enquryDate = enquryDate;
    }

    public String getEnquryPurpose() {
        return enquryPurpose;
    }

    public void setEnquryPurpose(String enquryPurpose) {
        this.enquryPurpose = enquryPurpose;
    }

    public BigDecimal getEnquryAmount() {
        return enquryAmount;
    }

    public void setEnquryAmount(BigDecimal enquryAmount) {
        this.enquryAmount = enquryAmount;
    }
}
