package com.realdiv.myrealbank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.realdiv.myrealbank.model.Transaction;
import com.realdiv.myrealbank.services.TransactionService;

@Controller
public class TransactionController {
	@Autowired
	private TransactionService service;
	
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
		List<Transaction> transactions = service.find(customerId, accountNumber, description);
	    model.addAttribute("transactions", transactions);
	     
	    return "index";	}
}
