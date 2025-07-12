package com.jocata.cibil.cibil.form;

import com.jocata.cibil.cibil.entity.*;

import java.util.List;


public class CreditReportsResForm {

    private String reportId;
    private String generatedOn;
    private CustomerResForm customers;
    private CibilScoreResForm CibilScores;
    private List<AccountResForm> accounts;
    private List<EnquriesResForm> enquries;
    private List<RemarkResForm> remarks;

    public CustomerResForm getCustomers() {
        return customers;
    }

    public void setCustomers(CustomerResForm customers) {
        this.customers = customers;
    }

    public CibilScoreResForm getCibilScores() {
        return CibilScores;
    }

    public void setCibilScores(CibilScoreResForm cibilScores) {
        CibilScores = cibilScores;
    }

    public List<AccountResForm> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountResForm> accounts) {
        this.accounts = accounts;
    }

    public List<EnquriesResForm> getEnquries() {
        return enquries;
    }

    public void setRemarks(List<RemarkResForm> remarks) {
        this.remarks = remarks;
    }

    public List<RemarkResForm> getRemarks() {
        return remarks;
    }

    public void setEnquries(List<EnquriesResForm> enquries) {
        this.enquries = enquries;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getGeneratedOn() {
        return generatedOn;
    }

    public void setGeneratedOn(String generatedOn) {
        this.generatedOn = generatedOn;
    }
}
