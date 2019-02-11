package it.unicam.cs.pa.mastermind.player;

import it.unicam.cs.pa.mastermind.ruleSet.Ruleset;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Random;

import it.unicam.cs.pa.mastermind.core.Cell;
import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.exception.IllegalIdArgument;
import it.unicam.cs.pa.mastermind.piece.Color;
import it.unicam.cs.pa.mastermind.piece.Piece;
import it.unicam.cs.pa.mastermind.player.PlayerAction;


/**
 * @author luca
 *
 */

public class RandomPlayer extends Player
{
	
	private PlayerAction secondaryAction;

	
	public PlayerAction selectAction()
	{return action;}

	
	public  RandomPlayer(String name,Role role,InputStream in, PrintStream out) 
	{   super(name,role,in,out);
		
	}
	
	public RandomPlayer(String name,Role role) 
	{
		this(name, role, System.in, System.out);
	}
	
	@Override
	public void init(int id, MatchField filed,Ruleset rule) throws IllegalIdArgument	// meccanismo controllo id
	{
		this.id = id;
		super.setRule(rule);
		this.filed=filed;
		
		switch (role) {
		case CODEBREACKER:
			action=rule.getPlayerActionMap().get(0);
			secondaryAction=null;
			break;
			
		case CODEMAKER:
			action=rule.getPlayerActionMap().get(1);
			secondaryAction=rule.getPlayerActionMap().get(2);
			break;
		
		}
		
	}


	public PlayerAction getSecondaryAction() 
	{
		return secondaryAction;
	}




	@Override
	public void startMatch() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int SelectTarget() 
	{
		
		return 0;
	}


	@Override
	public boolean isTheCorrectCombination()
	{
		return false;
		
	}


	@Override
	public void makeComb() 
	{  
		Cell [] combination = new Cell[filed.getColumns()];
		java.util.List<Color>color= Arrays.asList(Color.values());
		Random rand = new Random();
		Color a = null;
		
		for(int i = 0; i<filed.getColumns();i++)
		{
			a = color.get(rand.nextInt(color.size()));
			combination[i]= new Cell();
			combination[i].setPiece(new Piece(i+1, a));
		}
		this.CodeMakerCombination = combination;
	}

	
}
