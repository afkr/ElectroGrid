package com.oop.bll;

import java.util.ArrayList;

import com.oop.model.PowerConsumption;
import com.oop.model.Transaction;
import com.oop.repository.PowerConsumptionRepository;
import com.oop.repository.TransactionRepository;

public class TransactionBLL {
	public void CreateTransaction(Transaction transaction) {
		new TransactionRepository().CreateTransaction(transaction);	
	}
	
	public void EditTransaction(Transaction transaction) {
		new TransactionRepository().EditTransaction(transaction);
	}
	
	public void DeleteTransaction(String id) {
		new TransactionRepository().DeleteTransaction(id);
	}
	
	
	
	public Transaction GetTransactionByCardholdername(int cardnumber){
		Transaction transaction= new TransactionRepository().GetTransactionByCardholdername(cardnumber);
		return transaction;
	}

	public ArrayList<Transaction> GetListOfTransactions(){
		ArrayList<Transaction> transactionlist = new TransactionRepository().GetListOfTransactions();
		return transactionlist;
	}
}
