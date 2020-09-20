package ForStudent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/dorm?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true";
	static final String USERNAME = "root";
	static final String PASSWORD = "123456";
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	
	public DB() {
		
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            st = con.createStatement();
            String usedorm = "use dorm;";
            st.executeUpdate(usedorm);

		}
		catch(ClassNotFoundException e) {
			System.out.println("Class Not Found Exection");
			e.printStackTrace();
		}catch(SQLException e){
			System.out.println("SQL Exception : " + e.getMessage());
			e.printStackTrace();
		}
		
	}
}
