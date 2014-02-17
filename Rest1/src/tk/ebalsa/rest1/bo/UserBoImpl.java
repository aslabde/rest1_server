package tk.ebalsa.rest1.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.ebalsa.rest1.model.MyReturn;
import tk.ebalsa.rest1.model.MyReturn.statusType;
import tk.ebalsa.rest1.model.User;
import tk.ebalsa.rest1.persistence.UserRepository;

@Service
public class UserBoImpl implements UserBo {
	
	@Autowired
	UserRepository userRepository;
	//DI via Spring
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}



	@Override
	public MyReturn registerUser(User incomingUser) {

		List list=null;
		MyReturn ret = new MyReturn();
		ret.setBody(statusType.ERROR);
		list= userRepository.findByName(incomingUser.getName());
			
		//User not found
		if (!list.isEmpty()){
			ret.setBody(statusType.CONFLICT);
			return ret;
		}
				
		 userRepository.save(incomingUser);
		 ret.setBody(statusType.OK);
		 return ret;
		
	}		

	@Override
	public MyReturn loginUser(User incomingUser) {
		List list=null;
		MyReturn ret = new MyReturn();
		ret.setBody(statusType.ERROR);
		list= userRepository.findByName(incomingUser.getName());
			
		//User not found
		if (list.isEmpty()){
			return ret;
		}
		
		else{
			User registeredUser = (User) list.get(0);
			if (incomingUser.getPass().equals(registeredUser.getPass())){
				ret.setBody(statusType.OK);
				return ret;
			}
			
		}
		
		//Pass error
		return ret;
		
	}
}
