package de.codecentric.psd.worblehat.web.controller;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import de.codecentric.psd.worblehat.domain.BookRepository;

public class DeleteBookControllerTest {

	@InjectMocks
	private DeleteBookController deleteBookController;

	@Mock
	private ModelMap mockModelMap;

	@Mock
	private BindingResult mockBindingResult;

	@Mock
	private BookRepository bookRepository;

	@Before
	public void setUp() {
		deleteBookController = new DeleteBookController();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldShowAllBooks() {
		deleteBookController.setupForm(mockModelMap);
		assertThat(mockModelMap, not(nullValue()));
	}

	public void shouldDeleteBook() {
		ModelMap modelMap = new ModelMap();
		deleteBookController.setupForm(modelMap);
		Object object = modelMap.get("deleteBookDataFormData");
		assertThat(object, not(nullValue()));
	}

}
