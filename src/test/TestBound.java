package test;

import junit.framework.Assert;
import main.Bound;

import org.junit.Test;

public class TestBound {
	private final Bound bound = new Bound(5, true);

	@Test
	public void bound5IncludedShouldBeGreaterThan4() {
		int actual = bound.compareTo(new Bound(4, false));
		Assert.assertTrue(actual > 0);
	}

	/**
	 * [5 est plus petit que ]6
	 */
	@Test
	public void bound5IncludedShouldBeLowerThan6() {
		int actual = bound.compareTo(new Bound(6, false));
		Assert.assertTrue(actual < 0);
	}

	@Test
	public void bound5IncludedShouldBeEqualTo5Included() {
		int actual = bound.compareTo(new Bound(5, true));
		Assert.assertTrue(actual == 0);
	}

	/**
	 * [5 est plus petit que ]5
	 */
	@Test
	public void bound5IncludedShouldBeLowerThan5Excluded() {
		int actual = bound.compareTo(new Bound(5, false));
		Assert.assertTrue(actual < 0);
	}

	@Test
	public void bound5IncludedShouldBeGreaterThanNull() {
		int actual = bound.compareTo(null);
		Assert.assertTrue(actual > 0);
	}
}
