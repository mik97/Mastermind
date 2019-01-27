package it.unicam.cs.pa.mastermind.JTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import it.unicam.cs.pa.mastermind.core.Utils;;

class Utils_Test {

	@Test
	void test() 
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintStream out = System.out;
		Utils.doInput(in, out, "insert name", null, null);
		
		
		
	}

}
