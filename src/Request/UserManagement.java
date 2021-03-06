package Request;
import DB. *;

public class UserManagement {
	/**
	* @author	5423和田幹広
	* @param	userId	ユーザID
	* @param	passwd	パスワード
	* @param	name	ユーザ名
	* @return	ユーザ追加の成功可否。
	*/
	public boolean addUser(String userId, String passwd, String name){
		UserDBUtil newComer = getUser(userId);
		if(newComer.userID != null || !newComer.useID.isEmpty())
			return false;
		return addUser(userId, passwd, name);
	}
	
	/**
	 * @author	5419 的野汰威
	 * @param	requestName 依頼名
	 * @param	point 報酬ポイント数
	 * @param	advancePoint デポジットポイント数
	 * @param	details 依頼の内容文
	 * @param	deadline 依頼の期限
	 * @return	登録成功の可否。
	*/
	public boolean addQuest(String requestName, int point, int advancePoint, String details, Date deadline){
		return addRequest(String requestName, int point, int advancePoint, String details, Date deadline);
	}	
}
