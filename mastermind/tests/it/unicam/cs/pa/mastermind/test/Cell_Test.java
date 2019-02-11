package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.core.Cell;
import it.unicam.cs.pa.mastermind.piece.Color;
import it.unicam.cs.pa.mastermind.piece.Piece;

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
		}
		
	}
}
