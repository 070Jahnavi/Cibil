package com.jocata.cibil.cibil.service.impl;

import com.jocata.cibil.cibil.Dao.AccountDao;
import com.jocata.cibil.cibil.entity.Accounts;
import com.jocata.cibil.cibil.form.AccountReqForm;
import com.jocata.cibil.cibil.form.AccountResForm;
import com.jocata.cibil.cibil.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public AccountResForm saveAccount(AccountReqForm reqForm){

        Accounts accounts=new Accounts();
        accounts.setAccountNumber(reqForm.getAccountNumber());
        accounts.setAccountType(reqForm.getAccountType());
        accounts.setAccountStatus(reqForm.getAccountStatus());
        accounts.setSanctionedLimit(new BigDecimal(reqForm.getSanctionedLimit()));
        accounts.setCurrentBalance(new BigDecimal(reqForm.getCurrentBalance()));
        accounts.setDateOpened(Date.valueOf(reqForm.getDateOpened()));
        accounts.setCreditLimit(new BigDecimal(reqForm.getCreditLimit()));
        accounts.setEmiAmount(new BigDecimal(reqForm.getEmiAmount()));
        accounts.setLastPaymentDate(Date.valueOf(reqForm.getLastPaymentDate()));
        accounts.setOwnership(reqForm.getOwnership());
        accounts.setMemberName(reqForm.getMemberName());
        accounts.setPaymentHistory(reqForm.getPaymentHistory());
        accounts.setTenureMonthly(Integer.valueOf(reqForm.getTenureMonthly()));

        Accounts saved=accountDao.saveAccount(accounts);

        AccountResForm resForm=new AccountResForm();
        resForm.setAccountId(String.valueOf(saved.getAccountId()));
        resForm.setAccountNumber(saved.getAccountNumber());
        resForm.setAccountType(saved.getAccountType());
        resForm.setAccountStatus(saved.getAccountStatus());
        resForm.setSanctionedLimit(String.valueOf(new BigDecimal(String.valueOf(saved.getSanctionedLimit()))));
        resForm.setCurrentBalance(String.valueOf(saved.getCurrentBalance()));
        resForm.setMemberName(saved.getMemberName());
        resForm.setCreditLimit(String.valueOf(saved.getCreditLimit()));
        resForm.setEmiAmount(String.valueOf(saved.getEmiAmount()));
        resForm.setLastPaymentDate(String.valueOf(saved.getLastPaymentDate()));
        resForm.setOwnership(saved.getOwnership());
        resForm.setTenureMonthly(String.valueOf(saved.getTenureMonthly()));
        resForm.setPaymentHistory(saved.getPaymentHistory());
        resForm.setDateOpened(String.valueOf(saved.getDateOpened()));

        return resForm;

    }
}
