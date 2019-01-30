package it.unicam.cs.pa.mastermind.ruleSet;

import java.util.HashMap;

import it.unicam.cs.pa.mastermind.core.Cell;
import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.core.Size;
import it.unicam.cs.pa.mastermind.core.Utils;
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
	public void SwitchColor()// quando finisce una combinazione se ci sono colori corretti in pos errate permette di scambiare i colori di posto
	{
		
		
	}

	@Override
	public void RemoveColor()//utile si in caso di errore di inserimento.
	{
		
		
	}

	@Override
	public boolean ConfirmInsert(String choice)//una volta inserita la combinazione chiede conferma in caso di risposta neativa mostra le cose possibili da fare.
	{
		switch (choice)
		{
		case "Yes":
			System.out.println("Your turn is end");
			return true;
			

		case "No":
			
		}
		return false;

		
	}

	
	


	@Override
	public Winner TheWinnerIs() 
	{
	
		return null;
	}


	public boolean LineIsFull() //controlla se la riga è piena, quando è piena seleziona la riga sucessiva.
	{	int counter = 0;
		
		Cell[] cell=field.getRow().get(currentLine);
		for(int i = 0;i<field.getColumns();i++)
		{   
			if(cell[i].isEmpty() == false)	counter++;
			
		}
		if(counter == field.getColumns())
		{
			return true;
		}else return false;
		
	}



	@Override
	public void NextLine()
	{
		if(this.currentLine <0) System.out.println("The game is end"); // possibile richiamo al metodo the winner is...
		else this.currentLine--;
		
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
