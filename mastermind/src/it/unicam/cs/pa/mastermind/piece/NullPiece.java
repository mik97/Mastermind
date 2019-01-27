/**
 * 
 */
package it.unicam.cs.pa.mastermind.piece;

import java.util.Optional;

/**
 * @author Michele Celozzi
 *
 */
public class NullPiece extends AbstractPiece {

	/* (non-Javadoc)
	 * @see it.unicam.cs.pa.mastermind.piece.AbstractPiece#getColor()
	 */
	@Override
	public Color getColor() {
		return null;
	}

	/* (non-Javadoc)
	 * @see it.unicam.cs.pa.mastermind.piece.AbstractPiece#getId()
	 */
	@Override
	public Optional<Integer> getId() {
		return Optional.empty();
	}

	/* (non-Javadoc)
	 * @see it.unicam.cs.pa.mastermind.piece.AbstractPiece#isNull()
	 */
	@Override
	public boolean isNull() {
		return true;
	}

}
