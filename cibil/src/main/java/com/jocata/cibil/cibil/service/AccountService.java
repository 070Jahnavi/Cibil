package com.jocata.cibil.cibil.service;

import com.jocata.cibil.cibil.form.AccountReqForm;
import com.jocata.cibil.cibil.form.AccountResForm;

public interface AccountService {

    public AccountResForm saveAccount(AccountReqForm reqForm);
}
