package com.jocata.cibil.cibil.form;

import com.jocata.cibil.cibil.entity.CreditReports;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class RemarkResForm {
    //private String remarkId;
    private String description;
    //private CreditReportsResForm creditReports;

    /*public void setCreditReports(CreditReportsResForm creditReports) {
        this.creditReports = creditReports;
    }

    public CreditReportsResForm getCreditReports() {
        return creditReports;
    }

    public String getRemarkId() {
        return remarkId;
    }*/

    public String getDescription() {
        return description;
    }

    /*public void setRemarkId(String remarkId) {
        this.remarkId = remarkId;
    }*/

    public void setDescription(String description) {
        this.description = description;
    }
}
