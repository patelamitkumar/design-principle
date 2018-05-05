package dry;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dry.violating.Summation;

public class SummationTest {

	@Test
	public void testSummationViolatingDry() {
		assertEquals(6, Summation.sumEvenNo(100, 5));
		assertEquals(4, Summation.sumOddNo(100, 5));

	}

	@Test
	public void testSummationNotViolatingDry() {
		assertEquals(6, dry.notviolating.Summation.sum(100, 5, e -> e % 2 == 0));
		assertEquals(4, dry.notviolating.Summation.sum(100, 5, e -> e % 2 != 0));

	}
}
