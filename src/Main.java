
public class Main {

	public static void main(String[] args) throws Exception {
		SQLManager.launchSQLManager();//SQLサーバーとの接続を確立

		//ここで各種メソッドをテスト(以下は例)
		//UserDBUtil.addUser("5401","name1","name1");
		//
		//UserDBUtil.sample();
		//addPoint()のテスト
		//UserDBUtil.addPoint("pointtest",-10);

		//setStatus()のテスト
		RequestDBUtil.setStatus(2,1);
	}

}
