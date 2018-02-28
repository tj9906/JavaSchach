package de.allianz.javapraxis.schach.figur;

import de.allianz.javapraxis.schach.feld.Feld;
import de.allianz.javapraxis.schach.feld.koordinate.GehKoordinate;

public class Turm extends Figur {

	public Turm(FARBE farbe) {
		super(farbe);
		// TODO Auto-generated constructor stub
		zuege.add(new GehKoordinate(0, 1, 7));
		zuege.add(new GehKoordinate(1, 0, 7));
		zuege.add(new GehKoordinate(0, -1, 7));
		zuege.add(new GehKoordinate(-1, 0, 7));
	}
	
	@Override
	public String toString() {
		if(farbe == FARBE.SCHWARZ)
			return "T";
		else
			return "t";
	}

	@Override
	public Turm clone() throws CloneNotSupportedException {
		Turm figure = new Turm(farbe);
		return figure;
	}
	
}
