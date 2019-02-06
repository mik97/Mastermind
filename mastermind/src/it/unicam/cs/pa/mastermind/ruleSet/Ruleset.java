package it.unicam.cs.pa.mastermind.ruleSet;

import java.util.HashMap;

import it.unicam.cs.pa.mastermind.core.Size;
import it.unicam.cs.pa.mastermind.player.PlayerAction;

/**
 * @author luca
 *
 */

public interface Ruleset 
{


public Size getFiledSize();
public HashMap<Integer, PlayerAction> getPlayerActionMap();
public boolean  LineIsFull();
public void NextLine();
public boolean ConfirmInsert(String choice);
public void SwitchColor(int posIn, int posFin);
public void RemoveColor(int Target);


}
