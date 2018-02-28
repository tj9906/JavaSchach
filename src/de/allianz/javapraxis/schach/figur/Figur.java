package de.allianz.javapraxis.schach.figur;

import java.util.ArrayList;
import java.util.List;

import de.allianz.javapraxis.schach.exception.InvalideKoordinatenException;
import de.allianz.javapraxis.schach.feld.Bord;
import de.allianz.javapraxis.schach.feld.Feld;
import de.allianz.javapraxis.schach.feld.koordinate.*;

public abstract class Figur {
	protected FARBE farbe;
	protected List<GehKoordinate> zuege = new ArrayList<>();
	protected boolean ersterMove = true;

	public Figur(FARBE farbe) {
		this.farbe = farbe;
	}

	public FARBE getFarbe() {
		return farbe;
	}

	@Override
	public abstract String toString();

	/**
	 * erstellt eine Liste mit den Möglichen Ziel Koordinaten der eigenen Figur
	 * 
	 * @param bkor
	 * @param board
	 * @return List<BordKoordinate>
	 * @throws InvalideKoordinatenException
	 */
	public List<BordKoordinate> bewegungsregeln(BordKoordinate bkor, Bord board) throws InvalideKoordinatenException {
		// Liste zur Rückgabe
		List<BordKoordinate> regeln = new ArrayList<>();
		// bkor ist die aktuelle Koordinate
		int spalte = bkor.getSpalte();
		int zeile = bkor.getZeile();
		// be ist meine neue Koordinate, die erreichbar ist
		BordKoordinate be = null;
		// Gehe durch die ArrayList um jedes bewegugsmuster abzugreifen
		for (GehKoordinate akt : zuege) {
			// Setzte meine Aktuellen werte
			int aktOffset = akt.getOffset();
			int aktSpalte = akt.getSpalte();
			int aktZeile = akt.getZeile();
			// Hier könnte er hin (Zielspalte oder Zielzeile)
			int zielSpalte = spalte;
			int zielZeile = zeile;
			// Laufe den Offset ab, um alle Ziele zu erfahren
			for (int i = 1; i <= aktOffset; i++) {
				zielSpalte += aktSpalte;
				zielZeile += aktZeile;
				// Liegt das Ziel im Feld
				if (zielSpalte < 8 && zielZeile < 8 && zielSpalte >= 0 && zielZeile >= 0) {
					be = new BordKoordinate(zielSpalte, zielZeile);
					// Breche ab, wenn auf dem Ziel feld ein eigener steht
					if (board.getFigurAuf(be) != null && board.getFigurAuf(be).getFarbe() == this.getFarbe()) {
						break;
						// sonst füge hinzu und breche ab, wenn es ein Gegner
						// ist, der Geschlagen werden kann
					} else if (board.getFigurAuf(be) != null && this.getFarbe() != board.getFigurAuf(be).getFarbe()) {
						// Änderung von bis
						// ----------------------------------------------------
						if (this instanceof Bauer) {
							if (bkor.getSpalte() != zielSpalte) {

								regeln.add(be);
								break;
							}
							break;
						}
						// Änderung von bis
						// ----------------------------------------------------
						regeln.add(be);
						break;
					}
					regeln.add(be);
				}
			}
		}
		// Überprüfe ob es der erste Move war, um den Bauer einzuschränken
		/*
		 * if(this.ersterMove){ System.out.println("Das war der erste Streich!"
		 * ); //this.loescheErsterMove(); this.ersterMove = false; }
		 */
		return regeln;
	}

	public void loescheErsterMove() {
		System.out.println("Lösche nicht Bauer");
	}

	@Override
	public abstract Figur clone() throws CloneNotSupportedException ;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ersterMove ? 1231 : 1237);
		result = prime * result + ((farbe == null) ? 0 : farbe.hashCode());
		result = prime * result + ((zuege == null) ? 0 : zuege.hashCode());
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
		if (!(obj instanceof Figur)) {
			return false;
		}
		Figur other = (Figur) obj;
		if (ersterMove != other.ersterMove) {
			return false;
		}
		if (farbe != other.farbe) {
			return false;
		}
		if (zuege == null) {
			if (other.zuege != null) {
				return false;
			}
		} else if (!zuege.equals(other.zuege)) {
			return false;
		}
		return true;
	}
	
	public List<GehKoordinate> getGehKoor() {
		return zuege;
	}

}
