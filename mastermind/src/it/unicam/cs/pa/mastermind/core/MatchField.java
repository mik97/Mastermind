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

	private boolean initialized;
	
	private Cell field[][];
	private Size size;
	
	public MatchField() {
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
	
	public boolean insert(List<AbstractPiece> piece) {
		initCheckup();
		
		if(checkInsert(getCellList(getRow()), getRow())) {
				insertPiece(getCellList(getRow()), piece);
				return true;
			}
			return false;
	}
	
	public Cell[][] getField() {
		return this.field;
	}
	
	private boolean initCheckup() {
		return this.initialized;
	}
	
	public int getRows() {
		initCheckup();
		return this.size.getRow();
	}
	
	public int getColumns() {
		initCheckup();
		return this.size.getColumn();
	}
	
	public List<Cell> getCellList(int row) {
		List<Cell> cells = new ArrayList<>();
		
		for(int i = 0; i < getColumns(); i++) {
			cells.add(field[row][i]);
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
		
		//this.setCellInField(cell);
	}
	
	private void setCellInField(List<Cell> cells) {
		for(int i = 0; i < getColumns(); i++) {
			field[getRow()][i] = cells.get(i);
		}
	}
	
	public boolean checkInsert(List<Cell> cell, int i) {
//		List<Cell> cells = getCellList(cell, i);
		
		if(cell.stream().filter(emptyCell -> emptyCell.isEmpty()).count() == getColumns()) {
			return true;
		}
		
		return false;
		
	}

	public boolean isFull() {
		int count = 0;
		
		for(int i = 0; i < getRows(); i++) {
			for(int j = 0; j < getColumns(); j++) {
				if(!field[i][j].isEmpty() && j == getColumns() - 1) {
					count++;
				}
			}
		}
		
		if(count == getRows()) {
			return true;
		} else {
			return false;
		}
	}
	

	public void clear() {
		for(int i = 0; i < getRows(); i++) {
			for(int j = 0; j < getColumns(); j++) {
				field[i][j].pop();
			}
		}
		
	}
	
	public int getRow() {
		for(int i = 0; i < getRows(); i++) {
			for(int j = 0; j < getColumns(); j++) {
				if(field[i][j].isEmpty() || i == getRows() - 1) {
					return i;
				} else {
					continue;
				}
			}
		}
		
		return -1;
	}
}