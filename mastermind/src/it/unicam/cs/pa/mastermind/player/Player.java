package it.unicam.cs.pa.mastermind.player;
import java.util.HashMap;
import java.awt.Desktop.Action;

public abstract class Player
{
   protected String playerName;
   protected HashMap<Integer, PlayerAction> playerActionMap = new HashMap();
   protected PlayerAction action;
   protected int mapIndex=0;
   protected Role role;

	
	
   public abstract PlayerAction selectAction();
   
   public void  fillPlayerActionMap()
   {
		switch(role) 
		{
		 	case CODEBREACKER: 
		 		playerActionMap.put(mapIndex, PlayerAction.INSERTCOLOR);
		 		mapIndex++;
		 		break;
		 		
		 	case CODEMAKER:
		 		playerActionMap.put(mapIndex, PlayerAction.MAKECOMBINATION);
			 	mapIndex++;
		 		break;
		}
	 	
   }

public String getPlayerName() {
	return playerName;
}

public void setPlayerName(String playerName) {
	this.playerName = playerName;
}

public HashMap<Integer, PlayerAction> getPlayerActionMap() {
	return playerActionMap;
}

public void setPlayerActionMap(HashMap<Integer, PlayerAction> playerActionMap) {
	this.playerActionMap = playerActionMap;
}

public Role getRole() {
	return role;
}

public void setRole(Role role) {
	this.role = role;
}

public PlayerAction getAction() {
	return action;
}
   
   
   
}
