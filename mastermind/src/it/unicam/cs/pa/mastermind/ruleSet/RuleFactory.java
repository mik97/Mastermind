package it.unicam.cs.pa.mastermind.ruleSet;

import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.core.PieceFactory;
import it.unicam.cs.pa.mastermind.core.Utils;
import it.unicam.cs.pa.mastermind.piece.AbstractPiece;
import it.unicam.cs.pa.mastermind.piece.Color;
import it.unicam.cs.pa.mastermind.piece.Piece;

public class RuleFactory 
{
	private final static RuleFactory INSTANCE = new RuleFactory();
	
	
	
	public static RuleFactory getInstance() 
	{
		return INSTANCE;
	}
	
	public Ruleset getRule(String Rule)throws IllegalArgumentException
	{	Ruleset rule = null;  
		
		
		switch (Rule) 
		{
		case "Default": return rule = new DefaultRuleset(null);
		case "Alternative": return rule = new AlternativeRuleset(0, 0);	
		}
		return rule;
	}

	
	
}
