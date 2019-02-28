package it.unicam.cs.pa.mastermind.exception;

public class InternalException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;

	public InternalException(Throwable e)
	{
		super(e);
	}
}
