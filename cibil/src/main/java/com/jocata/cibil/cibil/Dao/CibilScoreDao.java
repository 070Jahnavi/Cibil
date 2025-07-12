package com.jocata.cibil.cibil.Dao;

import com.jocata.cibil.cibil.entity.CbilScores;

public interface CibilScoreDao {

    public CbilScores saveCibilScore(CbilScores entity);
    public CbilScores findScoreByReportId(String reportId);
}
