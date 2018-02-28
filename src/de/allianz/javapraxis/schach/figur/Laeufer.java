package de.allianz.javapraxis.schach.figur;

import de.allianz.javapraxis.schach.feld.Feld;
import de.allianz.javapraxis.schach.feld.koordinate.GehKoordinate;

public class Laeufer extends Figur {

	public Laeufer(FARBE farbe) {
		super(farbe);
		// TODO Auto-generated constructor stub
		zuege.add(new GehKoordinate(1, 1, 7));
		zuege.add(new GehKoordinate(1, -1, 7));
		zuege.add(new GehKoordinate(-1, 1, 7));
		zuege.add(new GehKoordinate(-1, -1, 7));
	}

	@Override
	public String toString() {
		if(farbe == FARBE.SCHWARZ)
			return "L";
		else
			return "l";
	}

	@Override
	public Laeufer clone() throws CloneNotSupportedException {
		Laeufer figure = new Laeufer(farbe);
		return figure;
	}

	

}
