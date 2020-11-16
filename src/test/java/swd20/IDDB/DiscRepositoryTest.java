package swd20.IDDB;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;


import swd20.IDDB.domain.Disc;
import swd20.IDDB.domain.DiscRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class DiscRepositoryTest {

	@Autowired
	private DiscRepository repository;
	
	@Test //Test for DiscRepositorys findByModel()-method
	public void findByModelShouldReturnDisc() {
		List<Disc> discs = repository.findByModel("Buzzz");
		
		assertThat(discs).hasSize(1);
		assertThat(discs.get(0).getSpeed()).isEqualTo(5);
		
	}
	
	@Test //Test for DiscRepositorys save()-method
	public void createNewDisc() {
		Disc disc = new Disc("RhynoX", 2, 1, 0, 4, null);
		repository.save(disc);
		assertThat(disc.getModelId()).isNotNull();
	}
	
	@Test //Test for DiscRepositorys delete()-method
	public void deleteDisc() {
		
		Disc disc = new Disc("RhynoX", 2, 1, 0, 4, null);
		repository.save(disc);
		
		List<Disc> discs = repository.findByModel("RhynoX");
		assertThat(discs).hasSize(1);
		
		repository.deleteById(discs.get(0).getModelId());
		
		discs = repository.findByModel("RhynoX");
		assertThat(discs).hasSize(0);
		
	}
}
