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
	 * @param email
	 *            the user email address
	 * @param isbn_title
	 *            ISBN or title
	 */
	public ReturnOneBookFormData(String email, String isbn_title) {
		this.email = email;
		this.isbn_title = isbn_title;
	}

	private String email;
	private String isbn_title;

	public String getIsbn_title() {
		return isbn_title;
	}

	public void setIsbn_title(String isbn_title) {
		this.isbn_title = isbn_title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String emailAddress) {
		this.email = emailAddress;
	}

}
