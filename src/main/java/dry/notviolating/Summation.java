package dry.notviolating;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * This class demonstrates the coding practice applying DRY 
 * 
 * @author Amit K Patel
 *
 */
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
