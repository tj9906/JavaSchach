package de.allianz.javapraxis.schach.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.allianz.javapraxis.schach.STEHTSCHACH;
import de.allianz.javapraxis.schach.Schach;
import de.allianz.javapraxis.schach.Spieler;
import de.allianz.javapraxis.schach.exception.InvalideKoordinatenException;
import de.allianz.javapraxis.schach.feld.koordinate.BordKoordinate;
import de.allianz.javapraxis.schach.figur.Bauer;
import de.allianz.javapraxis.schach.figur.Dame;
import de.allianz.javapraxis.schach.figur.FARBE;
import de.allianz.javapraxis.schach.figur.Turm;
import de.allianz.javapraxis.schach.gui.GUI;

public class TestSchach {

	public Schach schach;
	public static GUI gui;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		schach = new Schach();
		schach.spiel.setSpieler1(new Spieler("1", FARBE.WEISS));
		schach.spiel.setSpieler2(new Spieler("2", FARBE.SCHWARZ));
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testeMoeglichkeit() throws InvalideKoordinatenException, IOException, NullPointerException {
		// TODO Auto-generated method stub
		assertTrue(schach.macheZug("D2", "D4", null));
	}
	
	@Test 
	public void testeMoeglichkeit2() throws InvalideKoordinatenException, IOException {
		// TODO Auto-generated method stub
		assertFalse(schach.macheZug("D3", "D4", null));
	}
	@Test
	public void testeMoeglichkeit3() throws InvalideKoordinatenException, IOException {
		// TODO Auto-generated method stub
		assertTrue(schach.macheZug("B1", "C3", null));
	}
	
	@Test
	public void testeMoeglichkeit4() throws InvalideKoordinatenException, IOException {
		// TODO Auto-generated method stub
		assertFalse(schach.macheZug("B1", "D2", null));
	}
	
	@Test
	public void testeStehtSchach() throws InvalideKoordinatenException {
		// TODO Auto-generated method stub
		assertEquals(STEHTSCHACH.NEIN, schach.stehtSchach(FARBE.SCHWARZ, new BordKoordinate("E8")));
	}
	@Test
	public void testeStehtSchach2() throws InvalideKoordinatenException {
		// TODO Auto-generated method stub
		assertNotEquals(STEHTSCHACH.JA, schach.stehtSchach(FARBE.WEISS, new BordKoordinate("E8")));
	}

	@Test
	public void testeStehtSchachNeu() throws InvalideKoordinatenException {
		// TODO Auto-generated method stub
		schach.spiel.getBord().setFigurAuf(new BordKoordinate("E2"), null);
		schach.spiel.getBord().setFigurAuf(new BordKoordinate("E6"), new Turm(FARBE.SCHWARZ));
		System.out.println(schach.spiel.getBord().print());
		assertEquals(STEHTSCHACH.JA, schach.stehtSchach(FARBE.WEISS, new BordKoordinate("E1")));
	}
	
	@Test
	public void testeStehtMatt() throws InvalideKoordinatenException {
		// TODO Auto-generated method stub
		assertNotEquals(STEHTSCHACH.SCHACHMATT, schach.stehtMatt(FARBE.WEISS, new BordKoordinate("E8")));
	}

	@Test
	public void testeStehtMatthNeu() throws InvalideKoordinatenException {
		// TODO Auto-generated method stub
		schach.spiel.getBord().setFigurAuf(new BordKoordinate("E2"), null);
		schach.spiel.getBord().setFigurAuf(new BordKoordinate("E6"), new Turm(FARBE.SCHWARZ));
		System.out.println(schach.spiel.getBord().print());
		assertEquals(STEHTSCHACH.SCHACHMATT, schach.stehtMatt(FARBE.WEISS, new BordKoordinate("E1")));
	}
	
	@Test
	public void testeGameOver() throws InvalideKoordinatenException, CloneNotSupportedException {
		// TODO Auto-generated method stub
		schach.spiel.getBord().setFigurAuf(new BordKoordinate("D1"), null);
		schach.spiel.getBord().setFigurAuf(new BordKoordinate("E2"), null);
		schach.spiel.getBord().setFigurAuf(new BordKoordinate("F7"), null);
		schach.spiel.getBord().setFigurAuf(new BordKoordinate("G7"), null);
		schach.spiel.getBord().setFigurAuf(new BordKoordinate("E4"), new Bauer(FARBE.WEISS));
		schach.spiel.getBord().setFigurAuf(new BordKoordinate("F5"), new Bauer(FARBE.SCHWARZ));
		schach.spiel.getBord().setFigurAuf(new BordKoordinate("G5"), new Bauer(FARBE.SCHWARZ));
		schach.spiel.getBord().setFigurAuf(new BordKoordinate("H5"), new Dame(FARBE.WEISS));
		System.out.println(schach.spiel.getBord().print());
		assertTrue(schach.gameOver(FARBE.SCHWARZ, null));
	}
	
	@Test
	public void testeGameOver2() throws InvalideKoordinatenException, CloneNotSupportedException {
		// TODO Auto-generated method stub
		schach.spiel.getBord().setFigurAuf(new BordKoordinate("D1"), null);
		schach.spiel.getBord().setFigurAuf(new BordKoordinate("E2"), null);
		schach.spiel.getBord().setFigurAuf(new BordKoordinate("F7"), null);
		schach.spiel.getBord().setFigurAuf(new BordKoordinate("E4"), new Bauer(FARBE.WEISS));
		schach.spiel.getBord().setFigurAuf(new BordKoordinate("F5"), new Bauer(FARBE.SCHWARZ));
		schach.spiel.getBord().setFigurAuf(new BordKoordinate("H5"), new Dame(FARBE.WEISS));
		System.out.println(schach.spiel.getBord().print());
		assertFalse(schach.gameOver(FARBE.SCHWARZ, null));
	}

}
