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
	public ReturnOneBookFormData(String emailAddress, String isbn_title) {
		this.emailAddress = emailAddress;
		this.isbn_title = isbn_title;
	}

	private String emailAddress;
	private String isbn_title;

	public String getISBN_TITLE() {
		return isbn_title;
	}

	public void setISBN_TITLE(String isbn_title) {
		this.isbn_title = isbn_title;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
