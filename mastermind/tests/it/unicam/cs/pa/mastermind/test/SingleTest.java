package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.core.Size;
import it.unicam.cs.pa.mastermind.core.Utils;
import it.unicam.cs.pa.mastermind.piece.Color;
import it.unicam.cs.pa.mastermind.player.InteractivePlayer;
import it.unicam.cs.pa.mastermind.player.Role;
import it.unicam.cs.pa.mastermind.ruleSet.AlternativeRuleset;
import it.unicam.cs.pa.mastermind.ruleSet.DefaultRuleSet;
import it.unicam.cs.pa.mastermind.ruleSet.RuleSet;

class SingleTest {

	InteractivePlayer fZappa = new InteractivePlayer("simo", Role.CODEBREAKER);
	InteractivePlayer zanuf = new InteractivePlayer("zanuf", Role.CODEMAKER);
	MatchField field = new MatchField();
	RuleSet rule = new DefaultRuleSet();
	
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private PrintStream out = System.out;

	@Test
	void test() 
	{
		
	
		
		
		
		field.init(rule.getFieldSize());
		rule.setField(field);
		fZappa.init(1, field, rule);
		zanuf.init(2, field, rule);
		
		zanuf.makeCombination();
		fZappa.insertCombination();
		assertTrue(zanuf.isTheCorrectCombination(field.getCellList(0)));
	}

}
