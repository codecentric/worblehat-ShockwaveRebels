package de.codecentric.psd.worblehat.web.validator;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import de.codecentric.psd.worblehat.web.command.ReturnOneBookFormData;

public class ValidateReturnOneBookTest {

	private static final String VALID_EMAIL = "valid.user@worblehat.local";
	private static final String VALID_ISBN = "1234567962";
	private static final String VALID_TITLE = "validTitle";
	private ValidateReturnOneBook validateReturnOneBook;
	private ReturnOneBookFormData cmd;

	@Before
	public void setUp() {
		validateReturnOneBook = new ValidateReturnOneBook();
		cmd = new ReturnOneBookFormData(VALID_ISBN, VALID_EMAIL);
	}

	@Test
	public void shouldWorkForThisValidator() {
		boolean supports = validateReturnOneBook
				.supports(ReturnOneBookFormData.class);
		assertTrue(supports);
	}

	// @Test
	// public void shouldValidateValidISBN() {
	// cmd.setISBN_TITLE(VALID_ISBN);
	// Errors errors = new BindException(cmd, "returnOneBookFormData");
	// validateReturnOneBook.validate(cmd, errors);
	// Assert.assertEquals(0, errors.getErrorCount());
	// }
	//
	// @Test
	// public void shouldValidateValidTitle() {
	// cmd.setISBN_TITLE(VALID_TITLE);
	// Errors errors = new BindException(cmd, "returnOneBookFormData");
	// validateReturnOneBook.validate(cmd, errors);
	// Assert.assertEquals(0, errors.getErrorCount());
	// }
	//
	// @Test
	// public void shouldFailOnEmptyEmail() {
	// Errors errors = new BindException(cmd, "returnOneBookFormData");
	// cmd.setEmailAddress(" ");
	// validateReturnOneBook.validate(cmd, errors);
	// Assert.assertEquals(1, errors.getErrorCount());
	// String code = errors.getFieldError("emailAddress").getCode();
	// assertEquals("empty", code);
	// }
	//
	// @Test
	// public void shouldFailOnInvalidEmail() {
	// Errors errors = new BindException(cmd, "returnOneBookFormData");
	// cmd.setEmailAddress("aa.de");
	// validateReturnOneBook.validate(cmd, errors);
	// Assert.assertEquals(1, errors.getErrorCount());
	// String code = errors.getFieldError("emailAddress").getCode();
	// assertEquals("notvalid", code);
	// }
	//
	// @Test
	// public void shouldFailOnEmptyISBNTitle() {
	// Errors errors = new BindException(cmd, "returnOneBookFormData");
	// cmd.setISBN_TITLE(" ");
	// validateReturnOneBook.validate(cmd, errors);
	// Assert.assertEquals(1, errors.getErrorCount());
	// String code = errors.getFieldError("emailAddress").getCode();
	// assertEquals("empty", code);
	// }
	//
	// @Test
	// public void shoudlFailInvalidISBN() {
	// cmd.setISBN_TITLE("123");
	// Errors errors = new BindException(cmd, "returnOneBookFormData");
	// validateReturnOneBook.validate(cmd, errors);
	// Assert.assertEquals(1, errors.getErrorCount());
	// }

}
