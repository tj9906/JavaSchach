package de.allianz.javapraxis.schach.figur;

import de.allianz.javapraxis.schach.feld.Feld;
import de.allianz.javapraxis.schach.feld.koordinate.GehKoordinate;

public class Springer extends Figur {

	public Springer(FARBE farbe) {
		super(farbe);
		// TODO Auto-generated constructor stub
		zuege.add(new GehKoordinate(1, 2, 1));
		zuege.add(new GehKoordinate(2, 1, 1));
		zuege.add(new GehKoordinate(-1, 2, 1));
		zuege.add(new GehKoordinate(2, -1, 1));
		zuege.add(new GehKoordinate(1, -2, 1));
		zuege.add(new GehKoordinate(-2, 1, 1));
		zuege.add(new GehKoordinate(-1, -2, 1));
		zuege.add(new GehKoordinate(-2, -1, 1));
		
	}
	@Override
	public String toString() {
		if(farbe == FARBE.SCHWARZ)
			return "S";
		else
			return "s";
	}

	@Override
	public Springer clone() throws CloneNotSupportedException {
		Springer figure = new Springer(farbe);
		return figure;
	}
}
