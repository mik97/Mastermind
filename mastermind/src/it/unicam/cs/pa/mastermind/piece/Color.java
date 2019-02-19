/**
 * 
 */
package it.unicam.cs.pa.mastermind.piece;

/**
 * @author Michele Celozzi
 *
 */
public enum Color {
	BIANCO,
	GIALLO,
	ROSSO,
	ARANCIONE,
	BLU,
	MARRONE,
	VIOLA,
	NERO;

	@Override
	public String toString() {
		switch(this) {
		case BIANCO: 
			return "W";
		case GIALLO: 
			return "G";
		case ROSSO: 
			return "R";
		case ARANCIONE: 
			return "A";
		case BLU: 
			return "B";
		case MARRONE: 
			return "M";
		case VIOLA: 
			return "V";
		case NERO: 
			return "N";
		}
		
		return super.name();
	}
}
