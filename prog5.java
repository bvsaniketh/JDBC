import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class prog5 {

	public static void main(String[] args) {
		Connection con=null;
		//Statement st=null;
		PreparedStatement ps=null;
		String q1="create table bank1(balance integer(100),name varchar(20))";
		Scanner sc= new Scanner(System.in);
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?user=root&password=bridgeit");
			con.setAutoCommit(false);
			
			ps=con.prepareStatement("insert into bank1(?,?)");
			System.out.println("Enter the values to insert");
			int amt=sc.nextInt();
			String name=sc.next();
			ps.setInt(1, amt);
			ps.setString(2, name);
//			ps.execute(); //Not required. Execute at last as a batch.
			ps.addBatch();
			
			ps=con.prepareStatement("insert into bank1(?,?)");
			System.out.println("Enter the values to insert");
			amt=sc.nextInt();
			name=sc.next();
			ps.setInt(1, amt);
			ps.setString(2, name);
//			ps.execute(); //Not required. Execute at last as a batch.
			ps.addBatch();
					
			ps=con.prepareStatement("insert into bank1(?,?)");
			System.out.println("Enter the values to insert");
			amt=sc.nextInt();
			name=sc.next();
			ps.setInt(1, amt);
			ps.setString(2, name);
//			ps.execute(); //Not required. Execute at last as a batch.
			ps.addBatch();
			
			ps=con.prepareStatement("update bank set balance=? where name=?");
			System.out.println("Enter the values to update");
			amt=sc.nextInt();
			name=sc.next();
			ps.setInt(1, amt);
			ps.setString(2, name);
			
			ps.addBatch();
			
			ps.executeBatch();
			con.commit();
			
			ps=con.prepareStatement("select * from bank1");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("Balance : " + rs.getInt(1)+ "Name : "+rs.getString(2));
			}
			
			
//			ps=con.prepareStatement(q4);
//			System.out.println("Enter the rno and room name to update");
//			roomno=sc.nextInt();
//			roomname=sc.next();
//			ps.setInt(1, roomno);
//			ps.setString(2, roomname);
//			ps.executeUpdate();
//			ps=con.prepareStatement(q6);
//			System.out.println("Enter the rno to delete");
//			roomno=sc.nextInt();
//			ps.setInt(1, roomno);
//			ps.executeUpdate();
//			ps=con.prepareStatement(q5);
//			ResultSet rs=ps.executeQuery();
//			while(rs.next())
//			{
//				System.out.println(rs.getInt(1)+" " +rs.getString(2));
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
					//st.close();
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}

}
