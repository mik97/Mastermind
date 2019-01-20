package it.unicam.cs.pa.mastermind.player;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import it.unicam.cs.pa.mastermind.core.Utils;
import it.unicam.cs.pa.mastermind.exception.IllegalRoleActionException;
import it.unicam.cs.pa.mastermind.exception.InternalException;
import it.unicam.cs.pa.mastermind.ruleSet.Ruleset;

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
		super.getRule().getPlayerActionMap().entrySet().forEach(i->out.println(i.getKey()+" - "+i.getValue()));
		int y = Utils.doInput(in, out, "choose an action", this::isValidAction, Integer::parseInt);
		try {
			if(this.role == role.CODEBREACKER && y>0) throw new IllegalRoleActionException();
			if(this.role == role.CODEMAKER && y<1) throw new IllegalRoleActionException();
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
	public void init(int id, Ruleset rule) // add controllo su ID
	{
		this.id = id;
		super.setRule(rule);
		

	}
	/*
	 * public void doAction(Cell cell) // azione prototipale { switch (this.action)
	 * { case INSERTCOLOR: cell.setColor(Colors.GREEN); break;
	 * 
	 * } }
	 **/

}
