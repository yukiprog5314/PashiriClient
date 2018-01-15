package DB;
import java.util.ArrayList;

/**
 *
 * @author 5401masaya uchida
 *担当箇所のみ
 */
public class Request {

	/**
	 *
	 * 機能：ユーザIDを引数に、そのユーザが受注している依頼の一覧を取得
	 * 担当：5401 打田
	 * 引数：ユーザID(String)
	 * 返値：RequestRecord{依頼ID(int)、依頼名(string)}
	 */
	public static ArrayList<RequestRecord> getMyOrdered(String userId) {

		if(userId==null) {
			System.out.print("ユーザidを入力されていません");
		}

		System.out.println(userId);
		Pair pair[] = RequestDBUtil.getRequests(null, userId, -1);
		System.out.println(userId+"さんの受注中のお仕事は以下の通りです。");

		RequestRecord record  = new RequestRecord();
		ArrayList<RequestRecord> arrayRecord = new ArrayList<RequestRecord>();

		for(int i =0; i<pair.length ;i++) {
			record.setRequestId((int)pair[i].first);
			record.setName((String)pair[i].second);
			arrayRecord.add(record);

			System.out.println("依頼ID："+record.getRequestId() + " 依頼名：" + record.getName());
		}


		return arrayRecord;
	}


}
