package tk.ebalsa.rest1.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tk.ebalsa.rest1.model.Resource;


@Repository
public interface ResourceRepository extends CrudRepository<Resource, Long>{
	
	List<Resource> findByTitle (String title);
	
}
