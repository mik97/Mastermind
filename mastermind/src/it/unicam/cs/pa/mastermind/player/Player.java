package it.unicam.cs.pa.mastermind.player;
import java.util.HashMap;

import it.unicam.cs.pa.mastermind.core.Cell;
import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.exception.IllegalIdArgument;
import it.unicam.cs.pa.mastermind.exception.IllegalRoleActionException;
import it.unicam.cs.pa.mastermind.exception.InternalException;
import it.unicam.cs.pa.mastermind.ruleSet.RuleSet;

import java.awt.Desktop.Action;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

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
   protected MatchField filed;
   protected Cell CodeMakerCombination [];
	protected BufferedReader in ;
	
	


	protected PrintStream out;
   
	protected Player(String name,Role role,InputStream in, PrintStream out) 
	{
		this.playerName = name;
		this.in = new BufferedReader(new InputStreamReader(in));
		this.role=role;
		this.out = out;
	}

   


/**
 * allows you to choose one of the possible actions
 * @return
 * @throws InternalException
 * @throws IllegalRoleActionException
 */
public abstract PlayerAction selectAction() throws InternalException, IllegalRoleActionException;

	/**
	 * initialize the player
	 * @param id
	 * @param filed
	 * @param rule
	 * @throws IllegalIdArgument
	 */
   public abstract void init(int id, MatchField filed,RuleSet rule) throws IllegalIdArgument;
   /**
    * Initialize match's parameters
    */
   public abstract void startMatch();
   
   //public abstract int SelectTarget();
   /**
    * check if the inserted combination is correct
    * @param choice
    * @return
    */
   public abstract  boolean isTheCorrectCombination(String choice);
   /**
    * creates the combination that will be resolved
    */
   public abstract void  makeComb();
	


public void setId(int id) {
	this.id = id;
}

public void setRole(Role role) 
{
	this.role = role;
}

public void setRule(RuleSet rule) {
	this.rule = rule;
}

public void setPlayerName(String playerName) {
	this.playerName = playerName;
}

public int getId() {
	return id;
}

public RuleSet getRule() {
	return rule;
}

public String getPlayerName() {
	return playerName;
}



public Role getRole() {
	return role;
}


public PlayerAction getAction() {
	return action;

}
public MatchField getFiled() {
	return filed;
}
public BufferedReader getIn()
{
	return in;
}


public PrintStream getOut() 
{
	return out;
}
public Cell[] getCodeMakerCombination() 
{
	return CodeMakerCombination;
}


}
   
   
   