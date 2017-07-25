package pkgdbconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBconnection {
	
	public Connection conn = null;
	public DBconnection()



	{
	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	}
	try {
	this.conn = DriverManager.getConnection(
	"jdbc:mysql://localhost/facebook", "root", "");
	if (this.conn != null) {

	System.out.println("connected");
	}
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}





	}
}
