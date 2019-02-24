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
			return "Bianco";
		case GIALLO: 
			return "Giallo";
		case ROSSO: 
			return "Rosso";
		case ARANCIONE: 
			return "Arancione";
		case BLU: 
			return "Blu";
		case MARRONE: 
			return "Marrone";
		case VIOLA: 
			return "Viola";
		case NERO: 
			return "Nero";
		}
		
		return super.name();
	}
	
//	public static Color toColor(int color) {
//		switch(color) {
//		case 0:
//			return Color.BIANCO;
//		case 1:
//			return Color.GIALLO;
//		case 2:
//			return Color.ROSSO;
//		case 3:
//			return Color.ARANCIONE;
//		case 4:
//			return Color.BLU;
//		case 5:
//			return Color.MARRONE;
//		case 6:
//			return Color.VIOLA;
//		case 7:
//			return Color.NERO;
//		}
//		
//		return null;
//	}
	
	public static Color getColor(int color) {
		List<Color> colors = Arrays.asList(Color.values());
		return colors.get(color);
	}
	
	public static int getSize() {
		List<Color> colors = Arrays.asList(Color.values());
		return colors.size();
	}
}
