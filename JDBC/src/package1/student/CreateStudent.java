package package1.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.mysql.jdbc.Driver;

public class CreateStudent {
	
	public static void main(String[] args) throws Exception{		//DriverManager-> class Connection,PreparedStatement -> Interface

		DriverManager.registerDriver(new Driver());
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vanita","root","root");
		PreparedStatement ps = con.prepareStatement("create table student(sid int,percentage numeric(8,2),sname varchar(20))");
		ps.execute();
	
	}


}
