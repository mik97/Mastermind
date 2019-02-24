/**
 * 
 */
package it.unicam.cs.pa.mastermind.core;

import it.unicam.cs.pa.mastermind.piece.Color;
import it.unicam.cs.pa.mastermind.piece.AbstractPiece;
import it.unicam.cs.pa.mastermind.piece.Piece;

/**
 * @author Michele Celozzi
 *
 */
public class PieceFactory {

	private final static PieceFactory INSTANCE = new PieceFactory();
	private int id;
	
	public PieceFactory() {
		restart();
	}
	
	public static PieceFactory getInstance() {
		return INSTANCE;
	}
	
	public AbstractPiece getPiece(Color color)throws IllegalArgumentException {
		return new Piece(this.id++, color);
	}

	public void restart() {
		this.id = 0;
		
	}
}
