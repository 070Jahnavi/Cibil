package com.jocata.cibil.cibil.controller;


import com.jocata.cibil.cibil.form.AccountReqForm;
import com.jocata.cibil.cibil.form.AccountResForm;
import com.jocata.cibil.cibil.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")

public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/saveAccount")
    public AccountResForm saveAccount(@RequestBody AccountReqForm reqForm){
        return accountService.saveAccount(reqForm);
    }
}
