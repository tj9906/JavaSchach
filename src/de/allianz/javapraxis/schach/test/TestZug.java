package de.allianz.javapraxis.schach.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.allianz.javapraxis.schach.Zug;
import de.allianz.javapraxis.schach.exception.InvalideKoordinatenException;
import de.allianz.javapraxis.schach.exception.InvalideParameterException;
import de.allianz.javapraxis.schach.feld.koordinate.BordKoordinate;
import de.allianz.javapraxis.schach.figur.Bauer;
import de.allianz.javapraxis.schach.figur.FARBE;

public class TestZug {

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

	@Test(expected  = InvalideParameterException.class)
	public void testValidiere() throws InvalideParameterException, InvalideKoordinatenException {
		Zug a = new Zug(new Bauer (FARBE.SCHWARZ).getClass(), null, null, new BordKoordinate("A2"), new BordKoordinate("A3"));
	}

}
