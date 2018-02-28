package de.allianz.javapraxis.schach;

import de.allianz.javapraxis.schach.feld.Bord;
import de.allianz.javapraxis.schach.figur.FARBE;
import de.allianz.javapraxis.schach.figur.Figur;

public class Spiel {
	private Spieler spieler1;
	private Spieler spieler2;
	private Bord bord;
	
	public void spieleSchach(){
		setSpieler1(new Spieler("Spieler1", FARBE.WEISS));
		setSpieler2(new Spieler("Spieler2", FARBE.SCHWARZ));
		bord = new Bord();
	}
	public Spieler getSpieler1() {
		return spieler1;
	}
	public void setSpieler1(Spieler spieler1) {
		this.spieler1 = spieler1;
	}
	public Spieler getSpieler2() {
		return spieler2;
	}
	public void setSpieler2(Spieler spieler2) {
		this.spieler2 = spieler2;
	}
	public Bord getBord() {
		return bord;
	}
	
	@Override
	public Spiel clone() throws CloneNotSupportedException {
		Spiel neu = new Spiel();
		neu.bord = bord.clone();
		neu.spieler1 = spieler1;
		neu.spieler2 = spieler2;
		return neu;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bord == null) ? 0 : bord.hashCode());
		result = prime * result + ((spieler1 == null) ? 0 : spieler1.hashCode());
		result = prime * result + ((spieler2 == null) ? 0 : spieler2.hashCode());
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
		if (!(obj instanceof Spiel)) {
			return false;
		}
		Spiel other = (Spiel) obj;
		if (bord == null) {
			if (other.bord != null) {
				return false;
			}
		} else if (!bord.equals(other.bord)) {
			return false;
		}
		if (spieler1 == null) {
			if (other.spieler1 != null) {
				return false;
			}
		} else if (!spieler1.equals(other.spieler1)) {
			return false;
		}
		if (spieler2 == null) {
			if (other.spieler2 != null) {
				return false;
			}
		} else if (!spieler2.equals(other.spieler2)) {
			return false;
		}
		return true;
	}
}
