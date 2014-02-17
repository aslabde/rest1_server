package tk.ebalsa.rest1.bo;

import tk.ebalsa.rest1.model.MyReturn;
import tk.ebalsa.rest1.model.User;

public interface UserBo {
	
	//Method should return success/error/userExists string. 
	MyReturn registerUser(User user);
	MyReturn loginUser(User user);
	

}
