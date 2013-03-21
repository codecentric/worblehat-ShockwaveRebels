package de.codecentric.psd.worblehat.web.validator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

import de.codecentric.psd.worblehat.web.command.DeleteBookFormData;

public class ValidateDeleteBookTest {

	private ValidateDeleteBook validateDeleteBook;
	private DeleteBookFormData cmd;
	private static final String INVALID_ISBN = "978-3492285100-22";
	private static final String VALID_ISBN = "90-70002-34-5";
	private static final String VALID_TITLE = "title";
	private static final String VALID_EDITION = "2";

	@Before
	public void setup() {
		validateDeleteBook = new ValidateDeleteBook();
		cmd = new DeleteBookFormData();
		cmd.setEdition("2");
		cmd.setIsbn("90-70002-34-5");
		cmd.setTitle("title");
	}

	@Test
	public void shouldSupport() {
		boolean supports = validateDeleteBook
				.supports(DeleteBookFormData.class);
		assertTrue(supports);
	}

	@Test
	public void shouldFailForEmptyISBN() {
		cmd.setIsbn("         ");
		validateForOneError();
	}

	@Test
	public void shouldFailForNullISBN() {
		cmd.setIsbn(null);
		validateForOneError();
	}

	@Test
	public void shouldValidateISBN10() {
		String isbn13 = "90-70002-34-5";
		cmd.setIsbn(isbn13);
		Errors errors = new BindException(cmd, "cmdDeleteBookData");
		validateDeleteBook.validate(cmd, errors);
		Object value = errors.getFieldValue("isbn");
		assertThat(errors.getErrorCount(), is(0));
		Assert.assertEquals(isbn13, value);
	}

	@Test
	public void shouldFailForInvalidISBN() {
		String isbn13 = INVALID_ISBN;
		cmd.setIsbn(isbn13);
		validateForOneError();
	}

	@Test
	public void shouldFailForEmptyTitle() {
		Errors errors = new BindException(cmd, "cmdDeleteBookData");
		cmd.setTitle("");
		validateDeleteBook.validate((DeleteBookFormData) cmd, errors);
		assertThat(errors.getErrorCount(), is(1));
	}

	@Test
	public void shouldFailForWhitespaceTitle() {
		Errors errors = new BindException(cmd, "cmdDeleteBookData");
		cmd.setTitle("    ");
		validateDeleteBook.validate((DeleteBookFormData) cmd, errors);
		assertThat(errors.getErrorCount(), is(1));
	}

	@Test
	public void shouldFailForNullTitle() {
		Errors errors = new BindException(cmd, "cmdDeleteBookData");
		cmd.setTitle(null);
		validateDeleteBook.validate((DeleteBookFormData) cmd, errors);
		assertThat(errors.getErrorCount(), is(1));
	}

	@Test
	public void shouldValidateTitle() {
		String title = "Title";
		cmd.setTitle(title);
		Errors errors = new BindException(cmd, "cmdDeleteBookData");
		validateDeleteBook.validate((DeleteBookFormData) cmd, errors);
		assertThat(errors.getErrorCount(), is(0));
		String errorFieldValue = errors.getFieldValue("title").toString();
		;
		assertThat(errorFieldValue, is(title));
	}

	@Test
	public void shouldFailForEmptyEdition() {
		Errors errors = new BindException(cmd, "cmdDeleteBookData");
		cmd.setEdition(null);
		validateDeleteBook.validate((DeleteBookFormData) cmd, errors);
		Assert.assertEquals(1, errors.getErrorCount());
	}

	@Test
	public void shouldFailForWhitespaceEdition() {
		Errors errors = new BindException(cmd, "cmdDeleteBookData");
		cmd.setEdition("    ");
		validateDeleteBook.validate((DeleteBookFormData) cmd, errors);
		Assert.assertEquals(1, errors.getErrorCount());
	}

	@Test
	public void shouldFailForNullEdition() {
		Errors errors = new BindException(cmd, "cmdDeleteBookData");
		cmd.setEdition(null);
		validateDeleteBook.validate((DeleteBookFormData) cmd, errors);
		Assert.assertEquals(1, errors.getErrorCount());
	}

	@Test
	public void shouldValidateEdition() {
		String edition = "2";
		cmd.setEdition(edition);
		Errors errors = new BindException(cmd, "cmdDeleteBookData");
		validateDeleteBook.validate((DeleteBookFormData) cmd, errors);
		Object value = errors.getFieldValue("edition");
		Assert.assertEquals(0, errors.getErrorCount());
		Assert.assertEquals(edition, value);
	}

	@Test
	public void shouldFailOnCharacterInEdition() {
		String edition = "2a";
		cmd.setEdition(edition);
		Errors errors = new BindException(cmd, "cmdDeleteBookData");
		validateDeleteBook.validate((DeleteBookFormData) cmd, errors);
		Assert.assertEquals(1, errors.getErrorCount());
	}

	private void validateForOneError() {
		Errors errors = new BindException(cmd, "cmdBookdData");
		validateDeleteBook.validate(cmd, errors);
		assertThat(errors.getErrorCount(), is(1));
	}

}
