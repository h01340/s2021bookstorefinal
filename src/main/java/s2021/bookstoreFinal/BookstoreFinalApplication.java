package s2021.bookstoreFinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreFinalApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner bookstore(BookRepository bookRepository, 
//			CategoryRepository categoryRepository, UserRepository userRepository) {
//		return (args) -> {
//
//			categoryRepository.save(new Category("Dekkari"));
//			categoryRepository.save(new Category("Novelli"));
//			categoryRepository.save(new Category("Dokumentti"));
//
//			bookRepository.save(new Book("Kasvoton kuolema", "Hennig Mankell", 1991, 12.0,
//					categoryRepository.findByName("Dekkari").get(0)));
//			bookRepository.save(new Book("Riian verikoirat", "Hennig Mankell", 1992, 13.0,
//					categoryRepository.findByName("Dekkari").get(0)));
//			bookRepository.save(new Book("Koira", "Nina Maki-Kihnia", 2017, 45,
//					categoryRepository.findByName("Dokumentti").get(0)));
//
//			//user, user & admin, admin
//			userRepository.save(new User ("user", "$2a$10$gYhRVPCVkxonw4C6KbzBHOGfN3tR0cq8S51Ojct3iKEtP7fBCeZke", "USER"));
//			userRepository.save(new User ("admin", "$2a$04$g6UsslKArS7jZrevnIpQIe5udQCOSriLtEz19jDRFUVPM74FT2rvG", "ADMIN"));
//			
//		};
//	}

}
