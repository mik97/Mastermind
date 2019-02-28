/**
 * 
 */
package it.unicam.cs.pa.mastermind.piece;

import java.util.Optional;

/**
 * @author Michele Celozzi
 *
 */
public abstract class AbstractPiece {

	public AbstractPiece() {}
	
	/**
	 * returns the color
	 * @return
	 */
	public abstract Color getColor();
	
	/**
	 * returns the id
	 * @return
	 */
	public abstract Optional<Integer> getId();
	
	/**
	 * checked the piece is null
	 * @return
	 */
	public abstract boolean isNull();
	
	@Override
	public String toString() {
		return getColor().toString();
	}
}
