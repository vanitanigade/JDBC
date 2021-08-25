package package1.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.mysql.jdbc.Driver;

public class InsertStudent {
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		DriverManager.registerDriver(new Driver());
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vanita", "root","root");
		PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?)");
		System.out.println("enter student id");
		int id = sc.nextInt();
		System.out.println("enter percentage");
		float per = sc.nextFloat();
		System.out.println("enter name");
		String name = sc.next();
		
		ps.setInt(1, id);
		ps.setFloat(2, per);
		ps.setString(3, name);
		ps.executeUpdate();
	}

}
