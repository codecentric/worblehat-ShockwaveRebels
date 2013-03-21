package de.codecentric.psd.worblehat.web.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class NavigationControllerTest {

	@InjectMocks
	private NavigationController navigationController;

	@Before
	public void setup() {
		navigationController = new NavigationController();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldHome() {
		String object = navigationController.home();
		assertThat(object, is("/home"));
	}
}
