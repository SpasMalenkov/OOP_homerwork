package collections_part_1;

public class Rakia {
	int gradus;
	int kolichestvo;
	String surovina;

	public Rakia(int gradus, int kolichestvo, String surovina) {
		this.gradus = gradus;
		this.kolichestvo = kolichestvo;
		this.surovina = surovina;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Rakia))
			return false;

		Rakia otherRakia = (Rakia) obj;

		return otherRakia.gradus == this.gradus && otherRakia.surovina.equals(this.surovina);
	}

	@Override
	public String toString() {
		return "Rakia [gradus=" + gradus + ", kolichestvo=" + kolichestvo + ", surovina=" + surovina + "]";
	}
}
