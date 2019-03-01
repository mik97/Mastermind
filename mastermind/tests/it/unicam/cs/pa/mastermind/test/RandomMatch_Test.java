package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.match.Match;
import it.unicam.cs.pa.mastermind.player.Player;
import it.unicam.cs.pa.mastermind.player.RandomPlayer;
import it.unicam.cs.pa.mastermind.player.Role;
import it.unicam.cs.pa.mastermind.ruleSet.DefaultRuleSet;

class RandomMatch_Test {

	Player p1 = new RandomPlayer("Player1", Role.CODEMAKER);
	Player p2 = new RandomPlayer("Player2", Role.CODEBREAKER);
	
	HashMap<String, Object> prop = new HashMap<>();
	
	@Test
	void Match_Tests_Random() 
	{
		
		
		
		
		prop.put("size", DefaultRuleSet.fieldSize);
		prop.put("referee", new DefaultRuleSet());
		prop.put("firstPlayer", 0);
		Match m = Match.getInstance();
		m.initMatch(p1, p2, prop);
		m.start();
	}

}


