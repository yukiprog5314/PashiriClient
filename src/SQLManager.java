

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLManager {

	private static final String serverName = "ec2-52-14-126-140.us-east-2.compute.amazonaws.com";
	private static final String userName = "root";
	private static final String userPassword = "root";
	private static final String requestDBName = "requestDB";
	private static final String userDBName = "userDB";
	private static Connection requestConnection = null;
	private static Connection userConnection = null;

	public static void launchSQLManager() throws Exception{
		Class.forName("org.sqlite.JDBC");
		requestConnection = DriverManager.getConnection("jdbc:mysql://"+serverName+"/"+requestDBName+"?autoReconnect=true&useSSL=false",userName,userPassword);
		userConnection = DriverManager.getConnection("jdbc:mysql://"+serverName+"/"+userDBName+"?autoReconnect=true&useSSL=false",userName,userPassword);
	}
	/*
	 * 依頼DBへのSELECT文実行
	 */
	public static ResultSet requestDBQuery(String query) throws Exception{
		Statement stmt = requestConnection.createStatement();
		return stmt.executeQuery(query);
	}

	/*
	 * 依頼DBへのUPDATE,INSERT,DELETE文実行
	 */
	public static int requestDBUpdate(String query) throws Exception{
		Statement stmt = requestConnection.createStatement();
		return stmt.executeUpdate(query);
	}

	/*
	 * ユーザDBへのSELECT文実行
	 */
	public static ResultSet userDBQuery(String query) throws Exception{
		Statement stmt = userConnection.createStatement();
		return stmt.executeQuery(query);
	}

	/*
	 * 依頼DBへのUPDATE,INSERT,DELETE文実行
	 */
	public static int userDBUpdate(String query) throws Exception{
		Statement stmt = userConnection.createStatement();
		return stmt.executeUpdate(query);
	}

}
