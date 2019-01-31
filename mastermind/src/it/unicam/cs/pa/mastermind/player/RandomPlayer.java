package it.unicam.cs.pa.mastermind.player;

import it.unicam.cs.pa.mastermind.ruleSet.RuleSet;
import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.exception.IllegalIdArgument;
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

	
	public  RandomPlayer(String name,Role role) 
	{
		this.playerName=name;
		this.role=role;
	}
	
	@Override
	public void init(int id, MatchField field, RuleSet rule)throws IllegalIdArgument
	{
		this.id = id;
		this.field = field;
		super.setRule(rule);
		switch (role) {
		case CODEBREAKER:
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
	public int selectTarget() {
		// TODO Auto-generated method stub
		return 0;
	}
}
