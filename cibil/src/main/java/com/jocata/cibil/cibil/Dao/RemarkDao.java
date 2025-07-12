package com.jocata.cibil.cibil.Dao;

import com.jocata.cibil.cibil.entity.Remarks;

import java.util.List;

public interface RemarkDao {

    public Remarks saveRemark(Remarks entity);
    public List<Remarks> findRemarksByReportId(String reportId);
}
