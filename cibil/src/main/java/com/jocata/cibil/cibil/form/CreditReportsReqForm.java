package com.jocata.cibil.cibil.form;


import java.util.List;

public class CreditReportsReqForm {

    private String reportId;
    private String generatedOn;
    private CustomerReqForm customers;
    private CibilScoreReqForm cibilScores;
    private List<AccountReqForm> accounts;
    private List<EnquriesReqForm> enquries;
    private List<RemarkReqForm> remarks;

    public CustomerReqForm getCustomers() {
        return customers;
    }

    public void setCustomers(CustomerReqForm customers) {
        this.customers = customers;
    }

    public void setCibilScores(CibilScoreReqForm cibilScores) {
        this.cibilScores = cibilScores;
    }

    public CibilScoreReqForm getCibilScores() {
        return cibilScores;
    }

    public List<AccountReqForm> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountReqForm> accounts) {
        this.accounts = accounts;
    }

    public List<EnquriesReqForm> getEnquries() {
        return enquries;
    }

    public void setRemarks(List<RemarkReqForm> remarks) {
        this.remarks = remarks;
    }

    public List<RemarkReqForm> getRemarks() {
        return remarks;
    }

    public void setEnquries(List<EnquriesReqForm> enquries) {
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
