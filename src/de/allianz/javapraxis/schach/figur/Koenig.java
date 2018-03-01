package de.allianz.javapraxis.schach.figur;

import de.allianz.javapraxis.schach.feld.koordinate.GehKoordinate;

public class Koenig extends Figur {

	public Koenig(FARBE farbe) {
		super(farbe);
		// TODO Auto-generated constructor stub
		zuege.add(new GehKoordinate(1, 1, 1));
		zuege.add(new GehKoordinate(1, -1, 1));
		zuege.add(new GehKoordinate(-1, 1, 1));
		zuege.add(new GehKoordinate(-1, -1, 1));
		zuege.add(new GehKoordinate(0, 1, 1));
		zuege.add(new GehKoordinate(0, -1, 1));
		zuege.add(new GehKoordinate(1, 0, 1));
		zuege.add(new GehKoordinate(-1, 0, 1));
	}


	@Override
	public String toString() {
		if(farbe == FARBE.SCHWARZ)
			return "K";
		else
			return "k";
	}


	@Override
	public Koenig clone() throws CloneNotSupportedException {
		Koenig figure = new Koenig(farbe);
		return figure;
	}

	

}
