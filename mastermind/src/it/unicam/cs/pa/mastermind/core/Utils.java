package it.unicam.cs.pa.mastermind.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import it.unicam.cs.pa.mastermind.exception.InternalException;
import it.unicam.cs.pa.mastermind.piece.AbstractPiece;
import it.unicam.cs.pa.mastermind.piece.Color;
import it.unicam.cs.pa.mastermind.piece.Piece;
import it.unicam.cs.pa.mastermind.ruleSet.RuleSet;



/**
 * @author luca
 *
 */

public  class Utils
{
	/**
	 * 
	 * @param in
	 * @param out
	 * @param request
	 * @param condition
	 * @param readFun
	 * @return
	 * @throws InternalException
	 */
	public static <T> T doInput(BufferedReader in, PrintStream out, String request, Predicate<T> condition, Function<String, T> readFun)throws InternalException
	{
		while (true)
		{
			out.println(request);
			String line;
			try {line = in.readLine();}
			catch (IOException e )
				{
					throw new InternalException(e);
				}
			T x = null;
			 try 
			   {
				x = readFun.apply(line);
				if (!condition.test(x)) throw new Throwable("Wrong input");
			    }catch (Throwable e)
				     {
				      out.println("Input Error!");
				      continue;
				      }
			 return x;
					  
		}
	}
	
	public static String showColorValue() {
		String str = "";
		
		for(Color x : Color.values()) {
			str += "\n" + x.ordinal() + " for " + x.toString();
		}
		
		return str;
	}
	
//	public static List<Color> insertColor(BufferedReader in, PrintStream out, int length)
//	{
//		List<Color> colors = new ArrayList<>();
//		int color;
//		System.out.println("Insert the color: \n"+Utils.showColorValue());
//		
//		for(int i = 0; i < length; i++) {
//			color = doInput(in, out, "" ,(x) -> x >= 0 && x <= Color.values().length-1, Integer::parseInt);
//			
//			colors.add(Color.getColor(color));
//		}
//		
//		return colors;
//	}
	public static Color insertColor(BufferedReader in, PrintStream out)
	{
		int color;
		System.out.println("Insert the color: \n"+Utils.showColorValue());
		
		color = doInput(in, out, "" ,(x) -> x >= 0 && x <= Color.values().length-1, Integer::parseInt);
		return Color.getColor(color);
	}
	
	public static void printField(PrintStream out, MatchField field) {
		for(int i = 0; i < field.getRows(); i++) {
			for(int j = 0; j < field.getColumns(); j++) {
				if(field.getField()[i][j].getPiece().getColor() == null)
					out.print("||   || ");
				else
					out.print("|| " + field.getField()[i][j].getPiece().getColor().toString() +" || ");
			}
			out.print("\n");
		}
		out.print("\n\n");
	}
}
