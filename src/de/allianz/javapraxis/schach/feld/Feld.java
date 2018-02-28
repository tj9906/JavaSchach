package de.allianz.javapraxis.schach.feld;

import de.allianz.javapraxis.schach.feld.koordinate.Koordinate;
import de.allianz.javapraxis.schach.figur.Figur;

public class Feld {
	private Figur figur;
	private boolean istSchwarz;

	public Feld(Figur figur, boolean istSchwarz) {
		// TODO Auto-generated constructor stub
		this.setFigur(figur);
		this.istSchwarz = istSchwarz;
	}

	public Figur getFigur() {
		return figur;
	}

	public void setFigur(Figur figur) {
		this.figur = figur;
	}

	public boolean isIstSchwarz() {
		return istSchwarz;
	}

	@Override
	public String toString() {
		if (figur == null)
			return "| _ |";
		else
			return "| " + figur.toString() + " |";
	}
	
	@Override
	public Feld clone() throws CloneNotSupportedException {
		Feld neu = new Feld(figur.clone(), istSchwarz);
		return neu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((figur == null) ? 0 : figur.hashCode());
		result = prime * result + (istSchwarz ? 1231 : 1237);
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
		if (!(obj instanceof Feld)) {
			return false;
		}
		Feld other = (Feld) obj;
		if (figur == null) {
			if (other.figur != null) {
				return false;
			}
		} else if (!figur.equals(other.figur)) {
			return false;
		}
		if (istSchwarz != other.istSchwarz) {
			return false;
		}
		return true;
	}
}
