package tk.ebalsa.rest1.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;





import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
import tk.ebalsa.rest1.model.VisualResource;

@Controller
@RequestMapping("/resources")
public class ResourceController {
	
	@Autowired
	ResourceBo resourceBo;
	//DI via Spring	
	public void setUserBo(ResourceBo resourceBo) {
		this.resourceBo = resourceBo;
	}


	
	
	//Invoked from MKT client. Post new resource
   @RequestMapping(method=RequestMethod.POST, produces="application/json")
	  public  @ResponseBody ResponseEntity<MyReturn> postResource
	  				(@RequestBody VisualResource resource, UriComponentsBuilder builder) {
   
	      MyReturn ret = resourceBo.saveResource(resource);

	      return new ResponseEntity<MyReturn>(ret, HttpStatus.ACCEPTED);
	      	      

   } 
	 
	  
	  
	  //Invoked from Android. Gets a resource with given id
	  @RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
	  public  @ResponseBody VisualResource getResource(@PathVariable long id) {
		   
		
		  return (VisualResource)this.resourceBo.getResource(id);
	      
	      
	    } 
	  
	//TEST: Marshall image
	  @RequestMapping(value="/image", method=RequestMethod.GET, produces="image/jpg")
	  public  @ResponseBody byte[] getImage() {
		   
		  VisualResource vr =(VisualResource)this.resourceBo.getResource(83);
		  byte[] byteImage = vr.getImage();
		  
		  
		  return byteImage;
	      
	      
	    } 
	  
	 
}
