package com.portfolio.calculateeNetworth.exception;

import static org.junit.Assert.*;

import org.junit.Test;

public class SellServiceNotFoundExceptionTest {

	@Test
	public void testSellNotFoundException()
	{
		SellServiceNotFoundException sellexception = new SellServiceNotFoundException("The asset cannot be sold");
		assertEquals("The asset cannot be sold",sellexception.getMessage());
	}

	@Test
	public void testSellNotFoundException2()
	{
		SellServiceNotFoundException sellexception = new SellServiceNotFoundException("The portfolio Id doesn't match with the database");
		assertEquals("The portfolio Id doesn't match with the database",sellexception.getMessage());
	}

	@Test
	public void testSellNotFoundExceptio3()
	{
		SellServiceNotFoundException sellexception = new SellServiceNotFoundException("The portfolio ID doesn't contain the mentioned stock details");
		assertEquals("The portfolio ID doesn't contain the mentioned stock details",sellexception.getMessage());
	}

	@Test
	public void testSellNotFoundException4()
	{
		SellServiceNotFoundException sellexception = new SellServiceNotFoundException("The portfolio ID doesn't contain the mentioned mutualfund details");
		assertEquals("The portfolio ID doesn't contain the mentioned mutualfund details",sellexception.getMessage());
	}

}
