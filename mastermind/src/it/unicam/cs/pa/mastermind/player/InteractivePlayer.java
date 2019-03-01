package it.unicam.cs.pa.mastermind.player;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


import it.unicam.cs.pa.mastermind.core.Cell;
import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.core.PieceFactory;
import it.unicam.cs.pa.mastermind.core.Utils;
import it.unicam.cs.pa.mastermind.exception.IllegalIdArgument;
import it.unicam.cs.pa.mastermind.exception.IllegalRoleActionException;
import it.unicam.cs.pa.mastermind.exception.InternalException;
import it.unicam.cs.pa.mastermind.piece.AbstractPiece;
import it.unicam.cs.pa.mastermind.piece.Color;
import it.unicam.cs.pa.mastermind.piece.Piece;
import it.unicam.cs.pa.mastermind.ruleSet.RuleSet;


/**
 * @author luca
 *
 */

public class InteractivePlayer extends Player {


	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private PrintStream out = System.out;

	public PlayerAction selectAction() throws InternalException,IllegalRoleActionException{
		
		System.out.println("Available Actions:\n");
		super.getRule().getPlayerActionMap().entrySet().forEach(i -> out.println(i.getKey() + " - " + i.getValue()));
		PlayerAction y = Utils.doInput(in, out, "choose an action", this.rule::isValidAction, PlayerAction::valueOf);
		try {
			switch (role)
			{
			
			case CODEBREAKER:
				if (y == PlayerAction.MakeCombination || y  == PlayerAction.IsTheCorrectCombination) throw new IllegalRoleActionException();
				this.action = y;
				break;

			case CODEMAKER:
				if(this.role == Role.CODEMAKER && y == PlayerAction.InsertColor) throw new IllegalRoleActionException();
				this.action = y;
				break;
				}
		    }
		    catch (IllegalRoleActionException e)
			{
		    	System.out.println(e.toString());
		    	this.selectAction();
			}
				
			return this.action;
	}

	public InteractivePlayer(String name, Role role) {
		this.playerName = name;
		this.role = role;
	}
	
//	public InteractivePlayer(String name,Role role,InputStream in, PrintStream out)
//	{  
//		super(name,role,in,out);
//	}
//	
//	public InteractivePlayer(String name,Role role) 
//	{
//		this(name, role, System.in, System.out);
//	}

	@Override
	public void init(int id, MatchField field, RuleSet rule) throws IllegalIdArgument
	{
		this.id = id;
		super.setRule(rule);
		
		if(this.role == Role.CODEMAKER) {
			this.action = PlayerAction.InsertColor;
			this.field = null;
			this.combination = new ArrayList<>();
		}
		else {
			this.field = field;
			this.combination = null;
		}
	}
	

//	@Override
//	public int selectTarget()
//	{   
//		int limit = this.field.getColumns()-1;
//		int target = Utils.doInput(in, out, "Chose Target: between 0 - "+limit,
//				(x)-> x <= this.field.getColumns()-1, Integer::parseInt);
//		
//		return target;
//	}
	
	@Override
	public boolean insertCombination() {
		List<Color> colors = new ArrayList<>();
		
		for(int i = 0; i < this.field.getColumns(); i++) {
			colors.add(Utils.insertColor(in, out));
		}
		
		
		
		List<AbstractPiece> pieces = new ArrayList<>();
		
		PieceFactory pieceFactory = PieceFactory.getInstance();
		
		colors.stream().forEach(x -> {
			AbstractPiece piece = pieceFactory.getPiece(x);
			pieces.add(piece);
		});
		
		if(field.insert(pieces)) {
			return true;
		}
		
		return false;
	}
	
	
	
	@Override
	public boolean makeCombination() 
	{
		if(this.combination.isEmpty()) {
		System.out.println("Insert the secret combination: \n"+Utils.showColorValue());
		for(int i = 0; i < this.rule.getFieldSize().getColumn(); i++) 
		{
			int color = Utils.doInput(in, out, "",(x) -> x >= 0 && x <= Color.values().length -1, Integer::parseInt);
			
			Cell cell = new Cell();
			cell.setPiece(new Piece(i, Color.getColor(color)));
		
			combination.add(cell);
		}
	}
		return true;
}
	
	@Override
	public boolean isTheCorrectCombination(List<Cell> combination) 
	{
		combination.stream().forEach(x-> System.out.print(x.getPiece().getColor()));
		String choice = Utils.doInput(in, out, "\n Is the correct combination ? : y/n", (x)-> x.equals("y") || x.equals("n"),String::valueOf);
		
		if(choice.contentEquals("y"))return true;
		else 
		{	if(choice.contentEquals("n")) 
			{
			int correct = Utils.doInput(in, out, "how many colors are correct ?",(x) -> x >= 0 && x <= rule.getFieldSize().getColumn(), Integer::parseInt);
			int WrongPos = Utils.doInput(in, out, "how many colors are in wrong position ?",(x) -> x >= 0 && x <= rule.getFieldSize().getColumn(), Integer::parseInt);
			System.out.println("there are: "+correct+" corrct colors \n"+" and "+WrongPos+" wrong colors position");
			return false;
			}
		}
		return false;
	}
}