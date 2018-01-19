package Request;
import java.awt.List;
import java.util.ArrayList;

import DB. *;

public class RequestManagement {
	/** 
	* @author	5417成岡大輝
	* @return	全ユーザの情報が格納されたリスト。
	*/
	public void getUsersList(){
		List<User> userList = getAllUsers(); // DBから全ユーザの情報を取得するメソッド。DB班の実装待ち。名称未定。
		return userList;
	}
	
	/**
     * <p> ユーザIDを引数に、そのユーザが発注している依頼の一覧を取得 </p>
     * @author 5408 小林朝陽
     * @param userId ユーザID (String)
     * @return Pair配列 (依頼IDと依頼内容をまとめたクラスの配列, 失敗した場合はnull)
     */
    public Pair<Integer,String>[] getMyOrdering(String userId) {
    	if (userId == null || userId == "") {
            System.out.println("error : ユーザIDが未入力(getMyOrdering)"); // デバッグ用
            return null;
        } else {
            return RequestDBUtil.getRequests(userId, null, -1);
        }
    }
    
    /**
	 *機能：ユーザIDを引数に、そのユーザが受注している依頼の一覧を取得
	 * @author 5401 打田将也
	 * @param userId:ユーザID
	 * @return 依頼IDと依頼名をまとめたPair(失敗した場合はnull)
	 */
	public static Pair<Integer,String>[] getMyOrdered(String userId) {
		if(userId == null || userId == "") {
			System.out.print("ユーザidを入力されていません");
			return null;
		}
		else {
			return RequestDBUtil.getRequests(null, userId, -1);
		}
	}
	
	/**
	 * 機能：受注されていないRequestRecord型の配列データを返す
	 * @author 5410 鈴木勇哉
	 * @return ArrayList<RequestRecord> 型の配列
	 */
	public static ArrayList<RequestRecord> list_reqest(){
		Pair<Integer,String> pair[] = RequestDBUtil.getRequests(null, null, -1);
		ArrayList <RequestRecord> records = new ArrayList<RequestRecord>();
		for(Pair<Integer, String> i: pair){
			RequestRecord req = getRequest(i.first);
			if(req.getContractorId() == -1){
				records.add(req);
			}
		}
		return records;
	}
	
	/**
     * 依頼IDを引数にそのIDの依頼の詳細情報を取得
     * @author 5414 張ニコラス謙豪
     * @param id: 依頼ID(int型)
     * @return RequestRecord{依頼ID(int)、依頼名(string)、発注者ID(string)、受注者ID(string(存在しない場合：-1))、報酬ポイント(int)、デポジット(int)、内容(string)、状態(int)、期限(Date)}
     */
    public static RequestRecord showOrder(int id){ {
    	if (id < 1 ){
            System.out.println("正しい依頼IDが入力されていません"); 
            return null;
        }
        else{
            return RequestDBUtil.getRequest(id);
        }
    }
    
    /**
	 * <p> 依頼の受注を行うメソッド </p>
	 * @author 5418藤野眞人
	 * @param	reqId 依頼ID
	 * @param	posterId 受注者ID
	 * @return 受注の成功の可否
	 */
	public boolean postOrder(int reqId, String posterId){
		RequestRecord req = getRequest(reqId);
		if(req.getRequestId == -1)return false;
		return setContractorID(reqId, posterId);
	}
	
	/**
	 * <p> 受注のキャンセルを行う </p>
	 * @author 5413 多田明貴子
	 * @param  userId	発注者id
	 * @param  reqId	依頼id
	 * @return 削除の可否
	 */
	public boolean cancelOrder(String userId, int reqId){
	    RequestRecord req = getRequest(reqId);
	    String clientId = req.getClientId();
	    if(userId.equals(clientId)){
	        return false;
	    }
	    return removeRequest(int);
	}
	
	
	
}
