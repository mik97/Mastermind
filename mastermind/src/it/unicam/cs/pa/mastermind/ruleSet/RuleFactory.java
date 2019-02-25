package it.unicam.cs.pa.mastermind.ruleSet;

import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.core.Size;
import it.unicam.cs.pa.mastermind.piece.AbstractPiece;
import it.unicam.cs.pa.mastermind.piece.Color;
import it.unicam.cs.pa.mastermind.piece.Piece;

public class RuleFactory 
{
	private Size chosenSize;
	private String choice;
	private MatchField field;
	
	public RuleFactory(Size chosenSize, String choice,MatchField field)
	{
		this.chosenSize =  chosenSize;
		this.choice = choice;
		this.field = field;
		
	}
	/**
	 * returns a specific ruleset
	 * @return
	 * @throws IllegalArgumentException
	 */
	public RuleSet getRule()throws IllegalArgumentException
	{	
		RuleSet rule = null;  
		
		switch (choice) 
		{
		case "Default": return rule = new DefaultRuleSet();
		case "Alternative": return rule = new AlternativeRuleset(chosenSize,field);	
		}
		return rule;
	}

	
	
}
