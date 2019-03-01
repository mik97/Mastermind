package it.unicam.cs.pa.mastermind.ruleSet;

import java.util.HashMap;
import java.util.List;

import it.unicam.cs.pa.mastermind.core.Cell;
import it.unicam.cs.pa.mastermind.core.CellStatus;
import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.core.Size;
import it.unicam.cs.pa.mastermind.piece.AbstractPiece;
import it.unicam.cs.pa.mastermind.piece.Piece;
import it.unicam.cs.pa.mastermind.player.PlayerAction;

public class AlternativeRuleset implements RuleSet
{
	public static Size fieldSize;
	public MatchField field;
	private HashMap<Integer, PlayerAction> playerActionMap = new HashMap<>();
	private int currentLine;
	
	@Override
	public Size getFieldSize() 
	{
		
		return fieldSize;
	}

	@Override
	public HashMap<Integer, PlayerAction> getPlayerActionMap() {
		
		return playerActionMap;
	}
	
	public void remove(int target, AbstractPiece newPiece)
	{
		this.checkField();
		int a = currentLine ;
		
		List<Cell> cell = field.getCellList(--a);
		cell.get(target).pop();
		cell.get(target).setPiece(newPiece);
		cell.get(target).setStatus(CellStatus.FULL);
	}
	
	private boolean checkSize(Size fieldSize) 
	{
		if(fieldSize.getColumn() >= 4 && fieldSize.getRow() > 0) return true;
		else return false;
	}
	
	public AlternativeRuleset(Size size,MatchField field)
	{
		 if(checkSize(size))fieldSize = size;
		 this.field = field;
		 
		playerActionMap.put(0, PlayerAction.InsertColor);
		playerActionMap.put(1, PlayerAction.MakeCombination);
		playerActionMap.put(2, PlayerAction.IsTheCorrectCombination);		
		
	}

	@Override
	public int getCurrentLine() 
	{
	
		return currentLine;
	}

	@Override
	public boolean isValidAction(PlayerAction action) 
	{

		if (this.playerActionMap.containsValue(action)==  true)
			return true;
		else
			return false;
	}

	@Override
	public boolean checkField() {
		
		int cell=field.getRow();
		if(cell == -1)
		{	System.out.println("Field is full");
			return true;
		}else {
				currentLine = cell;
				return false;
				}
	}

	@Override
	public void setField(MatchField field) 
	{
		
		this.field = field;
		
	}
}
