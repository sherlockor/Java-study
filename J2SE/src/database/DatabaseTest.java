package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.jmx.snmp.internal.SnmpSecuritySubSystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DatabaseMetaData;

public class DatabaseTest {
	Connection connection = null;
	private Statement statement = null;
	
	public DatabaseTest(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Init database driver pass");
			connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8", "root", "");
			statement = connection.createStatement();
			
			System.out.println("Get statement object: " + statement);
			
			DatabaseMetaData meat_data = connection.getMetaData();
			
			System.out.println(meat_data.getDatabaseProductName());
			System.out.println(meat_data.getDatabaseProductVersion());
			System.out.println(meat_data.getCatalogSeparator());
			System.out.println(meat_data.getDriverVersion());
			
			ResultSet resultSet = meat_data.getCatalogs();
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Disconnect() throws SQLException {
		if(statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
		System.out.println("Disconnect pass");
	}
	
	public boolean CreateTable() {
		String sql = "CREATE TABLE java_test (name VARCHAR(40) NOT NULL)";
		boolean b_status = false;
		try {
			b_status = statement.execute(sql);
			System.out.println("Create table pass");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Create table fail");
			e.printStackTrace();
		}
		
		return b_status;
	}
	
	public boolean InsertData() {
		String sql = "INSERT INTO java_test (name) VALUES ('sherlock2');";
		boolean b_status = false;
		
		try {
			b_status = statement.execute(sql);
			System.out.println("Insert data pass");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b_status;
	}
	
	public void DeleteData() throws SQLException {
		String sql = "DELETE FROM java_test WHERE name='sherlock'";
		try {
			statement.execute(sql);
			System.out.println("Delete data pass");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void SearchData() throws SQLException {
		String sql = "SELECT * FROM java_test WHERE name='sherlock';";
		ResultSet results = statement.executeQuery(sql);
		System.out.println(results);
		while(results.next()) {
			System.out.println(results.getString(1));
		}
	}
	
	public void SearchData2() throws SQLException {
		String sql = "SELECT * FROM java_test WHERE name=?;";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, "sherlock");
		ResultSet results = ps.executeQuery();
		while(results.next()) {
			System.out.println(results.getString(1));
		}
	}
	
}
