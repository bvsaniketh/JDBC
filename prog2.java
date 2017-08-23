import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class prog2 {
//CRUD operations using PreparedStatement
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		PreparedStatement ps=null;
		String q1="create table room(rno integer(5),bname varchar(20))";
		String q2="insert into room values(?,?)";
		String q3="insert into room values(?,?)";
		String q4="update room set rno=? where bname=?";
		String q5="select * from room";
		String q6="delete from room where rno=?";
		Scanner sc= new Scanner(System.in);
		int roomno=0;
		String roomname=null;
		//String q2="insert "
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?user=root&password=bridgeit");
			st=con.createStatement();
//			ps=con.prepareStatement(q1);
//			ps.executeUpdate();
//			ps=con.prepareStatement(q2);
//			ps.setInt(1,106);
//			ps.setString(2, "Room6");
//			ps.executeUpdate();
//			ps=con.prepareStatement(q3);
//			ps.setInt(1,107);
//			ps.setString(2, "Room7");
//			ps.executeUpdate();
			ps=con.prepareStatement(q4);
			System.out.println("Enter the rno and room name to update");
			roomno=sc.nextInt();
			roomname=sc.next();
			ps.setInt(1, roomno);
			ps.setString(2, roomname);
			ps.executeUpdate();
			ps=con.prepareStatement(q6);
			System.out.println("Enter the rno to delete");
			roomno=sc.nextInt();
			ps.setInt(1, roomno);
			ps.executeUpdate();
			ps=con.prepareStatement(q5);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" " +rs.getString(2));
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
