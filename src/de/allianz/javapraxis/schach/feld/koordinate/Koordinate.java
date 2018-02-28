package de.allianz.javapraxis.schach.feld.koordinate;

import de.allianz.javapraxis.schach.exception.InvalideKoordinatenException;

public abstract class Koordinate {
	protected int spalte;
	protected int zeile;

	public Koordinate() {
		spalte = 0;
		zeile = 0;
	}

	public Koordinate(int spalte, int zeile) {
		this.spalte = spalte;
		this.zeile = zeile;
	}

	public int getSpalte() {
		return spalte;
	}

	public int getZeile() {
		return zeile;
	}

	public void setSpalte(int spalte) throws InvalideKoordinatenException {
		this.spalte = spalte;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + spalte;
		result = prime * result + zeile;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Koordinate)) {
			return false;
		}
		Koordinate other = (Koordinate) obj;
		if (spalte != other.spalte) {
			return false;
		}
		if (zeile != other.zeile) {
			return false;
		}
		return true;
	}

	public void setZeile(int zeile) {
		this.zeile = zeile;
	}

	@Override
	public Koordinate clone() throws CloneNotSupportedException {
		Koordinate koor = (Koordinate) super.clone();
		return koor;
	}
}
