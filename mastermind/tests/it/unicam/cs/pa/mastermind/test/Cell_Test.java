package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.core.Cell;
import it.unicam.cs.pa.mastermind.core.CellStatus;
import it.unicam.cs.pa.mastermind.piece.AbstractPiece;
import it.unicam.cs.pa.mastermind.piece.Color;
import it.unicam.cs.pa.mastermind.piece.NullPiece;
import it.unicam.cs.pa.mastermind.piece.Piece;

/**
 * @author Luca 
 *
 */
class Cell_Test {

	Cell cell = new Cell();
	Cell  cellGroup []= new Cell[4];
	
	@Test
	void Test_Insert_Piece_Cell() 
	{
		cell.setPiece(new Piece(1, Color.ARANCIONE));
		assertTrue(cell.getPiece().getColor() == Color.ARANCIONE);
	}

	
	@Test
	void Test_Istance_CellGroup() 
	{
		for(int i = 0; i<4;i++)
		{
			cellGroup[i] = new Cell();
			assertTrue(cellGroup[i] != null);
		}
		
	}
	
	@Test
	void Test_Insert_Piece_CellGroup() 
	{
		Test_Istance_CellGroup();
		
		for(int i = 0; i<4;i++)
		{
			cellGroup[i].setPiece(new Piece(i+1, Color.ARANCIONE));
			assertTrue(cellGroup[i].getPiece().equals(new NullPiece()) == false);
		}
	}
	
	@Test
	void Tes_IsEmpty() 
	{assertTrue(cell.isEmpty());}
	
	@Test
	void Tes_GetStatus() 
	{assertTrue(cell.getStatus() == CellStatus.EMPTY);}
	
	@Test
	void Tes_pop() 
	{
		Test_Insert_Piece_Cell();
		assertTrue(cell.pop().getColor() == Color.ARANCIONE && cell.isEmpty());
		
	}
}
