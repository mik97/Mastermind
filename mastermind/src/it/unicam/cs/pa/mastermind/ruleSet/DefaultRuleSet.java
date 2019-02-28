package it.unicam.cs.pa.mastermind.ruleSet;

import java.util.HashMap;
import java.util.List;

import it.unicam.cs.pa.mastermind.core.Cell;
import it.unicam.cs.pa.mastermind.core.CellStatus;
import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.core.Size;
import it.unicam.cs.pa.mastermind.core.Utils;
import it.unicam.cs.pa.mastermind.piece.AbstractPiece;
import it.unicam.cs.pa.mastermind.piece.NullPiece;
import it.unicam.cs.pa.mastermind.piece.Piece;
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
	
	public void setField(MatchField field) {
		this.field=field;
	}

	
	@Override
	public Size getFieldSize()
	{
		return fieldSize;
		
	}
	@Override
	public void Switch(int posIn, int posFin)// quando finisce una combinazione se ci sono colori corretti in pos errate permette di scambiare i colori di posto
	{
		
		this.checkField();
		int line = currentLine ;
		
		List<Cell> cell = field.getCellList(--line);
		
		AbstractPiece a ;
		AbstractPiece b;
		
		a = cell.get(posIn).pop();
		b = cell.get(posFin).pop();
		
		cell.get(posIn).setPiece(b);
		cell.get(posFin).setPiece(a);
	}

	@Override
	public void Remove(int Target)	
	{
		this.checkField();
		int a = currentLine ;
		
		List<Cell> cell = field.getCellList(--a);
		cell.get(Target).pop();
		
		
	}
	
	public void Remove(int Target,Piece newPiece)//utile se in caso di errore di inserimento.
	{
		this.checkField();
		int a = currentLine ;
		
		List<Cell> cell = field.getCellList(--a);
		cell.get(Target).pop();
		cell.get(Target).setPiece(newPiece);
		cell.get(Target).setStatus(CellStatus.FULL);
	}


	@Override
	public boolean ConfirmInsert(String choice)//una volta inserita la combinazione chiede conferma in caso di risposta negativa mostra le cose possibili da fare.
	{
		switch (choice)
		{
		case "Yes":
			System.out.println("Your turn is end");
			return false;
			

		case "No":
		System.out.println();
		return true;
			 
		}
		return false;

		
	}

		
	@Override
	public boolean checkField() //controlla se il Field è pieno, in caso sia pieno ritorna true , se e false ritorna la  riga corrente
	{
		

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
	public boolean isValidAction(PlayerAction V) 
	{
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