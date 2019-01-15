package it.unicam.cs.pa.mastermind.player;

import java.awt.Desktop.Action;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

import it.unicam.cs.pa.mastermind.core.Utils;

public class InteractivePlayer extends Player
{   
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private PrintStream out = System.out;
	
	
	
	private boolean IsValidAction(int V)	
	{
		if(this.playerActionMap.get(V) != null) return true;
		else return false;
	
	}
	
	@Override 
	public PlayerAction selectAction()
	{ 
	  int y = Utils.doInput(in, out, "choose an action",this::IsValidAction,Integer::parseInt); // add metodo di controllo azione
	  this.action = this.playerActionMap.get(y);
	  return this.action;
	}

	
	

}
