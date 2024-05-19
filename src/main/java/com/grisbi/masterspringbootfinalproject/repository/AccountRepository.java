package com.grisbi.masterspringbootfinalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, Long> {
   Optional<Account> findByAccountNumber(long accountNumber);
}
