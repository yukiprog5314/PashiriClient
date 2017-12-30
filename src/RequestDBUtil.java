import java.sql.ResultSet;


public class RequestDBUtil {
	/**
	 * 依頼の状態を示すvalueを変更する
	 * @param requestId
	 * @param value
	 * @return
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

}
