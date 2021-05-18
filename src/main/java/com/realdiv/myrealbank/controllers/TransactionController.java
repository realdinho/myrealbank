package com.realdiv.myrealbank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.realdiv.myrealbank.batch.TransactionProcessor;
import com.realdiv.myrealbank.model.Transaction;
import com.realdiv.myrealbank.services.TransactionService;

@Controller
public class TransactionController {
	@Autowired
	private TransactionService service;
	
	@Autowired
	private TransactionProcessor trxProcService;
	
	@RequestMapping("/")
	public String transactionsPage(Model model) {
		List<Transaction> transactions = service.getAll();
	    model.addAttribute("transactions", transactions);
	    return "index";
	}
	

	@RequestMapping("/{customerId}/{accountNumber}/{description}")
	public String find(
			Model model,
			@PathVariable String customerId,
			@PathVariable String accountNumber,
			@PathVariable String description) 
	{
//		List<Transaction> transactions = service.find(customerId, accountNumber, description);
		List<Transaction> transactions = service.getAll();
	    model.addAttribute("transactions", transactions);
	     
	    return "index";	
	}
	
	@RequestMapping("/save")
	public void saveDataToDB() throws Exception {		
		trxProcService.processFile();
	}
}
