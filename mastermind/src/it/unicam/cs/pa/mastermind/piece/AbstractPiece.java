/**
 * 
 */
package it.unicam.cs.pa.mastermind.piece;

/**
 * @author Michele Celozzi
 *
 */
public abstract class AbstractPiece {

	public AbstractPiece() {}
	
	public abstract Color getColor();
	
	public abstract boolean isNull();

	@Override
	public String toString() {
		return getColor().toString();
	}
}
