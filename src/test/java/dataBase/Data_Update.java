package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class Data_Update {
	@Test
	public void Dataupdate() throws Exception {

		Driver d=new Driver();

		DriverManager.registerDriver(d);

		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/mst1", "root","123456");

		Statement s=c.createStatement();
		
		@SuppressWarnings("unused")
		int i=s.executeUpdate("UPDATE report SET Name='Chik' Where Id=1 ");

		ResultSet r= s.executeQuery("SELECT * FROM mst1.report");
		while(r.next()) {

			String data =r.getString(1)+" "+r.getString(2)+" "+r.getString(3);
			System.out.println(data);
		}
	}
}