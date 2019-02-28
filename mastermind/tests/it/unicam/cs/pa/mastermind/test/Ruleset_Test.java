package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.core.Cell;
import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.core.Size;
import it.unicam.cs.pa.mastermind.piece.AbstractPiece;
import it.unicam.cs.pa.mastermind.piece.Color;
import it.unicam.cs.pa.mastermind.piece.Piece;
import it.unicam.cs.pa.mastermind.ruleSet.AlternativeRuleset;
import it.unicam.cs.pa.mastermind.ruleSet.DefaultRuleSet;
import it.unicam.cs.pa.mastermind.ruleSet.RuleFactory;
import it.unicam.cs.pa.mastermind.ruleSet.RuleSet;

/**
 * @author luca
 *
 */

class Ruleset_Test

{	MatchField filed = new MatchField();
	DefaultRuleSet rule = new DefaultRuleSet();
	RuleFactory factory = new RuleFactory(new Size(7,6),"Alternative",filed);
	
	@Test
	void Test_ConfirmInsert_DefaultRuleset()
	{
		filed.init(rule.getFieldSize());
		assertFalse(rule.ConfirmInsert("Yes"));
	}

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
	
	
	@Test
	void Test_RemovreColor_DefaultRuleset()
	{ 
		Test_checkField_DefaultRuleset();
		rule.Remove(3);
		
		List<Cell> cell = filed.getCellList(0);
		assertTrue(cell.get(3).isEmpty());
	}
	
	@Test
	void Test_RemovreColor_Alternative_DefaultRuleset()
	{ 
		Test_checkField_DefaultRuleset();
		rule.Remove(3, new Piece(11, Color.GIALLO));
		List<Cell> cell = filed.getCellList(0);
		assertTrue(cell.get(3).getPiece().getColor() == Color.GIALLO);
	}
	
	@Test
	void Test_Switch_DefaultRuleset()
	{ 
		Test_checkField_DefaultRuleset();
		rule.Switch(0, 2);
		List<Cell> cell = filed.getCellList(0);
		assertTrue(cell.get(0).getPiece().getColor() == Color.ROSSO && cell.get(2).getPiece().getColor() == Color.ARANCIONE);
	}
	@Test
	void Test_RuleFactory_DefaultRuleset()
	{
		RuleSet RuR = factory.getRule();
		assertTrue(RuR.getClass().equals(new AlternativeRuleset(RuR.getFieldSize(), null).getClass()));
		assertTrue(RuR.getFieldSize().getRow() >=7 && RuR.getFieldSize().getColumn() >=4);
	}
	
}