package de.allianz.javapraxis.schach;

import de.allianz.javapraxis.schach.figur.FARBE;

public class Spieler {
	private String name;
	private FARBE farbe;
	private boolean stehtSchach = false;
	
	public Spieler(String name, FARBE farbe){
		this.farbe = farbe;
		this.setName(name);
	}

	public String getName() {
		return name;
	}
	
	public FARBE getFarbe() {
		return farbe;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return name + ": " +  farbe;
	}

	public boolean isStehtSchach() {
		return stehtSchach;
	}

	public void setStehtSchach(boolean stehtSchach) {
		this.stehtSchach = stehtSchach;
	}
}
