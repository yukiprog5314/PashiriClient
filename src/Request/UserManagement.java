package Request;

public class UserManagement {
	/**
	* @author	5423和田幹広
	* @param	userId	ユーザID
	* @param	passwd	パスワード
	* @param	name	ユーザ名
	* @return	ユーザ追加の成功可否。
	*/
	public boolean addUser(String userId, String passwd, String name){
		User newComer = getUser(userId);
		if(newComer.userID != null || !newComer.useID.isEmpty())
			return false;
		
		return addUser(userId, passwd, name);
		

	}

}
