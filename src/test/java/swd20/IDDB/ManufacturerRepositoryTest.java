package swd20.IDDB;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;



import swd20.IDDB.domain.Manufacturer;
import swd20.IDDB.domain.ManufacturerRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ManufacturerRepositoryTest {

	@Autowired
	private ManufacturerRepository repository;
	
	@Test //Test for DiscRepositorys findByModel()-method
	public void findByNameShouldReturnManufacturer() {
		List<Manufacturer> manufacturers = repository.findByName("Innova");
		
		assertThat(manufacturers).hasSize(1);
		assertThat(manufacturers.get(0).getName()).isEqualTo("Innova");
		
	}
	
	@Test //Test for ManufacturerRepositorys save()-method
	public void createNewManufacturer() {
		Manufacturer manufacturer = new Manufacturer("Gateway");
		repository.save(manufacturer);
		assertThat(manufacturer.getManufacturerId()).isNotNull();
	}
	
	@Test //Test for ManufacturerRepositorys delete()-method
	public void deleteManufacturer() {
		
		Manufacturer manufacturer = new Manufacturer("Gateway");
		repository.save(manufacturer);
		
		List<Manufacturer> manufacturers = repository.findByName("Gateway");
		assertThat(manufacturers).hasSize(1);
		
		repository.deleteById(manufacturers.get(0).getManufacturerId());
		
		manufacturers = repository.findByName("RhynoX");
		assertThat(manufacturers).hasSize(0);
		
	}
}
