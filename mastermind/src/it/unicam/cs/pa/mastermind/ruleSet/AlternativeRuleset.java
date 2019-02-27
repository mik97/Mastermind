package it.unicam.cs.pa.mastermind.ruleSet;

import java.util.HashMap;

import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.core.Size;
import it.unicam.cs.pa.mastermind.player.PlayerAction;

public class AlternativeRuleset implements RuleSet
{
	public static Size fieldSize;
	public MatchField field;
	
	
	@Override
	public Size getFieldSize() {
		
		return fieldSize;
	}

	@Override
	public HashMap<Integer, PlayerAction> getPlayerActionMap() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean ConfirmInsert(String choice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Switch(int posIn, int posFin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Remove(int Target)
	{
		// TODO Auto-generated method stub
		
	}
	
	private boolean checkSize(Size fieldSize) 
	{
		if(fieldSize.getColumn() >= 4) return true;
		else return false;
	}
	
	public AlternativeRuleset(Size size,MatchField field)
	{
		 if(checkSize(size))fieldSize = size;
		 this.field = field;
		
	}

	@Override
	public int getCurrentLine() 
	{
	
		return 0;
	}

	@Override
	public boolean isValidAction(PlayerAction action) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkField() {
		// TODO Auto-generated method stub
		return false;
	}
}
