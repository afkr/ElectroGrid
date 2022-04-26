package com.oop.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.oop.model.PowerConsumption;
import com.oop.model.Transaction;
import com.oop.utils.DBConnection;
import com.oop.utils.Utilities;

public class TransactionRepository {
	private static Connection connection;

	private static Statement statement;

	private PreparedStatement preparedStatement;
	
	public void CreateTransaction(Transaction transaction) {
		try {
			connection = DBConnection.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement("insert into Transaction (id  , transactionAmount,cardtype,cardnumber,expirydate,cardholdername,code, userId) values (?, ?, ?, ?,?,?,?,?)");
			connection.setAutoCommit(false);
			 String id = generateIDs((ArrayList<Transaction>)GetListOfTransactions());
			
			preparedStatement.setString(Utilities.COLUMN_INDEX_ONE, id);
			preparedStatement.setDouble(Utilities.COLUMN_INDEX_TWO, transaction.getTransactionAmount() );
			preparedStatement.setString(Utilities.COLUMN_INDEX_THREE, transaction.getCardtype());
			preparedStatement.setInt(Utilities.COLUMN_INDEX_FOUR, transaction.getCardnumber());
			preparedStatement.setDate(Utilities.COLUMN_INDEX_FIVE,  (Date) transaction.getExpirydate());
			preparedStatement.setString(Utilities.COLUMN_INDEX_SIX, transaction.getCardholdername());
			preparedStatement.setInt(Utilities.COLUMN_INDEX_SEVEN, transaction.getCode());
			preparedStatement.setString(Utilities.COLUMN_INDEX_EIGHT, transaction.getUserid());

			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | ClassNotFoundException e) {
			
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		
	}
	
	
	public void EditTransaction(Transaction transaction) {
		
		try {
			connection = DBConnection.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement("update Transaction as n set n.transactionAmount = ?, n.cardtype = ?, n.cardnumber = ?, n.expirydate = ?, n.cardholdername = ? , n.code = ?    where n.id = ?");
			connection.setAutoCommit(false);
			

			preparedStatement.setDouble(Utilities.COLUMN_INDEX_ONE, transaction.getTransactionAmount() );
			preparedStatement.setString(Utilities.COLUMN_INDEX_TWO, transaction.getCardtype());
			preparedStatement.setInt(Utilities.COLUMN_INDEX_THREE, transaction.getCardnumber());
			preparedStatement.setDate(Utilities.COLUMN_INDEX_FOUR,  (Date) transaction.getExpirydate());
			preparedStatement.setString(Utilities.COLUMN_INDEX_FIVE, transaction.getCardholdername());
			preparedStatement.setInt(Utilities.COLUMN_INDEX_SIX, transaction.getCode());
			preparedStatement.setString(Utilities.COLUMN_INDEX_SEVEN, transaction.getId());
			preparedStatement.setString(Utilities.COLUMN_INDEX_EIGHT, transaction.getUserid());
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | ClassNotFoundException e) {
			
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				
			}
		}
		
		
		
	}
	public void DeleteTransaction(String id) {
		try {
			connection = DBConnection.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement("delete from  Transaction where  Transaction.id = ?");
			connection.setAutoCommit(false);
			
			preparedStatement.setString(Utilities.COLUMN_INDEX_ONE, id);

			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | ClassNotFoundException e) {
			
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				
			}
		}
		
	}
	
	public ArrayList<Transaction> GetListOfTransactions(){
		ArrayList<Transaction>  TransactionList = new ArrayList<Transaction>();
		try {
			connection = DBConnection.getDBConnection();


				preparedStatement = connection
						.prepareStatement("select * from  Transaction");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				 Transaction transaction = new Transaction();
				 transaction.setId(resultSet.getString(Utilities.COLUMN_INDEX_ONE));
				 transaction.setTransactionAmount(resultSet.getDouble(Utilities.COLUMN_INDEX_TWO));
				 transaction.setCardtype(resultSet.getString(Utilities.COLUMN_INDEX_THREE));
				 transaction.setCardnumber(resultSet.getInt(Utilities.COLUMN_INDEX_FOUR));
				 transaction.setExpirydate(resultSet.getDate(Utilities.COLUMN_INDEX_FIVE));
				 transaction.setCardholdername(resultSet.getString(Utilities.COLUMN_INDEX_SIX));
				 transaction.setCode(resultSet.getInt(Utilities.COLUMN_INDEX_SEVEN));
				 transaction.setUserid(resultSet.getString(Utilities.COLUMN_INDEX_EIGHT));
				
				 TransactionList.add(transaction);
			}

		} catch (SQLException | ClassNotFoundException e) {
			
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				
			}
		}
		return TransactionList;
	}
	  public static String generateIDs(ArrayList<Transaction> arrayList) {

	        String id;
	        int next = arrayList.size();
	        next++;
	        id = "E0" + next;
	        if (arrayList.contains(id)) {
	            next++;
	            id = "E0" + next;
	        }
	        return id;
	    }
	
	public Transaction GetTransactionByCardholdername(int cardnumber){
		Transaction transaction = new Transaction();
		try {
			connection = DBConnection.getDBConnection();


			preparedStatement = connection
					.prepareStatement("select * from Transaction where cardnumber = ?");
			//preparedStatement.setMaxRows(1); 
			
			preparedStatement.setInt(Utilities.COLUMN_INDEX_ONE, cardnumber);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				 transaction.setId(resultSet.getString(Utilities.COLUMN_INDEX_ONE));
				 transaction.setTransactionAmount(resultSet.getDouble(Utilities.COLUMN_INDEX_TWO));
				 transaction.setCardtype(resultSet.getString(Utilities.COLUMN_INDEX_THREE));
				 transaction.setCardnumber(resultSet.getInt(Utilities.COLUMN_INDEX_FOUR));
				 transaction.setExpirydate(resultSet.getDate(Utilities.COLUMN_INDEX_FIVE));
				 transaction.setCardholdername(resultSet.getString(Utilities.COLUMN_INDEX_SIX));
				 transaction.setCode(resultSet.getInt(Utilities.COLUMN_INDEX_SEVEN));
				 transaction.setUserid(resultSet.getString(Utilities.COLUMN_INDEX_EIGHT));
			}

		} catch (SQLException | ClassNotFoundException e) {
			
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				
			}
		}
		return transaction;
	}
}
