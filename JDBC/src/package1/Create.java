package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.mysql.jdbc.Driver;

public class Create {
	
	public static void main(String[] args) throws Exception{		//DriverManager-> class Connection,PreparedStatement -> Interface

		DriverManager.registerDriver(new Driver());
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		System.out.println("Connection established");
		PreparedStatement ps = con.prepareStatement("create table employee(empid int,salary int,ename varchar(25))");
		ps.execute();
	
	
	}

}
