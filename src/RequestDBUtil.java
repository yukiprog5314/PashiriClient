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


}
