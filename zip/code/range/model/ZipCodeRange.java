package zip.code.range.model;

public class ZipCodeRange {

	private int start;
	private int end;

	public ZipCodeRange(int start, int end) {
		if (start <= end) {
			this.start = start;
			this.end = end;
		} else {
			this.start = end;
			this.end = start;
		}
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setUpper(int end) {
		this.end = end;
	}

	public String toString() {
		return String.format("['%d','%d']", start, end);
	}

	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof ZipCodeRange) {
			ZipCodeRange zipCodeRange = (ZipCodeRange) obj;
			result = (this.getStart() == zipCodeRange.getStart() && this.getEnd() == zipCodeRange.getEnd());
		}
		return result;
	}
}
