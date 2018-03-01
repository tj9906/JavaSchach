package de.allianz.javapraxis.schach;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import de.allianz.javapraxis.schach.exception.InvalideKoordinatenException;
import de.allianz.javapraxis.schach.feld.koordinate.BordKoordinate;
import de.allianz.javapraxis.schach.figur.Bauer;
import de.allianz.javapraxis.schach.figur.FARBE;
import de.allianz.javapraxis.schach.figur.Figur;
import de.allianz.javapraxis.schach.gui.GUI;

public class Schach {
	public Spiel spiel = new Spiel();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((spiel == null) ? 0 : spiel.hashCode());
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
		if (!(obj instanceof Schach)) {
			return false;
		}
		Schach other = (Schach) obj;
		if (spiel == null) {
			if (other.spiel != null) {
				return false;
			}
		} else if (!spiel.equals(other.spiel)) {
			return false;
		}
		return true;
	}

	public Schach() {
		spiel.spieleSchach();
		System.out.println(spiel.getSpieler1());
	}

	/**
	 * erstellt die Eingabe und Wiederholt im Fehler Fall Erstellt die
	 * Koordinaten Fängt ab, ob es eine eigene Figur ist, und ob der Move
	 * möglich ist
	 * 
	 * @param farbe
	 * @param gui
	 * @throws InvalideKoordinatenException
	 * @throws IOException
	 * @throws CloneNotSupportedException
	 */
	public boolean eingabeZug(FARBE farbe, BordKoordinate von, BordKoordinate nach, GUI gui)
			throws InvalideKoordinatenException, IOException, NullPointerException, CloneNotSupportedException {
		if (farbe == spiel.getBord().getFigurAuf(von).getFarbe()) {
			if (macheZug(von.toString(), nach.toString(), gui)) {
				gui.addText("----Zug valide!----");

				FARBE farbeGeg;
				if (farbe == FARBE.WEISS) {
					farbeGeg = FARBE.SCHWARZ;
				} else {
					farbeGeg = FARBE.WEISS;
				}
				if (stehtSchach(farbeGeg, spiel.getBord().getKoorKoenig(farbeGeg)) == STEHTSCHACH.JA) {
					gui.addText("----SCHACH!!----");
				}
				if (spiel.getBord().getKoorKoenig(farbeGeg) == null || gameOver(farbeGeg, gui)) {
					gui.gewinnerFenster(farbe);
					return false;
				}
				return true;
			}
		}
		gui.addText("----Spiele deine Eigenen Figuren!----");
		return false;
	}

	/**
	 * Liest die Eingabe
	 * 
	 * @return eingabe
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private String getEingabe() throws IOException {
		System.out.println("Formvorlage:\nA1 A2");
		String eingabe = new BufferedReader(new InputStreamReader(System.in)).readLine();
		return eingabe;
	}

	/**
	 * ermittelt, ob die bewegung möglich ist
	 * 
	 * @param von
	 * @param nach
	 * @return istMoeglich?
	 * @throws InvalideKoordinatenException
	 */
	public boolean macheZug(String von, String nach, GUI gui) throws InvalideKoordinatenException {
		if (spiel.getBord().getFigurAuf(new BordKoordinate(von)) != null) {
			if (gui != null) {
				gui.addText(spiel.getBord().getFigurAuf(new BordKoordinate(von)) + " von: " + von + " nach: " + nach);
			}
			return ziehe(mglZuege(new BordKoordinate(von)), new BordKoordinate(von), new BordKoordinate(nach), gui);
		} else {
			return false;
		}
	}

	/**
	 * führt den Zug durch, falls er möglich ist
	 * 
	 * @param mglZuege
	 * @param startKoor
	 * @param zielKoor
	 * @return istZugGemacht
	 */
	public boolean ziehe(List<BordKoordinate> mglZuege, BordKoordinate startKoor, BordKoordinate zielKoor, GUI gui) {
		// TODO Auto-generated method stub
		if (mglZuege.remove(zielKoor)) {
			Figur fig = spiel.getBord().getFigurAuf(startKoor);
			spiel.getBord().setFigurAuf(zielKoor, fig);
			spiel.getBord().setFigurAuf(startKoor, null);
			return true;
		} else {
			if (gui != null) {
				gui.addText("----Ziel Koordinate kann nicht erreicht werden!----");
			}
			return false;
		}
	}

	/**
	 * Liefert die Möglichen Züge unter berücksichtigung der Schläge
	 * 
	 * @param koor
	 * @return liste moeglich Zuege
	 */
	private List<BordKoordinate> mglZuege(BordKoordinate koor) {
		try {
			List<BordKoordinate> mglZuege = spiel.getBord().getFigurAuf(koor).bewegungsregeln(koor, spiel.getBord());
			List<BordKoordinate> schlagZuege = new ArrayList<>();
			Figur eigeneFigur = spiel.getBord().getFigurAuf(koor);

			// Überprüft für jeden Eintrag in mglZuege, ob dort eine Figur steht
			// und Schlagbare ist
			for (BordKoordinate akt : mglZuege) {
				Figur zielFigur;
				zielFigur = spiel.getBord().getFigurAuf(new BordKoordinate(akt.getSpalte(), akt.getZeile()));
				if (zielFigur != null) {
					if (zielFigur.getFarbe() != eigeneFigur.getFarbe()) {
						schlagZuege.add(akt);
					}
				}
			}
			System.out.println("Schlagen auf: " + schlagZuege);

			// Hier wird für den Bauer das Schlagen ausgearbeitet
			if (eigeneFigur instanceof Bauer) {

				for (BordKoordinate curr : mglZuege) {

					if (curr.getSpalte() - 1 == koor.getSpalte() || curr.getSpalte() + 1 == koor.getSpalte()) {
						mglZuege.set(mglZuege.indexOf(curr), null);
					}

				}

				// Loesche Null einträge
				for (int i = mglZuege.size() - 1; i >= 0; i--) {
					BordKoordinate akt = mglZuege.get(i);
					if (akt instanceof BordKoordinate) {
						// tue nichts
					} else {
						mglZuege.remove(akt);
					}
				}
				for (int i = schlagZuege.size() - 1; i >= 0; i--) {
					BordKoordinate akt = schlagZuege.get(i);
					if (akt instanceof BordKoordinate) {
						// tue nichts
					} else {
						mglZuege.remove(akt);
					}
				}
				for (BordKoordinate current : schlagZuege) {
					mglZuege.add(current);
				}
			}
			// Ausgabe und Rückgabe
			System.out.println("Möglich: " + mglZuege);
			return mglZuege;
		} catch (InvalideKoordinatenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * Steht die Figur Schach?
	 * 
	 * @param farbe
	 * @param koorKoenig
	 * @return
	 * @throws InvalideKoordinatenException
	 */
	public STEHTSCHACH stehtSchach(FARBE farbe, BordKoordinate koorKoenig) throws InvalideKoordinatenException {
		List<BordKoordinate> figGegner = new ArrayList<>();
		if (farbe == FARBE.WEISS) {
			figGegner = spiel.getBord().getKoorVonFarbe(FARBE.SCHWARZ);
		} else {
			figGegner = spiel.getBord().getKoorVonFarbe(FARBE.WEISS);
		}
		List<BordKoordinate> mglZiele = new ArrayList<>();

		for (BordKoordinate koor : figGegner) {
			List<BordKoordinate> mglZieleProFig = spiel.getBord().getFigurAuf(koor).bewegungsregeln(koor,
					spiel.getBord());
			for (BordKoordinate curr : mglZieleProFig) {
				mglZiele.add(curr);
			}
		}
		if (mglZiele.remove(koorKoenig)) {
			return STEHTSCHACH.JA;
		}
		return STEHTSCHACH.NEIN;
	}

	public boolean gameOver(FARBE farbe, GUI gui) throws InvalideKoordinatenException, CloneNotSupportedException {
		List<BordKoordinate> posEig = spiel.getBord().getKoorVonFarbe(farbe);

		for (BordKoordinate curr : posEig) {
			Schach klon = clone();
			List<BordKoordinate> zieleEig = klon.spiel.getBord().getFigurAuf(curr).bewegungsregeln(curr,
					klon.spiel.getBord());
			for (BordKoordinate aktZ : zieleEig) {
				Schach klon2 = clone();
				try {
					klon2.macheZug(curr.toString(), aktZ.toString(), null);
				} catch (Exception e) {
					// TODO: handle exception
					klon2.macheZug(curr.toString(), aktZ.toString(), null);
				} finally {

					if (klon2.stehtSchach(farbe, klon2.spiel.getBord().getKoorKoenig(farbe)) != STEHTSCHACH.JA) {

						if (klon2.stehtMatt(farbe,
								klon2.spiel.getBord().getKoorKoenig(farbe)) != STEHTSCHACH.SCHACHMATT) {
							return false;
						}
					}
				}

			}
		}
		return true;
	}

	public STEHTSCHACH stehtMatt(FARBE farbe, BordKoordinate koorKoenig) throws InvalideKoordinatenException {
		List<STEHTSCHACH> auswahl = new ArrayList<>();
		List<BordKoordinate> mglKoenig = new ArrayList<>();

		mglKoenig = spiel.getBord().getFigurAuf(koorKoenig).bewegungsregeln(koorKoenig, spiel.getBord());

		for (BordKoordinate aktKoor : mglKoenig) {
			auswahl.add(stehtSchach(farbe, aktKoor));
		}
		auswahl.add(stehtSchach(farbe, koorKoenig));
		if (!auswahl.remove(STEHTSCHACH.NEIN)) {
			return STEHTSCHACH.SCHACHMATT;
		}
		return STEHTSCHACH.JA;
	}

	@Override
	public Schach clone() throws CloneNotSupportedException {
		Schach neu = new Schach();
		neu.spiel = spiel.clone();
		return neu;
	}
}
