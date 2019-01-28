package it.unicam.cs.pa.mastermind.player;



/**
 * @author luca
 *
 */

public enum TypePlayer 
{
	INTERACTIE,
	RANDOM;
	
	@Override
	
	public String toString() {

		switch (this) {
		case INTERACTIE:
			return "interactive";
		case RANDOM:
			return "random";
		}
		return super.name();
	}
}
