package de.codecentric.psd.atdd.step.page;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.inject.Inject;

import de.codecentric.psd.atdd.library.Config;
import de.codecentric.psd.atdd.library.SeleniumAdapter;

public class DeleteBook {
	private WebDriver driver;

	@Inject
	public DeleteBook(SeleniumAdapter selenium) {
		driver = selenium.getDriver();
	}

	// *******************
	// *** G I V E N *****
	// *******************

	// *****************
	// *** W H E N *****
	// *****************

	@When("librarian deletes the book <isbn> <title> <edition>")
	public void whenABookWithIsbnTitleEditionIsDeleted(
			@Named("isbn") String isbn, @Named("title") String title,
			@Named("edition") String edition) {
		openDeleteBookPage();
		fillInsertBookForm(title, edition, isbn);
		submitForm();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// *****************
	// *** U T I L *****
	// *****************

	private void setTitle(String titel) {
		typeIntoField("title", titel);
	}

	private void setEdition(String edition) {
		typeIntoField("edition", edition);
	}

	private void setIsbn(String isbn) {
		typeIntoField("isbn", isbn);
	}

	private void typeIntoField(String id, String value) {
		WebElement element = driver.findElement(By.id(id));
		element.clear();
		element.sendKeys(value);
	}

	private void fillInsertBookForm(String titel, String edition, String isbn) {
		setTitle(titel);
		setEdition(edition);
		setIsbn(isbn);
	}

	private void submitForm() {
		driver.findElement(By.id("deleteBook")).click();
	}

	private void openDeleteBookPage() {
		driver.get(Config.getApplicationURL() + "/"
				+ Config.getApplicationContext() + "/deleteBook");
	}

}
