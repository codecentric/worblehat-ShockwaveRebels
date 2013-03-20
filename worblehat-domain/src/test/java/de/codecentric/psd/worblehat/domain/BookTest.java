package de.codecentric.psd.worblehat.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;

public class BookTest {

	@Test
	public void shouldAllowBorrowingAvailableBook()
			throws BookAlreadyBorrowedException {
		Book book = new Book("Title", "author", "2", "1234", 2002,
				"Super Werk!");
		book.borrow("borrower@codecentric.local");

		assertNotNull(book.getCurrentBorrowing());
	}

	@Test(expected = BookAlreadyBorrowedException.class)
	public void shouldDenyBorrowingAlreadyBorrowedBook()
			throws BookAlreadyBorrowedException {
		Book book = new Book("Title", "author", "2", "1234", 2002,
				"Super Sache");
		book.borrow("borrower@codecentric.local");
		book.borrow("borrower@codecentric.local");
	}

	@Test
	public void shouldRemoveDashesForISBN() {
		String isbn = "123-123-123-123";
		String expectedISBN = "123123123123";
		Book book = new Book("Title", "author", "1", isbn, 2012, "Test");
		Assert.assertNotSame(isbn, book.getIsbn());
		Assert.assertEquals(expectedISBN, book.getIsbn());
	}

	@Test
	public void shouldRemoveWhitespacesForISBN() {
		String isbn = "123 123 123 123";
		String expectedISBN = "123123123123";
		Book book = new Book("Title", "author", "1", isbn, 2012, "Test");
		Assert.assertNotSame(isbn, book.getIsbn());
		Assert.assertEquals(expectedISBN, book.getIsbn());
	}

}
