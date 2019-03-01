package it.unicam.cs.pa.mastermind.match;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import it.unicam.cs.pa.mastermind.core.Cell;
import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.core.PieceFactory;
import it.unicam.cs.pa.mastermind.core.Size;
import it.unicam.cs.pa.mastermind.core.Utils;
import it.unicam.cs.pa.mastermind.player.Player;
import it.unicam.cs.pa.mastermind.player.PlayerAction;
import it.unicam.cs.pa.mastermind.player.Role;
import it.unicam.cs.pa.mastermind.ruleSet.DefaultRuleSet;
import it.unicam.cs.pa.mastermind.ruleSet.RuleSet;
import it.unicam.cs.pa.mastermind.exception.IllegalRoleActionException;
import it.unicam.cs.pa.mastermind.exception.UnitializedSingleton;
import it.unicam.cs.pa.mastermind.piece.Color;
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
	private RuleSet referee;
	
	private MatchStatus status = MatchStatus.INIT;
	
	private HashMap<PlayerAction, Function<Boolean, Boolean>> actions;
	
	private PieceFactory pieceFactory;
	
	private Match() {
		actions = new HashMap<>();
		
		
			actions.put(PlayerAction.InsertColor, value -> { return players[currentPlayer].insertCombination(); });
			actions.put(PlayerAction.MakeCombination, value -> { return players[currentPlayer].makeCombination(); });
			actions.put(PlayerAction.IsTheCorrectCombination, value -> { return players[currentPlayer]
					.isTheCorrectCombination(field.getCellList(field.getRow() - 1)); 
			});
		
		this.initialized = false;
	}
	
	public static Match getInstance() {
		return INSTANCE;
	}
	
	
	/**
	 * A method to initialized the match, in particular the first player and the field
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
			this.field = new MatchField();
			
			this.referee = getObj(p.getOrDefault("referee", new DefaultRuleSet()),RuleSet.class);
			this.referee.setField(field);
			Size size = getObj(p.getOrDefault("size", referee.getFieldSize()), Size.class);
			this.field.init(size);

			this.firstPlayer = getObj(p.getOrDefault("firstplayer", 0), Integer.class);
			this.currentPlayer = this.firstPlayer;
			
			
			if(currentPlayer < 0 || currentPlayer > 1)
				throw new IllegalArgumentException("" + currentPlayer 
						+ " is not allowed. The value of the current player must be 0 or 1! ");
			
			this.pieceFactory = PieceFactory.getInstance();
			
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
	
	public void restart() {
		this.status = MatchStatus.PLAYING;
		this.firstPlayer = otherPlayer(currentPlayer);
		this.currentPlayer = this.firstPlayer;
		this.field.clear();
		this.pieceFactory.restart();
		start();
	}
	
	public void play() {
		this.players[PLAYER1].startMatch();
		this.players[PLAYER2].startMatch();
		while(doAction(this.players[currentPlayer].selectAction()))
			;
	}
	
	private boolean doAction(PlayerAction action) 
	{
		
		if (this.referee.isValidAction(action)) {

			boolean a = actions.get(action).apply(true);
			if (isEnd(a,action))
				return false;
			
		} else {
			System.out.println("the action is not allowed. pleas insert another");
			doAction(this.players[currentPlayer].selectAction());
		}
		
		this.currentPlayer = otherPlayer(this.currentPlayer);
		return true;
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
	
	private boolean isEnd(boolean end, PlayerAction action) {
		if(!(action.equals(PlayerAction.IsTheCorrectCombination))) {
			return false;
		}
		else 
		{
			if(this.field.isFull()) {
				win(end);
				return true;
			}
			else
				return false;
		}
	}
	
	public void win(boolean win){
		if(win) {
		this.players[currentPlayer].youLose();
		this.players[otherPlayer(currentPlayer)].youWin();
		}else 
		{
			if((this.field.getRow() == this.referee.getFieldSize().getRow() -1) && !win)
			{
				this.players[currentPlayer].youWin();
				this.players[otherPlayer(currentPlayer)].youLose();
			}
		}
	}
	
	private <T> T getObj(Object obj, Class<? extends T> target) throws IllegalArgumentException{
		if(!target.isAssignableFrom(obj.getClass()))
			throw new IllegalArgumentException("HashMap contain" + obj.getClass().getSimpleName() + "class, instead of" 
					+ target.getSimpleName());
		
		return target.cast(obj);
	}
}