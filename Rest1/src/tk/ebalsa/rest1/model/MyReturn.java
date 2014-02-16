package tk.ebalsa.rest1.model;

public class MyReturn {

	public MyReturn(){};
	
	public enum statusType{
		OK, ERROR, CONFLICT
	}
	
	private statusType body;

	public statusType getBody() {
		return body;
	}

	public void setBody(statusType body) {
		this.body = body;
	}
	
	
	
}
