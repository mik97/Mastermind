package it.unicam.cs.pa.mastermind.player;

import it.unicam.cs.pa.mastermind.exception.IllegalRoleActionException;
import it.unicam.cs.pa.mastermind.exception.InternalException;
import it.unicam.cs.pa.mastermind.ruleSet.RuleSet;
import it.unicam.cs.pa.mastermind.core.MatchField;

/**
 * @author luca
 *
 */

public abstract class Player
{
   protected String playerName;
   protected PlayerAction action;
   protected Role role;
   protected int id;
   protected RuleSet rule;
   protected MatchField field;
  
   
   
   
	public abstract PlayerAction selectAction() throws InternalException, IllegalRoleActionException;
	public abstract void init(int id, MatchField field, RuleSet rule);
	public abstract int selectTarget();
	
	
	public void startMatch() {
		System.out.println("My id is: " + this.id);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public RuleSet getRule() {
		return rule;
	}
	
	public void setRule(RuleSet rule) {
		this.rule = rule;
	}
	
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public PlayerAction getAction() {
		return action;
	}
	
	public void youWin() {
		System.out.println("Congratulation! You are the winner");
	}
	
	public void youLose() {
		System.out.println("Oh no! You lose");
	}
}