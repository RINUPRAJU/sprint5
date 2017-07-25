package pkgdbconnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.searchbean;

public class db_relationship extends DBconnection {
	
	public List<searchbean> getList(int log)
	{

	List<searchbean> list = new ArrayList<searchbean>();
	PreparedStatement ps = null;
	  
	   try {
	   ps = conn.prepareStatement("select * from tbl_user where ID!=?");
	       ps.setInt(1,log);
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

}
