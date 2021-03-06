package it.unicam.cs.pa.mastermind.player;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.core.PieceFactory;
import it.unicam.cs.pa.mastermind.core.Utils;
import it.unicam.cs.pa.mastermind.core.Cell;
import it.unicam.cs.pa.mastermind.exception.IllegalIdArgument;
import it.unicam.cs.pa.mastermind.piece.AbstractPiece;
import it.unicam.cs.pa.mastermind.piece.Color;
import it.unicam.cs.pa.mastermind.piece.Piece;
import it.unicam.cs.pa.mastermind.player.PlayerAction;
import it.unicam.cs.pa.mastermind.ruleSet.RuleSet;


/**
 * @author luca
 *
 */

public class RandomPlayer extends Player
{
	
	private PlayerAction secondaryAction;
	private int timeIstant = 0;
	private PrintStream out = System.out;
	
	public  RandomPlayer(String name,Role role) 
	{
		this.playerName=name;
		this.role=role;
	}
	
	
	
	@Override
	public void init(int id, MatchField field, RuleSet rule)throws IllegalIdArgument
	{
		this.id = id;
		this.field = field;
		super.setRule(rule);
		
		switch (role) {
		case CODEBREAKER:
			action=rule.getPlayerActionMap().get(0);
			secondaryAction=null;
			break;
			
		case CODEMAKER:
			action=rule.getPlayerActionMap().get(1);
			secondaryAction=rule.getPlayerActionMap().get(2);
			combination = new ArrayList<Cell>();
			break;
		
		}
		
	}


	public PlayerAction getSecondaryAction() 
	{
		return secondaryAction;
	}
	
	public PlayerAction selectAction() 
	{
		Utils.printField(out, this.field);
		
		if(this.role.equals(Role.CODEBREAKER))
		{	timeIstant++;
			return action;
		}
		
		if(this.role.equals(Role.CODEMAKER))
		{
			if(timeIstant == 0)
			{
				timeIstant++;
				return action;
			}
			else 
			{
				return this.getSecondaryAction();
			}
		}
		return action;
	}
	
	@Override
	public boolean insertCombination() {
		List<AbstractPiece> pieces = new ArrayList<>();
		
		PieceFactory pieceFactory = PieceFactory.getInstance();
		Random rand = new Random();
		
		for(int i = 0; i < field.getColumns(); i++) {
			AbstractPiece piece = pieceFactory.getPiece(Color.getColor(rand.nextInt(Color.getSize())));
			pieces.add(piece);
		}
		
		if(field.insert(pieces)) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean makeCombination() {
		Cell cell;
		List<Color>color= Arrays.asList(Color.values());
		Random rand = new Random();
		Color a = null;
		
		for(int i = 0; i < field.getColumns();i++)
		{
			a = color.get(rand.nextInt(color.size()));
			cell = new Cell();
			cell.setPiece(new Piece(i+1, a));
			this.combination.add(cell);
		}
		if (this.combination.isEmpty()) return false;
		return true;
	}


	@Override
	public boolean isTheCorrectCombination(List<Cell> comb) {
		List<Long> pPosition = this.checkPosition(comb, this.combination);
		
		if(pPosition != null)
		{
			System.out.println("There are " + pPosition.get(0) + " pieces in the correct position");
			System.out.println("There are " + pPosition.get(1) + " pieces in the wrong position\n");
		}
		
		if(pPosition.get(0) == 4) {
			return true;
		} else {
			return false;
		}
	}
	
	private Stream<Cell> compareLists(List<Cell> comb, List<Cell> comb2) {
		Stream<Cell> stream = comb.stream().filter(x -> comb2.stream()
				.findAny().get().getPiece().getColor().equals(
						x.getPiece().getColor()));
		
		if(checkStream(stream)) {
			return stream;
		} else {
			return null;
		}
	}
	
	private List<Long> checkPosition(List<Cell> comb, List<Cell> comb2) {
		Stream<Cell> stream = compareLists(comb, comb2);
		Stream<Cell> streamCopy = compareLists(comb, comb2);
		
		List<Long> piecesPosition = new ArrayList<>();
		
		if(!checkStream(stream) && !checkStream(streamCopy)) {return null;}
		
		piecesPosition.add(0, stream.filter(x -> this.combination.stream()
				.findAny().get().getPiece().getId().equals(
						x.getPiece().getId())).count());
		
		piecesPosition.add(1, streamCopy.filter(x -> this.combination.stream()
				.findAny().get().getPiece().getId() != 
				(x.getPiece().getId())).count());
		
		return piecesPosition;
	}
	
	private boolean checkStream(Stream<Cell> stream) {
		if(stream != null) {
			return true;
		} else {
			return false;
		}
	}
}