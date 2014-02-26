package tk.ebalsa.rest1.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import tk.ebalsa.rest1.model.CatalogUnit;
import tk.ebalsa.rest1.model.MyReturn;
import tk.ebalsa.rest1.model.Resource;
import tk.ebalsa.rest1.model.MyReturn.statusType;
import tk.ebalsa.rest1.persistence.ResourceRepository;

@Service
public class ResourceBoImpl implements ResourceBo {
	
	@Autowired
	ResourceRepository resourceRepository;
	//DI via Spring
	public void setResourceRepository(ResourceRepository resourceRepository) {
		this.resourceRepository = resourceRepository;
	}
	
	@Autowired
	CatalogUnitBo cuBo;
	//DI via Spring
	public void setCuBo(CatalogUnitBo cuBo) {
		this.cuBo = cuBo;
	}




	@Override
	public MyReturn saveResource(Resource resource) {
		
		MyReturn ret = new MyReturn();
		ret.setBody(statusType.ERROR);
		
		try{//Saves resource, generates url based on id, and creates catalog entry.
			this.resourceRepository.save(resource);
			String url = new StringBuilder().append("/resources/")
				.append(resource.getResourceId())
				.toString();
			
			CatalogUnit unit = new CatalogUnit(url , resource.getPublishingDate(),
					resource.getEndDate());
			
			this.cuBo.registerCatalogUnit(unit);
			
			ret.setBody(statusType.OK);
			return ret;
		}
		catch (Exception e){
			return ret;
		}
		
	}




	@Override
	public @ResponseBody  Resource getResource(long id) {
		
		return this.resourceRepository.findOne(id);
	}

}
