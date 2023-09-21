package com.dnb.ProductTest1.exceptions;

public class DescNotFoundException extends Exception {
	public DescNotFoundException(String msg) 
	{
		super(msg);
	}
	public String toString() 
	{
		// TODO Auto-generated method stub
		return super.toString()+super.getMessage();
	}
}



