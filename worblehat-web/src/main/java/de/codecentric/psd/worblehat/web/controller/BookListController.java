package de.codecentric.psd.worblehat.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.codecentric.psd.worblehat.domain.Book;
import de.codecentric.psd.worblehat.domain.BookRepository;

/**
 * Controller class for the book table result.
 * 
 * @author psd
 * 
 */

@Controller
@RequestMapping("/bookList")
public class BookListController {

	@Inject
	private BookRepository bookRepository;

	public BookListController() {
		super();
	}

	public BookListController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(ModelMap modelMap) {
		List<Book> books = bookRepository.findAllBooks();
		modelMap.addAttribute("books", books);
		return "bookList";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(ModelMap modelMap, String emailAddress) {
		List<Book> tmp = bookRepository.findAllBooks();
		List<Book> books = new ArrayList<Book>();

		for (int i = 0; i < tmp.size(); i++) {
			if (tmp.get(i).getCurrentBorrowing().getBorrowerEmailAddress()
					.equals(emailAddress)) {
				books.add(tmp.get(i));
			}
		}
		modelMap.addAttribute("books", books);
		return "bookList";
	}
}
