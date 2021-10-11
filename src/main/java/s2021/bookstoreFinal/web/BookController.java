package s2021.bookstoreFinal.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import s2021.bookstoreFinal.domain.Book;
import s2021.bookstoreFinal.domain.BookRepository;
import s2021.bookstoreFinal.domain.CategoryRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CategoryRepository categoryRepository;


	@GetMapping("index")
	public String index() {
		return "index";
	}

	@GetMapping("booklist")
	public String booklist(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
	}

	@GetMapping("addBook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "addBook";
	}

	@PostMapping("save")
	public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			if (bindingResult.getFieldError().getField().equalsIgnoreCase("price")) {
				bindingResult.rejectValue("price", "err.price", "Check price format");
			} else {
				System.out.println("Jokin muu vika");
			}
			return "redirect:addBook";

		}
		bookRepository.save(book);
		return "redirect:booklist";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/edit/{id}")
	public String updateBook(@PathVariable("id") Long id, Model model) {
		Book book = bookRepository.findById(id).get();
		model.addAttribute("book", book);
		model.addAttribute("categories", categoryRepository.findAll());
		return "editBook";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		bookRepository.deleteById(id);
		return "redirect:../booklist";
	}

}
