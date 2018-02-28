package de.allianz.javapraxis.schach.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.allianz.javapraxis.schach.exception.InvalideKoordinatenException;
import de.allianz.javapraxis.schach.feld.koordinate.BordKoordinate;
import de.allianz.javapraxis.schach.feld.koordinate.GehKoordinate;
import de.allianz.javapraxis.schach.figur.Bauer;
import de.allianz.javapraxis.schach.figur.FARBE;
import de.allianz.javapraxis.schach.figur.Laeufer;

public class TestKoordinate {

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
	public void testGetter() throws InvalideKoordinatenException {
		assertEquals(5, new BordKoordinate(5,6).getSpalte());
	}
	
	@Test
	public void testEquals() throws InvalideKoordinatenException {
		assertEquals(new BordKoordinate(5,6), new BordKoordinate(5,6));
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
			fail("Bauer konnte nicht Kopiert werden");
		}
		
	}

}
