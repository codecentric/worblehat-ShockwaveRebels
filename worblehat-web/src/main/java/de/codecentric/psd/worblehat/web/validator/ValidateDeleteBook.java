package de.codecentric.psd.worblehat.web.validator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.ISBNValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import de.codecentric.psd.worblehat.web.command.DeleteBookFormData;

/**
 * Validation for adding a book
 * 
 * @author mahmut.can
 * 
 */
public class ValidateDeleteBook implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return DeleteBookFormData.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if (!supports(target.getClass()))
			throw new IllegalArgumentException("Validation of classs '"
					+ target.getClass() + "' is not supported");

		DeleteBookFormData cmd = (DeleteBookFormData) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "empty");

		checkThatIsbnIsFilledAndValid(errors, cmd);
		checkThatEditionisFilledAndValid(errors, cmd);

	}

	private void checkThatEditionisFilledAndValid(Errors errors,
			DeleteBookFormData cmd) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "edition", "empty");
		if (!errors.hasFieldErrors("edition")) {
			if (!StringUtils.isNumeric(cmd.getEdition())) {
				errors.rejectValue("edition", "notvalid");
			}
		}
	}

	private void checkThatIsbnIsFilledAndValid(Errors errors,
			DeleteBookFormData cmd) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn", "empty");
		if (!errors.hasFieldErrors("isbn")) {
			ISBNValidator isbnValidator = new ISBNValidator();
			if (!isbnValidator.isValid(cmd.getIsbn())) {
				errors.rejectValue("isbn", "notvalid");
			}
		}
	}

}
