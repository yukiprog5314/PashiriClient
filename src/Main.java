
public class Main {

	public static void main(String[] args) throws Exception {
		SQLManager.launchSQLManager();//SQLサーバーとの接続を確立
		
		//ここで各種メソッドをテスト(以下は例)
		UserDBUtil.addUser("5401","password","ABCDE FGHI");
		//
	}

}
