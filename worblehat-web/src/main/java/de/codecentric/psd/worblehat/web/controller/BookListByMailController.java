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
		return "bookList";
	}
}
