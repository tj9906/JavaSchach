package de.allianz.javapraxis.schach.figur;

import de.allianz.javapraxis.schach.feld.koordinate.GehKoordinate;

public class Dame extends Figur{

	public Dame(FARBE farbe) {
		super(farbe);
		// TODO Auto-generated constructor stub
		zuege.add(new GehKoordinate(1, 1, 7));
		zuege.add(new GehKoordinate(1, -1, 7));
		zuege.add(new GehKoordinate(-1, 1, 7));
		zuege.add(new GehKoordinate(-1, -1, 7));
		zuege.add(new GehKoordinate(0, 1, 7));
		zuege.add(new GehKoordinate(0, -1, 7));
		zuege.add(new GehKoordinate(1, 0, 7));
		zuege.add(new GehKoordinate(-1, 0, 7));
	}

	@Override
	public String toString() {
		if(farbe == FARBE.SCHWARZ)
			return "D";
		else
			return "d";
	}


	@Override
	public Dame clone() throws CloneNotSupportedException {
		Dame figure = new Dame(farbe);
		return figure;
	}

	

}
