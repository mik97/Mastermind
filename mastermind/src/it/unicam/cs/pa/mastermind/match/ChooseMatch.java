/**
 * 
 */
package it.unicam.cs.pa.mastermind.match;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;

import it.unicam.cs.pa.mastermind.core.Size;
import it.unicam.cs.pa.mastermind.core.Utils;
import it.unicam.cs.pa.mastermind.player.Player;
import it.unicam.cs.pa.mastermind.player.Role;
import it.unicam.cs.pa.mastermind.player.TypePlayer;
import it.unicam.cs.pa.mastermind.ruleSet.DefaultRuleSet;
import it.unicam.cs.pa.mastermind.ruleSet.RuleSet;

/**
 * @author Michele Celozzi
 *
 */
public class ChooseMatch {
	
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private static PrintStream out = System.out;

	public static void main(String[] args) {
		Player p1 = choosePlayerType(1);
		Player p2 = choosePlayerType(2);
		
		HashMap<String, Object> prop = new HashMap<>();
		
		prop.put("referee", new DefaultRuleSet());
		prop.put("size", chooseSettings((RuleSet) prop.get("referee")));
		prop.put("firstPlayer", selectFirstPlayer(p1, p2));
		
		Match m = Match.getInstance();	
		m.initMatch(p1,  p2,  prop);
		m.start();
	}
	
	private static Player choosePlayerType(int i) {
		int n = Utils.doInput(in, out, selectType("Player"), x -> x >= 0 && x < TypePlayer.values().length, 
				Integer::valueOf);
		
		return TypePlayer.values()[n].getPlayer(setName(), setRole());
	}
	
	private static String selectType(String name) {
		String pType = "\nInsert the " + name + "type: ";
		switch(name) {
		case "Player":
			for(TypePlayer x : TypePlayer.values()) {
				pType += "\n" + x.ordinal() + "-->" + x.toString();
			}
			break;
		}
		
		return pType;
	}

	private static Size chooseSettings(RuleSet referee) {
		String line = Utils.doInput(in, out, "\nDo  you want to use default settings 7 attempts and a combination of 4 colors? (y/n) ",
				x -> x.equals("y") || x.equals("n"), String::valueOf);
		if (line.equals("y"))
			return referee.getFieldSize();
		return new Size(chooseNumber("rows"), chooseNumber("columns"));
	}
	
	private static Integer chooseNumber(String name) {
		int num = Utils.doInput(in, out, "\nChoose the number of " + name + " : ", x -> x > 4,
				Integer::parseInt);
		return num;
	}
	
	private static Role setRole() {
		String line = Utils.doInput(in, out, "\nInsert the role of player: [CODEMAKER] [CODEBRAKER] ",
				x -> x.equals("Codemaker") || x.equals("Codebraker"), String::valueOf);
		
		switch(line) {
		case "Codemaker":
			return Role.CODEMAKER;
		case "Codebraker":
			return Role.CODEBREAKER;
		}
		
		return null;
	}
	
	private static String setName() {
		return Utils.doInput(in, out, "\nInsert the player name: ", n -> true, String::valueOf);
	}
	
	private static Integer selectFirstPlayer(Player p1, Player p2) {
		if(p1.getRole() == Role.CODEMAKER)
			return 0;
		else
			return 1;
	}
}
