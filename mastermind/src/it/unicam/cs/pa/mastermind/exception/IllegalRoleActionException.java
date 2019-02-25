package it.unicam.cs.pa.mastermind.exception;


/**
 * @author luca
 *
 */

public class IllegalRoleActionException extends IllegalArgumentException 
{
 private static final long serialVersionUID = 1L;

public IllegalRoleActionException()
 	{
	  super("Role Issue");
 	}
  
  @Override
	public String toString() {
		
		return getMessage()+": your role does not allow this action\n";
	}
}
