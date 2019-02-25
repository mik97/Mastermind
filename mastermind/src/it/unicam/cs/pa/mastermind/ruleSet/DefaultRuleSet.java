package it.unicam.cs.pa.mastermind.ruleSet;

import java.util.HashMap;

import it.unicam.cs.pa.mastermind.core.Size;
import it.unicam.cs.pa.mastermind.player.PlayerAction;
import it.unicam.cs.pa.mastermind.player.Role;


/**
 * @author luca
 *
 */

public class DefaultRuleSet implements RuleSet
{
	public static final Size fieldSize = new Size(7,4);
	private HashMap<Integer, PlayerAction> playerActionMap = new HashMap<>();
	
	public DefaultRuleSet() 
	{
		playerActionMap.put(0, PlayerAction.INSERTCOLOR);
		playerActionMap.put(1, PlayerAction.MAKECOMBINATION);
		playerActionMap.put(2, PlayerAction.ISTHECORRECTCOMBINATION);
	}
	

	
	@Override
	public Size getFieldSize()
	{
		return fieldSize;
		
	}

	@Override
	public void switchColor()// quando finisce una combinazione se ci sono colori corretti in pos errate permette di scambiare i colori di posto
	{
	
		
	}

	@Override
	public void removeColor()//utile si in caso di errore di inserimento.
	{
		
		
	}

	@Override
	public void confirmInsert()//una volta inserita la combinazione chiede conferma in caso di risposta neativa mostra le cose possibili da fare.
	{
		
		
	}

	@Override
	public boolean lineIsFull() //controlla se la riga è piena, quando è piena seleziona la riga sucessiva.
	{
		return false;
	}



	public HashMap<Integer, PlayerAction> getPlayerActionMap() {
		return playerActionMap;
	}



	@Override
	public Role theWinnerIs() 
	{
	
		return null;
	}



	@Override
	public boolean confirmInsert(String choice) {
		// TODO Auto-generated method stub
		return false;
	}

}
