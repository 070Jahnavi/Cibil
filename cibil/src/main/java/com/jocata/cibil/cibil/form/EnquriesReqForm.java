package com.jocata.cibil.cibil.form;

public class EnquriesReqForm {
    private String enquryId;
    private String enquryDate;
    private String memberName;
    private String enquryPurpose;
    private String enquryAmount;
    private CreditReportsReqForm creditReports;

    public CreditReportsReqForm getCreditReports() {
        return creditReports;
    }

    public void setCreditReports(CreditReportsReqForm creditReports) {
        this.creditReports = creditReports;
    }

    public String getEnquryId() {
        return enquryId;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getEnquryAmount() {
        return enquryAmount;
    }

    public String getEnquryDate() {
        return enquryDate;
    }

    public String getEnquryPurpose() {
        return enquryPurpose;
    }

    public void setEnquryAmount(String enquryAmount) {
        this.enquryAmount = enquryAmount;
    }

    public void setEnquryId(String enquryId) {
        this.enquryId = enquryId;
    }

    public void setEnquryDate(String enquryDate) {
        this.enquryDate = enquryDate;
    }

    public void setEnquryPurpose(String enquryPurpose) {
        this.enquryPurpose = enquryPurpose;
    }
}
