package de.codecentric.psd.worblehat.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

	}

}
