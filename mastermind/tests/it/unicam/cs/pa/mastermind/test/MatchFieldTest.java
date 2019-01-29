/**
 * 
 */
package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.core.MatchField;
import it.unicam.cs.pa.mastermind.core.Size;
import it.unicam.cs.pa.mastermind.piece.AbstractPiece;
import it.unicam.cs.pa.mastermind.piece.Color;
import it.unicam.cs.pa.mastermind.piece.Piece;

/**
 * @author Michele Celozzi
 *
 */
class MatchFieldTest {
	
	MatchField mfield = MatchField.getInstance();
	Size size = new Size(7,4);
	
	@Test
	void testInitMatchField() {
		mfield.init(this.size);
	}

	@Test
	void testGetInstance() {
		testInitMatchField();
		assertNotNull(mfield);
	}
	
	@Test
	void testSetPieces() {
		testInitMatchField();
		mfield.setPieces();
	}
	
	@Test
	void testGetRows() {
		testInitMatchField();
		assertTrue(mfield.getRows() == 7);
	}
	
	@Test
	void testGetColumns() {
		testInitMatchField();
		assertTrue(mfield.getColumns() == 4);
	}
	
	@Test
	void testInsert() {
		List<AbstractPiece> piece = new ArrayList();
		Piece p1 = new Piece(0, Color.ARANCIONE);
		Piece p2 = new Piece(1, Color.BLU);
		Piece p3 = new Piece(0, Color.ROSSO);
		Piece p4 = new Piece(1, Color.NERO);
		
		piece.add(p1);
		piece.add(p2);
		piece.add(p3);
		piece.add(p4);
		
		assertTrue(mfield.insert(piece, 0) != false);
	}
	
}
