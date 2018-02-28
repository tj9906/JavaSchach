package de.allainz.javapraxis.schach.gui;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.allianz.javapraxis.schach.Schach;
import de.allianz.javapraxis.schach.Spieler;
import de.allianz.javapraxis.schach.exception.InvalideKoordinatenException;
import de.allianz.javapraxis.schach.feld.Bord;
import de.allianz.javapraxis.schach.feld.koordinate.BordKoordinate;
import de.allianz.javapraxis.schach.figur.Figur;

public class GUI {
	private Display display = new Display();
	private Shell shell = new Shell(display); // Fenster
	private final Canvas[][] array = new Canvas[SIZE][SIZE]; // Einzelnen Felder
	private Color COLOR_LIGHTBROWN = new Color(display, 255, 192, 100); // Farben
	private Color COLOR_DARKBROWN = new Color(display, 153, 51, 0);
	public static final int SIZE = 8; // Anzahl der Felder
	public static final int SIZEFELDER = 80;
	public static Schach schach;
	private static Text konsole;
	private static BordKoordinate start;
	private static BordKoordinate ziel;
	private static int anzahlZuege;

	public static void main(String[] args) throws InvalideKoordinatenException, IOException {
		GUI view = new GUI();
		view.init();
	}

	public GUI() throws InvalideKoordinatenException, IOException {
		schach = new Schach();

	}

