package pkgdbconnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.newsfeedbean;

public class Db_newsfeed extends DBconnection {
	
	public String newsinsert(int int_uid,String vchr_newsfeed) throws SQLException
	{
	      PreparedStatement pt;
	      pt= super.conn
	     .prepareStatement("insert into tbl_newsfeed(int_uid,vchr_newsfeed)values(?,?)");
	      //pt.setInt(1,pk_int_nfid);
	      pt.setInt(1,int_uid);
	      pt.setString(2,vchr_newsfeed);
	      pt.execute();
	      return "home";
	}

	public String imginsert(int int_userid,String vchr_imgstatus,String vchr_imgupload) throws SQLException {
		 
		PreparedStatement pt;
		pt=super.conn
		.prepareStatement("insert into tbl_newsfeedimg(int_userid,vchr_imgstatus,vchr_imgupload)values(?,?,?)");
		pt.setInt(1,int_userid);
		pt.setString(2,vchr_imgstatus);
		pt.setString(3,vchr_imgupload);
		pt.execute();
		return "home";
	}
	
	public List<newsfeedbean> getList()
	{

	List<newsfeedbean> list = new ArrayList<newsfeedbean>();
	PreparedStatement ps = null;
	  
	   try {
		   ps = conn.prepareStatement(" select s.ID,s.Firstname, s.Lastname, s.file, g.vchr_newsfeed from tbl_user s, tbl_newsfeed g where g.int_uid=s.ID order by pk_int_nfid DESC;");
	      // ps.setInt(1,newfeed1);
	       ps.execute();
	       ResultSet rs = ps.executeQuery();
	       while (rs.next()) {
	       newsfeedbean nb=new newsfeedbean();
	       nb.setFirstname( rs.getString("Firstname"));
	       nb.setLastname(rs.getString("Lastname"));
	       nb.setFile(rs.getString("file"));   
	       nb.setID(rs.getString("ID"));
	       nb.setNewsstatus(rs.getString("vchr_newsfeed"));
	       list.add(nb);
	       System.out.println("newsfeed:"+nb.getNewsstatus());
	           }
	   } catch (Exception e) {
	       System.out.println(e.getMessage());
	   }

	       return list;
	}
	public List<newsfeedbean> getList1()
	{

	List<newsfeedbean> list = new ArrayList<newsfeedbean>();
	PreparedStatement ps = null;
	  
	   try {
		   ps = conn.prepareStatement("select s.ID,s.Firstname, s.Lastname, s.file, g.vchr_imgstatus,g.vchr_imgupload from tbl_user s, tbl_newsfeedimg g where g.int_userid=s.ID order by pk_int_nimg DESC;");
	      // ps.setInt(1,newfeed1);
	       ps.execute();
	       ResultSet rs = ps.executeQuery();
	       while (rs.next()) {
	       newsfeedbean nb=new newsfeedbean();
	       nb.setFirstname( rs.getString("Firstname"));
	       nb.setLastname(rs.getString("Lastname"));
	       nb.setFile(rs.getString("file"));   
	       nb.setID(rs.getString("ID"));
	       nb.setImgstatus(rs.getString("vchr_imgstatus"));
	       nb.setImgupload(rs.getString("vchr_imgupload"));
	       list.add(nb);
	       System.out.println("imgstat:"+nb.getImgstatus());
	       System.out.println("imguplod:"+nb.getImgupload());
	           }
	   } catch (Exception e) {
	       System.out.println(e.getMessage());
	   }

	       return list;
	}

		
}
