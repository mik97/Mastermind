package it.unicam.cs.pa.mastermind.player;
import java.util.HashMap;

import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.exception.IllegalIdArgument;
import it.unicam.cs.pa.mastermind.exception.IllegalRoleActionException;
import it.unicam.cs.pa.mastermind.exception.InternalException;
import it.unicam.cs.pa.mastermind.ruleSet.Ruleset;

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
   protected Ruleset rule;
   protected MatchField filed;
	// va inserito un field
  
   
   
   
   public abstract PlayerAction selectAction() throws InternalException, IllegalRoleActionException;
   public abstract void init(int id, MatchField filed,Ruleset rule) throws IllegalIdArgument;
   public abstract void startMatch();

	
	
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Ruleset getRule() {
	return rule;
}

public void setRule(Ruleset rule) {
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
public MatchField getFiled() {
	return filed;
}
public abstract int SelectTarget();


}
   
   
   