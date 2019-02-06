package it.unicam.cs.pa.mastermind.ruleSet;

import java.util.HashMap;
import java.util.List;

import it.unicam.cs.pa.mastermind.core.Size;
import it.unicam.cs.pa.mastermind.player.PlayerAction;

public class AlternativeRuleset implements Ruleset
{
	public static Size fieldSize;
	
	@Override
	public Size getFiledSize() {
		// TODO Auto-generated method stub
		return fieldSize;
	}

	@Override
	public HashMap<Integer, PlayerAction> getPlayerActionMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean LineIsFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void NextLine() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean ConfirmInsert(String choice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void SwitchColor(int posIn, int posFin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RemoveColor(int Target)
	{
		// TODO Auto-generated method stub
		
	}
	
	private void checkSize(Size fieldSize) 
	{
		
	}
	
	public AlternativeRuleset(int fRow,int fColumn)
	{
		if(fColumn>=4) AlternativeRuleset.fieldSize = new  Size(fRow, fColumn);
		
		
	}
	
	
}
