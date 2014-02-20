package tk.ebalsa.rest1.bo;

import java.util.List;

import tk.ebalsa.rest1.model.CatalogUnit;
import tk.ebalsa.rest1.model.MyReturn;
import tk.ebalsa.rest1.model.User;

public interface CatalogUnitBo {
	

	MyReturn registerCatalogUnit(CatalogUnit unit);
	List<CatalogUnit> catalog();
	
	

}
