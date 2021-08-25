package package1.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class UpdateStudent {
	
	public static void main(String[] args) throws Exception {
		
		DriverManager.registerDriver(new Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vanita","root","root");
		System.out.println("connection established");
		PreparedStatement ps = con.prepareStatement("update student set percentage=? where sid=?");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id");
		int id = sc.nextInt();
		System.out.println("enter percentage which has to set");
		float per = sc.nextFloat();
		ps.setFloat(1, per);
		ps.setInt(2, id);
		ps.executeUpdate();
		
	}

}
