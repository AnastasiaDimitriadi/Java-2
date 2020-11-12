
import java.sql.*;

public class EditDatabase 
{
	public static void insertDB(String Username, int orderNo, String Product)
	{
		String url = "jbc:mysql://localhost:3306/OrderDB?user=root&password=tei@123";
		
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement s = null;
		try {
			s = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int m = 0;
		try {
			m = s.executeUpdate("INSERT INTO Orders VALUES ('" + Username + "', " + orderNo + ", '" + Product + "';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readDB()
	{
		String url = "jbc:mysql://localhost:3306/OrderDB?user=root&password=tei@123";
		Connection con = null;
		try {
			 con = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String myQuery = "SELECT * FROM OrderDB;";
		ResultSet results = null;
		try {
			results = st.executeQuery(myQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Print
		try {
			while (results.next())
			{	
				// [1]
				String Username;
				try {
					Username = results.getString(1);
				
					String Product = results.getString(3);
					int orderNo = results.getInt(2);
					System.out.println("Record found: Username = " + Username + ", OrderNo = " + orderNo + ", Product = " + Product + "\n");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		insertDB("user1", 1, "HP Laptop 1114");
		insertDB("user2", 12, "DELL Laptop 6445");
		insertDB("user3", 29, "Asus Laptop 8653");
		
		readDB();
	}
}
