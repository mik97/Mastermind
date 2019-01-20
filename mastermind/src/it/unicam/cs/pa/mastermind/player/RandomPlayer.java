package it.unicam.cs.pa.mastermind.player;

import it.unicam.cs.pa.mastermind.ruleSet.Ruleset;

public class RandomPlayer extends Player
{
	private int actionSelector=0;
	
	public PlayerAction selectAction()
	{
		return action;
		
		
	}

	@Override
	public void init(int id, Ruleset rule)// meccanismo controllo id
	{
		// TODO Auto-generated method stub
		
	}

	
}
