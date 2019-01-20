package it.unicam.cs.pa.mastermind.player;

import it.unicam.cs.pa.mastermind.tmp.Cell;

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
