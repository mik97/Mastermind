package it.unicam.cs.pa.mastermind.player;


/**
 * @author luca
 *
 */

public enum Role
{ 
	CODEMAKER,
	CODEBREAKER;
	
	@Override
	public String toString() {

		switch (this) {
		case CODEMAKER:
			return "CodeMaker";
		case CODEBREAKER:
			return "CodeBreaker";
		}
		return super.name();
	}
}
