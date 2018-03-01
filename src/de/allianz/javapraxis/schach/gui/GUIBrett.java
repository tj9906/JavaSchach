package de.allianz.javapraxis.schach.gui;
/*package de.allainz.javapraxis.schach.gui;
 
 * example snippet: Hello World
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 

import org.eclipse.swt.events.MouseAdapter;

import javax.print.attribute.standard.Sides;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import de.allianz.javapraxis.schach.exception.InvalideKoordinatenException;
import de.allianz.javapraxis.schach.feld.Bord;
import de.allianz.javapraxis.schach.feld.koordinate.BordKoordinate;

*//**
 * Zeichnet das Schachbrett mittels SWT
 * 
 * @author g7361, peter.heide@allianz.de
 * @version 2.0
 * 
 *//*
public class GUIBrett {
	*//** Verbindet Java mit OS *//*
	private Display display = new Display();
	*//** Hauptfenster *//*
	private Shell shell = new Shell(display);
	*//** Schachbrett *//*
	private final Canvas[][] feld = new Canvas[SIZE][SIZE];
	*//** Farbe Rot mit Systemfarben *//*
	private final Color COLOR_LIGHTBROWN = new Color(display, 255, 192, 100);
	*//** Farbe gr�n mit Display *//*
	private final Color COLOR_DARKBROWN = new Color(display, 153, 51, 0);
	*//** Gr��e des Schachfeldes *//*
	public static final int SIZE = 8;
	*//** Koordinate wo Anwender hingeklickt hat *//*
	public BordKoordinate koor;

	*//**
	 * Initialisiert View einmalig
	 * 
	 * @throws InvalideKoordinatenException
	 *//*

	public void init() throws InvalideKoordinatenException {
		 Shellgr��e setzen 
		shell.setSize(1000, 1000);

		for (int spalte = 0; spalte < SIZE; spalte++) {
			for (int zeile = 0; zeile < SIZE; zeile++) {

				feld[spalte][zeile] = new Canvas(shell, SWT.BORDER);
				feld[spalte][zeile].setBounds(spalte * 100 + 100, (8 - zeile) * 100, 100, 100);
				feld[spalte][zeile].addMouseListener(new MouseAdapter() {

					public void mouseDown(MouseEvent e) {
						Canvas canvas = (Canvas) e.getSource();
						for (int i = 0; i < SIZE; i++) {
							if (feld[spalte][zeile] == canvas) {
								System.out.println("Sie haben auf " + i + " geklickt"); // koor
																						// =
																						// new
								BordKoordinate(spalte, zeile);
							}
						}
						draw();
					}
				});

				if (spalte % 2 == zeile % 2) {
					feld[spalte][zeile].setBackground(COLOR_LIGHTBROWN);
				} else {
					feld[spalte][zeile].setBackground(COLOR_DARKBROWN);
				}
			}
		}

		
		 * Label lblHelloWorld = new Label(shell, SWT.NONE);
		 * lblHelloWorld.setBounds(0, 200, 216, 20); lblHelloWorld.setText(
		 * "Hello world");
		 

		Button btnKlickMich = new Button(shell, SWT.NONE);
		btnKlickMich.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Danke f�rs Klicken");
			}
		});

		shell.open();

		draw();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	*//**
	 * Zeichnet die View immer wieder
	 * 
	 * @throws InvalideKoordinatenException
	 *//*
	public void draw() throws InvalideKoordinatenException {
		for (int spalte = 0; spalte < SIZE; spalte++) {
			for (int zeile = 0; zeile < SIZE; zeile++) {
				Image imageOld = feld[spalte][zeile].getBackgroundImage();
				if (imageOld != null) {
					imageOld.dispose();
				}
				feld[spalte][zeile].setBackgroundImage(null);
				feld[spalte][zeile].setBackground(null);
				if (koor == new BordKoordinate(spalte, zeile)) {
					String fileName = ".\\resources\\200px-Chess_bdt45.svg.gif";
					Image image = new Image(display, fileName);
					Image imageScaled = new Image(display, image.getImageData().scaledTo(100, 100));
					if (spalte % 2 == zeile % 2) {
						imageScaled.setBackground(COLOR_LIGHTBROWN);
					} else {
						imageScaled.setBackground(COLOR_DARKBROWN);
					}
					feld[spalte][zeile].setBackgroundImage(imageScaled);
				} else {
					if (spalte % 2 == zeile % 2) {
						feld[spalte][zeile].setBackground(COLOR_LIGHTBROWN);
					} else {
						feld[spalte][zeile].setBackground(COLOR_DARKBROWN);
					}
				}
			}
		}
	}

	*//**
	 * Started das Programm
	 * 
	 * @throws InvalideKoordinatenException
	 *//*
	public static void main(String[] args) throws InvalideKoordinatenException {
		GUIBrett view = new GUIBrett();
		view.init();
	}
}
*/