package com.realdiv.myrealbank.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.realdiv.myrealbank.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	List<Transaction> findAll();         
	Transaction findById(long id);
	void save(List<Transaction> transaction);  
}
