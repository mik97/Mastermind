/**
 * 
 */
package it.unicam.cs.pa.mastermind.core;

/**
 * @author Michele Celozzi
 *
 */
public class MatchField {

	private static final MatchField INSTANCE = new MatchField();
	
	private MatchField() {}
	
	public static MatchField getInstance() {
		return INSTANCE;
	}
}