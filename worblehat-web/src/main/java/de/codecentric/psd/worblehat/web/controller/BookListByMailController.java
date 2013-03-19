package de.codecentric.psd.worblehat.web.controller;

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
@RequestMapping("/myBooks")
public class BookListByMailController {

	@Inject
	private BookRepository bookRepository;

	public BookListByMailController() {
		super();
	}

	public BookListByMailController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// @RequestMapping(method = RequestMethod.POST)
	// public String processSubmit(HttpServletRequest request, ModelMap
	// modelMap,
	// @ModelAttribute("bookDataFormData") BookDataFormData cmd,
	// BindingResult result) {
	//
	// modelMap.put("bookDataFormData", cmd);
	// validateAddBook.validate(cmd, result);
	//
	// if (result.hasErrors()) {
	// return "/insertBooks";
	// } else {
	//
	// bookFactory.createBook(cmd.getTitle(), cmd.getAuthor(),
	// cmd.getEdition(), cmd.getIsbn(),
	// Integer.parseInt(cmd.getYear()), cmd.getDescription());
	// LOG.debug("new book instance is created: " + cmd.getIsbn());
	//
	// List<Book> books = bookRepository.findAllBooks();
	// modelMap.addAttribute("books", books);
	//
	// return "/bookList";
	// }
	// }

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(ModelMap modelMap) {
		String test = "user2@dings.com";
		List<Book> books = bookRepository.findAllBorrowBooksByBorrower(test);

		for (int i = 0; i < books.size(); i++) {
			for (int j = 0; j < books.size(); j++) {
				if (books.get(i).getCurrentBorrowing().getBorrowDate()
						.getTime() > books.get(j).getCurrentBorrowing()
						.getBorrowDate().getTime()) {
					Book tempBook = books.get(i);
					books.set(i, books.get(j));
					books.set(j, tempBook);
				}
			}
		}

		modelMap.addAttribute("books", books);
		return "myBooks";
	}
}
