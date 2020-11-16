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
			Manufacturer manufacturer6 = new Manufacturer("Prodigy");
			manufacturerRepository.save(manufacturer1);
			manufacturerRepository.save(manufacturer2);
			manufacturerRepository.save(manufacturer3);
			manufacturerRepository.save(manufacturer4);
			manufacturerRepository.save(manufacturer5);
			manufacturerRepository.save(manufacturer6);
			
			Disc disc1 = new Disc("Buzzz", 5, 4, -1, 1, manufacturer1);
			Disc disc2 = new Disc("Rhyno", 2, 1, 0, 3, manufacturer2);
			Disc disc3 = new Disc("Underworld", 7, 6, -3, 1, manufacturer3);
			Disc disc4 = new Disc("TeeBird", 7, 5, 0, 2, manufacturer2);
			Disc disc5 = new Disc("Wraith", 11, 5, -1, 3, manufacturer2);
			Disc disc6 = new Disc("Sidewinder", 9, 5, -3, 1, manufacturer2);
			Disc disc7 = new Disc("Thunderbird", 9, 5, 0, 2, manufacturer2);
			Disc disc8 = new Disc("Jokeri", 4, 3, 0, 2, manufacturer4);
			Disc disc9 = new Disc("AviarX3", 3, 2, 0, 3, manufacturer2);
			Disc disc10 = new Disc("Magnet", 2, 3, -1, 1, manufacturer1);
			Disc disc11 = new Disc("Mentor", 11, 5, -2, 2, manufacturer3);
			Disc disc12 = new Disc("Destroyer", 12, 5, -1, 3, manufacturer2);
			Disc disc13 = new Disc("Comet", 4, 5, -2, 1, manufacturer1);
			Disc disc14 = new Disc("M5", 5, 5, -3, 1, manufacturer6);
			Disc disc15 = new Disc("Northman", 10, 5, -1, 2, manufacturer1);
			discRepository.save(disc1);
			discRepository.save(disc2);
			discRepository.save(disc3);
			discRepository.save(disc4);
			discRepository.save(disc5);
			discRepository.save(disc6);
			discRepository.save(disc7);
			discRepository.save(disc8);
			discRepository.save(disc9);
			discRepository.save(disc10);
			discRepository.save(disc11);
			discRepository.save(disc12);
			discRepository.save(disc13);
			discRepository.save(disc14);
			discRepository.save(disc15);
			
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
