/**
 * 
 */
package it.unicam.cs.pa.mastermind.exception;

/**
 * @author Michele Celozzi
 *
 */
public class IllegalIdArgument extends IllegalArgumentException {

	private static final long serialVersionID = 1L;
	
	public final int id;
	
	public IllegalIdArgument(int id) {
		super("The value " + id + " is not allowed");
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
}
