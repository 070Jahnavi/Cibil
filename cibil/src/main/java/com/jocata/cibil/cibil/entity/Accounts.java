package com.jocata.cibil.cibil.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
@Entity
@Table(name="Accounts")
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_id")
    private Integer accountId;
    @Column(name="account_number")
    private String accountNumber;
    @Column(name="account_type")
    private String accountType;
    @Column(name="member_name")
    private String memberName;
    @Column(name = "ownership")
    private String ownership;
    @Column(name="date_opened")
    private Date dateOpened;
    @Column(name="last_payment_date")
    private Date lastPaymentDate;
    @Column(name="current_balance")
    private BigDecimal currentBalance;
    @Column(name="credit_limit")
    private BigDecimal creditLimit;
    @Column(name="sanctioned_amount")
    private BigDecimal sanctionedLimit;
    @Column(name = "emi_amount")
    private BigDecimal emiAmount;
    @Column(name="tenure_monthly")
    private Integer tenureMonthly;
    @Column(name="payment_history")
    private String paymentHistory;
    @Column(name = "account_status")
    private String accountStatus;

    @ManyToOne
    @JoinColumn(name = "report_id")
    private CreditReports report;

    public CreditReports getReport() {
        return report;
    }

    public void setReport(CreditReports report) {
        this.report = report;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType(){
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }

    public Date getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(Date lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getSanctionedLimit() {
        return sanctionedLimit;
    }

    public void setSanctionedLimit(BigDecimal sanctionedLimit) {
        this.sanctionedLimit = sanctionedLimit;
    }

    public BigDecimal getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(BigDecimal emiAmount) {
        this.emiAmount = emiAmount;
    }

    public Integer getTenureMonthly() {
        return tenureMonthly;
    }

    public void setTenureMonthly(Integer tenureMonthly) {
        this.tenureMonthly = tenureMonthly;
    }

    public String getPaymentHistory() {
        return paymentHistory;
    }

    public void setPaymentHistory(String paymentHistory) {
        this.paymentHistory = paymentHistory;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
}
