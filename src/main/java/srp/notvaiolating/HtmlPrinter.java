package srp.notvaiolating;

public class HtmlPrinter implements Printer {

	@Override
	public void print(Book book) {
		System.out.println("HtmlPrinter: " + "<html><body>" + book.getCurrentPage() + "</body></html>");
	}

}
