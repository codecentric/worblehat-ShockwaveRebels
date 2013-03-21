package de.codecentric.psd.worblehat.web.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import de.codecentric.psd.worblehat.domain.BookRepository;
import de.codecentric.psd.worblehat.web.command.MailFormData;

public class BookListByMailControllerTest {

	@Mock
	private HttpServletRequest mockRequest;

	@Mock
	private ModelMap mockModelMap;

	@Mock
	private BindingResult mockBindingResult;

	@Mock
	private BookRepository mockRepository;

	@InjectMocks
	BookListByMailController bookListByMailController;

	@Before
	public void setUp() {
		bookListByMailController = new BookListByMailController();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldSetup() {
		ModelMap modelMap = new ModelMap();
		bookListByMailController.setupForm(modelMap);
		Object object = modelMap.get("mailFormData");
		assertThat(object, not(nullValue()));
	}

	@Test
	public void shouldGetBooksByMail() {
		MailFormData cmd = new MailFormData();
		cmd.setEmail("mail@test.de");
		when(mockBindingResult.hasErrors()).thenReturn(false);
		String path = bookListByMailController.processSubmit(mockRequest,
				mockModelMap, cmd, mockBindingResult);
		verify(mockModelMap).put("mailFormData", cmd);
		assertThat(path, is("/myBooks"));
	}

}
