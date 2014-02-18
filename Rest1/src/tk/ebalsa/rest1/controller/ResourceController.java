package tk.ebalsa.rest1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import tk.ebalsa.rest1.bo.ResourceBo;
import tk.ebalsa.rest1.bo.UserBo;
import tk.ebalsa.rest1.model.MyReturn;
import tk.ebalsa.rest1.model.MyReturn.statusType;
import tk.ebalsa.rest1.model.Resource;
import tk.ebalsa.rest1.model.User;

@Controller
@RequestMapping("/resource")
public class ResourceController {
	
	@Autowired
	ResourceBo resourceBo;
	//DI via Spring	
	public void setUserBo(ResourceBo resourceBo) {
		this.resourceBo = resourceBo;
	}


	
	//Invoked from MKT client. Post new resource
	  @RequestMapping(method=RequestMethod.POST, produces="application/json")
	  public  @ResponseBody ResponseEntity<MyReturn> newResource
	  				(@RequestBody Resource resource, UriComponentsBuilder builder) {
	   
	      MyReturn ret = resourceBo.saveResource(resource);

	      return new ResponseEntity<MyReturn>(ret, HttpStatus.ACCEPTED);
	      
	      
	    } 
	  
	 
	  
	  
	  //Experimental future resources.
	  @RequestMapping(method=RequestMethod.GET, produces="application/json")
	  public  @ResponseBody ResponseEntity<MyReturn> resources() {
		   
	     return null;
	      
	      
	    } 

}
