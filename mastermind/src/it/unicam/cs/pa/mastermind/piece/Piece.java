/**
 * 
 */
package it.unicam.cs.pa.mastermind.piece;

import it.unicam.cs.pa.mastermind.core.CellStatus;
import it.unicam.cs.pa.mastermind.exception.IllegalIdArgument;

/**
 * @author Michele Celozzi
 *
 */
public class Piece extends AbstractPiece {
	
	private int id;
	private Color color;
	
	public Piece(int id, Color c, CellStatus s)throws IllegalIdArgument, IllegalArgumentException {
		if(id >= 0) {
			this.id = id;
		}
		else throw new IllegalIdArgument(id);
		
		if(s == CellStatus.EMPTY)
			this.color = c;
		else
			throw new IllegalArgumentException();
	}

	/* (non-Javadoc)
	 * @see it.unicam.cs.pa.mastermind.piece.AbstractPiece#getColor()
	 */
	@Override
	public Color getColor() {
		return this.color;
	}

	/* (non-Javadoc)
	 * @see it.unicam.cs.pa.mastermind.piece.AbstractPiece#isNull()
	 */
	@Override
	public boolean isNull() {
		return false;
	}

}
