package it.unicam.cs.pa.mastermind.player;

/**
 * @author luca
 *
 */

public enum PlayerAction
{
	InsertColor,
	MakeCombination,
	IsTheCorrectCombination;

	@Override
	public String toString() {

		switch (this) {
		case InsertColor:
			return "InsertColor";
		case MakeCombination:
			return "MakeCombination";
		case IsTheCorrectCombination:
			return "IsTheCorrectCombination";
			
		}
		
		return super.name();
	}
	
}
