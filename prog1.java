import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/* ALL CRUD operations in this program */

public class prog1 {

	public static void main(String[] args) {
			Connection con=null;
			Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?user=root&password=bridgeit");
			System.out.println("Connection Established");
			st=con.createStatement();
			System.out.println("Statement Created");
//			int rs1=st.executeUpdate("create table login(id integer(5) primary key,username varchar(20),password varchar(20));");
//			System.out.println("Executed Creation");
//				System.out.println(rs1);
//			int rs1=st.executeUpdate("insert into login values(1,'aniketh','root1')");
//			System.out.println(rs1);
//			rs1=st.executeUpdate("insert into login values(7,'Milner','root2')");
//			System.out.println(rs1);
			int rs1=st.executeUpdate("update login set id=1,username='Aniketh' where id=1");
			System.out.println(rs1);
			ResultSet rs=st.executeQuery("select * from login");
			
			while(rs.next())
			{
				System.out.println("The ID is : "+rs.getInt(1) +" name is : "+rs.getString(2)+" password is :"+rs.getString(3));
			}
				
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
	}
}
