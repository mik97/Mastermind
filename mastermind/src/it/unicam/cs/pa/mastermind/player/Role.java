package it.unicam.cs.pa.mastermind.player;

public enum Role
{ 
	CODEMAKER,
	CODEBREACKER;
	
	@Override
	public String toString() {

		switch (this) {
		case CODEMAKER:
			return "CodeMaker";
		case CODEBREACKER:
			return "CodeBreacker";
		}
		return super.name();
	}
}
