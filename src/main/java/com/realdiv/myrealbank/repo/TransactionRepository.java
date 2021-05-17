package com.realdiv.myrealbank.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realdiv.myrealbank.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
