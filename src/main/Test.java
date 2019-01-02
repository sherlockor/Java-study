package main;

import java.sql.SQLException;
import database.DatabaseTest;

public class Test {
	public static void main(String[] args) throws SQLException {
		DatabaseTest database_test = new DatabaseTest();
		//database_test.CreateTable();
		database_test.InsertData();
		//database_test.DeleteData();
		database_test.SearchData2();
		database_test.Disconnect();
		
		System.out.println("Finished");
	}
}
