package com.realdiv.myrealbank.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realdiv.myrealbank.model.Transaction;
import com.realdiv.myrealbank.repo.TransactionRepository;

@Service
@Transactional
public class TransactionService {
	@Autowired
	private TransactionRepository repo;
	
	public List<Transaction> find(String customerId, String accountNumber, String description) {
//		TODO:
        return repo.findAll();
    }
	
	public List<Transaction> getAll() {
        return repo.findAll();
    }
     
    public void save(Transaction transaction) {
        repo.save(transaction);
    }
     
    public Transaction get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
