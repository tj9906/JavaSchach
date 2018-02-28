package de.allianz.javapraxis.schach.feld.koordinate;

import de.allianz.javapraxis.schach.exception.InvalideKoordinatenException;

public class GehKoordinate extends Koordinate {

	private int offset;

	public GehKoordinate(int spalte, int zeile, int offsett) {
		setSpalte(spalte);
		setZeile(zeile);
		this.offset = offsett;
		// TODO Auto-generated constructor stub
	}
	/**
	 * stezt Spalte
	 */
	public void setSpalte(int spalte) {
		try {
			if (spalte > 2 || spalte < -2) {
				throw new InvalideKoordinatenException("Koordinaten (spalte) liegen nicht auf dem Brett!");
			}
			this.spalte = spalte;
		} catch (InvalideKoordinatenException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	/**
	 * stezt Zeile
	 */
	@Override
	public void setZeile(int zeile) {
		try {
			if (zeile > 2 || zeile < -2) {
				throw new InvalideKoordinatenException("Koordinaten (Zeile) liegen nicht auf dem Brett!");
			}
			this.zeile = zeile;
		} catch (InvalideKoordinatenException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public int getOffset() {
		return offset;
	}
	/**
	 * stezt Offset
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	@Override
	public GehKoordinate clone() throws CloneNotSupportedException {
		GehKoordinate koor = new GehKoordinate(spalte, zeile, offset);
		return koor;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof GehKoordinate)) {
			return false;
		}
		GehKoordinate other = (GehKoordinate) obj;
		if (spalte != other.spalte) {
			return false;
		}
		if (zeile != other.zeile) {
			return false;
		}
		if(offset != other.offset){
			return false;
		}
		return true;
	}
}
