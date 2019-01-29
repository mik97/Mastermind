package it.unicam.cs.pa.mastermind.exception;


/**
 * @author luca
 *
 */

public class IllegalRoleActionException extends IllegalArgumentException 
{
 public IllegalRoleActionException()
 	{
	  super("Role Issue");
 	}
  
  @Override
	public String toString() {
		
		return getMessage()+": your role does not allow this action\n";
	}
}
