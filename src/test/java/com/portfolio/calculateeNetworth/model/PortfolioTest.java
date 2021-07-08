package com.portfolio.calculateeNetworth.model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//Total : 2
public class PortfolioTest {


	//1
	@Test
	void testGetPortfolio() {
		Portfolio portfolio=new Portfolio();
		portfolio.setPortfolio_id(101);
		portfolio.getPortfolio_id();
		assertEquals(101,portfolio.getPortfolio_id());
	}
	
	//2
	@Test
	void testGetPortfolio1() {
		Portfolio portfolio=new Portfolio();
		portfolio.setPortfolio_id(102);
		portfolio.getPortfolio_id();
		assertEquals(102,portfolio.getPortfolio_id());
	}
}
