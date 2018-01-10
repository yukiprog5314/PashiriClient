
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
	/*
	 * 依頼の取得(引数で返り値変化)
	 */
	public static Pair<Integer,String>[] getRequests( String clientUserId, String contractorUserId, int status){
		int i=0,flag=0;
		Pair<Integer,String> result_pairs[];

		String query = "SELECT RequestID,Name from Requests";
		if (clientUserId!=null) {
			query+=(flag==0)? " where " : " OR ";
			query+=" ClientID='"+clientUserId+"'";
			flag=1;
		}
		if (contractorUserId!=null) {
			query+=(flag==0)? " where " : " OR ";
			query+=" ContractorID='"+contractorUserId+"'";
			flag=1;
		}
		if (status!=-1) {
			query+=(flag==0)? " where " : " OR ";
			query+=" status="+status;
			flag=1;
		}
		//System.out.println(query);

		try {
			ResultSet resultSet =SQLManager.requestDBQuery(query);
			resultSet.last();
			result_pairs = new Pair[resultSet.getRow()];
			resultSet.beforeFirst();

			while(resultSet.next()){
				Pair<Integer,String> instsnce = new Pair<Integer, String>(resultSet.getInt("RequestID"),resultSet.getString("Name"));
				result_pairs[i]=instsnce;
				i++;
			}
			return (result_pairs);
		} catch (Exception e) {
			e.printStackTrace();
			Pair<Integer,String> instsnce = new Pair<Integer, String>(-1,null);
			result_pairs = new Pair[1];
			result_pairs[0]=instsnce;
			return (result_pairs);	//クエリ送信失敗

		}

	}

}
