package tk.ebalsa.rest1.model;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.Type;

@Entity
public class VisualResource extends Resource {
	
	
	@Lob
	private byte[] image;
	private String mime;
	
	public VisualResource (){};
	
	public VisualResource(Date publishingDate, Date endDate, String title, String body, byte[] image
			, String mime) {
		super(publishingDate, endDate, title, body);
		this.image= image;
		this.setMime(mime);
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getMime() {
		return mime;
	}

	public void setMime(String mime) {
		this.mime = mime;
	}
	
	
}
