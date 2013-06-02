package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un intervalle de nombre entiers, par exemple [2,6[ ou
 * ]5,8[
 * 
 * @author ecravero
 * 
 */
public class Range {
	private Bound min;
	private Bound max;

	public Range(int min, int max, boolean minIncluded, boolean maxIncluded) {
		this.min = new Bound(min, minIncluded);
		this.max = new Bound(max, maxIncluded);
	}

	/**
	 * @param value
	 * @return if value is present in this range
	 */
	public boolean contains(int value) {
		if (min.getValue() < value && value < max.getValue()) {
			return true;
		} else if (min.getValue() == value && min.isIncluded()) {
			return true;
		} else if (max.getValue() == value && max.isIncluded()) {
			return true;
		} else {
			return false;
		}
	}

	public List<Integer> getAllPoints() {
		List<Integer> points = new ArrayList<Integer>();

		if (min.isIncluded()) {
			points.add(min.getValue());
		}
		for (int i = min.getValue() + 1; i < max.getValue(); i++) {
			points.add(new Integer(i));
		}
		if (max.isIncluded()) {
			// Cas de l'intervalle d'un seul nombre
			if (!points.contains(max.getValue())) {
				points.add(max.getValue());
			}
		}

		return points;
	}

	public boolean containsRange(Range range) {
		if (range != null) {
			if (min.compareTo(range.getMin()) <= 0) {
				if (max.compareTo(range.getMax()) >= 0) {
					return true;
				}
			}
		}
		return false;
	}

	public Bound getMin() {
		return min;
	}

	public void setMin(Bound min) {
		this.min = min;
	}

	public Bound getMax() {
		return max;
	}

	public void setMax(Bound max) {
		this.max = max;
	}

}
