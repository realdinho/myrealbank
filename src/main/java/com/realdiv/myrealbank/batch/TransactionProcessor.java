package com.realdiv.myrealbank.batch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.realdiv.myrealbank.model.Transaction;
import com.realdiv.myrealbank.repo.TransactionRepository;

@Component
public class TransactionProcessor {
//	@Autowired
//	TransactionService service;
	
	@Autowired
	TransactionRepository repo;
	
//	public void saveDataToDb() throws Exception {
//		List<Transaction> trxFromFile = this.processFile();
//		
//		if (trxFromFile.isEmpty()) {
//			throw new Exception("No transactions found!");
//		}
//		
//		try {
//			repo.save(trxFromFile);
//		} catch (Exception e) {
//			System.out.println("Failed to save transactions: " + e);
//		}
//	}
	
	// get list of transactions from the file
	public List<Transaction> processFile() throws IOException {
		List<Transaction> transactionList = new ArrayList<Transaction>();
		Class clazz = TransactionProcessor.class;
		InputStream inputStream = clazz.getResourceAsStream("/static/dataSource.txt");

		try {
			String line;
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			br.readLine(); // skip the file header

			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "|"); // pipe separated value
				
				Transaction transaction = new Transaction();
				transaction.setAccountNumber(st.nextToken()); // account number
				transaction.setAmount(Double.valueOf(st.nextToken())); // amount
				transaction.setDescription(st.nextToken()); // description
				
				// convert date and time from String to Date 
				String dateStr = st.nextToken(); // get date
				String timeStr = st.nextToken(); // get time
				String datetimeStr = dateStr + "T" + timeStr + ".000Z'"; // string date with time zone
				Date date = this.convertStringDate(datetimeStr);
				
				transaction.setDate(date); // set converted date				
				transaction.setCustomerId(st.nextToken()); // customerId
				
				transactionList.add(transaction); // add to the list				
				repo.save(transaction); // quick fix: save to the database
			}
		} catch(Exception ex) {
			System.err.println(ex);
		}

		// return list of transactions retrieved from the file
		return transactionList; 
	}
	
	// 
	private Date convertStringDate(String datetimeStr) throws Exception {
		Date date;
		
		try {
			date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(datetimeStr);
		} catch (Exception e) {
			throw new Exception("Could not pase date! Exception: " + e);
		}
		
		return date;
	}
	
}
