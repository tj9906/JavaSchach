package de.allianz.javapraxis.schach;

import de.allianz.javapraxis.schach.exception.InvalideParameterException;
import de.allianz.javapraxis.schach.feld.koordinate.BordKoordinate;
import de.allianz.javapraxis.schach.figur.*;

public class Zug {
	private Class<? extends Figur> vonFigur;
	private Class<? extends Figur> geschlagen;
	private Class<? extends Figur> tausche;
	private BordKoordinate vonKoor;
	private BordKoordinate zuKoor;

	public Zug(Class<? extends Figur> vonFigur, Class<? extends Figur> geschlagen, Class<? extends Figur> tausche,
			BordKoordinate vonKoor, BordKoordinate zuKoor) throws InvalideParameterException{
		this.vonFigur = vonFigur;
		this.geschlagen = geschlagen;
		this.tausche = tausche;
		this.vonKoor = vonKoor;
		this.zuKoor = zuKoor;
		
		validiere();
	}

	private void validiere() throws InvalideParameterException {
		if(vonFigur == null){
			throw new InvalideParameterException("Kein Von-Figur!");
		}
		if(vonKoor == null){
			throw new InvalideParameterException("Kein Von-Koordinate!");
		}
		if(zuKoor == null){
			throw new InvalideParameterException("Kein Zu-Koordinate!");
		}
		if(tausche == null && vonFigur == Bauer.class){
			throw new InvalideParameterException("Fehler bei Umwandlung!");
		}
	}

	public Class<? extends Figur> getVonFigur() {
		return vonFigur;
	}

	public Class<? extends Figur> getGeschlagen() {
		return geschlagen;
	}

	public Class<? extends Figur> getTausche() {
		return tausche;
	}

	public BordKoordinate getVonKoor() {
		return vonKoor;
	}

	public BordKoordinate getZuKoor() {
		return zuKoor;
	}
}
