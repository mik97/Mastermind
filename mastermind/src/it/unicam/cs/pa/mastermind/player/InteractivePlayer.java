package it.unicam.cs.pa.mastermind.player;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import it.unicam.cs.pa.mastermind.core.Cell;
import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.core.Utils;
import it.unicam.cs.pa.mastermind.exception.IllegalIdArgument;
import it.unicam.cs.pa.mastermind.exception.IllegalRoleActionException;
import it.unicam.cs.pa.mastermind.exception.InternalException;
import it.unicam.cs.pa.mastermind.piece.Color;
import it.unicam.cs.pa.mastermind.ruleSet.Ruleset;



/**
 * @author luca
 *
 */

public class InteractivePlayer extends Player {

	/**
	 * check if the action is existing{@code true}  return true {@code false } return false
	 * @param V
	 * @return
	 */
	private boolean isValidAction(int V) 
	{
		if (this.getRule().getPlayerActionMap().get(V) != null)
			return true;
		else
			return false;

	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.unicam.cs.pa.mastermind.player.Player#selectAction()
	 */
	
	public PlayerAction selectAction() throws InternalException,IllegalRoleActionException{
		System.out.println("\nAvailable Actions:\n");
		super.getRule().getPlayerActionMap().entrySet().forEach(i->out.println(i.getKey()+" - "+i.getValue()));
		int y = Utils.doInput(in, out, "\nchoose an action", this::isValidAction, Integer::parseInt);
		try {
			if(this.role == Role.CODEBREAKER && y>0) throw new IllegalRoleActionException();
			if(this.role == Role.CODEMAKER && y<1) throw new IllegalRoleActionException();
			this.action = PlayerAction.values()[y];
		    }
		    catch (IllegalRoleActionException e)
			{
			 System.out.println(e.toString());
			 
			}
				
				return this.action;

	}

	public InteractivePlayer(String name,Role role,InputStream in, PrintStream out)
	{  
		super(name,role,in,out);
	}
	
	public InteractivePlayer(String name,Role role) 
	{
		this(name, role, System.in, System.out);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see it.unicam.cs.pa.mastermind.player.Player#init()
	 */
	@Override
	public void init(int id,MatchField field, Ruleset rule)  throws IllegalIdArgument
	{
		this.id = id;
		super.setRule(rule);
		this.filed = field;
		if(this.role == Role.CODEMAKER) this.action = PlayerAction.INSERTCOLOR;

	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.unicam.cs.pa.mastermind.player.Player#startMatch()
	 */
	
	@Override
	public void startMatch() 
	{
		System.out.println("My ID is " + this.id);
		
	}
	
	/*public int SelectTarget()
	{   
		int limit = this.filed.getColumns()-1;
		int target = Utils.doInput(in, out, "Chose Target: between 0 - "+limit,(x)->x<= this.filed.getColumns()-1, Integer::parseInt);
		
		return target;
	}*/

	/*
	 * (non-Javadoc)
	 * 
	 *@see it.unicam.cs.pa.mastermind.player.Player#isTheCorrectCombination()
	 */
	
	@Override
	public boolean isTheCorrectCombination(String choice) 
	{
		
		
		switch (choice) 
		{
		
		case "Yes":
			return true;
	
				
				
		case "No":
				return false;
			
		}
		return false;
}

	/*
	 * (non-Javadoc)
	 * 
	 *@see it.unicam.cs.pa.mastermind.player.Player#makeComb()
	 */
	
	@Override
	public void makeComb() 
	{
		
		
	}

}
