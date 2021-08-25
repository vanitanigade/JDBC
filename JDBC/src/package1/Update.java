package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.mysql.jdbc.Driver;

public class Update {
	
	public static void main(String[] args) throws Exception{		//DriverManager-> class Connection,PreparedStatement -> Interface

		Scanner sc = new Scanner(System.in);
		DriverManager.registerDriver(new Driver());
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vanita","root","root");
		System.out.println("Connection established");
		PreparedStatement ps = con.prepareStatement("Update customer set balance=? where custid=? ");
		System.out.println("enter customer id where balance has to set");
		int cid = sc.nextInt();
		System.out.println("set balance");
		int bal = sc.nextInt();
		ps.setInt(1, bal);
		ps.setInt(2, cid);
		ps.executeUpdate();
	}


}
