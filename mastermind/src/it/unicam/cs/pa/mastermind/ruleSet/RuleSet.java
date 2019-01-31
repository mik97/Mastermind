package it.unicam.cs.pa.mastermind.ruleSet;

import java.util.HashMap;

import it.unicam.cs.pa.mastermind.core.Size;
import it.unicam.cs.pa.mastermind.player.PlayerAction;
import it.unicam.cs.pa.mastermind.player.Role;

/**
 * @author luca
 *
 */

public interface RuleSet 
{

	public Size getFieldSize();

	public void switchColor();
	
	public void removeColor();
	
	public void confirmInsert();
	
	public boolean lineIsFull();
	
	public HashMap<Integer, PlayerAction> getPlayerActionMap();
	
	public Role theWinnerIs();
	
	public boolean confirmInsert(String choice);
}
