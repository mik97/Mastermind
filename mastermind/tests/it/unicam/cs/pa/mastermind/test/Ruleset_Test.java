package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.piece.AbstractPiece;
import it.unicam.cs.pa.mastermind.piece.Color;
import it.unicam.cs.pa.mastermind.piece.Piece;
import it.unicam.cs.pa.mastermind.ruleSet.DefaultRuleSet;
/**
 * @author luca
 *
 */

class Ruleset_Test

{	MatchField filed = new MatchField();
	DefaultRuleSet rule = new DefaultRuleSet();
	
	
	@Test
	void Test_checkField_DefaultRuleset()
	{	
		filed.init(rule.getFieldSize());
		rule.setField(filed);
		List<AbstractPiece> piece = new ArrayList<>();
		Piece p1 = new Piece(0, Color.ARANCIONE);
		Piece p2 = new Piece(1, Color.BLU);
		Piece p3 = new Piece(2, Color.ROSSO);
		Piece p4 = new Piece(3, Color.NERO);
	
		piece.add(p1);
		piece.add(p2);
		piece.add(p3);
		piece.add(p4);
		filed.insert(piece);
		assertTrue(rule.checkField() == false);
		
	}
	
}