package de.codecentric.psd.worblehat.web.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import de.codecentric.psd.worblehat.domain.BookService;
import de.codecentric.psd.worblehat.web.command.ReturnOneBookFormData;

public class ReturnOneBookControllerTest {

	@InjectMocks
	private ReturnOneBookController returnOneBookController;

	private ModelMap modelMap;

	@Mock
	private BookService bookService;

	@Mock
	private BindingResult mockBindingResult;

	@Before
	public void setUp() {
		returnOneBookController = new ReturnOneBookController();
		MockitoAnnotations.initMocks(this);
		modelMap = new ModelMap();
	}

	@Test
	public void shouldPrepareView() {
		returnOneBookController.prepareView(modelMap);
		ReturnOneBookFormData object = (ReturnOneBookFormData) modelMap
				.get("returnOneBookFormData");
		assertThat(object, not(nullValue()));
	}

	@Test
	public void shouldReturnOneBookByIsbn() {
		when(mockBindingResult.hasErrors()).thenReturn(false);
		ReturnOneBookFormData formData = new ReturnOneBookFormData();
		formData.setEmail("email@email.de");
		formData.setISBNNumber("1234567962");
		String page = returnOneBookController.returnOneBook(modelMap, formData,
				mockBindingResult);
		assertThat(page, is("/home"));
		verify(mockBindingResult).hasErrors();
		verify(bookService).returnOneBookByBorrower("1234567962",
				"email@email.de");
	}

	@Test
	public void shouldReturnOneBookByTitle() {
		when(mockBindingResult.hasErrors()).thenReturn(false);
		ReturnOneBookFormData formData = new ReturnOneBookFormData();
		formData.setEmail("email@email.de");
		formData.setISBNNumber("title");
		String page = returnOneBookController.returnOneBook(modelMap, formData,
				mockBindingResult);
		assertThat(page, is("/home"));
		verify(mockBindingResult).hasErrors();
		verify(bookService).returnOneBookByBorrower("title", "email@email.de");
	}

	@Test
	public void shouldNotReturnBook() {
		when(mockBindingResult.hasErrors()).thenReturn(true);
		String page = returnOneBookController.returnOneBook(modelMap,
				new ReturnOneBookFormData(), mockBindingResult);
		// assertThat(page, is("/returnAllBooks"));
		// verify(mockBindingResult).hasErrors();
	}

}
