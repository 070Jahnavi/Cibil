package com.jocata.cibil.cibil.service;

import com.jocata.cibil.cibil.form.AccountReqForm;
import com.jocata.cibil.cibil.form.AccountResForm;
import com.jocata.cibil.cibil.form.CreditReportsReqForm;
import com.jocata.cibil.cibil.form.CreditReportsResForm;
import org.springframework.web.bind.annotation.RequestBody;

public interface CibilService {

    public CreditReportsResForm createCibil(CreditReportsReqForm creditReportsReqForm);
    public CreditReportsResForm getCibil(String pan);

}
