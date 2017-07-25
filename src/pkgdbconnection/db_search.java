package pkgdbconnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.searchbean;



public class db_search extends DBconnection {
	
	
	public String inserting(int fk_int_id,int user_one_id,int user_two_id,int status,int action_user_id) throws SQLException
	{
		System.out.println("inserting");
		PreparedStatement pt;
		pt= super.conn
	   .prepareStatement("insert into tbl_relationship(fk_int_id,user_one_id,user_two_id,status,action_user_id)values(?,?,?,?,?)");
	    //pt.setInt(1,ID);
		pt.setInt(1,fk_int_id);
		pt.setInt(2,user_one_id);
		pt.setInt(3,user_two_id );
		pt.setInt(4,status );
		pt.setInt(5,action_user_id);
		
		pt.execute();
		
		
		return "success";
	}
	
	public String confirm(int status,int action_user_id,int user_one_id,int user_two_id) throws SQLException
	{
		PreparedStatement pt1;
		pt1= super.conn
	   .prepareStatement("UPDATE tbl_relationship SET status = ?, action_user_id =? WHERE user_one_id =?  AND user_two_id =?");
		pt1.setInt(1,status );
		pt1.setInt(2,action_user_id);
		pt1.setInt(3,user_one_id);
		pt1.setInt(4,user_two_id );
		
		pt1.execute();
		return "sucess";
	}
	public String delete(int status,int action_user_id,int user_one_id,int user_two_id) throws SQLException
	{
		
		PreparedStatement pt2;
		pt2= super.conn
	   .prepareStatement("delete from tbl_relationship where status = ? and action_user_id =? and user_one_id =?  AND user_two_id =?");
		pt2.setInt(1,status );
		pt2.setInt(2,action_user_id);
		pt2.setInt(3,user_one_id);
		pt2.setInt(4,user_two_id );
		
		pt2.execute();
		return "sucess";
	}
	public String unfriend(int status,int action_user_id,int user_one_id,int user_two_id) throws SQLException
	{
		
		PreparedStatement pt3;
		pt3= super.conn
	   .prepareStatement("update tbl_relationship set status = ? and action_user_id =? where user_one_id =?  AND user_two_id =?");
		pt3.setInt(1,status );
		pt3.setInt(2,action_user_id);
		pt3.setInt(3,user_one_id);
		pt3.setInt(4,user_two_id );
		
		pt3.execute();
		return "sucess";
	}
	
	public List<searchbean> getList1(int logid)
	{

	            List<searchbean> list = new ArrayList<searchbean>();
	            PreparedStatement ps = null;
	  
	   try {
	            ps = conn.prepareStatement("select * from tbl_user where ID!=?");
	            ps.setInt(1,logid);
	            ps.execute();
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	        	searchbean sb=new searchbean();
	           	sb.setFirstname( rs.getString("Firstname"));
	            sb.setLastname(rs.getString("Lastname"));
	            sb.setFile(rs.getString("file"));   
	            sb.setID(rs.getString("ID"));
	            list.add(sb);
	            System.out.println("nameee"+sb.getFirstname());
	           }
	   } catch (Exception e) {
	           System.out.println(e.getMessage());
	   }

	            return list;
	}
	public List<searchbean> getList(int reqid)
	{

	           List<searchbean> list = new ArrayList<searchbean>();
	           PreparedStatement ps = null;
	  
	   try {
	           ps = conn.prepareStatement("select s.ID,s.Firstname, s.Lastname, s.file, g.status, g.fk_int_id from tbl_user s, tbl_relationship g where(user_two_id=?) and status=0 and ID=fk_int_id;");
	      
		       ps.setInt(1,reqid);
	           ps.execute();
	           ResultSet rs = ps.executeQuery();
	           while (rs.next()) {
	           searchbean sb=new searchbean();
	           sb.setFirstname( rs.getString("Firstname"));
	           sb.setLastname(rs.getString("Lastname"));
	           sb.setFile(rs.getString("file"));   
	           sb.setID(rs.getString("ID"));
	           list.add(sb);
	           System.out.println("nameee"+sb.getFirstname());
	           }
	   } catch (Exception e) {
	           System.out.println(e.getMessage());
	   }

	          return list;
	}
	public List<searchbean> getList2(int loginid)
	{

	          List<searchbean> list = new ArrayList<searchbean>();
	          PreparedStatement ps = null;
	  
	   try {
	          ps = conn.prepareStatement("select s.ID,s.Firstname, s.Lastname, s.file, g.status, g.fk_int_id from tbl_user s, tbl_relationship g where(user_two_id=?) and status=1 and ID=fk_int_id;");
	          ps.setInt(1,loginid);
	          ps.execute();
	          ResultSet rs = ps.executeQuery();
	          while (rs.next()) {
	          searchbean sb=new searchbean();
	          sb.setFirstname( rs.getString("Firstname"));
	          sb.setLastname(rs.getString("Lastname"));
	          sb.setFile(rs.getString("file"));   
	          sb.setID(rs.getString("ID"));
	          list.add(sb);
	          System.out.println("nameee"+sb.getFirstname());
	           }
	   } catch (Exception e) {
	          System.out.println(e.getMessage());
	   }

	          return list;
	}
				
	public ArrayList<String> getNames(String name) {
	       ArrayList<String> list = new ArrayList<String>();
	       PreparedStatement ps = null;
	       String data;
	       try {
	       ps = conn.prepareStatement("select * from tbl_user where Firstname  LIKE ?");
	       ps.setString(1, name + "%");
	       System.out.println("searchname:"+ name);
	       ResultSet rs = ps.executeQuery();
	       while (rs.next()) {
	       data = rs.getString("Firstname");
	       list.add(data);
	       System.out.println("dataname:"+ data);
	               }
	       } catch (Exception e) {
	               System.out.println(e.getMessage());
	       }
	       return list;
	}
	

}
