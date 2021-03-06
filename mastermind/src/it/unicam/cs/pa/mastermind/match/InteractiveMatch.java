package it.unicam.cs.pa.mastermind.match;

import java.util.HashMap;

import it.unicam.cs.pa.mastermind.player.InteractivePlayer;
import it.unicam.cs.pa.mastermind.player.Player;
import it.unicam.cs.pa.mastermind.player.Role;
import it.unicam.cs.pa.mastermind.ruleSet.DefaultRuleSet;

/**
 * @author Michele Celozzi
 *
 */
public class InteractiveMatch {

	public static void main(String[] args) {
		Player p1 = new InteractivePlayer("Player1", Role.CODEMAKER);
		Player p2 = new InteractivePlayer("Player2", Role.CODEBREAKER);
		
		HashMap<String, Object> prop = new HashMap<>();
		
		prop.put("size", DefaultRuleSet.fieldSize);
		prop.put("referee", new DefaultRuleSet());
		prop.put("firstPlayer", 0);
		Match m = Match.getInstance();
		m.initMatch(p1, p2, prop);
		m.start();
	}

}
