package it.unicam.cs.pa.mastermind.test;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.match.Match;
import it.unicam.cs.pa.mastermind.player.InteractivePlayer;
import it.unicam.cs.pa.mastermind.player.Player;
import it.unicam.cs.pa.mastermind.player.Role;
import it.unicam.cs.pa.mastermind.ruleSet.DefaultRuleSet;

class MatchTests {

	@Test
	Match testInitMatch() {
		Player p1 = new InteractivePlayer("P1", Role.CODEMAKER);
		Player p2 = new InteractivePlayer("P2", Role.CODEBREAKER);
		
		HashMap<String, Object> prop = new HashMap<>();
		
		prop.put("size", DefaultRuleSet.fieldSize);
		prop.put("referee", new DefaultRuleSet());
		prop.put("firstPlayer", 0);
		Match m = Match.getInstance();
		m.initMatch(p1, p2, prop);
		return m;
	}
	
	@Test
	void testStart() {
		Match m = testInitMatch();
		m.start();
	}

}
