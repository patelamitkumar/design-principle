package srp;

import org.junit.Test;

import srp.notvaiolating.HtmlPrinter;
import srp.notvaiolating.PlainTextPrinter;
import srp.notvaiolating.Printer;
import srp.violating.Book;

public class BookPrintingTest {

	@Test
	public void testViolatingSrp() {
		Book book = new Book("title", "author");
		
		book.print();
	}
	
	@Test
	public void testNotViolatingSrp() {
		srp.notvaiolating.Book book = new srp.notvaiolating.Book("title", "author");
		
		Printer plainText = new PlainTextPrinter();
		plainText.print(book);

		Printer htmlText = new HtmlPrinter();
		htmlText.print(book);

	}
}
