package de.codecentric.psd.worblehat.service;

import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.codecentric.psd.worblehat.domain.Book;
import de.codecentric.psd.worblehat.domain.BookRepository;
import de.codecentric.psd.worblehat.domain.StandardBookService;

public class StandardBookServiceTest {

	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	public StandardBookService standardBookService;

	Book testBook;

	@Before
	public void setup() throws Exception {
		standardBookService = new StandardBookService();
		MockitoAnnotations.initMocks(this);
		testBook = new Book("MyTitle", "MyAuthor", "2007", "1234567962", 2009,
				"Super Description!");
		testBook.borrow("test@test.de");
	}

	@Test
	public void shouldreturnOneBookByBorrowerAndIsbn() {

		List<Book> result = new ArrayList<Book>();
		result.add(testBook);
		when(bookRepository.findAllBorrowBooksByBorrower(anyString()))
				.thenReturn(result);
		standardBookService.returnOneBookByBorrowerAndIsbn("1234567962",
				"test@test.de");
		assertNull(testBook.getCurrentBorrowing());
	}

	@Test
	public void shouldreturnOneBookByBorrowerAndTitle() {
		List<Book> result = new ArrayList<Book>();
		result.add(testBook);
		when(bookRepository.findAllBorrowBooksByBorrower(anyString()))
				.thenReturn(result);
		standardBookService.returnOneBookByBorrowerAndTitle("MyTitle",
				"test@test.de");
		assertNull(testBook.getCurrentBorrowing());

	}

}
