package swd20.IDDB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import swd20.IDDB.domain.Disc;
import swd20.IDDB.domain.DiscRepository;
import swd20.IDDB.domain.Manufacturer;
import swd20.IDDB.domain.ManufacturerRepository;
import swd20.IDDB.domain.User;
import swd20.IDDB.domain.UserRepository;




@SpringBootApplication
public class IddbApplication {
	
	private static final Logger log = LoggerFactory.getLogger(IddbApplication.class);  // New logger attribute

	//Automatically generated main method
	public static void main(String[] args) {
		SpringApplication.run(IddbApplication.class, args);
	}
	
	@Bean
	public static CommandLineRunner demodata(DiscRepository discRepository, ManufacturerRepository manufacturerRepository, UserRepository userRepository) {
		return (args) -> {
			
		
			
			Manufacturer manufacturer1 = new Manufacturer("Discraft");
			Manufacturer manufacturer2 = new Manufacturer("Innova");
			Manufacturer manufacturer3 = new Manufacturer("Disc Mania");
			Manufacturer manufacturer4 = new Manufacturer("Prodiscus");
			Manufacturer manufacturer5 = new Manufacturer("Dynamic Discs");
			manufacturerRepository.save(manufacturer1);
			manufacturerRepository.save(manufacturer2);
			manufacturerRepository.save(manufacturer3);
			manufacturerRepository.save(manufacturer4);
			manufacturerRepository.save(manufacturer5);
			
			Disc disc1 = new Disc("Buzzz", 5, 4, -1, 1, manufacturer1);
			Disc disc2 = new Disc("Rhyno", 2, 1, 0, 3, manufacturer2);
			Disc disc3 = new Disc("Underworld", 7, 6, -3, 1, manufacturer3);
			discRepository.save(disc1);
			discRepository.save(disc2);
			discRepository.save(disc3);
			
			//Creating test user
			User user1 =  new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "user@gmail.com");
			userRepository.save(user1);
			
			log.info("Fetch all discs");
			for (Disc disc : discRepository.findAll()) {
				log.info(disc.toString());
			}
			
			log.info("Fetch all manufacturers");
			for (Manufacturer manufacturer : manufacturerRepository.findAll()) {
				log.info(manufacturer.toString());
			}
		
			
		};
	}

	
	
}
