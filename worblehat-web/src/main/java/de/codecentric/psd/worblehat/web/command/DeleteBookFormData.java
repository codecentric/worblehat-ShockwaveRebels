package de.codecentric.psd.worblehat.web.command;

/**
 * @author mahmut.can
 * 
 */
public class DeleteBookFormData {

	private String title;
	private String edition;
	private String isbn;

	private String removeWhitespaceCharacters(String s) {

		if (s != null) {
			return s.replaceAll("\\n", " ").replaceAll("\\s.\\s", " ").trim();
		} else {
			return s;
		}

	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = removeWhitespaceCharacters(title);
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = removeWhitespaceCharacters(edition);
	}

	@Override
	public String toString() {
		return "BookDataFormData [title=" + title + ", edition=" + edition
				+ ", isbn=" + isbn + "]";
	}

}
