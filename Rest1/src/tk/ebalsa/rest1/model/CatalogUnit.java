package tk.ebalsa.rest1.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CatalogUnit {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long unitId;
	private String link2resource;
	private Date pubDate;
	private Date endDate;
	
	public CatalogUnit(){};
	
	public CatalogUnit( String link2resource, Date pubDate,	Date endDate) {
		this.link2resource = link2resource;
		this.pubDate = pubDate;
		this.endDate = endDate;
	}

	public long getUnitId() {
		return unitId;
	}

	public void setUnitId(long unitId) {
		this.unitId = unitId;
	}

	public String getLink2resource() {
		return link2resource;
	}

	public void setLink2resource(String link2resource) {
		this.link2resource = link2resource;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
	
	
}
