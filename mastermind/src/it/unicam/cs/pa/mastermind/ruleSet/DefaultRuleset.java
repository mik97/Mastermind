package it.unicam.cs.pa.mastermind.ruleSet;

import java.util.HashMap;

import it.unicam.cs.pa.mastermind.player.PlayerAction;

public class DefaultRuleset implements Ruleset
{
	public static final int fieldSize[] = {7,4};
	private HashMap<Integer, PlayerAction> playerActionMap = new HashMap();
	
	public DefaultRuleset() 
	{
		playerActionMap.put(0, PlayerAction.INSERTCOLOR);
		playerActionMap.put(1, PlayerAction.MAKECOMBINATION);
		playerActionMap.put(2, PlayerAction.ISTHECORRECTCOMBINATION);
	}
	
	
	
	
	
	
	
	
	

	@Override
	public void lineIsFull() // controlla che la riga su cui si sta lavorando non sia piena in caso lo sia fa scorrere vero la successiva.
	{
		
		
	}

	@Override
	public int []getFiledSize()
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
	public void ConfirmInsert()//una volta inserita la combinazione chiede conferma in caso di risposta neativa mostra le cose possibili da fare.
	{
		
		
	}

	@Override
	public void LineIsFull() //controlla se la riga è piena, quando è piena seleziona la riga sucessiva.
	{
		
		
	}



	public HashMap<Integer, PlayerAction> getPlayerActionMap() {
		return playerActionMap;
	}



	@Override
	public Winner TheWinnerIs() 
	{
	
		return null;
	}

}
