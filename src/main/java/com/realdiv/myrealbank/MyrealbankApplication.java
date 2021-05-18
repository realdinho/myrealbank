package com.realdiv.myrealbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyrealbankApplication {
//	@Autowired
//	static TransactionProcessor tnxProc;

	public static void main(String[] args) throws Exception {
		// TransactionProcessor tnxProc = new TransactionProcessor();
		// test get transactions from file
		// System.out.println(tnxProc.processFile().get(0).getDescription());
		
		SpringApplication.run(MyrealbankApplication.class, args);
	}

}
