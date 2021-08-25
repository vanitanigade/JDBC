package package1.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class DeleteStudent {

	public static void main(String[] args) throws Exception {

		DriverManager.registerDriver(new Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vanita","root","root");
		System.out.println("connection established");
		PreparedStatement ps = con.prepareStatement("delete from student where sid=?");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter student id where record needs to delete");
		int id = sc.nextInt();
		ps.setInt(1, id);
		ps.executeUpdate();
	}

}
