package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.core.Size;
import it.unicam.cs.pa.mastermind.piece.Color;
import it.unicam.cs.pa.mastermind.player.InteractivePlayer;
import it.unicam.cs.pa.mastermind.player.Role;
import it.unicam.cs.pa.mastermind.ruleSet.AlternativeRuleset;
import it.unicam.cs.pa.mastermind.ruleSet.RuleSet;

class SingleTest {

	InteractivePlayer fZappa = new InteractivePlayer("simo", Role.CODEBREAKER);
	InteractivePlayer zanuf = new InteractivePlayer("zanuf", Role.CODEMAKER);
	MatchField field = new MatchField();
	RuleSet rule = new AlternativeRuleset(new Size(5, 4), field);
	
	@Test
	void test() 
	{
		
		
		field.init(rule.getFieldSize());
		
		fZappa.init(1, field, rule);
		zanuf.init(2, field, rule);
		
		zanuf.makeCombination();
		fZappa.insertCombination();
		zanuf.isTheCorrectCombination(field.getCellList(0));
		
	}

}
