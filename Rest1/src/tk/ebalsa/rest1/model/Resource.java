package tk.ebalsa.rest1.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Resource {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long resourceId;
	private Date date;
	private String body;
	
	public Resource(){};
	
	public Resource(Date date, String body) {
		this.date=date;
		this.body= body;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}
