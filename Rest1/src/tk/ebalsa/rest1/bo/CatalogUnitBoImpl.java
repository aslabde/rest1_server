package tk.ebalsa.rest1.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.ebalsa.rest1.model.CatalogUnit;
import tk.ebalsa.rest1.model.MyReturn;
import tk.ebalsa.rest1.model.MyReturn.statusType;
import tk.ebalsa.rest1.persistence.CatalogUnitRepository;
import tk.ebalsa.rest1.persistence.UserRepository;

@Service
public class CatalogUnitBoImpl implements CatalogUnitBo {

	@Autowired
	CatalogUnitRepository catalogUnitRepository;
	//DI via Spring
	public void setCatalogUnitRepository(CatalogUnitRepository catalogUnitRepository) {
		this.catalogUnitRepository = catalogUnitRepository;
	}


	@Override
	public MyReturn registerCatalogUnit(CatalogUnit unit) {
		MyReturn ret = new MyReturn();
		ret.setBody(statusType.ERROR);
		
		try{
			this.catalogUnitRepository.save(unit);
			ret.setBody(statusType.OK);
			return ret;
		}
		catch (Exception e){
			return ret;
		}
		
	}
	
	

}
