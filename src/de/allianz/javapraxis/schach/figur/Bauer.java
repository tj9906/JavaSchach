package de.allianz.javapraxis.schach.figur;

import de.allianz.javapraxis.schach.feld.koordinate.GehKoordinate;

public class Bauer extends Figur {

	/**
	 * Unterscheidung in Bewegungen nach Farbe
	 * @param farbe
	 */
	public Bauer(FARBE farbe) {
		super(farbe);
		// TODO Auto-generated constructor stub
		if (farbe == FARBE.WEISS) {
			zuege.add(new GehKoordinate(0, 1, 2));
			zuege.add(new GehKoordinate(0, 1, 1));
			zuege.add(new GehKoordinate(1, 1, 1));
			zuege.add(new GehKoordinate(-1, 1, 1));
		} else {
			zuege.add(new GehKoordinate(0, -1, 2));
			zuege.add(new GehKoordinate(0, -1, 1));
			zuege.add(new GehKoordinate(1, -1, 1));
			zuege.add(new GehKoordinate(-1, -1, 1));
		}

	}

	@Override
	public String toString() {
		if (farbe == FARBE.SCHWARZ)
			return "B";
		else
			return "b";
	}

	/**
	 * Soll die zewi mal vor löschen
	 */
	@Override
	public void loescheErsterMove() {
		// TODO Auto-generated method stub
		
		this.zuege.remove(new GehKoordinate(0, -1, 2));
		this.zuege.remove(new GehKoordinate(0, 1, 2));
	}
	
	@Override
	public Bauer clone() throws CloneNotSupportedException {
		Bauer figure = new Bauer(farbe);
		return figure;
	}

}
