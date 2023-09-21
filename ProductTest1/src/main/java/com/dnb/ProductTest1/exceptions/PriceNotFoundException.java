package com.dnb.ProductTest1.exceptions;

public class PriceNotFoundException extends Exception {
	public PriceNotFoundException(String msg) 
	{
		super(msg);
	}
	public String toString() 
	{
		// TODO Auto-generated method stub
		return super.toString()+super.getMessage();
	}
}