package swd20.IDDB;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import swd20.IDDB.domain.User;
import swd20.IDDB.domain.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)  
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;
	
	@Test //Test for UserRepositorys save()-method
	public void createNewUser() {
		User user = new User("Tuukka", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3jy95i9oPkeMTpjKU5uo6", "USER", "tuukka@gmail.com");
		repository.save(user);
		assertThat(user.getuId()).isNotNull();
	}

	@Test //Test for UserRepositorys findByUserName()-method
	public void findByUsernameShouldReturnUsername() {
		User user = repository.findByUsername("admin");
		
		assertThat(user.getuId()).isNotNull();
	}
	
	@Test //Test for UserRepositorys delete()-method
	public void deleteUser() {
		User user = new User("Tuukka", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3jy95i9oPkeMTpjKU5uo6", "USER", "tuukka@gmail.com");
		repository.save(user);
		user = repository.findByUsername("Tuukka");
		assertThat(user).isNotNull();
		
		
		repository.deleteById(user.getuId());
		
		
		user = repository.findByUsername("Tuukka");
		assertThat(user).isNull();
		
	}
}
