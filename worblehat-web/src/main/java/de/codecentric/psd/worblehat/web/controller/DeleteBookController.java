package de.codecentric.psd.worblehat.web.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.codecentric.psd.worblehat.domain.Book;
import de.codecentric.psd.worblehat.domain.BookRepository;
import de.codecentric.psd.worblehat.web.command.DeleteBookFormData;
import de.codecentric.psd.worblehat.web.validator.ValidateDeleteBook;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/deleteBook")
public class DeleteBookController {

	private static final Logger LOG = LoggerFactory
			.getLogger(DeleteBookController.class);

	private final ValidateDeleteBook validateDeleteBook = new ValidateDeleteBook();

	@Inject
	private BookRepository bookRepository;

	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(ModelMap modelMap) {
		modelMap.put("deleteBookFormData", new DeleteBookFormData());
		List<Book> books = bookRepository.findAllBooks();
		modelMap.addAttribute("books", books);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(HttpServletRequest request, ModelMap modelMap,
			@ModelAttribute("deleteBookFormData") DeleteBookFormData cmd,
			BindingResult result) {

		modelMap.put("deleteBookFormData", cmd);

		bookRepository.deleteBookByTitelAndIsbnAndEdition(cmd.getTitle(),
				cmd.getIsbn(), cmd.getEdition());

		validateDeleteBook.validate(cmd, result);

		if (result.hasErrors()) {
			return "/deleteBook";
		} else {
			LOG.debug("Book instance was deleted: " + cmd.getIsbn());

			List<Book> books = bookRepository.findAllBooks();
			modelMap.addAttribute("books", books);

			return "/deleteBook";
		}
	}

}
