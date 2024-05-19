package com.grisbi.masterspringbootfinalproject.service;

import com.grisbi.masterspringbootfinalproject.repository.Account;
import com.grisbi.masterspringbootfinalproject.repository.AccountRepository;
import com.grisbi.masterspringbootfinalproject.repository.Person;
import com.grisbi.masterspringbootfinalproject.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PersonRepository personRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);

    }
    public Account newAccount(Person person) throws Exception {
        Account a = new Account();
        Optional<Person> foundPerson = personRepository.findByDocumentNumber(person.getDocumentNumber());
        if (foundPerson.isPresent()) {
            throw new RuntimeException("Person already registered");
        }
        person = personRepository.save(person);
        Random random = new Random();
        a.setAccountNumber(Long.parseLong(generateRandomNumber(10)));
        a.setDebitCardNumber(Long.parseLong(generateRandomNumber(16)));
        a.setPin(Long.parseLong(generateRandomNumber(4)));
        a.setPerson(person);
        a.setBalance(new BigDecimal(Long.parseLong(generateRandomNumber(3))));
        a.setRegistrationDate(new Date());
        accountRepository.save(a);
        return a;
    }
    public Optional<Account> findAccount(long accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    public static String generateRandomNumber(int size) {
        final SecureRandom secureRandom = new SecureRandom();

        StringBuilder number = new StringBuilder();
        for (int i = 0; i < size; i++) {
            number.append(secureRandom.nextInt(10));
        }
        return number.toString();
    }
}

