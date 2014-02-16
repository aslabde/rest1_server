package tk.ebalsa.rest1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import tk.ebalsa.rest1.bo.UserBo;
import tk.ebalsa.rest1.model.MyReturn;
import tk.ebalsa.rest1.model.MyReturn.statusType;
import tk.ebalsa.rest1.model.User;

@Controller

public class UserController {
	
	@Autowired
	UserBo userBo;
	
	//DI via Spring	
	public void setUserBo(UserBo userBo) {
		this.userBo = userBo;
	}


	//Invoked from Android client. New user
	
	@RequestMapping("/register")
	    public @ResponseBody ResponseEntity<User> createUser(@RequestBody User user, UriComponentsBuilder builder) {

	       	String result = userBo.registerUser(user);
		  	
	       	if (result.equals("success")){
	       	 return new ResponseEntity<User>(HttpStatus.CREATED);
	       	}
	       	
	       	return new ResponseEntity<User>(HttpStatus.CONFLICT);
	       
	    }

	//Invoked from Android client. Login user
	  @RequestMapping(value="/login", produces="application/json")
	  public  @ResponseBody ResponseEntity<MyReturn> login(@RequestBody User user, UriComponentsBuilder builder) {
	   
	      MyReturn ret = userBo.loginUser(user);

	      return new ResponseEntity<MyReturn>(ret, HttpStatus.ACCEPTED);
	      
	      
	    } 

}
