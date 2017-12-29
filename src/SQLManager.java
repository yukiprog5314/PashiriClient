

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLManager {
	
	private static final String serverName = "http://hogehoge.com";
	private static final String iraiDBName = "requestDB.db";
	private static final String userDBName = "userDB.db";
	private static Connection requestConnection = null;
	private static Connection userConnection = null;
	
	public static void launchSQLManager() throws Exception{
		Class.forName("org.sqlite.JDBC");
		requestConnection = DriverManager.getConnection("jdbc:sqlite:"+serverName+"/"+iraiDBName);
		userConnection = DriverManager.getConnection("jdbc:sqlite:"+serverName+"/"+userDBName);
	}
	
	public static ResultSet requestDBQuery(String query) throws Exception{
		Statement stmt = requestConnection.createStatement();
		return stmt.executeQuery(query);
	}
	
	public static ResultSet userDBQuery(String query) throws Exception{
		Statement stmt = userConnection.createStatement();
		return stmt.executeQuery(query);
	}

}
