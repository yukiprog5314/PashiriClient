

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * <p>Userクラスは、それぞれのユーザーの情報をインスタンスに保持する。</p>
 *
 * @author 5415 土田 雄輝 & 5422 和田
 *
 */
public class RequestRecord {

	private int requestID;		///依頼ID
	private String name;		///依頼名
	private String clientID;		///発注者ID
	private String clientName;
	private String contractorID;	///受注者ID
	private String contractorName;
	private int point;			///ポイント
	private int advancePoint;	///前金
	private String detail;		///内容
	private int status;			///状態
	private java.util.Date deadline;		///期限

	//コンストラクタ
	public RequestRecord(){
		this.requestID = 0;
		this.name = null;
		this.clientID = "0";
		this.clientName = null;
		this.contractorID = "-1";
		this.contractorName = null;
		this.point = 0;
		this.advancePoint = 0;
		this.detail = null;
		this.status = 0;
		this.deadline = null;
	}



	// Matono tukure1
		public void setDeadline(Date dline){
			this.deadline =dline;
		}

		public java.util.Date getDeadline(){
			return deadline;
		}


		public void setRequestId(int reqId){
			this.requestID = reqId;
		}

		public int getRequestId(){
			return requestID;
		}

		public void setName(String name){
			this.name = name;
		}

		public String getName(){
			return name;
		}

		public void setClientId(String clientId){
			this.clientID = clientId;
		}

		public String getClientId(){
			return clientID;
		}

		public void setClientName(String clientName){
			this.clientName = clientName;
		}

		public String getClientName(){
			return clientName;
		}

		public void setContractorId(String contractorId){
			this.contractorID = contractorId;
		}

		public String getContractorId(){
			return contractorID;
		}

		public void setContractorName(String contractorName){
			this.contractorName = contractorName;
		}

		public String getContractorName(){
			return contractorName;
		}

		public void setPoint(int point){
			this.point = point;
		}

		public int getPoint(){
			return point;
		}

		public void setAdpoint(int adpoint){
			this.advancePoint = adpoint;
		}

		public int getAdpoint(){
			return advancePoint;
		}

		public void setDetails(String details){
			this.detail = details;
		}

		public String getDetails(){
			return detail;
		}

		public void setStatus(int status){
			this.status = status;
		}

		public int getStatus(){
			return status;
		}
}
