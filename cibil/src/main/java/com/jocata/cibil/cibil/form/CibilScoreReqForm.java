package com.jocata.cibil.cibil.form;

public class CibilScoreReqForm {

    private String scoreId;
    private CreditReportsReqForm creditReports;
    private String score;
    private String scoreDate;
    private String riskGrade;

    public CreditReportsReqForm getCreditReports() {
        return creditReports;
    }

    public void setCreditReports(CreditReportsReqForm creditReports) {
        this.creditReports = creditReports;
    }

    public String getScore() {
        return score;
    }

    public String getRiskGrade() {
        return riskGrade;
    }

    public String getScoreId() {
        return scoreId;
    }

    public String getScoreDate() {
        return scoreDate;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setRiskGrade(String riskGrade) {
        this.riskGrade = riskGrade;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId;
    }

    public void setScoreDate(String scoreDate) {
        this.scoreDate = scoreDate;
    }
}
