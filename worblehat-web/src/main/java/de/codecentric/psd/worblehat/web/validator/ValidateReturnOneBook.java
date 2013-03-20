package de.codecentric.psd.worblehat.web.validator;

import org.apache.commons.validator.EmailValidator;
import org.apache.commons.validator.ISBNValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import de.codecentric.psd.worblehat.web.command.ReturnOneBookFormData;

/**
 * 
 * Validates email address when borrowed books are returned.
 * 
 * @author psd
 * 
 */
public class ValidateReturnOneBook implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ReturnOneBookFormData.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if (!supports(target.getClass())) {
			throw new IllegalArgumentException(
					"Not supported FormData for this validator: "
							+ target.getClass());
		}

		ReturnOneBookFormData cmd = (ReturnOneBookFormData) target;
		boolean isISBN = checkIfArgumentIsIsbnOrTitle(cmd.getIsbn_title());

		if (isISBN) {
			checkThatIsbnIsFilledAndValid(errors, cmd);
		} else {
			checkThatTitleIsFilledAndValid(errors, cmd);
		}

		checkThatUserEmailAddressIsFilledAndValid(errors, cmd);
	}

	public boolean checkIfArgumentIsIsbnOrTitle(String isbn_title) {
		return true;
		// return isbn_title.matches("[0-9]");
	}

	private void checkThatUserEmailAddressIsFilledAndValid(Errors errors,
			ReturnOneBookFormData cmd) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "empty");
		if (!errors.hasFieldErrors("email")) {
			if (!EmailValidator.getInstance().isValid(cmd.getEmail())) {
				errors.rejectValue("email", "notvalid");
			}
		}
	}

	private void checkThatIsbnIsFilledAndValid(Errors errors,
			ReturnOneBookFormData cmd) {
		ValidationUtils
				.rejectIfEmptyOrWhitespace(errors, "isbn_title", "empty");
		if (!errors.hasFieldErrors("isbn_title")) {
			ISBNValidator isbnValidator = new ISBNValidator();
			if (!isbnValidator.isValid(cmd.getIsbn_title())) {
				errors.rejectValue("isbn_title", "notvalid");
			}
		}
	}

	private void checkThatTitleIsFilledAndValid(Errors errors,
			ReturnOneBookFormData cmd) {
		ValidationUtils
				.rejectIfEmptyOrWhitespace(errors, "isbn_title", "empty");
		if (!errors.hasFieldErrors("isbn_title")) {
			ISBNValidator isbnValidator = new ISBNValidator();
			if (!isbnValidator.isValid(cmd.getIsbn_title())) {
				errors.rejectValue("isbn_title", "notvalid");
			}
		}
	}

}
