package de.codecentric.psd.worblehat.domain;

/**
 * The interface of the domain service for books.
 * 
 * @author psd
 * 
 */
public interface BookService {

	void returnAllBooksByBorrower(String mail);

	void returnOneBookByBorrowerAndIsbn(String isbn, String mail);

	void returnOneBookByBorrowerAndTitle(String title, String mail);

}
