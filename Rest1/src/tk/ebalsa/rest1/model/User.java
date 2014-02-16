package tk.ebalsa.rest1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="USERS")
public class User {


	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userId;
	private String name;
	private String pass;
	
	protected User(){};
	
	public User( String name, String pass) {
		this.name = name;
		this.pass = pass;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	
	
}
