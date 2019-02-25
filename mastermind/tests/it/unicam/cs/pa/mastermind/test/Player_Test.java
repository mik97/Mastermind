package it.unicam.cs.pa.mastermind.test;

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
import it.unicam.cs.pa.mastermind.core.MatchField;

/**
 * @author luca
 *
 */

class Player_Test 

{	
	MatchField mfield = MatchField.getInstance();
	DefaultRuleset rule = new DefaultRuleset(mfield);
	
	
	InteractivePlayer P1 = new InteractivePlayer("SUS",Role.CODEBREAKER);
	RandomPlayer P2 = new RandomPlayer("SIS", Role.CODEMAKER);
	
	
	
	@Test
	void Test_Init_InteracivePlayer() 
	{	
		mfield.init(rule.getFiledSize());
		P1.init(1, mfield,rule);
		assertTrue(P1.getRule() != null);
		assertTrue(P1.getId()!=0);
	}
	
	@Test
	void Test_SelectAction_InteracivePlayer()
	
	{	Test_Init_InteracivePlayer();
		P1.selectAction();
		assertTrue(P1.getAction()!= null);
	}
	
	@Test
	void Test_isTheCorrectCombination_InteracivePlayer() 
	{
		Test_Init_InteracivePlayer();
		assertTrue(P1.isTheCorrectCombination("Yes"));
	}
	
	@Test
	void Test_Init_RandomPlayer()
	{	
		mfield.init(rule.getFiledSize());
		P2.init(2, mfield, rule);
		assertTrue(P2.getRule() != null);
		assertTrue(P2.getId()!=0);
		
	}

	@Test
	void Test_SelectAction_RandomPlayer()
	
	{	Test_Init_RandomPlayer();
		P2.selectAction();
		assertTrue(P2.getAction()!= null);
		
	}

	@Test
	void Test_RandomPlayer_Assignment()
	{
		Test_Init_RandomPlayer();
		Test_SelectAction_RandomPlayer();
		
		switch (P2.getRole()) 
		{
		case CODEBREAKER:
			assertTrue(P2.getAction()!= null);
			assertTrue(P2.getSecondaryAction()== null);
		
		case CODEMAKER:
			assertTrue(P2.getAction()!= null);
			assertTrue(P2.getSecondaryAction()!= null);
		}
	}
	@Test
	void Test_RandomPlayer_MakeComb()
	{
		Test_Init_RandomPlayer();
		P2.makeComb();
		assertTrue(P2.getCodeMakerCombination() != null);
	}
	
	
	
}
