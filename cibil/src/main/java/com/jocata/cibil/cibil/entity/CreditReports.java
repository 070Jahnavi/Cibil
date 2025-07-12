package com.jocata.cibil.cibil.entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="CreditReports")
public class CreditReports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Integer reportId;
    @Column(name = "generated_on")
    private LocalDate generatedOn;
    @OneToOne(mappedBy = "report",cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customers customer;
    @OneToOne(mappedBy = "report",cascade = CascadeType.ALL)
    private CbilScores cibilscore;
    @OneToMany(mappedBy = "report",cascade = CascadeType.ALL)
    private List<Accounts>accounts;
    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
    private List<Enquries> enquiries;

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
    private List<Remarks> remarks;

    public List<Accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Accounts> accounts) {
        this.accounts = accounts;
    }

    public List<Enquries> getEnquiries() {
        return enquiries;
    }

    public void setEnquiries(List<Enquries> enquiries) {
        this.enquiries = enquiries;
    }

    public List<Remarks> getRemarks() {
        return remarks;
    }

    public void setRemarks(List<Remarks> remarks) {
        this.remarks = remarks;
    }

    public CbilScores getCibilscore() {
        return cibilscore;
    }

    public void setCibilscore(CbilScores cibilscore) {
        this.cibilscore = cibilscore;
    }

    public Customers getCustomer(){
        return customer;
    }

    public void setCustomerId(Customers customer) {
        this.customer = customer;
    }

    public void setReportId(Integer reportId){
        this.reportId=reportId;
    }

    public Integer getReportId(){
        return reportId;
    }

    public void setGeneratedOn(LocalDate generatedOn) {
        this.generatedOn = generatedOn;
    }

    public LocalDate getGeneratedOn() {
        return generatedOn;
    }
}
