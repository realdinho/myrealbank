package com.realdiv.myrealbank.batch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.realdiv.myrealbank.model.Transaction;

public class TransactionProcessor {
	
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
				StringTokenizer st = new StringTokenizer(line, "|");
				Transaction transaction = new Transaction();
				transaction.setAccountNumber(st.nextToken());
				transaction.setAmount(Double.valueOf(st.nextToken()));
				transaction.setDescription(st.nextToken());
//				transaction.setDate(st.nextToken()); // TODO: use 2 tokens for this
				st.nextToken(); // skip date
				st.nextToken(); // skip time
				transaction.setCustomerId(st.nextToken());
				transactionList.add(transaction);
			}
		} catch(Exception ex) {
			System.err.println(ex);
		}

		return transactionList;
	}
	
}
