package tk.ebalsa.rest1.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tk.ebalsa.rest1.model.Resource;

@Controller
public class NewsController {

	@RequestMapping("/news")
	public @ResponseBody Resource news (){
		
		return new Resource(new Date(), "Este es el cuerpo de.....la noticia");
		
	}
	
}
