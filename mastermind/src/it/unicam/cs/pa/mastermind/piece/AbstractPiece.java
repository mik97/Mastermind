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
	
	public abstract Color getColor();
	
	public abstract Optional<Integer> getId();
	
	public abstract boolean isNull();

	@Override
	public String toString() {
		return getColor().toString();
	}
}
