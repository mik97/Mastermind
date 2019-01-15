package it.unicam.cs.pa.mastermind.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.function.Function;
import java.util.function.Predicate;

import it.unicam.cs.pa.mastermind.exception.InternalException;



public  class Utils
{

	public static <T> T doInput(BufferedReader in, PrintStream out, String request,Predicate<T> condition, Function<String, T> function)
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
				x = function.apply(line);
				if (!condition.test(x)) throw new Throwable("Wrong input");
			    }catch (Throwable e)
				     {
				      out.println("Input Error!");
				      continue;
				      }
					   return x;
		}
		
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
}
