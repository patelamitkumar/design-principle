package srp.notvaiolating;

public class PlainTextPrinter implements Printer {

	@Override
	public void print(Book book) {
		System.out.println("PlainTextPrinter: " + book.getCurrentPage());
	}

}
