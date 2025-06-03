package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTask {

	public static void main(String[] args) throws SQLException {
		
		String db_url= "jdbc:mysql://localhost:3306";
		String username="root";
	    String password="Saran@123?";
	    
	    Connection connection = DriverManager.getConnection(db_url, username, password);
	    
	    String createDB="create database JDBCEmployees";
	    String useDB="use JDBCEmployees ";
	    String createTable="CREATE TABLE Employee (empcod INT PRIMARY KEY,empnam VARCHAR(50),empag INT,esalar DECIMAL(10,2))";
	    String insert="INSERT INTO Employee (empcod, empnam, empag, esalar) VALUES(101, 'Jenny', 25, 10000),(102, 'Jacky', 30, 20000),(103, 'Joe', 20, 40000),(104, 'John', 40, 80000),(105, 'Shameer', 25, 90000)";
		String select="select * from Employee ";
		
		Statement smt = connection.createStatement();
		smt.execute(createDB);
		smt.execute(useDB);
		smt.execute(createTable);
		smt.executeUpdate(insert);
		
		ResultSet result = smt.executeQuery(select);
		
		while(result.next()) {
			
			System.out.println(result.getInt("empcod")+ "||"+ result.getString("empnam")+"||"+result.getInt("empag")+"||"+result.getBigDecimal("esalar"));
		}
		
		connection.close();
		
	}

}
		
		
		
	

