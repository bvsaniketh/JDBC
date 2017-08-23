import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class prog3 {

	public static void main(String[] args) {
		Connection con =null;
		Statement st=null;
		PreparedStatement ps=null;
		String q1="select id,username from login where username=? and password=?";
		Scanner sc=new Scanner(System.in);
		String username1;
		String password1;
		int flag=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?user=root&password=bridgeit");
			System.out.println("Enter the username and password to login");
			username1=sc.next();
			password1=sc.next();
			
			ps=con.prepareStatement(q1);
			ps.setString(1, username1);
			ps.setString(2, password1);
//			ps.executeUpdate();
//			boolean a=
//			System.out.println(a);
//			if(a)
//			System.out.println("Login Successful");
//			else
//			System.out.println("Invalid Login");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				flag=1;
				System.out.println("Welcome " + rs.getInt(1)+" "+ rs.getString(2));
			}
			if(flag==0)
			{
				System.out.println("Invalid Login");
			}
//			st=con.createStatement();
//			ResultSet rs=st.executeQuery("select * from login");
//			while(rs.next)
//			{
//				if(rs.getString(1)==username1 &&rs.getString(2)==password1)
//					
//			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try {
					st.close();
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		// TODO Auto-generated method stub

	}

}
