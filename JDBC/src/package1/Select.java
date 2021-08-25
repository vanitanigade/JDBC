package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.mysql.jdbc.Driver;

public class Select {

	public static void main(String[] args) throws Exception{   //DriverManager-> class Connection,PrepStatment, Resultset -> Interface

		Scanner sc = new Scanner(System.in);
		DriverManager.registerDriver(new Driver());

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vanita","root","root");
		System.out.println("Connection established");
		PreparedStatement ps = con.prepareStatement("select * from customer where custid=? ");
		System.out.println("enter customer id");
		int cid = sc.nextInt();

		ps.setInt(1, cid);
		ResultSet rs = ps.executeQuery();
		rs.next();	//point to row, display whole row
		System.out.println(rs.getInt("custid") + " " + rs.getInt("balance"));
	}

}
