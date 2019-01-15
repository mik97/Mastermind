/**
 * 
 */
package it.unicam.cs.pa.mastermind.match;

import java.util.*;

import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.player.Player;
import it.unicam.cs.pa.mastermind.exception.UnitializedSingleton;

/**
 * @author Michele Celozzi
 *
 */
public final class Match {
	
	private static final Match INSTANCE = new Match();
	private boolean initialized;
	
	private static final int PLAYER1 = 0;
	private static final int PLAYER2 = 1;
	private Player[] player;
	private MatchField field;
	private int firstPlayer;
	private int currentPlayer;
	
	private MatchStatus status = MatchStatus.INIT;
	
	private Match() {
		this.initialized = false;
	}
	
	public static Match getInstance() {
		return INSTANCE;
	}
	
	public boolean init(Player p1, Player p2, Map<String, Object> p) throws IllegalArgumentException{
		if(!initialized) {
			this.player = new Player[] { p1, p2 };
			this.field = MatchField.getInstance();
			
			this.firstPlayer = getObj(p.getOrDefault("firstplayer", 0), Integer.class);
			this.currentPlayer = this.firstPlayer;
			
			if(currentPlayer < 0 || currentPlayer > 1)
				throw new IllegalArgumentException("" + currentPlayer + " is not allowed. The value of the current player must be 0 or 1! ");
			
			this.initialized = true;
			
			return true;
		}
		
		return false;
	}
	
	public void start() {
		this.status = MatchStatus.START;
		
//		this.player[this.currentPlayer].play();
		
	}
	
	public MatchStatus getStatus() throws UnitializedSingleton {
		if(!initialized)
			throw new UnitializedSingleton("Match");
		return this.status;
	}
	
	public void setStatus(MatchStatus status) {
		this.status = status;
	}
	
	private <T> T getObj(Object obj, Class<? extends T> target) throws IllegalArgumentException{
		if(!target.isAssignableFrom(obj.getClass()))
			throw new IllegalArgumentException("HashMap contain" + obj.getClass().getSimpleName() + "class, instead of" 
					+ target.getSimpleName());
		
		return target.cast(obj);
	}
}
