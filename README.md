# design-principle

#### Why should I care ?
Change is the only constant, right? Most of the time we developers are busy fixing defect or implementing features on top of an existing code and often times we curse the original author (sometimes we ourself is the author of the code). So in the agile development or adaptive software development world the design principles are core to produce maintainable code. 

#### What are those principles ?
- DRY - Don't Repeat Yourself
- KISS - Keep It Simple Stupid
- SRP - Single Responsibility Principle
- OCP - Open Closed Principle
- LSP -  Liskov Substitution Principle
- ISP - Interface Segregation Principle
- DIP - Dependency Inversion Principle
- YAGNI - You "Ain't Gonna Need It

##### DRY:
Duplicity is found in two forms as below
 - Code duplicity
 - Effort duplicity
 
Code duplicity is the result of copy/paste. Effort duplicity is when the same activity is performed at multiple place. For example the validation being done at UI layer written in Javascript and being done server side written with server side language. 

Look at the below Sum function. It has been duplicated and hence when there is ask for summation of other numbers (real, prime etc) you tend to duplicate the code by writing more sumXXX function.

```java
public class Summation {

	public static int sumEvenNo(int n, int k) {
		return IntStream.range(0, n).limit(k).filter(e -> e % 2 == 0).sum();
	}

	public static int sumOddNo(int n, int k) {
		return IntStream.range(0, n).limit(k).filter(e -> e % 2 != 0).sum();
	}

	public static void main(String[] args) {
		// Bad Coding - Not applied DRY
		System.out.println("Sum of First k even no from 0 to n is: " + sumEvenNo(100, 5));
		System.out.println("Sum of First k odd no from 0 to n is: " + sumOddNo(100, 5));
	}
}
```
Let's refactor it and hence it becomes as below..

```java
public class Summation {

	public static int sum(int n, int k, IntPredicate predicate) {
		return IntStream.range(0, n).limit(k).filter(predicate).sum();
	}

	public static void main(String[] args) {
		// Good coding - Applied DRY
		System.out.println("Sum of First k even no from 0 to n is: " + sum(100, 5, e -> e % 2 == 0));
		System.out.println("Sum of First k odd no from 0 to n is: " + sum(100, 5, e -> e % 2 != 0));

	}
}
```

<a href=../../tree/master/src/main/java/dry>Refer the complete example here</a>

##### KISS:
Many a times the problem is simple, but we developer tend to add accidental complexities which is unnecessary.

You should keep in mind familiar doesn't mean simple. 

##### SRP:
A class should have one and only one reason to change, meaning that a class should have only one job.

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

