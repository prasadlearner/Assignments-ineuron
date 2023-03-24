package in.ineuron.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {
	private JdbcUtil() {
		// can't create object
	}

	static {
		// loading and register the Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	public static Connection getJdbcConnection() throws SQLException, IOException {
		/*
		 * String fileLocation =
		 * "D:\\Git_LocalRepo\\JDBC_CRUD_APP\\src\\main\\java\\in\\ineuron\\properties\\application.proprties";
		 * HikariConfig hikariConfig = new HikariConfig(fileLocation); HikariDataSource
		 * dataSourse = new HikariDataSource(hikariConfig); Connection connection =
		 * dataSourse.getConnection(); return connection;
		 */
		return physicalConnection();
	}

	
	private static Connection physicalConnection() throws FileNotFoundException, IOException, SQLException {
		FileInputStream fis = new FileInputStream("D:\\JavaServletProjects\\MVC_CRUD_APP\\src\\main\\java\\in\\ineuron\\properties\\application.proprties");
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String userName = p.getProperty("userName");
		String password = p.getProperty("password");
		Connection connection = DriverManager.getConnection(url, userName, password);
		return connection;
	}

	public static void cleanUp(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
		if (connection != null) {
			connection.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (resultSet != null) {
			resultSet.close();
		}
	}
}
