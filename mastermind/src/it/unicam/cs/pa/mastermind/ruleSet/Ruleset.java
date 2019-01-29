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
public void SwitchColor();
public void RemoveColor();
public void ConfirmInsert();
public void LineIsFull();
public HashMap<Integer, PlayerAction> getPlayerActionMap();
public Winner TheWinnerIs();
}