	public void init() throws InvalideKoordinatenException, IOException {
		char buchstabe;
		anzahlZuege = 0;
		start = null;
		ziel = null;
		shell.setSize(SIZEFELDER * 10 + 300, SIZEFELDER * 11);
		shell.setText("Schachspiel von Thomas <3");
		Font fontBorder = new Font(display, "Courier New", 20, SWT.BOLD);

		for (int column = 0; column < SIZE; column++) {
			for (int row = 0; row < SIZE; row++) {
				array[column][row] = new Canvas(shell, SWT.BORDER);
				array[column][row].setBounds(column * SIZEFELDER + SIZEFELDER, (8 - row) * SIZEFELDER, SIZEFELDER,
						SIZEFELDER);
				array[column][row].addMouseListener(new MouseListener() {

					@Override
					public void mouseDoubleClick(org.eclipse.swt.events.MouseEvent arg0) {
						// TODO Auto-generated method stub
					}

					@Override
					public void mouseDown(org.eclipse.swt.events.MouseEvent arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseUp(org.eclipse.swt.events.MouseEvent e) {
						// TODO Auto-generated method stub
						// System.out.println("Maus Up");

						// System.out.println("Feld besetzt");
						Canvas hier = (Canvas) e.getSource();
						for (int spalte = 0; spalte < array.length; spalte++) {
							for (int zeile = 0; zeile < array.length; zeile++) {
								if (array[spalte][zeile] == hier) {
									// System.out.println("Feld gefunden");
									try {

										if (start == null) {
											start = new BordKoordinate(spalte, zeile);
											break;
										} else {
											ziel = new BordKoordinate(spalte, zeile);
											@SuppressWarnings("static-access")
											Figur fig1 = schach.spiel.getBord().getFigurAuf(start);
											if (fig1 == null) {
												throw new InvalideKoordinatenException(
														"####Falsche Koordinate!####\n####Feld ist frei!####");
											}
											if (ziehe(start, ziel)) {
												fig1.loescheErsterMove();
											}
											start = null;
											ziel = null;
										}
										draw();
									} catch (InvalideKoordinatenException e1) {
										// TODO Auto-generated catch
										addText(e1.getMessage());
										e1.printStackTrace();
										start = null;
										ziel = null;
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
										start = null;
										ziel = null;
										addText("####Ein Fehler ist aufgetreten!####\n----Bitte Wiederholen!----");
									} catch (NullPointerException e1) {
										e1.printStackTrace();
										start = null;
										ziel = null;
										addText("####Ein Fehler ist aufgetreten!####\n----Bitte Wiederholen!----");
									} catch (CloneNotSupportedException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
										start = null;
										ziel = null;
										addText("####Ein Fehler ist aufgetreten!####\n----Bitte Wiederholen!----");
									}
								}
							}
							// addText(start.toString());
						}
					}

				});

				// ich lübe Dhomas
				// !!♥MıU UM5M♣
				// 5♣§!♥

				Label links = new Label(shell, SWT.NONE);
				Label rechts = new Label(shell, SWT.NONE);
				Label oben = new Label(shell, SWT.NONE);
				Label unten = new Label(shell, SWT.NONE);
				buchstabe = (char) (row + 'A');
				oben.setBounds(SIZEFELDER + 40 + (row * SIZEFELDER), SIZEFELDER / 2, SIZEFELDER / 2, 25);
				oben.setFont(fontBorder);
				oben.setText(String.valueOf(buchstabe));
				unten.setBounds(SIZEFELDER + 40 + (row * SIZEFELDER), SIZEFELDER * 9 + 10, SIZEFELDER / 2, 25);
				unten.setFont(fontBorder);
				unten.setText(String.valueOf(buchstabe));
				links.setBounds(40, SIZEFELDER + 30 + (row * SIZEFELDER), SIZEFELDER / 2, 25);
				links.setFont(fontBorder);
				links.setText(String.valueOf(8 - row));
				rechts.setBounds(SIZEFELDER * 9 + 10, SIZEFELDER + 30 + (row * SIZEFELDER), SIZEFELDER / 2, 25);
				rechts.setFont(fontBorder);
				rechts.setText(String.valueOf(8 - row));
			}
		}

		// Später einfügen
		konsole = new Text(shell, SWT.MULTI | SWT.V_SCROLL);
		konsole.setBounds(SIZEFELDER * 10, SIZEFELDER, 300, SIZEFELDER * 8);
		konsole.setEditable(false);
		konsole.getScrollbarsMode();
		addText("Es spielt: " + player().toString());
		draw();
		shell.open();
		draw();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	public void drawPic() throws InvalideKoordinatenException {
		@SuppressWarnings("static-access")
		Bord brett = schach.spiel.getBord();
		for (int spalte = 0; spalte < 8; spalte++) {
			for (int zeile = 0; zeile < 8; zeile++) {
				if (brett.getFigurAuf(new BordKoordinate(spalte, zeile)) != null) {
					char bezeichner = brett.getFigurAuf(new BordKoordinate(spalte, zeile)).toString().charAt(0);
					String file = ".\\resources\\200px-Chess_";
					switch (bezeichner) {
					case 'L':
						file += "bd";
						break;
					case 'l':
						file += "bl";
						break;
					case 'K':
						file += "kd";
						break;
					case 'k':
						file += "kl";
						break;
					case 'S':
						file += "nd";
						break;
					case 's':
						file += "nl";
						break;
					case 'D':
						file += "qd";
						break;
					case 'd':
						file += "ql";
						break;
					case 'T':
						file += "rd";
						break;
					case 't':
						file += "rl";
						break;
					case 'B':
						file += "pd";
						break;
					case 'b':
						file += "pl";
						break;
					default:
						break;
					}
					file += "t45.svg.gif";
					Image i = new Image(display, file);
					Image is = new Image(display, i.getImageData().scaledTo(SIZEFELDER, SIZEFELDER));

					if (spalte % 2 == zeile % 2) {
						is.setBackground(COLOR_DARKBROWN);
					} else {
						is.setBackground(COLOR_LIGHTBROWN);
					}
					array[spalte][zeile].setBackgroundImage(is);
				}
			}
		}
	}

	private boolean ziehe(BordKoordinate start, BordKoordinate ziel)
			throws InvalideKoordinatenException, IOException, NullPointerException, CloneNotSupportedException {
		// TODO Auto-generated method stub
		if (schach.eingabeZug(player().getFarbe(), start, ziel, this)) {
			anzahlZuege++;
			addText("Es spielt: " + player().toString());
			return true;
		} else {
			addText("----Bitte wiederholen!----");
			return false;
		}
	}

	@SuppressWarnings("static-access")
	private Spieler player() {
		Spieler[] spielerFeld = new Spieler[2];
		spielerFeld[0] = schach.spiel.getSpieler1();
		spielerFeld[1] = schach.spiel.getSpieler2();

		if (anzahlZuege % 2 == 0) {
			return spielerFeld[0];
		} else {
			return spielerFeld[1];
		}
	}

	public void draw() throws InvalideKoordinatenException {

		for (int column = 0; column < SIZE; column++) {

			for (int row = 0; row < SIZE; row++) {

				Image imageOld = array[column][row].getBackgroundImage();
				if (imageOld != null) {
					imageOld.dispose();
				}
				array[column][row].setBackgroundImage(null);

				if (column % 2 == row % 2) // modulo formel um jedes zweite Feld
											// zu färben

				{
					array[column][row].setBackground(COLOR_DARKBROWN);
				} else {
					array[column][row].setBackground(COLOR_LIGHTBROWN);
				}
			}
		}
		drawPic();

	}

	public void addText(String neu) {
		konsole.setText("\n" + neu + konsole.getText());
	}

	public void gewinnerFenster() throws InvalideKoordinatenException {
		draw();
		int ergebniss = JOptionPane.showOptionDialog(null,
				"Gewinner ist: " + player().getFarbe().toString() + "\nNochmal?", "Gewinner",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
				new String[] { "Ja!", "Zeige Bild" }, "Ja!");
		if (ergebniss == 0) {
			this.display.dispose();
			GUI guiNeu;
			try {
				guiNeu = new GUI();
				guiNeu.init();
			} catch (InvalideKoordinatenException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			for (int column = 0; column < SIZE; column++) {
				for (int row = 0; row < SIZE; row++) {
					array[column][row] = new Canvas(shell, SWT.BORDER);
					array[column][row].setBounds(column * SIZEFELDER + SIZEFELDER, (8 - row) * SIZEFELDER, SIZEFELDER,
							SIZEFELDER);
					array[column][row].setEnabled(false);
					
				}
			}
		}
	}
}
