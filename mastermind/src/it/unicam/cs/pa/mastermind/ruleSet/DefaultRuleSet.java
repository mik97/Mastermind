package it.unicam.cs.pa.mastermind.ruleSet;

import java.util.HashMap;

import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.core.Size;
import it.unicam.cs.pa.mastermind.player.PlayerAction;


/**
 * @author luca
 *
 */

public class DefaultRuleSet implements RuleSet
{
	public static final Size fieldSize = new Size(7,4);
	private HashMap<Integer, PlayerAction> playerActionMap = new HashMap<>();
	public MatchField field;
	private int currentLine;
	
	
	
	public DefaultRuleSet() 
	{
		playerActionMap.put(0, PlayerAction.InsertColor);
		playerActionMap.put(1, PlayerAction.MakeCombination);
		playerActionMap.put(2, PlayerAction.IsTheCorrectCombination);		
	}
	@Override
	public void setField(MatchField field) 
	{
		this.field=field;
	}

	
	@Override
	public Size getFieldSize()
	{
		return fieldSize;
		
	
	}
	
	@Override
	public boolean checkField() //controlla se il Field è pieno, in caso sia pieno ritorna true , se e false ritorna la  riga corrente
	{
		

		int cell=field.getRow();
		if(cell == -1)
		{	System.out.println("Field is full");
			return true;
		}else {
				currentLine = cell -1;
				return false;
				}
	}



	@Override
	public boolean isValidAction(PlayerAction V) 
	{
		if(V.equals(PlayerAction.MakeCombination) && this.field.getRow() !=0) return false;
		if(V.equals(PlayerAction.IsTheCorrectCombination) && this.field.getRow() == 0) return false;
		
		if (this.playerActionMap.containsValue(V)==  true)
			return true;
		else
			return false;
	}
	
	public int getCurrentLine()
	{
		return currentLine;
	}


	public HashMap<Integer, PlayerAction> getPlayerActionMap() 
	{
		return playerActionMap;
	}
}