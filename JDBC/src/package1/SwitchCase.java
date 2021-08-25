package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class SwitchCase {

	public static void main(String[] args) throws Exception {

		PreparedStatement ps;
		DriverManager.registerDriver(new Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		Scanner sc = new Scanner(System.in);
		while(true) {	//menu driven
			System.out.println("1.create table"); //case1
			System.out.println("2.insert data"); //case2
			System.out.println("3.update data"); //case3
			System.out.println("4.delete data"); //case4
			System.out.println("5.select data"); //case5
			System.out.println("6.exit"); 		//default
			System.out.println("enter your case no choice");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				ps = con.prepareStatement("create table employee1(empid int,salary int,ename varchar(25))");
				ps.execute();
				break;
			case 2:
				ps = con.prepareStatement("insert into employee1 values(?,?,?)");
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
				break;
			case 3:
				ps = con.prepareStatement("Update employee1 set salary=? where empid=? ");
				System.out.println("enter employee id where salary has to set");
				int eid = sc.nextInt();
				System.out.println("set salary");
				int sal = sc.nextInt();
				ps.setInt(1, sal);
				ps.setInt(2, eid);
				ps.executeUpdate();
				break;
			case 4:
				ps = con.prepareStatement("delete from employee1 where empid=? ");
				System.out.println("enter employee id");
				int id = sc.nextInt();
				ps.setInt(1, id);
				ps.executeUpdate();
				System.out.println("record deleted");
			case 5:
				ps = con.prepareStatement("select * from employee1 where empid=? ");
				System.out.println("enter employee id");
				int emid = sc.nextInt();

				ps.setInt(1, emid);
				ResultSet rs = ps.executeQuery();
				rs.next();	//point to row, display whole row
				System.out.println(rs.getInt("empid") + " " + rs.getInt("salary"));
			case 6:
				System.exit(0);
			
			}

			
		}
	}

}
