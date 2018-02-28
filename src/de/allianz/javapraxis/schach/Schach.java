package de.allianz.javapraxis.schach;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import de.allainz.javapraxis.schach.gui.GUI;
import de.allianz.javapraxis.schach.exception.InvalideKoordinatenException;
import de.allianz.javapraxis.schach.feld.Bord;
import de.allianz.javapraxis.schach.feld.koordinate.BordKoordinate;
import de.allianz.javapraxis.schach.feld.koordinate.GehKoordinate;
import de.allianz.javapraxis.schach.figur.Bauer;
import de.allianz.javapraxis.schach.figur.FARBE;
import de.allianz.javapraxis.schach.figur.Figur;

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
	 * Start Alles
	 * 
	 * @param args
	 */
	/*
	 * public static void main(String[] args) { // erstellt spieler in der
	 * Konsole try { spiel.spieleSchach(); System.out.println("Spieler 1:");
	 * String eingabe = new BufferedReader(new
	 * InputStreamReader(System.in)).readLine(); spiel.setSpieler1(new
	 * Spieler(eingabe, FARBE.WEISS)); System.out.println("Spieler 2:"); eingabe
	 * = new BufferedReader(new InputStreamReader(System.in)).readLine();
	 * spiel.setSpieler2(new Spieler(eingabe, FARBE.SCHWARZ));
	 * System.out.println(spiel.getBord().print()); } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * Spieler[] spielerfeld = new Spieler[2]; spielerfeld[0] =
	 * spiel.getSpieler1(); spielerfeld[1] = spiel.getSpieler2();
	 * 
	 * int i = 0; do { // Muss immer Laufen für die Eingabe try { while (i <
	 * spielerfeld.length) { System.out.println(spielerfeld[i] +
	 * ": Du bist an der Reihe!"); eingabeZug(spielerfeld[i].getFarbe(),
	 * spielerfeld[i].isStehtSchach()); i++; } i = 0; } catch
	 * (InvalideKoordinatenException e) { // TODO: handle exception
	 * System.out.println(e.getMessage()); } catch (Exception e) { // TODO:
	 * handle exception e.printStackTrace(); }
	 * 
	 * } while (true);
	 * 
	 * }
	 */

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
		// zug = getEingabe();
		// String Validierung für Längere Eingaben
		// String pruefe = "[A-H]{1}[1-8]{1} [A-H]{1}[1-8]{1}";
		/*
		 * if (zug.matches(pruefe)) { String koor1 = zug.substring(0, 2); String
		 * koor2 = zug.substring(3, 5);
		 */
		// Schach schach2 = (Schach) clone();
		// Schach schach2 = (Schach) this.clone();
		// ----------------------------------------------------------------------

		/*
		 * if (schach2.macheZug(von.toString(), nach.toString(), gui)) {
		 * BordKoordinate koorKoenig = spiel.getBord().getKoorKoenig(farbe); if
		 * (schach2.stehtSchach(farbe, koorKoenig) == STEHTSCHACH.JA) { if
		 * (schach2.stehtMatt(farbe, koorKoenig) == STEHTSCHACH.SCHACHMATT) {
		 * gui.addText("----Schach Matt!----\n----Das Spiel ist aus!----\n****"
		 * + farbe + " gewinnt!!****"); return false; } } }
		 */
		// ---------------------------------------------------------------------
		/*
		 * BordKoordinate koorKoenig = spiel.getBord().getKoorKoenig(farbe); if
		 * (stehtSchach(farbe, koorKoenig) == STEHTSCHACH.JA) { if
		 * (stehtMatt(farbe, koorKoenig) == STEHTSCHACH.SCHACHMATT) {
		 * gui.addText("----Schach Matt!----\n----Das Spiel ist aus!----\n****"
		 * + farbe + " gewinnt!!****"); return false; }
		 */

		/*
		 * 
		 * Schach schach2 = (Schach) this.clone();
		 * schach2.macheZug(von.toString(), nach.toString(), gui);
		 * 
		 * if(schach2.stehtMatt(farbe, koorKoenig) == STEHTSCHACH.NEIN){
		 * gui.addText("----Schach!----"); if (farbe ==
		 * spiel.getBord().getFigurAuf(new
		 * BordKoordinate(von.toString())).getFarbe()) { if
		 * (macheZug(von.toString(), nach.toString(), gui)) { gui.addText(
		 * "----Zug valide!----"); return true; } } return false; }else{
		 * gui.addText("----Schach!----\n----Das geht so nicht----"); return
		 * false; }
		 */

		if (farbe == spiel.getBord().getFigurAuf(new BordKoordinate(von.toString())).getFarbe()) {
			
			if (macheZug(von.toString(), nach.toString(), gui)) {
				gui.addText("----Zug valide!----");
				
				FARBE farbeGeg;
				if (farbe == FARBE.WEISS) {
					farbeGeg = FARBE.SCHWARZ;
				} else {
					farbeGeg = FARBE.WEISS;
				}
				if (spiel.getBord().getKoorKoenig(farbeGeg) == null || gameOver(farbeGeg, gui)) {
					System.out.println(spiel.getBord().print());
					//gui.draw();
					//gui.addText("****Der König ist Tot!****\n****Es lebe der König!!****");
					gui.gewinnerFenster();
					return false;
				}
				return true;
			}
		}
		// gui.addText("----Ungültige Figurauswahl!!----");
		// }
		// System.out.println("----Ungültige Eingabe!!----");
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
			gui.addText(spiel.getBord().getFigurAuf(new BordKoordinate(von)) + " von: " + von + " nach: " + nach);
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
	private boolean ziehe(List<BordKoordinate> mglZuege, BordKoordinate startKoor, BordKoordinate zielKoor, GUI gui) {
		// TODO Auto-generated method stub
		if (mglZuege.remove(zielKoor)) {
			Figur fig = spiel.getBord().getFigurAuf(startKoor);
			spiel.getBord().setFigurAuf(zielKoor, fig);
			spiel.getBord().setFigurAuf(startKoor, null);
			// System.out.println(spiel.getBord().print());
			return true;
		} else {
			gui.addText("----Ziel Koordinate kann nicht erreicht werden!----");
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
					// System.out.println(curr);
					if (curr.getSpalte() - 1 == koor.getSpalte() || curr.getSpalte() + 1 == koor.getSpalte()) {
						mglZuege.set(mglZuege.indexOf(curr), null);
					}

				}
				// Loesche Falsches Schlage

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
				try {
					klon.macheZug(curr.toString(), aktZ.toString(), null);
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					if (klon.stehtSchach(farbe, klon.spiel.getBord().getKoorKoenig(farbe)) != STEHTSCHACH.JA) {
						return false;
					}

				}

			}
		}
		return true;
		// return false;
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
