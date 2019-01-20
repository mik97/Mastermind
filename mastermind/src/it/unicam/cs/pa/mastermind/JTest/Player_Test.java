package it.unicam.cs.pa.mastermind.JTest;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.player.InteractivePlayer;
import it.unicam.cs.pa.mastermind.player.PlayerAction;
import it.unicam.cs.pa.mastermind.player.Role;
import it.unicam.cs.pa.mastermind.ruleSet.DefaultRuleset;
import it.unicam.cs.pa.mastermind.tmp.*;
class Player_Test {

	@Test
	void Playertest() 
	{
		DefaultRuleset rule = new DefaultRuleset();
		
		InteractivePlayer P1 = new InteractivePlayer("SUS",Role.CODEBREACKER);
		P1.init(1, rule);
		P1.selectAction();
		assertTrue(!P1.getRule().getPlayerActionMap().isEmpty());
		assertTrue(P1.getAction()!= null);
		
		
	}
	
}
