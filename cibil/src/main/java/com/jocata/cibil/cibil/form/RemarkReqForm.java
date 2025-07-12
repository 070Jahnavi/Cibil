package com.jocata.cibil.cibil.form;

public class RemarkReqForm {
    private String remarkId;
    private String description;
    private CreditReportsReqForm creditReports;

    public void setCreditReports(CreditReportsReqForm creditReports) {
        this.creditReports = creditReports;
    }

    public CreditReportsReqForm getCreditReports() {
        return creditReports;
    }

    public String getRemarkId() {
        return remarkId;
    }

    public String getDescription() {
        return description;
    }

    public void setRemarkId(String remarkId) {
        this.remarkId = remarkId;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
