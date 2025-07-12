package com.jocata.cibil.cibil.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Remarks")
public class Remarks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="remark_id")
    private Integer remarkId;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "report_id")
    private CreditReports report;

    public CreditReports getReport() {
        return report;
    }

    public void setReport(CreditReports report) {
        this.report = report;
    }

    public Integer getRemarkId() {
        return remarkId;
    }

    public void setRemarkId(Integer remarkId) {
        this.remarkId = remarkId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
