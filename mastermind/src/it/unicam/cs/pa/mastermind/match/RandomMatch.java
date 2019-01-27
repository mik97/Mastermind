/**
 * 
 */
package it.unicam.cs.pa.mastermind.match;

import java.util.HashMap;
/**
 * @author Michele Celozzi
 *
 */
public class RandomMatch {

	public static void main(String[] args) {
//		Player p1 = new RandomPlayer();
//		Player p2 = new RandomPlayer();
//		
//		HashMap<String, Object> prop = new HashMap<>();
//		
//		prop.put("size", DefaultRuleSet.DEFAULT_SIZE);
//		prop.put("referee", new DefaultRuleSet());
//		prop.put("firstPlayer", 0);
		Match m = Match.getInstance();
//		metodo init
		m.start();
	}

}
