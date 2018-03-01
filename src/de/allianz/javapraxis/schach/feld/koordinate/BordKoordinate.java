package de.allianz.javapraxis.schach.feld.koordinate;

import de.allianz.javapraxis.schach.exception.InvalideKoordinatenException;

public class BordKoordinate extends Koordinate {

	public BordKoordinate() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Erstellt eine BordKoordinate aus 2 int
	 * 
	 * @param spalte
	 * @param zeile
	 * @throws InvalideKoordinatenException
	 */
	public BordKoordinate(int spalte, int zeile) throws InvalideKoordinatenException {
		setSpalte(spalte);
		setZeile(zeile);
	}

	/**
	 * Erstellt eine BordKoordinate aus einem String
	 * 
	 * @param koor
	 * @throws InvalideKoordinatenException
	 */
	public BordKoordinate(String koor) throws InvalideKoordinatenException {
		String regex = "[A-H]{1}[1-8]{1}";
		if (koor.matches(regex)) {
			int zeile = Integer.parseInt(koor.substring(1)) - 1;
			int spalte;
			char c = (char) koor.charAt(0);
			switch (c) {
			case 'A': case 'a':
				spalte = 0;
				break;
			case 'B': case 'b':
				spalte = 1;
				break;
			case 'C': case 'c':
				spalte = 2;
				break;
			case 'D': case 'd':
				spalte = 3;
				break;
			case 'E': case 'e':
				spalte = 4;
				break;
			case 'F': case 'f':
				spalte = 5;
				break;
			case 'G': case 'g':
				spalte = 6;
				break;
			case 'H': case 'h':
				spalte = 7;
				break;

			default:
				spalte = -1;
				break;
			}
			setSpalte(spalte);
			setZeile(zeile);
		} else {
			throw new InvalideKoordinatenException("Falsches Format!!");
		}
	}
	
	/**
	 * setzt die Spalte
	 * @throws InvalideKoordinatenException
	 */
	@Override
	public void setSpalte(int spalte) throws InvalideKoordinatenException {
		if (spalte > 7 || spalte < 0) {
			throw new InvalideKoordinatenException("Koordinaten (spalte) liegen nicht auf dem Brett!");
		}
		this.spalte = spalte;
	}
	
	/**
	 * setzt die Spalte
	 * @throws InvalideKoordinatenException
	 */
	@Override
	public void setZeile(int zeile) {
		try {
			if (zeile > 7 || zeile < 0) {
				throw new InvalideKoordinatenException("Koordinaten (Zeile) liegen nicht auf dem Brett!");
			}
			this.zeile = zeile;
		} catch (InvalideKoordinatenException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	/**
	 * erstellt einen String in form von A2
	 */
	@Override
	public String toString() {
		String help = "";
		switch (spalte) {
		case 0:
			help = "A";
			break;
		case 1:
			help = "B";
			break;
		case 2:
			help = "C";
			break;
		case 3:
			help = "D";
			break;
		case 4:
			help = "E";
			break;
		case 5:
			help = "F";
			break;
		case 6:
			help = "G";
			break;
		case 7:
			help = "H";
			break;

		default:
			help = "X";
			break;
		}
		return help + (zeile + 1);
	}
	
	@SuppressWarnings("finally")
	@Override
	public BordKoordinate clone() throws CloneNotSupportedException {
		BordKoordinate koor = null;
		try {
			koor = new BordKoordinate(spalte, zeile);
		} catch (InvalideKoordinatenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return koor;
		}
		
	}
}
