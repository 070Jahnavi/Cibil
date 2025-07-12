package com.jocata.cibil.cibil.controller;

import com.jocata.cibil.cibil.form.AccountReqForm;
import com.jocata.cibil.cibil.form.AccountResForm;
import com.jocata.cibil.cibil.form.CreditReportsReqForm;
import com.jocata.cibil.cibil.form.CreditReportsResForm;
import com.jocata.cibil.cibil.service.CibilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class CibilController {

    @Autowired
    private CibilService cibilService;

    @PostMapping("/createCibil")
    public CreditReportsResForm createCibil(@RequestBody CreditReportsReqForm creditReportsReqForm){

        return cibilService.createCibil(creditReportsReqForm);

    }

    @GetMapping("/getCibil")

    public CreditReportsResForm getCibil(@RequestParam String pan){

        return cibilService.getCibil(pan);
    }
}
