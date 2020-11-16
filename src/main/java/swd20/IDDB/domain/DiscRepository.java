package swd20.IDDB.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DiscRepository extends CrudRepository <Disc, Long> {
	
	//CrudRepository extends all basic methods like findAll(), save() and delete()
	
	//New find method
	public List<Disc> findByModel(String model);
	
	//New find method
	public List<Disc> findBySpeed(String speed);
	
	//New find method
	public List<Disc> findByGlide(String glide);
	
	//New find method
	public List<Disc> findByTurn(String turn);
	
	//New find method
	public List<Disc> findByFade(String fade);

}
