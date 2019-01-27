/**
 * 
 */
package it.unicam.cs.pa.mastermind.core;

import it.unicam.cs.pa.mastermind.piece.AbstractPiece;
import it.unicam.cs.pa.mastermind.piece.Color;
import it.unicam.cs.pa.mastermind.piece.Piece;

/**
 * @author Michele Celozzi
 *
 */
public class PieceFactory {

	private static final PieceFactory INSTANCE = new PieceFactory();
	private int id;
	
	public PieceFactory() {
		this.id = 0;
	}
	
	public PieceFactory getInstance() {
		return this.INSTANCE;
	}
	
	public AbstractPiece getPiece(Color color) {
		return new Piece(this.id++, color);
	}
}
