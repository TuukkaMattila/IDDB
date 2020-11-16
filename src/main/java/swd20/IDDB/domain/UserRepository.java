package swd20.IDDB.domain;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
