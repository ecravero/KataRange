package test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import main.Range;

import org.junit.Test;

public class TestRange {
	private static final Range FROM_MINUS_2_INCLUDED_TO_6_EXCLUDED = new Range(-2, 6, true, false);
	private static final Range FROM_5_EXCLUDED_TO_8_INCLUDED = new Range(5, 8, false, true);
	private static final Range FROM_3_INCLUDED_TO_3_INCLUDED = new Range(3, 3, true, true);

	@Test
	public void includeMinus2Exclude6ShouldContain2() {
		Assert.assertTrue(FROM_MINUS_2_INCLUDED_TO_6_EXCLUDED.contains(2));
	}

	@Test
	public void includeMinus2Exclude6ShouldContain4() {
		Assert.assertTrue(FROM_MINUS_2_INCLUDED_TO_6_EXCLUDED.contains(4));
	}

	@Test
	public void includeMinus2Exclude6ShouldNotContainMinus3() {
		Assert.assertFalse(FROM_MINUS_2_INCLUDED_TO_6_EXCLUDED.contains(-3));
	}

	@Test
	public void includeMinus2Exclude6ShouldNotContain7() {
		Assert.assertFalse(FROM_MINUS_2_INCLUDED_TO_6_EXCLUDED.contains(7));
	}

	@Test
	public void includeMinus2Exclude6ShouldNotContain6() {
		Assert.assertFalse(FROM_MINUS_2_INCLUDED_TO_6_EXCLUDED.contains(6));
	}

	@Test
	public void exclude5Include8ShouldNotContain5() {
		Assert.assertFalse(FROM_5_EXCLUDED_TO_8_INCLUDED.contains(5));
	}

	@Test
	public void exclude5Include8ShouldContain8() {
		Assert.assertTrue(FROM_5_EXCLUDED_TO_8_INCLUDED.contains(8));
	}

	@Test
	public void include3Include3ShouldContain3() {
		Assert.assertTrue(FROM_3_INCLUDED_TO_3_INCLUDED.contains(3));
	}

	@Test
	public void include3Include3ShouldHaveAllPointsFromMinus3To3() {
		List<Integer> actual = FROM_3_INCLUDED_TO_3_INCLUDED.getAllPoints();
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(3);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void includeMinus2Exclude6ShouldHaveAllPointsFromMinus2To5() {
		List<Integer> actual = FROM_MINUS_2_INCLUDED_TO_6_EXCLUDED.getAllPoints();
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(-2);
		expected.add(-1);
		expected.add(0);
		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(4);
		expected.add(5);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void exclude5Include8ShouldHaveAllPointsFrom6To8() {
		List<Integer> actual = FROM_5_EXCLUDED_TO_8_INCLUDED.getAllPoints();
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(6);
		expected.add(7);
		expected.add(8);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void includeMinus2Exclude6ShouldContainRangeFromMinus1To5() {
		Range rangeContained = new Range(-1, 5, true, true);
		Assert.assertTrue(FROM_MINUS_2_INCLUDED_TO_6_EXCLUDED.containsRange(rangeContained));
	}

	@Test
	public void includeMinus2Exclude6ShouldContainRangeFromMinus2To5BothIncluded() {
		Range rangeContained = new Range(-2, 5, true, true);
		Assert.assertTrue(FROM_MINUS_2_INCLUDED_TO_6_EXCLUDED.containsRange(rangeContained));
	}

	/**
	 * [-2 ; 6[ should contain ]-2 ; 5 [
	 */
	@Test
	public void includeMinus2Exclude6ShouldContainRangeFromMinus2To5BothExcluded() {
		Range rangeContained = new Range(-2, 5, false, false);
		Assert.assertTrue(FROM_MINUS_2_INCLUDED_TO_6_EXCLUDED.containsRange(rangeContained));
	}

	/**
	 * [-2 ; 6[ should not contain [3 ; 8]
	 */
	@Test
	public void includeMinus2Exclude6ShouldNotContainRangeFrom3To8() {
		Range rangeContained = new Range(3, 8, true, true);
		Assert.assertFalse(FROM_MINUS_2_INCLUDED_TO_6_EXCLUDED.containsRange(rangeContained));
	}

	/**
	 * ]5 ; 8] should contain ]5 ; 8[
	 */
	@Test
	public void exclude5Include8ShouldNotContainRangeFrom5To8BothIncluded() {
		Range rangeContained = new Range(5, 8, true, true);
		Assert.assertFalse(FROM_5_EXCLUDED_TO_8_INCLUDED.containsRange(rangeContained));
	}

	/**
	 * ]5 ; 8] should NOT contain [5 ; 8]
	 */
	@Test
	public void exclude5Include8ShouldNotContainRangeFrom5To8BothExcluded() {
		Range rangeContained = new Range(5, 8, false, false);
		Assert.assertFalse(FROM_5_EXCLUDED_TO_8_INCLUDED.containsRange(rangeContained));
	}

	@Test
	public void exclude5Include8ShouldContainRangeItself() {
		Assert.assertTrue(FROM_5_EXCLUDED_TO_8_INCLUDED
				.containsRange(FROM_5_EXCLUDED_TO_8_INCLUDED));
	}
}
