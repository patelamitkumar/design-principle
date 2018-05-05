package srp.violating;

/**
 * This class is expected to do Book operation and should only change due to
 * change is book behavior However this class is also in the business of
 * printing. So if ypu want to print in pdf it this class requires a change
 * 
 * @author hr65
 *
 */
public class Book {
	private String title;
	private String author;

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	void turnPage() {
		// pointer to next page
	}

	String getCurrentPage() {
		return "current page";
	}

	// This behavior should be separated out
	public void print() {
		System.out.println("Book: "+getCurrentPage());
	}

}
