package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import com.mysql.jdbc.Driver;

public class InsertRow {

	public static void main(String[] args) throws Exception{		//DriverManager-> class Connection,PreparedStatement -> Interface

		Scanner sc = new Scanner(System.in);
		DriverManager.registerDriver(new Driver());
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		System.out.println("Connection established");
		PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?)");
		System.out.println("enter employee id");
		int empid = sc.nextInt();
		System.out.println("enter employee salary");
		int salary = sc.nextInt();
		System.out.println("enter employee name");
		String ename = sc.next();
		
		ps.setInt(1, empid);
		ps.setInt(2, salary);
		ps.setString(3, ename);
		ps.executeUpdate();
	}

}
