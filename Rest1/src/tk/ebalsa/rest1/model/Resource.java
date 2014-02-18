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
	private Date pubDate;
	private Date endDate;
	private String title;
	private String body;
	
	public Resource(){};
	

	public Resource(Date publishingDate, Date endDate, String title, String body) {
		this.pubDate = publishingDate;
		this.endDate = endDate;
		this.title = title;
		this.body = body;
	}


	public long getResourceId() {
		return resourceId;
	}


	public void setResourceId(long resourceId) {
		this.resourceId = resourceId;
	}


	public Date getPublishingDate() {
		return pubDate;
	}


	public void setPublishingDate(Date publishingDate) {
		this.pubDate = publishingDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public Date getPubDate() {
		return pubDate;
	}


	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	
	
	
}
