package dry;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SummationTest {

	@Test
	public void testSumEvenNo() {
		assertEquals(6, Summation.sumEvenNo(100, 5));
		assertEquals(4, Summation.sumOddNo(100, 5));

		assertEquals(6, Summation.sum(100, 5, e -> e % 2 == 0));
		assertEquals(4, Summation.sum(100, 5, e -> e % 2 != 0));

	}
}
