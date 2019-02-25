/**
 * 
 */
package it.unicam.cs.pa.mastermind.core;

/**
 * @author Michele Celozzi
 *
 */
public enum CellStatus {
	EMPTY,
	FULL;

	@Override
	public String toString() {
		switch(this) {
		case EMPTY:
			return " ";
		case FULL:
			return "Full";
		}
		
		return super.name();
	}
	
}
