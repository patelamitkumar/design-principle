package dry.violating;

import java.util.stream.IntStream;

/**
 * This class demonstrates the coding practice without applying DRY and applying
 * DRY
 * 
 * @author Amit K Patel
 *
 */
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
