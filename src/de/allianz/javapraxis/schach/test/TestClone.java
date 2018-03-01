package de.allianz.javapraxis.schach.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.allianz.javapraxis.schach.Schach;
import de.allianz.javapraxis.schach.Spiel;
import de.allianz.javapraxis.schach.exception.InvalideKoordinatenException;
import de.allianz.javapraxis.schach.feld.Bord;
import de.allianz.javapraxis.schach.feld.Feld;
import de.allianz.javapraxis.schach.feld.koordinate.BordKoordinate;
import de.allianz.javapraxis.schach.feld.koordinate.GehKoordinate;
import de.allianz.javapraxis.schach.figur.Bauer;
import de.allianz.javapraxis.schach.figur.Dame;
import de.allianz.javapraxis.schach.figur.FARBE;
import de.allianz.javapraxis.schach.figur.Koenig;
import de.allianz.javapraxis.schach.figur.Laeufer;
import de.allianz.javapraxis.schach.figur.Springer;
import de.allianz.javapraxis.schach.figur.Turm;

public class TestClone {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testGehKoorClone() throws InvalideKoordinatenException {
		GehKoordinate gehKoorO = new GehKoordinate(2, 1, 7);
		try {
			GehKoordinate gehKoorK = gehKoorO.clone();
			assertEquals("Sind Gleich", gehKoorO, gehKoorK);
			assertNotSame("Sind Same", gehKoorO, gehKoorK);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("GehKoor konnte nicht gelont werden!");
		}

	}
	@Test
	public void testCloneBauer() throws InvalideKoordinatenException {
		Bauer b1 = new Bauer(FARBE.SCHWARZ);
		try {
			Bauer b2 = b1.clone();
			assertNotSame(b1.getGehKoor(), b2.getGehKoor());
			assertEquals(b1,b2);
			assertNotSame(b1,b2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Bauer konnte nicht Kopiert werden");
		}
		
	}
	
	@Test
	public void testCloneLauefer() throws InvalideKoordinatenException {
		Laeufer b1 = new Laeufer(FARBE.SCHWARZ);
		try {
			Laeufer b2 = (Laeufer) b1.clone();
			assertEquals(b1,b2);
			assertNotSame(b1,b2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Laeufer konnte nicht Kopiert werden");
		}
		
	}
	
	@Test
	public void testCloneKoenig() throws InvalideKoordinatenException {
		Koenig b1 = new Koenig(FARBE.SCHWARZ);
		try {
			Koenig b2 = (Koenig) b1.clone();
			assertEquals(b1,b2);
			assertNotSame(b1,b2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Koenig konnte nicht Kopiert werden");
		}
		
	}
	@Test
	public void testCloneDame() throws InvalideKoordinatenException {
		Dame b1 = new Dame(FARBE.SCHWARZ);
		try {
			Dame b2 = (Dame) b1.clone();
			assertEquals(b1,b2);
			assertNotSame(b1,b2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Dame konnte nicht Kopiert werden");
		}
		
	}
	@Test
	public void testCloneSpringer() throws InvalideKoordinatenException {
		Springer b1 = new Springer(FARBE.SCHWARZ);
		try {
			Springer b2 = (Springer) b1.clone();
			assertEquals(b1,b2);
			assertNotSame(b1,b2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Springer konnte nicht Kopiert werden");
		}
		
	}
	@Test
	public void testCloneTurm() throws InvalideKoordinatenException {
		Turm b1 = new Turm(FARBE.SCHWARZ);
		try {
			Turm b2 = (Turm) b1.clone();
			assertEquals(b1,b2);
			assertNotSame(b1,b2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Turm konnte nicht Kopiert werden");
		}
		
	}
	
	@Test
	public void testCloneBauerW() throws InvalideKoordinatenException {
		Bauer b1 = new Bauer(FARBE.WEISS);
		try {
			Bauer b2 = b1.clone();
			assertEquals(b1,b2);
			assertNotSame(b1,b2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Bauer konnte nicht Kopiert werden");
		}
		
	}
	
	@Test
	public void testCloneLaueferW() throws InvalideKoordinatenException {
		Laeufer b1 = new Laeufer(FARBE.WEISS);
		try {
			Laeufer b2 = (Laeufer) b1.clone();
			assertEquals(b1,b2);
			assertNotSame(b1,b2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Laeufer konnte nicht Kopiert werden");
		}
		
	}
	
	@Test
	public void testCloneKoenigW() throws InvalideKoordinatenException {
		Koenig b1 = new Koenig(FARBE.WEISS);
		try {
			Koenig b2 = (Koenig) b1.clone();
			assertEquals(b1,b2);
			assertNotSame(b1,b2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Koenig konnte nicht Kopiert werden");
		}
		
	}
	@Test
	public void testCloneDameW() throws InvalideKoordinatenException {
		Dame b1 = new Dame(FARBE.WEISS);
		try {
			Dame b2 = (Dame) b1.clone();
			assertEquals(b1,b2);
			assertNotSame(b1,b2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Dame konnte nicht Kopiert werden");
		}
		
	}
	@Test
	public void testCloneSpringerW() throws InvalideKoordinatenException {
		Springer b1 = new Springer(FARBE.WEISS);
		try {
			Springer b2 = (Springer) b1.clone();
			assertEquals(b1,b2);
			assertNotSame(b1,b2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Springer konnte nicht Kopiert werden");
		}
		
	}
	@Test
	public void testCloneTurmW() throws InvalideKoordinatenException {
		Turm b1 = new Turm(FARBE.WEISS);
		try {
			Turm b2 = (Turm) b1.clone();
			assertEquals(b1,b2);
			assertNotSame(b1,b2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Turm konnte nicht Kopiert werden");
		}
		
	}
	
	@Test
	public void testCloneFeld() throws InvalideKoordinatenException {
		Feld b1 = new Feld(new Bauer(FARBE.SCHWARZ) ,false);
		try {
			Feld b2 = (Feld) b1.clone();
			assertEquals(b1,b2);
			assertNotSame("Feld",b1,b2);
			assertNotSame("FigurFeld", b1.getFigur(), b2.getFigur());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Feld konnte nicht Kopiert werden");
		}
		
	}
	
	@Test
	public void testCloneBord() throws InvalideKoordinatenException {
		Bord b1 = new Bord();
		try {
			Bord b2 = (Bord) b1.clone();
			//For schleife, prüfen, altes Brett pos inhalte = neues Brett Inhalt
			assertEquals(b1,b2);
			assertNotSame(b1,b2);
			for(int spalte = 0; spalte < 8; spalte++){
				for (int zeile = 0; zeile < 8; zeile++) {
					BordKoordinate bkoor = new BordKoordinate(spalte, zeile);
					if(b1.getFigurAuf(bkoor) != null){
						assertEquals("Hier sollte wer stehen", b1.getFigurAuf(bkoor), b2.getFigurAuf(bkoor));
						assertNotSame(b1.getFigurAuf(bkoor), b2.getFigurAuf(bkoor));
					}else{
						assertEquals("Hier wäre null",null, b2.getFigurAuf(bkoor));
					}
				}
			}
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Bord konnte nicht Kopiert werden");
		}
		
	}
	
	@Test
	public void testCloneSpiel() throws InvalideKoordinatenException {
		Spiel b1 = new Spiel();
		b1.spieleSchach();
		try {
			Spiel b2 = (Spiel) b1.clone();
			assertEquals(b1,b2);
			assertNotSame(b1,b2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Feld konnte nicht Kopiert werden");
		}
		
	}

	@Test
	public void testCloneSchach() throws InvalideKoordinatenException {
		Schach b1 = new Schach();
		try {
			Schach b2 = (Schach) b1.clone();
			assertEquals(b1,b2);
			assertNotSame(b1,b2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Feld konnte nicht Kopiert werden");
		}
		
	}

}
