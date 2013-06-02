package main;

/**
 * Représente une borne d'un intervalle de nombres entiers
 * 
 * @author ecravero
 * 
 */
public class Bound {
	private int value;
	private boolean included;

	public Bound(int value, boolean included) {
		this.value = value;
		this.included = included;
	}

	/**
	 * @param b the Bound to be compared to
	 * @return an int > 0 if this Bound is greater than the specified Bound, 0
	 *         if they are equals, or an int < 0 if this Bound is lower than the
	 *         specified Bound
	 */
	public int compareTo(Bound b) {
		if (b == null) {
			return 1;
		}
		if (equals(b)) {
			return 0;
		}
		if (value == b.value) {
			if (included) {
				return -1;
			} else {
				return 1;
			}
		} else {
			return value - b.getValue();
		}
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Bound) {
			Bound b = (Bound) o;
			if (value == b.value) {
				if (included == b.included) {
					return true;
				}
			}
		}
		return false;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isIncluded() {
		return included;
	}

	public void setIncluded(boolean included) {
		this.included = included;
	}

}
