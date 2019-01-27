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
			return "Bianco";
		case GIALLO: 
			return "Giallo";
		case ROSSO: 
			return "Rosso";
		case ARANCIONE: 
			return "Arancione";
		case BLU: 
			return "Blu";
		case MARRONE: 
			return "Marrone";
		case VIOLA: 
			return "Viola";
		case NERO: 
			return "Nero";
		}
		
		return super.name();
	}
}
