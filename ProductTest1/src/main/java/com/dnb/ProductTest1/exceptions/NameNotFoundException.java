package com.dnb.ProductTest1.exceptions;

public class NameNotFoundException extends Exception {
	
	public NameNotFoundException(String msg) 
	{
		super(msg);
	}
	public String toString() 
	{
		// TODO Auto-generated method stub
		return super.toString()+super.getMessage();
	}
}
