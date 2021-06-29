package com.portfolio.calculateeNetworth.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/*
 * Author: Saravanan R
 * Date: 25-06-2021
 * Description: Function to handle exception*/
@ResponseStatus(HttpStatus.NOT_FOUND)
public class SellServiceNotFoundException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SellServiceNotFoundException(String message)
	{
		super(message);
	}
}
