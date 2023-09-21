package com.dnb.ProductTest1.exceptions;

public class UniqueNameException extends Exception {
	public UniqueNameException(String msg) 
	{
		super(msg);
	}
	public String toString() 
	{
		// TODO Auto-generated method stub
		return super.toString()+super.getMessage();
	}
}
