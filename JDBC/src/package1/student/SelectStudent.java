package package1.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class SelectStudent {
	
	public static void main(String[] args) throws Exception {
		
		DriverManager.registerDriver(new Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vanita","root","root");
		PreparedStatement ps = con.prepareStatement("select * from student where sid=?");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter student id");
		int id = sc.nextInt();
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		System.out.println(rs.getInt("sid") + " " + rs.getFloat("percentage") + " " + rs.getString("sname"));
		
	}

}
