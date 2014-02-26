package tk.ebalsa.rest1.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import tk.ebalsa.rest1.bo.CatalogUnitBo;
import tk.ebalsa.rest1.model.CatalogUnit;
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


	  
	//Provisional Catalog entry point
	  @RequestMapping(method=RequestMethod.GET, produces="application/json")
	  public  @ResponseBody List<CatalogUnit> catalog
	  				() {
	   
	       return this.catalogUnitBo.catalog();
	      
	  	      
	      
	    }
  
	

}
