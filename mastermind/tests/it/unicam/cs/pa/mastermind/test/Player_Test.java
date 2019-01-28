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
import it.unicam.cs.pa.mastermind.player.RandomPlayer;
import it.unicam.cs.pa.mastermind.player.Role;
import it.unicam.cs.pa.mastermind.ruleSet.DefaultRuleset;


/**
 * @author luca
 *
 */

class Player_Test 
{

	@Test
	void InteractivePlayertest() 
	{
		DefaultRuleset rule = new DefaultRuleset();
		InteractivePlayer P1 = new InteractivePlayer("SUS",Role.CODEBREACKER);
		P1.init(1, rule);
		P1.selectAction();
		assertTrue(P1.getAction()!= null);
	}
	
	@Test
	void RandomPlayertest()
	{	DefaultRuleset rule = new DefaultRuleset();
		RandomPlayer P2 = new RandomPlayer("SIS", Role.CODEMAKER);
		P2.init(2, rule);
		P2.selectAction();
		switch (P2.getRole()) 
		{
		case CODEBREACKER:
			assertTrue(P2.getAction()!= null);
			assertTrue(P2.getSecondaryAction()== null);
		
		case CODEMAKER:
			assertTrue(P2.getAction()!= null);
			assertTrue(P2.getSecondaryAction()!= null);
		}
		
	}
	
}
