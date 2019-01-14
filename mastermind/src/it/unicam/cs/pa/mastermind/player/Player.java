package it.unicam.cs.pa.mastermind.player;
import java.util.HashMap;
import java.awt.Desktop.Action;

public abstract class Player
{
   private  String playerName;
   HashMap<Integer, PlayerAction> playerAction;
   private Role role;
   private TypePlayer type;
	
	
   public abstract void makeAction();
  
}
