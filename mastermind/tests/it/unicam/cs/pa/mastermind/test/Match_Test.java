package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.core.Size;
import it.unicam.cs.pa.mastermind.match.Match;
import it.unicam.cs.pa.mastermind.player.InteractivePlayer;
import it.unicam.cs.pa.mastermind.player.Player;
import it.unicam.cs.pa.mastermind.player.Role;
import it.unicam.cs.pa.mastermind.ruleSet.DefaultRuleSet;

class Match_Test {

	Match pipo = Match.getInstance();
	
	Player p1 = new InteractivePlayer("SUS", Role.CODEBREAKER);
	Player p2 = new InteractivePlayer("SAS", Role.CODEMAKER);
	
	MatchField filed = new MatchField();
	
	HashMap<String, Object>prop = new HashMap<String, Object>();
	
	DefaultRuleSet refree = new DefaultRuleSet();
	
	Size size = new Size(7,4);
	
	@Test
	void TestMatch()
	{   
		
		prop.put("firstPlayer", 0);
		pipo.initMatch(p1, p2, prop);
		
		p1.init(0, filed, refree);
		p2.init(1, filed, refree);
		filed.init(size);
		filed.topUp();
		pipo.play();
	}

}
