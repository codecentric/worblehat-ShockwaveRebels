package de.codecentric.psd.worblehat.web.command;

/**
 * This class represent the form data of the return book form.
 * 
 * @author psd
 * 
 */

public class ReturnOneBookFormData {

	/**
	 * Empty constructor, required by Spring Framework.
	 */
	public ReturnOneBookFormData() {
		super();
	}

	/**
	 * @param emailAddress
	 *            the user email address
	 */
	public ReturnOneBookFormData(String isbn, String emailAddress) {
		this.isbn = isbn;
		this.emailAddress = emailAddress;
	}

	private String emailAddress;
	private String isbn;

	public String getISBNNumber() {
		return isbn;
	}

	public void setISBNNumber(String isbn) {
		this.isbn = isbn;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
