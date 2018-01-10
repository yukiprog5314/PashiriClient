
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RequestDBUtil {

	/*
	 * ステータスの設定
	 */
	public static boolean setStatus( int requestId, int value ){
		String query = "UPDATE Requests SET Status = "+value+" where RequestID='"+requestId+"'";
		try {
			 int result =SQLManager.requestDBUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
			return false;	//クエリ送信失敗
		}
		return true;
	}

	/*
	 * 内容の設定
	 */
	public static boolean setDetails( int requestId, String details ){
    	String query = "UPDATE Requests SET Details = '"+details+"' where RequestID='"+requestId+"'";
   		//System.out.printf("sql:%s",query);
    	try {
   			  int result =SQLManager.requestDBUpdate(query);
   		 } catch (Exception e) {
   			 e.printStackTrace();
   			 return false;
   		 }
   		 return true;
    }

	/*
	 * 依頼の締切日時の追加
	 */
	public static boolean setDeadline( int requestId, Date deadline ){
		// java.util.Dateからdatetime型の形式「yyyy-MM-dd HH:mm:ss」に整形
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String convDeadline = sdFormat.format( deadline );

		String query = "UPDATE Requests SET Deadline = cast('" + convDeadline + "' as Datetime ) WHERE RequestID = " + requestId;	//SQL文を生成
		//System.out.println( query );
		try {
			SQLManager.requestDBUpdate( query );	//SQLManagerのメソッドを用いてクエリを飛ばす(この場合は依頼データベースに)
		} catch (Exception e) {
			e.printStackTrace();
			return false;	//クエリ送信失敗
		}
		return true; //期限設定成功
	}

	/*
	 * ポイントの設定
	 * 依頼テーブルのpointの値を変更
	 */
	public static boolean setPoint( int requestId, int point ) {
		String query = "UPDATE Requests SET Point = " + point + " WHERE RequestID = " + requestId;	//SQL文を生成
		try {
			SQLManager.requestDBUpdate( query );	//SQLManagerのメソッドを用いてクエリを飛ばす(この場合は依頼データベースに)
		} catch (Exception e) {
			e.printStackTrace();
			return false; //クエリ送信失敗
		}
		return true;
	}


	/*
	 * 全依頼の取得
	 */
	public static int[] getAllRequest() {
		int [] requestIDs;
		int i=0;
		String query = "SELECT RequestID from Requests";
		try {
			System.out.println(query);
			ResultSet resultSet =SQLManager.requestDBQuery(query);
			resultSet.last();
			int number_of_tables = resultSet.getRow();
			resultSet.beforeFirst();
			requestIDs = new int[number_of_tables];
			while(resultSet.next()){
				requestIDs[i]=resultSet.getInt("RequestID");
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			requestIDs = new int[1];
			requestIDs[0] =-1;
			return (requestIDs);	//クエリ送信失敗
		}
		return (requestIDs);
	}
	
	/*
	 * 受注者の設定
	 */
	public static boolean setContractorID( int requestId, String contractorID ) {
		String query = "UPDATE Requests SET ContractorID = '" + contractorID + "' WHERE RequestID = " + requestId;	//SQL文を生成
		//System.out.println( query );
		try {
			SQLManager.requestDBUpdate( query );	//SQLManagerのメソッドを用いてクエリを飛ばす(この場合は依頼データベースに)
		} catch (Exception e) {
			e.printStackTrace();
			return false; //クエリ送信失敗
		}
		return true;
	}
	
	/*
	 * 依頼名の設定
	 */	
	public static boolean setRequestName( int requestId, String name ) {
		String query = "UPDATE Requests SET Name = '" + name + "' WHERE RequestID = " + requestId;	//SQL文を生成
		System.out.println( query );
		try {
			SQLManager.requestDBUpdate( query );	//SQLManagerのメソッドを用いてクエリを飛ばす(この場合は依頼データベースに)
		} catch (Exception e) {
			e.printStackTrace();
			return false; //クエリ送信失敗
		}
		return true;
	}


}
