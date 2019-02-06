package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.core.Cell;
import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.piece.AbstractPiece;
import it.unicam.cs.pa.mastermind.piece.Color;
import it.unicam.cs.pa.mastermind.piece.Piece;
import it.unicam.cs.pa.mastermind.ruleSet.DefaultRuleset;
import it.unicam.cs.pa.mastermind.ruleSet.RuleFactory;
import it.unicam.cs.pa.mastermind.ruleSet.Ruleset;

/**
 * @author luca
 *
 */

class Ruleset_Test
{	MatchField filed = MatchField.getInstance();
	DefaultRuleset rule = new DefaultRuleset(filed);
	RuleFactory factory = new RuleFactory();
	@Test
	void ConfirmInsert()
	{
		filed.init(rule.getFiledSize());
		assertFalse(rule.ConfirmInsert("Yes"));
	}

	@Test
	void LineIsFull()
	{	filed.init(rule.getFiledSize());
	
		List<AbstractPiece> piece = new ArrayList();
		Piece p1 = new Piece(0, Color.ARANCIONE);
		Piece p2 = new Piece(1, Color.BLU);
		Piece p3 = new Piece(2, Color.ROSSO);
		Piece p4 = new Piece(3, Color.NERO);
	
		piece.add(p1);
		piece.add(p2);
		piece.add(p3);
		piece.add(p4);
		filed.insert(piece, rule.getCurrentLine());
		assertTrue(rule.LineIsFull() == true);
		
	}
	
	@Test
	void NextLine()
	{
		LineIsFull();
		rule.NextLine();
		assertTrue(rule.LineIsFull() == false);
	}
	@Test
	void RemovreColor()
	{ 
		LineIsFull();
		rule.RemoveColor(3);
		assertTrue(rule.LineIsFull());
	}
	
	@Test
	void SwitchColor()
	{ 
		LineIsFull();
		rule.SwitchColor(0, 2);
		Cell[] cell = rule.field.getRow().get(rule.getCurrentLine());
		assertTrue(cell[0].getPiece().getColor() == Color.ROSSO && cell[2].getPiece().getColor() == Color.ARANCIONE);
	}
	@Test
	void RuleFactory()
	{
		Ruleset RuR = factory.getRule("Default");
		Ruleset RaR = factory.getRule("Alternative");
		assertTrue(RuR.getClass().equals(rule.getClass()));
		assertTrue(RaR.getClass().equals(factory.getRule("Alternative").getClass()));
	}
	
}
