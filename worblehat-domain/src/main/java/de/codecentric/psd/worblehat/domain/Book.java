package de.codecentric.psd.worblehat.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Book
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "findBorrowableBookByISBN", query = "from Book where isbn=:isbn and currentBorrowing is null"),
		@NamedQuery(name = "findAllBorrowedBooksByEmail", query = "select book from Book as book where book.currentBorrowing.borrowerEmailAddress = :email"),
		@NamedQuery(name = "findAllBooks", query = "from Book order by title") })
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String title;
	private String author;
	private String edition;
	private String isbn;
	private String description;
	private int year;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Borrowing currentBorrowing;

	/**
	 * Empty constructor needed by Hibernate.
	 */
	private Book() {
		super();
	}

	/**
	 * @param digitsToRemove
	 *            String to remove all character which aren't a number
	 */
	private String removeNondigits(String digitsToRemove) {
		if (digitsToRemove == null) {
			return digitsToRemove;
		} else {

			return digitsToRemove.replaceAll("-", "").replaceAll("\\s", "");
		}
	}

	/**
	 * @param stringToRemoveWhiteSpaces
	 *            String to remove Whitespaces
	 */
	private String removeWhitespaceCharacters(String stringToRemoveWhiteSpaces) {

		if (stringToRemoveWhiteSpaces != null) {
			return stringToRemoveWhiteSpaces.replaceAll("\\n", " ")
					.replaceAll("\\s.\\s", " ").trim();
		} else {
			return stringToRemoveWhiteSpaces;
		}

	}

	/**
	 * Creates a new book instance.
	 * 
	 * @param title
	 *            the title
	 * @param author
	 *            the author
	 * @param edition
	 *            the edition
	 * @param isbn
	 *            the isbn
	 * @param year
	 *            the year
	 * @param description
	 *            the Book Description
	 */
	public Book(String title, String author, String edition, String isbn,
			int year, String description) {
		super();
		this.title = removeWhitespaceCharacters(title);
		this.author = removeWhitespaceCharacters(author);
		this.edition = removeWhitespaceCharacters(edition);
		this.isbn = removeNondigits(isbn);
		this.year = year;
		this.description = removeWhitespaceCharacters(description);
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getEdition() {
		return edition;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getYear() {
		return year;
	}

	public String getDescription() {
		return description;
	}

	public Borrowing getCurrentBorrowing() {
		return currentBorrowing;
	}

	/**
	 * Borrow this book.
	 * 
	 * @param borrowerEmailAddress
	 *            the user that borrows the book
	 * @throws BookAlreadyBorrowedException
	 *             if this current book is already borrowed
	 */
	public void borrow(String borrowerEmailAddress)
			throws BookAlreadyBorrowedException {
		if (currentBorrowing != null) {
			throw new BookAlreadyBorrowedException("book is already borrowed");
		} else {
			currentBorrowing = new Borrowing(borrowerEmailAddress, new Date());
		}
	}

	/**
	 * Return the book.
	 */
	public void returnBook() {
		this.currentBorrowing = null;
	}

}
