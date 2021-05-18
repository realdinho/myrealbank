package com.realdiv.myrealbank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.realdiv.myrealbank.model.Transaction;
import com.realdiv.myrealbank.repo.TransactionRepository;

@Component
public class TransactionService {
	@Autowired
	TransactionRepository repo;
	
	public List<Transaction> find(String customerId, String accountNumber, String description) {
		// TODO:
        return this.repo.findAll();
    }
	
	public List<Transaction> getAll() {
        return repo.findAll();
    }
     
    public void save(Transaction transaction) {
    	this.repo.save(transaction);
    }
    
    public void saveAll(List<Transaction> transactions) {
    	repo.save(transactions);
    }
     
    public Transaction get(long id) {
        return repo.findById(id);
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
