package com.realdiv.myrealbank;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.realdiv.myrealbank.batch.TransactionProcessor;

@SpringBootApplication
public class MyrealbankApplication {

	public static void main(String[] args) throws IOException {
		// test get transactions from file
//		TransactionProcessor tnxProc = new TransactionProcessor();
//		System.out.println(tnxProc.processFile().get(0).getDescription());
		
		SpringApplication.run(MyrealbankApplication.class, args);
	}

}
