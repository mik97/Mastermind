package it.unicam.cs.pa.mastermind.ruleSet;

import java.util.HashMap;

import it.unicam.cs.pa.mastermind.core.Size;
import it.unicam.cs.pa.mastermind.player.PlayerAction;

/**
 * @author luca
 *
 */

public interface RuleSet 
{
	public abstract int getCurrentLine();
	public abstract Size getFiledSize();
	public abstract HashMap<Integer, PlayerAction> getPlayerActionMap();
	public  abstract boolean  LineIsFull();
	public abstract void NextLine();
	public abstract boolean ConfirmInsert(String choice);
	public abstract void Switch(int posIn, int posFin);
	public abstract void Remove(int Target);
	public  abstract boolean isValidAction(int V);
}
