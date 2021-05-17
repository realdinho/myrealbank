package com.realdiv.myrealbank.dao;

import java.util.ArrayList;
import java.util.List;

import com.realdiv.myrealbank.model.Transaction;

public class TransactionDAO {
//	private MyConnection myCon = new MyConnection();
	
	public int insert(List<Transaction> transList) {
		try
	    {
			// Connection conn = myCon.getConnection();
			//
			// // the mysql insert statement
			// String query = " insert into transactions "
			//  + "(ACCOUNT_NUMBER, TRX_AMOUNT, DESCRIPTION, TRX_DATE, CUSTOMER_ID)"
			//  + " values (?, ?, ?, ?, ?)";
			//
			// // create the mysql insert prepared statement
			//
			// PreparedStatement preparedStmt = conn.prepareStatement(query); |||2019-09-12|11:11:11|
			// preparedStmt.setString (1, "8872838283");
			// preparedStmt.setDouble (2, 123.00);
			// preparedStmt.setString (3, "FUND TRANSFER");
			// preparedStmt.setDate   (4, null);
			// preparedStmt.setDate   (5, null);
			// preparedStmt.setString (5, "222");
			//
			// // execute the prepared statement
			// preparedStmt.execute();
			//
			// conn.close();
	    }
	    catch (Exception e) {
	      System.err.println("Error creating transaction" + e.getMessage());
	    }
		
		return 0;
	}
	
	public List<Transaction> find(String customerId, String accountNumber, String description) {		
		return new ArrayList<Transaction>();
	}
	
	
}
