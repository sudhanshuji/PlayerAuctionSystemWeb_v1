package pas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import pas.exceptions.DBUtilException;

public class DBUtil {

	private static final String DBDriver = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/Cricket"; //Player_DB
	private static final String DBUsername = "root";
	private static final String dbPassword = "Welcome123";

	public static Connection getConnection() throws DBUtilException {
		Connection conn = null;
		try {
			Class.forName(DBDriver);
			conn = DriverManager.getConnection(DBURL, DBUsername, dbPassword);
			return conn;
		} catch (ClassNotFoundException e) {
			throw new DBUtilException("Error while establishing connection, class not found");
		} catch (SQLException e) {
			throw new DBUtilException("Error while establishing connection");
		}
	}

}
