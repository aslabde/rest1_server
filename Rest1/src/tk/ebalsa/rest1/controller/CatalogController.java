package tk.ebalsa.rest1.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import tk.ebalsa.rest1.bo.CatalogUnitBo;
import tk.ebalsa.rest1.model.MyReturn;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
	
	@Autowired
	CatalogUnitBo catalogUnitBo;
	//DI via Spring	
	public void setUserBo(CatalogUnitBo catalogUnitBo) {
		this.catalogUnitBo = catalogUnitBo;
	}


	
	//Invoked from Android client. Catalog entry pont
	  @RequestMapping(method=RequestMethod.GET, produces="application/json")
	  public  @ResponseBody ResponseEntity<MyReturn> catalog
	  				(@RequestBody Date date, UriComponentsBuilder builder) {
	   
	      return null;
	      
	      //TODO- return units after given date
	      
	      
	    } 
	  
	 
  
	

}
