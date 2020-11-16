package swd20.IDDB;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


import swd20.IDDB.web.DiscController;
import swd20.IDDB.web.ManufacturerController;

@RunWith(SpringRunner.class) //JUNIT 4
@ExtendWith(SpringExtension.class) //Junit 5
@SpringBootTest
class IddbApplicationTests {
	
	@Autowired
	private DiscController discController;
	@Autowired
	private ManufacturerController manufacturerController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(discController).isNotNull();
		assertThat(manufacturerController).isNotNull();
		
	}

}
