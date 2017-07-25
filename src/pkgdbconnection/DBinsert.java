package pkgdbconnection;

import java.sql.*;

public class DBinsert extends DBconnection {
	
	
	public String insert(String Firstname,String Lastname,String Email,String Reemail,String Password,String file,String date_dob,String Gender) throws SQLException
	{
		PreparedStatement pt;
		pt= super.conn
	.prepareStatement("insert into tbl_user(Firstname,Lastname,Email,Reemail,Password,file,date_dob,Gender)values(?,?,?,?,?,?,?,?)");
	    //pt.setInt(1,ID);
		pt.setString(1, Firstname);
		pt.setString(2, Lastname);
		pt.setString(3, Email);
		pt.setString(4,Reemail);
		pt.setString(5,Password);
		pt.setString(6, file);
		pt.setString(7, date_dob);
		pt.setString(8, Gender);
		pt.execute();
		return "success";
	}
	
	public ResultSet select(String Email, String Password) throws SQLException
	{
		PreparedStatement pt1;
		
			pt1 = super.conn
			
		.prepareStatement("select * from tbl_user where Email=? and Password=?");
			pt1.setString(1, Email);
			pt1.setString(2, Password);
			ResultSet rs = pt1.executeQuery();
            /*while(rs.next())
            {
                     String email=rs.getString("Email");
                     String pswd=rs.getString("Password");
                     System.out.println("email:"+Email + "pswd:"+Password);
            }
				pt1.execute();
*/			System.out.println("selected");
		
		
		return rs;
		
	}
	public ResultSet emailerror(String Email) throws SQLException
	{
		PreparedStatement pt2;
		pt2=super.conn.
		prepareStatement(" select * from tbl_user where Email=?");
		System.out.println("Email");
				pt2.setString(1,Email);
        ResultSet rs1 = pt2.executeQuery();
        pt2.execute();
          
          return rs1;
	}
	
	public String test()
	{
		System.out.println("success");
		return "success";
	}
	
	public ResultSet store(String Username, String Password) throws SQLException
	{
		PreparedStatement pt1;
		pt1=super.conn.
		//prepareStatement("select email,password from tbl_user where email=?, password=?");
	    prepareStatement("call face(?,?)");
		
				
				
		pt1.setString(1,Username);
		pt1.setString(2,Password);
		//pt1.execute();
		 // System.out.println( pt1.execute());
     ResultSet rs = pt1.executeQuery();
   
          
          return rs;
		
	}
	
	
	
}
	
/*
		
	public ResultSet getall() throws SQLException
	{
		PreparedStatement pt;
		pt=super.conn.prepareStatement("select * from tbl_user");
		ResultSet rs =pt.executeQuery();
		return rs;
	}

	}

*/
