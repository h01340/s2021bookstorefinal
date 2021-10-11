package s2021.bookstoreFinal.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import s2021.bookstoreFinal.domain.Book;
import s2021.bookstoreFinal.domain.BookRepository;
import s2021.bookstoreFinal.domain.CategoryRepository;


@RestController
public class RestBookController {

	@Autowired 
	BookRepository bookRepository; 

	@Autowired 
	CategoryRepository categoryRepository; 
	
	@GetMapping(value="/kirjat")
	public List<Book> bookListRest() {
		return (List<Book>) bookRepository.findAll();
	}

	

	
}
