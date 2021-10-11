package s2021.bookstoreFinal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import s2021.bookstoreFinal.web.BookController;

@SpringBootTest
class BookstoreFinalApplicationTests {

	@Autowired 
	BookController bookController;

	@Test
	void contextLoads() {
		//JUnit4: assertThat(bookController).isNot(null);
		//Junit5:
		assertNotNull(bookController);
		}

}
