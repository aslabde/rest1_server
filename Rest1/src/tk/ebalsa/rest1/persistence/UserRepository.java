package tk.ebalsa.rest1.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tk.ebalsa.rest1.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	List<User> findByName (String name);
	
}
