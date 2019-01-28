/**
 * 
 */
package it.unicam.cs.pa.mastermind.core;

import java.util.List;

/**
 * @author Michele Celozzi
 *
 */
public class Size {
	
	private List<Integer> sizes;
	
	public Size(Integer[] sizes)throws IllegalArgumentException {
		if(sizes.length != 2)
			throw new IllegalArgumentException ("The array must be contain a two integer values!");
		
		this.sizes = List.of(sizes[0], sizes[1]);
		
		if(this.sizes.stream().anyMatch(x -> x <= 3))
			throw new IllegalArgumentException ("The value of size must be bigger than 3! "
					+ "Only combination of 4 or more colors is allowed");
	}

	public Size(Integer row, Integer column)throws IllegalArgumentException {
		this(new Integer[] {row, column});
	}
	
	public List<Integer> getSize() {
		return this.sizes;
	}
	
	public Integer getRow() {
		return this.sizes.get(0);
	}
	
	public Integer getColumn() {
		return this.sizes.get(1);
	}

	@Override
	public String toString() {
		return "The size is: -- " + this.sizes.get(0) + " , " + this.sizes.get(1) + " --";
	}
}
