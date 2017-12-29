import java.sql.ResultSet;

public class UserDBUtil {
	
	/*
	 * ユーザデータベースにユーザを追加するメソッド(参考程度に)
	 */
	public static boolean addUser(String userId, String pw, String name) {
		String query = "INSERT INTO table1 VALUES('"+userId+"','"+pw+"','"+name+"')";	//SQL文を生成
		try {
			ResultSet resultSet = SQLManager.userDBQuery(query);	//SQLManagerのメソッドを用いてクエリを飛ばす(この場合はユーザデータベースに)
		} catch (Exception e) {
			e.printStackTrace();
			return false;	//クエリ送信失敗
		}
		return true;	//ユーザ追加成功
	}

}
