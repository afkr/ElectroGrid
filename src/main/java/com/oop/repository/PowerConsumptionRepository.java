package com.oop.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.oop.model.PowerConsumption;
import com.oop.utils.DBConnection;
import com.oop.utils.Utilities;

public class PowerConsumptionRepository {
	private static Connection connection;

	private static Statement statement;

	private PreparedStatement preparedStatement;
	
	public void CreatePowerConsumption(PowerConsumption powerConsumption) {
		try {
			connection = DBConnection.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement("insert into PowerConsumption (UserId, MobileNumber, Units, BillDate) values (?, ?, ?, ?)");
			connection.setAutoCommit(false);
			
			preparedStatement.setInt(Utilities.COLUMN_INDEX_ONE, powerConsumption.getUserId());
			preparedStatement.setString(Utilities.COLUMN_INDEX_TWO, powerConsumption.getMobileNumber());
			preparedStatement.setInt(Utilities.COLUMN_INDEX_THREE, powerConsumption.getUnits());
			preparedStatement.setDate(Utilities.COLUMN_INDEX_FOUR, new java.sql.Date(powerConsumption.getBillDate().getTime()));

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
	
	
	public void EditPowerConsumption(PowerConsumption powerConsumption) {
		
		try {
			connection = DBConnection.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement("update PowerConsumption as n set n.UserId = ?, n.MobileNumber = ?, n.Units = ? where n.Id = ?");
			connection.setAutoCommit(false);
			
			preparedStatement.setInt(Utilities.COLUMN_INDEX_ONE, powerConsumption.getUserId());
			preparedStatement.setString(Utilities.COLUMN_INDEX_TWO, powerConsumption.getMobileNumber());			
			preparedStatement.setInt(Utilities.COLUMN_INDEX_THREE, powerConsumption.getUnits());
			
			preparedStatement.setInt(Utilities.COLUMN_INDEX_FOUR, powerConsumption.getId());

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
	public void DeletePowerConsumption(int id) {
		try {
			connection = DBConnection.getDBConnection();
			/*
			 * Query is available in EmployeeQuery.xml file and use
			 * insert_employee key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement("delete from PowerConsumption where PowerConsumption.Id = ?");
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
	
	public ArrayList<PowerConsumption> GetListOfPowerConsumptions(){
		ArrayList<PowerConsumption> powerConsumptionList = new ArrayList<PowerConsumption>();
		try {
			connection = DBConnection.getDBConnection();


				preparedStatement = connection
						.prepareStatement("select * from PowerConsumption");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				PowerConsumption powerConsumption = new PowerConsumption();
				powerConsumption.setId(resultSet.getInt(Utilities.COLUMN_INDEX_ONE));
				powerConsumption.setUserId(resultSet.getInt(Utilities.COLUMN_INDEX_TWO));
				powerConsumption.setMobileNumber(resultSet.getString(Utilities.COLUMN_INDEX_THREE));
				powerConsumption.setUnits(resultSet.getInt(Utilities.COLUMN_INDEX_FOUR));
				powerConsumption.setBillDate(resultSet.getDate(Utilities.COLUMN_INDEX_FIVE));
				powerConsumptionList.add(powerConsumption);
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
		return powerConsumptionList;
	}
	
	public PowerConsumption GetPowerConsumptionByTel(String tel){
		PowerConsumption powerConsumption = new PowerConsumption();
		try {
			connection = DBConnection.getDBConnection();


			preparedStatement = connection
					.prepareStatement("select * from PowerConsumption where MobileNumber = ?");
			//preparedStatement.setMaxRows(1); 
			
			preparedStatement.setString(Utilities.COLUMN_INDEX_ONE, tel);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				powerConsumption.setId(resultSet.getInt(Utilities.COLUMN_INDEX_ONE));
				powerConsumption.setUserId(resultSet.getInt(Utilities.COLUMN_INDEX_TWO));
				powerConsumption.setMobileNumber(resultSet.getString(Utilities.COLUMN_INDEX_THREE));
				powerConsumption.setUnits(resultSet.getInt(Utilities.COLUMN_INDEX_FOUR));
				powerConsumption.setBillDate(resultSet.getDate(Utilities.COLUMN_INDEX_FIVE));
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
		return powerConsumption;
	}

}
