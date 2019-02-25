package it.unicam.cs.pa.mastermind.player;
/**
 * @author luca
 *
 */

public enum TypePlayer 
{
	INTERACTIVE,
	RANDOM;
	
	public Player getPlayer(String type, Role role) {
		switch(this) {
		case INTERACTIVE:
			return new InteractivePlayer(type, role);
		case RANDOM:
			return new RandomPlayer(type, role);
		}
		
		return null;
	}
}
