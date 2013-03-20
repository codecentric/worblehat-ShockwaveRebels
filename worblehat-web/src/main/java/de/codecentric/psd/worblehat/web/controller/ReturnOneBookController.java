package de.codecentric.psd.worblehat.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.codecentric.psd.worblehat.domain.BookService;
import de.codecentric.psd.worblehat.web.command.ReturnOneBookFormData;
import de.codecentric.psd.worblehat.web.validator.ValidateReturnOneBook;

/**
 * Controller class for the
 * 
 * @author psd
 * 
 */
@Controller
@RequestMapping("/returnOneBook")
public class ReturnOneBookController {

	ValidateReturnOneBook validateReturnOneBook = new ValidateReturnOneBook();

	@Inject
	private BookService bookService;

	@RequestMapping(method = RequestMethod.GET)
	public void prepareView(ModelMap modelMap) {
		modelMap.put("returnOneBookFormData", new ReturnOneBookFormData());
	}

	@RequestMapping(method = RequestMethod.POST)
	public String returnOneBook(ModelMap modelMap,
			@ModelAttribute("returnOneBookFormData") ReturnOneBookFormData cmd,
			BindingResult result) {

		// modelMap.put("returnOneBookFormData", cmd);
		boolean isISBN = validateReturnOneBook.checkIfArgumentIsIsbnOrTitle(cmd
				.getIsbn_title());

		validateReturnOneBook.validate(cmd, result);
		if (result.hasErrors()) {
			return "/returnOneBook";
		} else {
			if (isISBN) {
				bookService.returnOneBookByBorrowerAndIsbn(cmd.getIsbn_title(),
						cmd.getEmail());
			} else {
				bookService.returnOneBookByBorrowerAndTitle(
						cmd.getIsbn_title(), cmd.getEmail());
			}
			return "/home";
		}
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
}
