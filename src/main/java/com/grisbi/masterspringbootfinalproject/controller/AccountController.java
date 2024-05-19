package com.grisbi.masterspringbootfinalproject.controller;

import com.grisbi.masterspringbootfinalproject.repository.Account;
import com.grisbi.masterspringbootfinalproject.repository.Person;
import com.grisbi.masterspringbootfinalproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/createAccount")
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @PostMapping("/newAccount")
    public Account newAccount(@RequestBody Person person) throws Exception {
        return accountService.newAccount(person);
    }

    @GetMapping("/findAccount")
    public Optional<Account> findAccountByAccount(@RequestParam long accountNumber) {
        return accountService.findAccount(accountNumber);
    }

}
