/**
 * 
 */
package it.unicam.cs.pa.mastermind.exception;

/**
 * @author Michele Celozzi
 *
 */
public class UnitializedSingleton extends IllegalStateException {

	private static final long serialVersionUID = 1L;
	
	private String obj;
	
	public UnitializedSingleton(String obj) {
		super("'" + obj.getClass().getName() + "must be initialized");
		this.obj = obj;
	}
	
	public String getObj() {
		return this.obj;
	}
}
