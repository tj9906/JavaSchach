package de.allianz.javapraxis.schach.feld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.allianz.javapraxis.schach.exception.InvalideKoordinatenException;
import de.allianz.javapraxis.schach.feld.koordinate.BordKoordinate;
import de.allianz.javapraxis.schach.figur.Bauer;
import de.allianz.javapraxis.schach.figur.Dame;
import de.allianz.javapraxis.schach.figur.FARBE;
import de.allianz.javapraxis.schach.figur.Figur;
import de.allianz.javapraxis.schach.figur.Koenig;
import de.allianz.javapraxis.schach.figur.Laeufer;
import de.allianz.javapraxis.schach.figur.Springer;
import de.allianz.javapraxis.schach.figur.Turm;

public class Bord {
	//------------------------------------
	private Feld[][] brett;
	
	//------------------------------------
	public Bord() {
		brett = new Feld[8][8];
		feldErzeugen();
		erzeugeStartaufstellung();
	}

	//----------------------------------
	/**
	 * Wandle das Feld in ein druckbaren String um
	 * @return Feld als String
	 */
	public String print() {
		String text = "   A    B    C    D    E    F    G    H  \n";
		for (int zeile = brett.length - 1; zeile >= 0; zeile--) {
			text += zeile + 1;
			for (int spalte = 0; spalte < brett[zeile].length; spalte++) {
				text += brett[spalte][zeile].toString();
			}
			text += zeile + 1;
			text += "\n";
		}
		text += "   A    B    C    D    E    F    G    H  \n";
		return text;
	}

	/**
	 * erzeuge die Start aufstellung, Weiss unten, schwarz oben
	 */
	private void erzeugeStartaufstellung() {
		// Stelle Bauer auf
		for (int spalte = 0; spalte < brett.length; spalte++) {
			brett[spalte][1].setFigur(new Bauer(FARBE.WEISS));
			brett[spalte][6].setFigur(new Bauer(FARBE.SCHWARZ));
		}
		// Stelle Turm auf
		brett[0][0].setFigur(new Turm(FARBE.WEISS));
		brett[7][0].setFigur(new Turm(FARBE.WEISS));
		brett[0][7].setFigur(new Turm(FARBE.SCHWARZ));
		brett[7][7].setFigur(new Turm(FARBE.SCHWARZ));
		// Stelle Springer auf
		brett[1][0].setFigur(new Springer(FARBE.WEISS));
		brett[6][0].setFigur(new Springer(FARBE.WEISS));
		brett[1][7].setFigur(new Springer(FARBE.SCHWARZ));
		brett[6][7].setFigur(new Springer(FARBE.SCHWARZ));
		// Stelle L�ufer auf
		brett[2][0].setFigur(new Laeufer(FARBE.WEISS));
		brett[5][0].setFigur(new Laeufer(FARBE.WEISS));
		brett[2][7].setFigur(new Laeufer(FARBE.SCHWARZ));
		brett[5][7].setFigur(new Laeufer(FARBE.SCHWARZ));
		// Stelle Springer auf
		brett[3][0].setFigur(new Dame(FARBE.WEISS));
		brett[4][0].setFigur(new Koenig(FARBE.WEISS));
		brett[3][7].setFigur(new Dame(FARBE.SCHWARZ));
		brett[4][7].setFigur(new Koenig(FARBE.SCHWARZ));

	}

	/**
	 * erzeugt das Feld, stellt sicher, und sorgt f�r die richtige Farbe der Felder
	 */
	private void feldErzeugen() {
		for (int spalte = 0; spalte < brett.length; spalte++) {
			for (int zeile = brett.length - 1; zeile >= 0; zeile--) {
				if ((spalte + zeile) % 2 == 0) {
					brett[spalte][zeile] = new Feld(null, false);
				} else {
					brett[spalte][zeile] = new Feld(null, true);
				}

			}
		}

	}

	/**
	 * 
	 * @param koordinate
	 * @return Figur auf der eingegeben Koordinate
	 */
	public Figur getFigurAuf(BordKoordinate koordinate) {
		return brett[koordinate.getSpalte()][koordinate.getZeile()].getFigur();
	}

	/**
	 * Setzt auf Koordinate die Figur xy
	 * @param koordinate
	 * @param figur
	 */
	public void setFigurAuf(BordKoordinate koordinate, Figur figur) {
		brett[koordinate.getSpalte()][koordinate.getZeile()].setFigur(figur);
	}

	/**
	 * Gibt alle Positionen zur�ck, die von farbe besetzt sind
	 * @param farbe
	 * @return List<BordKoordinate>
	 * @throws InvalideKoordinatenException
	 */
	public List<BordKoordinate> getKoorVonFarbe(FARBE farbe) throws InvalideKoordinatenException {
		List<BordKoordinate> gegner = new ArrayList<>();
		
		for (int spalte = 0; spalte < brett.length; spalte++) {
			for (int zeile = 0; zeile < brett.length; zeile++) {
				if(brett[spalte][zeile].getFigur() != null && brett[spalte][zeile].getFigur().getFarbe() == farbe){
					gegner.add(new BordKoordinate(spalte, zeile));
				}
			}
		}
		
		return gegner;
	}

	/**
	 * Gibt die Koordinate des Koenigs der farbe zur�ck
	 * @param farbe
	 * @return BordKoordinate
	 * @throws InvalideKoordinatenException
	 */
	public BordKoordinate getKoorKoenig(FARBE farbe) throws InvalideKoordinatenException {
		// TODO Auto-generated method stub
		BordKoordinate koorKoenig = null;
		for (int spalte = 0; spalte < brett.length; spalte++) {
			for (int zeile = 0; zeile < brett.length; zeile++) {
				if(brett[spalte][zeile].getFigur() instanceof Koenig && brett[spalte][zeile].getFigur().getFarbe() == farbe){
					koorKoenig = new BordKoordinate(spalte, zeile);
				}
			}
		}
		return koorKoenig;
	}
	
	/*public Bord cloneThis() throws CloneNotSupportedException{
		return (Bord) this.clone();
	}*/

	
	@Override
	public Bord clone() throws CloneNotSupportedException {
		Bord neu = new Bord();
		for(int spalte = 0; spalte < 8; spalte++){
			for (int zeile = 0; zeile < 8; zeile++){
				if(brett[spalte][zeile].getFigur() != null){
					neu.brett[spalte][zeile] = brett[spalte][zeile].clone();
				}else{
					neu.brett[spalte][zeile] = new Feld(null, brett[spalte][zeile].isIstSchwarz());
				}
			}
		}
		return neu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(brett);
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
		if (!(obj instanceof Bord)) {
			return false;
		}
		Bord other = (Bord) obj;
		for(int spalte = 0; spalte < 8; spalte++){
			for (int zeile = 0; zeile < 8; zeile++){
				if(!brett[spalte][zeile].equals(other.brett[spalte][zeile])){
					return false;
				}
			}
		}
		return true;
	}

}


