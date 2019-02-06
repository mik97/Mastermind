package it.unicam.cs.pa.mastermind.core;

import it.unicam.cs.pa.mastermind.piece.AbstractPiece;
import it.unicam.cs.pa.mastermind.piece.NullPiece;

/**
 * @author Michele Celozzi
 *
 */
public class Cell {
	
	private AbstractPiece piece;
	private CellStatus status;
	
	public Cell() {
		this.piece = new NullPiece();
		this.status = CellStatus.EMPTY;
	}
	
	public CellStatus getStatus() {
		return this.status;
	}
	
	public boolean isEmpty() {
		return this.piece.isNull();
	}
	public AbstractPiece pop() {
	    AbstractPiece returnPiece = getPiece();
	    this.piece = new NullPiece();
	    return returnPiece;
	  }
	
	public AbstractPiece getPiece() 
	{
	    return this.piece;
	}
	
	public boolean setPiece(AbstractPiece piece) {
		if(!this.piece.isNull()) {
			return false;
		} else {
			this.piece = piece;
			return true;
		}		
	}
	
	public void setStatus(CellStatus s) {
		this.status = s;
	}
}
