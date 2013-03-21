package de.codecentric.psd.worblehat.domain;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BookFactoryTest {

	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private BookFactory bookFactory;

	@Before
	public void setUp() {
		bookRepository = new BookRepository();
		bookFactory = new BookFactory(bookRepository);
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldCreateBook() {
		Book book = bookFactory.createBook("title", "author", "2",
				"1234567962", 2013, "desc");
		// assertThat(book, not(null));
	}
}
