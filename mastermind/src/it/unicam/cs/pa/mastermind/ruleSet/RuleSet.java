package it.unicam.cs.pa.mastermind.ruleSet;

import java.util.HashMap;

import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.core.Size;
import it.unicam.cs.pa.mastermind.player.PlayerAction;

/**
 * @author luca
 *
 */

public interface RuleSet 
{
	public abstract int getCurrentLine(); 
	public abstract Size getFieldSize(); 
	public abstract void  setField(MatchField field) ; 
	public abstract HashMap<Integer, PlayerAction> getPlayerActionMap();
	public  abstract boolean checkField(); // controlla se il filed è pieno 
	public  abstract boolean isValidAction(PlayerAction action); // verifica che un azione selezionata da un giocatore  sia valida 
}
