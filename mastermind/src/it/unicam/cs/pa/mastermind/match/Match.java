package it.unicam.cs.pa.mastermind.match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.core.PieceFactory;
import it.unicam.cs.pa.mastermind.core.Utils;
import it.unicam.cs.pa.mastermind.player.Player;
import it.unicam.cs.pa.mastermind.player.PlayerAction;
import it.unicam.cs.pa.mastermind.ruleSet.Ruleset;
import it.unicam.cs.pa.mastermind.exception.UnitializedSingleton;
import it.unicam.cs.pa.mastermind.piece.Color;
import it.unicam.cs.pa.mastermind.piece.Piece;
import it.unicam.cs.pa.mastermind.piece.AbstractPiece;

/**
 * @author Michele Celozzi
 *
 */
public final class Match {
	
	private static final Match INSTANCE = new Match();
	private boolean initialized;
	
	private static final int PLAYER1 = 0;
	private static final int PLAYER2 = 1;
	
	private Player[] players;
	private MatchField field;
	private int firstPlayer;
	private int currentPlayer;
	private int attempts;
	private Ruleset referee;
	
	private MatchStatus status = MatchStatus.INIT;
	
	private HashMap<PlayerAction, Function<Integer, Boolean>> actions;
	
	private PieceFactory pieceFactory;
	
	private Match() {
		actions = new HashMap<>();
		List<AbstractPiece> pieces = new ArrayList<>();
		
		actions.put(PlayerAction.INSERTCOLOR, column -> {
			for(int i = 0; i < field.getRows(); i++) {
				AbstractPiece piece = pieceFactory.getPiece(Color.BIANCO); // errore
				pieces.add(piece);
			}
			return field.insert(pieces, column);
			});
	
		//actions.put(PlayerAction.MAKECOMBINATION, value);
		
		//actions.put(PlayerAction.ISTHECORRECTCOMBINATION, value);
		
		this.initialized = false;
	}
	
	public static Match getInstance() {
		return INSTANCE;
	}
	
	
	/**
	 * A method to initialized the match, particurally the first player and the field
	 * @param p1 is one player
	 * @param p2 is an other player
	 * @param p is the hashmap that contain the {@code 'size'} that in our case is standard, 
	 * the {@code 'firstPlayer'} and the {{@code 'referee'}, if one of this values is missing
	 * there are set to the default values
	* @return {@code True} if the match is initialized, else {@code False}
	 * @throws IllegalArgumentException if the value of the currentPlayer or if the values in the map is incorrect 
	 */
	public boolean initMatch(Player p1, Player p2, Map<String, Object> p) throws IllegalArgumentException{
		if(!initialized) {
			this.players = new Player[] { p1, p2 };
			this.field = MatchField.getInstance();
			
			this.firstPlayer = getObj(p.getOrDefault("firstplayer", 0), Integer.class);
			this.currentPlayer = this.firstPlayer;
			
			if(currentPlayer < 0 || currentPlayer > 1)
				throw new IllegalArgumentException("" + currentPlayer + " is not allowed. The value of the current player must be 0 or 1! ");
			
			this.attempts = 0;
			
			this.initialized = true;
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * Is the method that start the match, initialized the players, 
	 * set the match status to PLAYING and call play method
	 * @throws UnitializedSingleton if the match is not initialized
	 */
	public void start() throws IllegalStateException {
		
		if (!initialized)
			throw new UnitializedSingleton("Match");
		if (!init(PLAYER1)) {
			return;
		}
		if (!init(PLAYER2)) {
			return;
		}
				
		this.status = MatchStatus.PLAYING;
		play();		
	}
	
	public void play() {
		this.players[PLAYER1].startMatch();
		this.players[PLAYER2].startMatch();
		while(doAction(this.players[currentPlayer].selectAction()))
			;
	}
	
	private boolean doAction(PlayerAction action) 
	{  
		
		if(this.referee.LineIsFull() == true ) 
		{
			String choice = Utils.doInput(this.players[currentPlayer].getIn(), this.players[currentPlayer].getOut(), "Confirm your choice ? : Yes or No ", (x)->x == "Yes" || x == "No", (x)->x.substring(0,1).toUpperCase()+x.substring(1));
			this.referee.ConfirmInsert(choice);
		}
		
		return false;
	}
	
	public boolean init(int player) {
		try {
			this.players[player].init(player, field, referee);
			return true;
		}
		catch(Throwable e) {
			return false;
		}
	}
	
	public static int otherPlayer(int player) {
		return (player + 1) % 2;
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
