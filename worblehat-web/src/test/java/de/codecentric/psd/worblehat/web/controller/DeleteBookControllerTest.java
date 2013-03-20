package de.codecentric.psd.worblehat.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import de.codecentric.psd.worblehat.domain.BookRepository;

public class DeleteBookControllerTest {

	// @InjectMocks
	// private DeleteBookController deleteBookController;

	@Mock
	private ModelMap mockModelMap;

	@Mock
	private BindingResult mockBindingResult;

	@Mock
	private BookRepository bookRepository;

	@Before
	public void setUp() {
		// deleteBookController = new DeleteBookController();
		// MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldShowAllBooks() {
		// String deleteBook = deleteBookController.setupForm(mockModelMap);
		//
		// verify(mockModelMap).addAttribute(anyString(), any());
		// verify(bookRepository).findAllBooks();
		// assertThat(deleteBook, is("deleteBook"));
	}

	public void shouldDeleteBook() {
		// ModelMap modelMap = new ModelMap();
		// deleteBookController.setupForm(modelMap);
		// Object object = modelMap.get("deleteBookDataFormData");
		// assertThat(object, not(nullValue()));
	}

}
