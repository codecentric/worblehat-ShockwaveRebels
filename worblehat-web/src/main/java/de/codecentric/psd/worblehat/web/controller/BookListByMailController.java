package de.codecentric.psd.worblehat.web.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.codecentric.psd.worblehat.domain.Book;
import de.codecentric.psd.worblehat.domain.BookRepository;
import de.codecentric.psd.worblehat.web.command.MailFormData;

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

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(HttpServletRequest request, ModelMap modelMap,
			@ModelAttribute("mailFormData") MailFormData cmd,
			BindingResult result) {
		modelMap.put("mailFormData", cmd);
		// validateAddBook.validate(cmd, result);

		List<Book> books = bookRepository.findAllBorrowBooksByBorrower(cmd
				.getEmail());

		for (int i = 0; i < books.size(); i++) {
			for (int j = 0; j < books.size(); j++) {
				if (books.get(i).getCurrentBorrowing().getBorrowDate()
						.getTime() < books.get(j).getCurrentBorrowing()
						.getBorrowDate().getTime()) {
					Book tempBook = books.get(i);
					books.set(i, books.get(j));
					books.set(j, tempBook);
				}
			}
		}

		modelMap.addAttribute("books", books);

		return "/myBooks";
	}

	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(ModelMap modelMap) {
		modelMap.put("mailFormData", new MailFormData());

	}
}
