package com.jocata.cibil.cibil.Dao;

import com.jocata.cibil.cibil.entity.Enquries;

import java.util.List;

public interface EnquiryDao {

    public Enquries saveEnquiry(Enquries entity);
    public List<Enquries> findEnquiriesByReportId(String reportId);
}
