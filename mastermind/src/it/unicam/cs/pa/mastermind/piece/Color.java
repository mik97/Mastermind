/**
 * 
 */
package it.unicam.cs.pa.mastermind.piece;

import java.util.Arrays;
import java.util.List;

/**
 * @author Michele Celozzi
 *
 */
public enum Color {
	BIANCO,
	GIALLO,
	ROSSO,
	ARANCIONE,
	BLU,
	MARRONE,
	VIOLA,
	NERO;

	@Override
	public String toString() {
		switch(this) {
		case BIANCO: 
			return "W";
		case GIALLO: 
			return "G";
		case ROSSO: 
			return "R";
		case ARANCIONE: 
			return "A";
		case BLU: 
			return "B";
		case MARRONE: 
			return "M";
		case VIOLA: 
			return "V";
		case NERO: 
			return "N";
		}
		
		return super.name();
	}
	
	/**This method return a color from int
	 * @param color
	 * @return color
	 */
	public static Color getColor(int color) {
		List<Color> colors = Arrays.asList(Color.values());
		return colors.get(color);
	}
	
	public static int getSize() {
		List<Color> colors = Arrays.asList(Color.values());
		return colors.size();
	}
}
