package it.unicam.cs.pa.mastermind.core;

import java.util.ArrayList;
import java.util.List;

import it.unicam.cs.pa.mastermind.exception.UnitializedSingleton;
import it.unicam.cs.pa.mastermind.piece.AbstractPiece;

/**
 * @author Michele Celozzi
 *
 */
public class MatchField {

	private static final MatchField INSTANCE = new MatchField();
	private boolean initialized;
	public UnitializedSingleton exc = new UnitializedSingleton("MatchField");
	
	private Cell field[][];
	private Size size;
	private int pieces;
	
	private MatchField() {
		this.initialized = false;
	}
	
	public boolean init(Size size) {
		if(!initialized) {
			this.size = size;
			this.field = new Cell[this.size.getRow()][this.size.getColumn()];
			this.initialized = true;
			topUp();
			return true;
		}
		
		return false;
	}
	
	public void topUp() {
		for(int i = 0; i < getRows(); i++) {
			for(int j = 0; j < getColumns(); j++) {
				this.field[i][j] = new Cell();
			}
		}
	}
	
	public void setPieces() throws UnitializedSingleton {
		initCheckup();
		long empty = getEmptyCells().stream().filter(cell -> cell.isEmpty()).count();
		pieces += empty;
	}
	
	public boolean insert(List<AbstractPiece> piece, int index)throws UnitializedSingleton {
		initCheckup();		
		if(pieces <= getRows()*getColumns()) {
			if(checkInsert(getRow(),index)) {
				insertPiece(getCellList(getRow(),index), piece);
				return true;
			}
			return false;
		}
		
		return false;
	}
	
	private void initCheckup()throws UnitializedSingleton {
		if(!initialized)
			throw exc;
	}
	
	public int getRows() {
		initCheckup();
		return this.size.getRow();
	}
	
	public int getColumns() {
		initCheckup();
		return this.size.getColumn();
	}
	
	public List<Cell> getEmptyCells() {
		List<Cell> cell = new ArrayList<>();
		
		for(int i = 0; i < getRows(); i++) {
			for(int j = 0; j < getColumns(); j++) {
				cell.add(field[i][j]);
			}
		}
		
		return cell;
	}
	
	public List<Cell[]> getRow() {
		List<Cell[]> cells = new ArrayList<>();
		
		for(int i = 0; i < getRows(); i++) {
			cells.add(this.field[i]);
		}		
	
		
		return cells;
	}
	
	private void insertPiece(List<Cell> cell, List<AbstractPiece> piece) {
		if(cell.stream().anyMatch(cel -> cel.getStatus().equals(CellStatus.EMPTY))) {
			for(int i = 0; i < cell.size(); i++) {
				cell.get(i).setPiece(piece.get(i));
			}
			
			cell.stream().forEach(cel -> cel.setStatus(CellStatus.FULL));
		}
	}
	
	public boolean checkInsert(List<Cell[]> cell, int i) {
		List<Cell> cells = getCellList(cell, i);
		
		if(cells.stream().filter(emptyCell -> emptyCell.isEmpty()).count() == getColumns()) {
			return true;
		}
		
		return false;
		
	}
	
	public List<Cell> getCellList(List<Cell[]> cell, int i){
		List<Cell> cells = new ArrayList<>();

		for(int x = 0; x < getColumns(); x++) {
			cells.add(cell.get(i)[x]);
		}
		
		return cells;
	}
	
	public static MatchField getInstance() {
		return INSTANCE;
	}
}