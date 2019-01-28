package it.unicam.cs.pa.mastermind.player;



/**
 * @author luca
 *
 */

public enum PlayerAction
{
	INSERTCOLOR,
	MAKECOMBINATION,
	ISTHECORRECTCOMBINATION;

	@Override
	public String toString() {

		switch (this) {
		case INSERTCOLOR:
			return "InsertColor";
		case MAKECOMBINATION:
			return "MakeCombination";
		case ISTHECORRECTCOMBINATION:
			return "IsTheCorrectCombination";
		}
		return super.name();
	}
	
	
}
