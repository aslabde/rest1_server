package tk.ebalsa.rest1.persistence;


import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tk.ebalsa.rest1.model.CatalogUnit;


@Repository
public interface CatalogUnitRepository extends CrudRepository<CatalogUnit, Long>{
	
		
	List<CatalogUnit> findByPubDate (Date pubDate);
	
	
}
