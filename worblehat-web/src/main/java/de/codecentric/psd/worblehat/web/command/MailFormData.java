package de.codecentric.psd.worblehat.web.command;

/**
 * Form data object from the borrow view.
 * 
 * @author psd
 * 
 */
public class MailFormData {

	private String email;

	/**
	 * Empty constructor, required by Spring Framework.
	 */
	public MailFormData() {
		super();
	}

	/**
	 * Constructor for testing.
	 * 
	 * @param email
	 *            the user email address
	 */
	public MailFormData(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
