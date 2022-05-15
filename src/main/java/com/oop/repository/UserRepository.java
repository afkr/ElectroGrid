package com.oop.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.oop.model.User;
import com.oop.utils.DBConnection;
import com.oop.utils.Utilities;

public class UserRepository {
	
	private static Connection connection;

	private static Statement statement;

	private PreparedStatement preparedStatement;
	
	public void CreateUser(User user) {
		try {
			connection = DBConnection.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement("insert into User (Name, Address, MobileNumber) values (?, ?, ?)");
			connection.setAutoCommit(false);
			
			preparedStatement.setString(Utilities.COLUMN_INDEX_ONE, user.getName());
			preparedStatement.setString(Utilities.COLUMN_INDEX_TWO, user.getAddress());
			preparedStatement.setString(Utilities.COLUMN_INDEX_THREE, user.getMobileNumber());

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
	
	
	public void EditUser(User user) {
		
		try {
			connection = DBConnection.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement("update User as n set n.Name = ?, n.Address = ?, n.MobileNumber = ? where n.UserId = ?");
			connection.setAutoCommit(false);
			
			preparedStatement.setString(Utilities.COLUMN_INDEX_ONE, user.getName());
			preparedStatement.setString(Utilities.COLUMN_INDEX_TWO, user.getAddress());
			preparedStatement.setString(Utilities.COLUMN_INDEX_THREE, user.getMobileNumber());
			
			preparedStatement.setInt(Utilities.COLUMN_INDEX_FOUR, user.getUserId());

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

	
	public void DeleteUser(int id) {
		try {
			connection = DBConnection.getDBConnection();
			
			preparedStatement = connection
					.prepareStatement("delete from User where User.UserId = ?");
			connection.setAutoCommit(false);
			
			preparedStatement.setInt(Utilities.COLUMN_INDEX_ONE, id);

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
	
	
	public ArrayList<User> GetListOfUsers(){
		ArrayList<User> userList = new ArrayList<User>();
		try {
			connection = DBConnection.getDBConnection();


				preparedStatement = connection
						.prepareStatement("select * from User");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				User user = new User();
				user.setUserId(resultSet.getInt(Utilities.COLUMN_INDEX_ONE));
				user.setName(resultSet.getString(Utilities.COLUMN_INDEX_TWO));
				user.setAddress(resultSet.getString(Utilities.COLUMN_INDEX_THREE));
				user.setMobileNumber(resultSet.getString(Utilities.COLUMN_INDEX_FOUR));
				
				userList.add(user);
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
		return userList;
	}
	
	
	public User GetUserByTel(String tel){
		User user = new User();
		try {
			connection = DBConnection.getDBConnection();


			preparedStatement = connection
					.prepareStatement("select * from User where MobileNumber = ?");
			//preparedStatement.setMaxRows(1); 
			
			preparedStatement.setString(Utilities.COLUMN_INDEX_ONE, tel);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				user.setUserId(resultSet.getInt(Utilities.COLUMN_INDEX_ONE));
				user.setName(resultSet.getString(Utilities.COLUMN_INDEX_TWO));
				user.setAddress(resultSet.getString(Utilities.COLUMN_INDEX_THREE));
				user.setMobileNumber(resultSet.getString(Utilities.COLUMN_INDEX_FOUR));
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
		return user;
	}
	
	public User GetUserByUsernameAndPassword(String username, String password) {
		
		User existingUser = new User();
		try {
			connection = DBConnection.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement("select Id, Name, Username, Password from User where User.Username = ? and User.Password = ?");
			connection.setAutoCommit(false);
			
			preparedStatement.setString(Utilities.COLUMN_INDEX_ONE, username);
			preparedStatement.setString(Utilities.COLUMN_INDEX_TWO, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				existingUser.setUserId(resultSet.getInt(Utilities.COLUMN_INDEX_ONE));
				existingUser.setName(resultSet.getString(Utilities.COLUMN_INDEX_TWO));
				existingUser.setUsername(resultSet.getString(Utilities.COLUMN_INDEX_THREE));
				existingUser.setPassword(resultSet.getString(Utilities.COLUMN_INDEX_FOUR));
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
		
		return existingUser;
	}

}
