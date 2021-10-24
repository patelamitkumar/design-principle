# design-principle

#### Why should I care ?
Change is the only constant, right? Most of the time we developers are busy fixing defect or implementing features on top of an existing code and often times we curse the original author (sometimes we ourself is the author of the code). So in the agile development or adaptive software development world the design principles are core to produce maintainable code. 

#### What are those principles ?
- DRY - Don't Repeat Yourself
- KISS - Keep It Simple Stupid
- SRP - Single Responsibility Principle [Goal: This principle aims to separate behaviours so that if bugs arise as a result of your change, it won’t affect other unrelated behaviours.]
- OCP - Open Closed Principle [Goal: This is to avoid causing bugs wherever the Class is being used.]
- LSP -  Liskov Substitution Principle [Goal: This principle aims to enforce consistency so that the parent Class or its child Class can be used in the same way without any errors.]
- ISP - Interface Segregation Principle [Goal: This principle aims at splitting a set of actions into smaller sets so that a Class executes ONLY the set of actions it requires.]
- DIP - Dependency Inversion Principle [Goal: This principle aims at reducing the dependency of a high-level Class on the low-level Class by introducing an interface.]
- YAGNI - You "Ain't Gonna Need It

##### DRY:
Duplicity is found in two forms as below
 - Code duplicity
 - Effort duplicity
 
Code duplicity is the result of copy/paste. Effort duplicity is when the same activity is performed at multiple place. For example the validation being done at UI layer written in Javascript and being done server side written with server side language. 

###### An example - calculating sum
Let's say Fred is developing a Summation class to find the Sum of first k even numbers.

```java
public class Summation {
	public static int sumEvenNo(int n, int k) {
		return IntStream.range(0, n).limit(k).filter(e -> e % 2 == 0).sum();
	}
}
```
The class is presented and the client is happy to use the class. After sometime client asked to find sum of first k odd number. Fred was in a hurry and copied the sumEvenNo function and changed to make it work for odd number. Client is happy to use both sumEvenNo and sumOddNo functionality.

```java
public class Summation {
	public static int sumEvenNo(int n, int k) {
		return IntStream.range(0, n).limit(k).filter(e -> e % 2 == 0).sum();
	}

	public static int sumOddNo(int n, int k) {
		return IntStream.range(0, n).limit(k).filter(e -> e % 2 != 0).sum();
	}
}
```

After sometime client again in need of a summation of prime numbers. Now Fred realized the mistake of not applying DRY and he decided to refactor. 

```java
public class Summation {
	public static int sum(int n, int k, IntPredicate predicate) {
		return IntStream.range(0, n).limit(k).filter(predicate).sum();
	}

	public static void main(String[] args) {
		System.out.println("Sum of First k even no from 0 to n is: " + sum(100, 5, e -> e % 2 == 0));
		System.out.println("Sum of First k odd no from 0 to n is: " + sum(100, 5, e -> e % 2 != 0));
	}
}
```
The code above is now abiding by the rule of DRY and hence client can use the sum behaviour for any type of numbers.

<a href=../../tree/master/src/main/java/dry>Refer the complete example here</a>

##### KISS:
Many a times the problem is simple, but we developer tend to add accidental complexities which is unnecessary.

You should keep in mind familiar doesn't mean simple. 

##### SRP:
A class should have one and only one reason to change, meaning that a class should have only one job. You can think it is like master of one but not jack of all.

###### An example - Printing books
Let's say we have the below Book class. The book class should only provide behaviour related to book activities like get author, get next page, get current page etc. However it has taken the responsibility of printing which should be taken care by other printer master class.

```java
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
```
Let's fix it by moving the print behaviour to specialized printer classes

```java
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
}

public interface Printer {
	public void print(Book book);
}

public class HtmlPrinter implements Printer {

	@Override
	public void print(Book book) {
		System.out.println("HtmlPrinter: " + "<html><body>" + book.getCurrentPage() + "</body></html>");
	}

}

public class PlainTextPrinter implements Printer {

	@Override
	public void print(Book book) {
		System.out.println("PlainTextPrinter: " + book.getCurrentPage());
	}

}
```
Now all the 3 classes (book, HtmlPrinter, PlainTextPrinter) are doing a single task and they are master of the activity.

<a href=../../tree/master/src/main/java/srp>Refer the complete example here</a>

##### OCP:
Objects or entities should be open for extension, but closed for modification. 

##### LSP:
When Inheritance is used the inherited class should not require more and shouldn't provide less than the parent. This ensures the client of the class is unaffected when the child object is substituted in clients code.

##### ISP:
A client should never be forced to implement an interface that it doesn't use or clients shouldn't be forced to depend on methods they do not use.

##### DIP:
Entities must depend on abstractions not on concrete object. It states that the high level module must not depend on the low level module, but they should depend on abstractions. It provides the decoupling.
 
##### YAGNI: 
A single line of code is a lot of code when not asked to implement. So developer should defer it until it is needed. This principle applies to some of the above principles and hence use cautions. One shouldn't over do any of these.

