package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class DataBase {
	@Test
	public void JDBC() throws SQLException {

		Driver d=new Driver();

		DriverManager.registerDriver(d);

		Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/mst1","root","123456");
		Statement statement=connect.createStatement();

		//int value=statement.executeUpdate(null)
		ResultSet q=statement.executeQuery("SELECT * FROM mst1.students");
		while(q.next())
		{
			String data=q.getString(1)+" "+q.getString(2)+" "+q.getString(3);
			System.out.println(data);
		}
		connect.close();
	}

}
