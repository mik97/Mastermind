package it.unicam.cs.pa.mastermind.ruleSet;

import java.util.HashMap;

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

public class DefaultRuleset implements Ruleset
{
	public static final Size fieldSize = new Size(7,4);
	private HashMap<Integer, PlayerAction> playerActionMap = new HashMap();
	public MatchField field;
	private int currentLine = 6;
	
	public DefaultRuleset(MatchField field) 
	{
		playerActionMap.put(0, PlayerAction.INSERTCOLOR);
		playerActionMap.put(1, PlayerAction.MAKECOMBINATION);
		playerActionMap.put(2, PlayerAction.ISTHECORRECTCOMBINATION);
		this.field=field;
		
	}
	

	
	@Override
	public Size getFiledSize()
	{
		return fieldSize;
		
	}
	@Override
	public void Switch(int posIn,int posFin)// quando finisce una combinazione se ci sono colori corretti in pos errate permette di scambiare i colori di posto
	{
		Cell[] cell = this.field.getRow().get(currentLine);
		
		AbstractPiece a ;
		AbstractPiece b;
		
		a=cell[posIn].pop();
		b=cell[posFin].pop();
		
		cell[posIn].setPiece(b);
		cell[posFin].setPiece(a);
	}

	@Override
	public void Remove(int Target)	
	{
		Cell[] cell = this.field.getRow().get(currentLine);
		cell[Target].pop();
		
	}
	
	public void Remove(int Target,Piece newPiece)//utile si in caso di errore di inserimento.
	{
		Cell[] cell = this.field.getRow().get(currentLine);
		cell[Target].pop();
		cell[Target].setPiece(newPiece);
	}


	@Override
	public boolean ConfirmInsert(String choice)//una volta inserita la combinazione chiede conferma in caso di risposta neativa mostra le cose possibili da fare.
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

	


	public boolean LineIsFull() //controlla se la riga è piena, quando è piena seleziona la riga sucessiva.
	{	int counter = 0;
		
		Cell[] cell=field.getRow().get(currentLine);
		for(int i = 0;i<field.getColumns();i++)
		{   
			if(cell[i].getStatus() == CellStatus.FULL)	counter++;
			
		}
		if(counter == field.getColumns())
		{
			return true;
		}else return false;
		
	}



	@Override
	public void NextLine()
	{
		if(this.currentLine <0) System.out.println("The game is end"); 
		else this.currentLine--;
		
	}

	
	public boolean isValidAction(int V) 
	{
		if (this.playerActionMap.get(V) != null)
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
