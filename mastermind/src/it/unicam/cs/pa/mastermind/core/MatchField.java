package it.unicam.cs.pa.mastermind.core;

import it.unicam.cs.pa.mastermind.exception.UnitializedSingleton;

/**
 * @author Michele Celozzi
 *
 */
public class MatchField {

	private static final MatchField INSTANCE = new MatchField();
	private boolean initialized;
	public UnitializedSingleton exc = new UnitializedSingleton("MatchField");
	
	private Cell field[][];
	private Size size;
	
	private MatchField() {
		this.initialized = false;
	}
	
	public boolean init(Size size) {
		if(!initialized) {
			this.size = size;
			this.field = new Cell[this.size.getRow()][this.size.getColumn()];
			this.initialized = true;
			topUp();
			return true;
		}
		
		return false;
	}
	
	public void topUp() {
		for(int i = 0; i < getRow(); i++) {
			for(int j = 0; j < getColumn(); j++) {
				this.field[i][j] = new Cell();
			}
		}
	}
	
	public void insert() {
		
	}
	
	private void initCheckup()throws UnitializedSingleton {
		if(!initialized)
			throw exc;
	}
	
	private int getRow() {
		initCheckup();
		return this.size.getRow();
	}
	
	private int getColumn() {
		initCheckup();
		return this.size.getColumn();
	}
	
	public static MatchField getInstance() {
		return INSTANCE;
	}
}