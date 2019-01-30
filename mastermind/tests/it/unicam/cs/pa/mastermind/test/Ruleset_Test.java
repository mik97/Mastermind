package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.piece.AbstractPiece;
import it.unicam.cs.pa.mastermind.piece.Color;
import it.unicam.cs.pa.mastermind.piece.Piece;
import it.unicam.cs.pa.mastermind.ruleSet.DefaultRuleset;

/**
 * @author luca
 *
 */

class Ruleset_Test
{	MatchField filed = MatchField.getInstance();
	DefaultRuleset rule = new DefaultRuleset(filed);
	
	@Test
	void ConfirmInsert()
	{
		filed.init(rule.getFiledSize());
		assertTrue(rule.ConfirmInsert("Yes"));
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
}
