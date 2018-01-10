import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {

	public static void main(String[] args) throws Exception {
		SQLManager.launchSQLManager();//SQLサーバーとの接続を確立
		//ここで各種メソッドをテスト

		/*
		 * UserDBUtil
		 */
		//addUser()のテスト(ユーザの追加)
		//public static boolean addUser( String userId, String pw, String name )
		//UserDBUtil.addUser("5401","name1","name1");

		//removeUser()のテスト(ユーザの削除)
		//public static boolean removeUser( String userId ) {
		/*
		boolean result=UserDBUtil.removeUser("test");
		System.out.print(result);
		*/

		//addPoint()のテスト(ユーザのポイント追加)
		//public static boolean addPoint( String userId, int value ) {
		//UserDBUtil.addPoint("pointtest",-10);

		/*
		 * RequestDBUtil
		 */

		//setStatus()のテスト(依頼の状態を設定)
		//public static boolean setStatus( int requestId, int value ){
		//RequestDBUtil.setStatus(2,1);

		//setDetails()のテスト(内容の変更)
		//public static boolean setDetails( int requestId, String details ){
		/*
		boolean result=RequestDBUtil.setDetails(1,"誰かジュース買ってきて");
		System.out.print(result);
		*/

		//setDeadline()のテスト(依頼の締め切り日時を設定)
		//public static boolean setDeadline( int requestId, Date deadline )
		/*
		String strDate = "2018/03/02 01:23:45";
        System.out.println("設定日時= "+strDate);
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        Date date = sdFormat.parse(strDate);
		boolean result=RequestDBUtil.setDeadline(1, date);
		System.out.print(result);
		*/

		//setPoint()のテスト(ポイントの設定)
		//public static boolean setPoint( int requestId, int point ) {
		/*
		boolean result=RequestDBUtil.setPoint(1,100);
		System.out.print(result);
		*/

		//setContractorID()のテスト(受注者の設定)
		//public static boolean setContractorID( int requestId, String contractorID )
		/*
		boolean result=RequestDBUtil.setContractorID(1,"pointtest");
		System.out.print(result);
		*/

		//setRequestName()のテスト(依頼名の設定)
		//public static boolean setRequestName( int requestId, String name )
		/*
		boolean result=RequestDBUtil.setRequestName(1,"ジュース買ってきて");
		System.out.print(result);
		*/

		//getRequests()のテスト(依頼の取得(引数で返り値変化))
		//public static Pair[] getRequests( String clientUserId, String contractorUserId, int status)
		/*
		Pair[] rezults=RequestDBUtil.getRequests("testUserID","pointtest",1);
		for (Pair rezult: rezults){
		      System.out.printf("%s,%s\n",rezult.first,rezult.second);
		}
		*/

		//sample
		//DBへ接続するためのサンプルプログラム
		/*
		UserDBUtil.sample();
		*/

	}

}
