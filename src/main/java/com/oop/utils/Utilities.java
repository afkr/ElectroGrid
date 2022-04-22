package com.oop.utils;

public class Utilities {
	/** Constant for config.properties key for query file path */
	public static final String QUERY_XML = "queryFilePath";

	/** Constant for file path of config.properties */
	public static final String PROPERTY_FILE = "config.properties";

	/** Constant for query tag in EmployeeQuery.xml */
	public static final String TAG_NAME = "query";

	/** Constant for query id in EmployeeQuery.xml */
	public static final String ATTRIB_ID = "id";
	
	/** Constant for employee id prefix */
	public static final String EMPLOYEE_ID_PREFIX = "E300";

	/** Constant for comma */
	public static final String COMMA = ",";

	public static final String URL = "jdbc:mysql://localhost:3306/electrogrid";

	public static final String USERNAME = "root";

	public static final String PASSWORD = "";

	public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	
	/** Constant for Column index one */
	public static final int COLUMN_INDEX_ONE = 1;
	
	/** Constant for Column index two */
	public static final int COLUMN_INDEX_TWO = 2;
	
	/** Constant for Column index three */
	public static final int COLUMN_INDEX_THREE = 3;
	
	/** Constant for Column index four */
	public static final int COLUMN_INDEX_FOUR = 4;
	
	/** Constant for Column index five */
	public static final int COLUMN_INDEX_FIVE = 5;
	
	/** Constant for Column index six */
	public static final int COLUMN_INDEX_SIX = 6;
	
	/** Constant for Column index seven */
	public static final int COLUMN_INDEX_SEVEN = 7;
	
	/** Constant for Column index eight */
	public static final int COLUMN_INDEX_EIGHT = 8;
	
	public static enum resultStatus{
		success,
		error,
		warning
	}
	
	public static enum SessionVariables{
		userId,
		fullName,
		email,
		userType
	}
	
	public static enum TicketStatus{
		pending,
		resolved
	}
	
	public static enum UserType{
		admin,
		manager,
		technicalSupport,
		student
	}
	
	public static String INVALID_CREDENTIALS = "Invalid Credentials";
}
