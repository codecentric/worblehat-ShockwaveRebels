package de.codecentric.psd.worblehat.web.command;

/**
 * @author mahmut.can
 * 
 */
public class BookDataFormData {

	private String title;
	private String edition;
	private String year;
	private String isbn;
	private String author;
	private String description;

	private String trimStringOrNull(String s) {
		if (s == null) {
			return s;
		} else {

			return s.trim();
		}
	}

	private String removeWhitespaceCharacters(String s) {

		if (s != null) {
			return s.replaceAll("\\n", " ").replaceAll("\\s.\\s", " ").trim();
		} else {
			return s;
		}

	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = removeWhitespaceCharacters(year);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = removeWhitespaceCharacters(description);

	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = removeWhitespaceCharacters(author);
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
				+ ", year=" + year + ", isbn=" + isbn + ", author=" + author
				+ ", description=" + description + "]";
	}

}
