/**
 * 
 */
package it.unicam.cs.pa.mastermind.piece;

import java.util.Optional;

import it.unicam.cs.pa.mastermind.exception.IllegalIdArgument;

/**
 * @author Michele Celozzi
 *
 */
public class Piece extends AbstractPiece {
	
	private int id;
	private Color color = null;
	
	public Piece(int id, Color c)throws IllegalIdArgument {
		if(id >= 0) {
			this.id = id;
		}
		else throw new IllegalIdArgument(id);
		
		this.color = c;
	}

	/* (non-Javadoc)
	 * @see it.unicam.cs.pa.mastermind.piece.AbstractPiece#getColor()
	 */
	@Override
	public Color getColor() {
		return this.color;
	}
	
	/* (non-Javadoc)
	 * @see it.unicam.cs.pa.mastermind.piece.AbstractPiece#getId()
	 */
	@Override
	public Optional<Integer> getId() {
		return Optional.of(this.id);
	}

	/* (non-Javadoc)
	 * @see it.unicam.cs.pa.mastermind.piece.AbstractPiece#isNull()
	 */
	@Override
	public boolean isNull() {
		return false;
	}

}
