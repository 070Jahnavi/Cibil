package com.jocata.cibil.cibil.form;

import com.jocata.cibil.cibil.entity.CreditReports;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.sql.Date;

public class AccountResForm {

    private String accountId;
    private String accountNumber;
    private String accountType;
    private String memberName;
    private String ownership;
    private String dateOpened;
    private String lastPaymentDate;
    private String currentBalance;
    private String creditLimit;
    private String sanctionedLimit;
    private String emiAmount;
    private String tenureMonthly;
    private String paymentHistory;
    private String accountStatus;

    /*private CreditReportsResForm report;

    public CreditReportsResForm getReport() {
        return report;
    }

    public void setReport(CreditReportsResForm report) {
        this.report = report;
    }*/

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public String getCreditLimit() {
        return creditLimit;
    }


    public String getCurrentBalance() {
        return currentBalance;
    }

    public String getDateOpened() {
        return dateOpened;
    }

    public String getEmiAmount() {
        return emiAmount;
    }

    public String getLastPaymentDate() {
        return lastPaymentDate;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getOwnership() {
        return ownership;
    }

    public String getPaymentHistory() {
        return paymentHistory;
    }

    public String getSanctionedLimit() {
        return sanctionedLimit;
    }

    public String getTenureMonthly() {
        return tenureMonthly;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public void setCurrentBalance(String currentBalance) {
        this.currentBalance = currentBalance;
    }



    public void setDateOpened(String dateOpened) {
        this.dateOpened = dateOpened;
    }

    public void setEmiAmount(String emiAmount) {
        this.emiAmount = emiAmount;
    }

    public void setLastPaymentDate(String lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public void setPaymentHistory(String paymentHistory) {
        this.paymentHistory = paymentHistory;
    }

    public void setSanctionedLimit(String sanctionedLimit) {
        this.sanctionedLimit = sanctionedLimit;
    }

    public void setTenureMonthly(String tenureMonthly) {
        this.tenureMonthly = tenureMonthly;
    }


}
