package swd20.IDDB.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ManufacturerRepository extends CrudRepository <Manufacturer, Long> {
	
	//CrudRepository extends all basic methods like findAll(), save() and delete()
	
	//New find method
	public List<Manufacturer> findByName(String name);

}
