package it.unicam.cs.pa.mastermind.player;

public enum PlayerAction
{
	INSERTCOLOR,
	MAKECOMBINATION;
	
	@Override
	public String toString() {

		switch (this) {
		case INSERTCOLOR:
			return "InsertColor";
		case MAKECOMBINATION:
			return "MakeCombination";
		}
		return super.name();
	}
	
	
}
