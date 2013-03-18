package de.codecentric.psd.worblehat.web.command;

public class ReturnOneBookFormData {

	private String emailAddress;
	private String isbn;

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
