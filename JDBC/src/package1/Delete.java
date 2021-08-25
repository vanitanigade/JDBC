package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.mysql.jdbc.Driver;

public class Delete {

	public static void main(String[] args) throws Exception{		//DriverManager-> class Connection,PreparedStatement -> Interface

		Scanner sc = new Scanner(System.in);
		DriverManager.registerDriver(new Driver());
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vanita","root","root");
		System.out.println("Connection established");
		PreparedStatement ps = con.prepareStatement("delete from customer where custid=? ");
		System.out.println("enter customer id");
		int cid = sc.nextInt();
		ps.setInt(1, cid);
		ps.executeUpdate();
		System.out.println("record deleted");
	}

}
