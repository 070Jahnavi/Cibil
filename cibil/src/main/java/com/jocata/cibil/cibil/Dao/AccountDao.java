package com.jocata.cibil.cibil.Dao;

import com.jocata.cibil.cibil.entity.Accounts;

import java.util.List;

public interface AccountDao {

    public Accounts saveAccount(Accounts entity);
    public List<Accounts> findAccountsByReportId(String reportId);
}
