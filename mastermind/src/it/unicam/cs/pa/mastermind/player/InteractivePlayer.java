package it.unicam.cs.pa.mastermind.player;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.core.Utils;
import it.unicam.cs.pa.mastermind.exception.IllegalIdArgument;
import it.unicam.cs.pa.mastermind.exception.IllegalRoleActionException;
import it.unicam.cs.pa.mastermind.exception.InternalException;
import it.unicam.cs.pa.mastermind.ruleSet.RuleSet;


/**
 * @author luca
 *
 */

public class InteractivePlayer extends Player {


	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private PrintStream out = System.out;

	private boolean isValidAction(int V) {
		if (this.getRule().getPlayerActionMap().get(V) != null)
			return true;
		else
			return false;

	}

	public PlayerAction selectAction() throws InternalException,IllegalRoleActionException{
		System.out.println("Available Actions:\n");
		super.getRule().getPlayerActionMap().entrySet().forEach(i -> out.println(i.getKey() + " - " + i.getValue()));
		int y = Utils.doInput(in, out, "choose an action", this::isValidAction, Integer::parseInt);
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

	public InteractivePlayer(String name, Role role) {
		this.playerName = name;
		this.role = role;
	}

	@Override
	public void init(int id, MatchField field, RuleSet rule) throws IllegalIdArgument
	{
		this.id = id;
		this.field = field;
		super.setRule(rule);
		if(this.role == Role.CODEMAKER) this.action = PlayerAction.INSERTCOLOR;

	}
	

	@Override
	public int selectTarget()
	{   
		int limit = this.field.getColumns()-1;
		int target = Utils.doInput(in, out, "Chose Target: between 0 - "+limit,
				(x)->x<= this.field.getColumns()-1, Integer::parseInt);
		
		return target;
	}

}