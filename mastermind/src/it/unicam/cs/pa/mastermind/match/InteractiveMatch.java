/**
 * 
 */
package it.unicam.cs.pa.mastermind.match;

import java.util.HashMap;

/**
 * @author Michele Celozzi
 *
 */
public class InteractiveMatch {

	public static void main(String[] args) {
//		Player p1 = new InteractivePlayer();
//		Player p2 = new InteractivePlayer();
//		
//		HashMap<String, Object> prop = new HashMap<>();
//		
//		prop.put("size", DefaultRuleSet.DEFAULT_SIZE);
//		prop.put("referee", new DefaultRuleSet());
//		prop.put("firstPlayer", 0);
		Match m = Match.getInstance();
//		m.init(p1, p2, prop);
		m.start();
	}

}
