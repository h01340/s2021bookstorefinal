package s2021.bookstoreFinal;

import java.util.List;

import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import s2021.bookstoreFinal.domain.Book;
import s2021.bookstoreFinal.domain.BookRepository;
import s2021.bookstoreFinal.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace = NONE)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class BookRepositoryTest {

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CategoryRepository categoryRepository;

	@Test
	public void findByAuthorShouldReturnAuthor() {
		List<Book> books = bookRepository.findByAuthor("Hennig Mankell");
		System.out.println("TESTING: FindByAuthor: " + books);
		System.out.println("TESTING: FindAll:" +  bookRepository.findAll());
		
		Assertions.assertThat(books.get(0).getAuthor()).isEqualTo("Hennig Mankell");
	}

	@Test
	public void findByAuthorShouldReturnSize() {
		List<Book> books = bookRepository.findByAuthor("Hennig Mankell");
		Assertions.assertThat(books).hasSize(2);

	}

	@Test
	public void insertNewBook() {
		Book book = new Book("KauhuKakara", "SuperNanny", 2020);
		bookRepository.save(book);
		List<Book> books = bookRepository.findByAuthor("SuperNanny");
		Assertions.assertThat(books.get(0).getAuthor()).isEqualTo("SuperNanny");

	}


	@Test
	public void findByAuthorShouldReturnSize4() {
		List<Book> books = bookRepository.findByAuthor("Hennig Mankell");
		System.out.println("TESTING - books: " + books);
		Assertions.assertThat(books).hasSize(4);

	}

}
