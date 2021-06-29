package com.portfolio.calculateeNetworth.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
//Total : 10
public class StockDetailsTest {
	StockDetails stockdetails;
	
	//1
	@BeforeAll
	public static void setupAll()
	{
		System.out.println("Should run before all testcases");
	}
	
	@Before
	public void beforeObj()
	{
		stockdetails = new StockDetails();
	}
	
	//2
	@Test
	void testIdTwo() {
		stockdetails.setId("2");
		assertEquals("2",stockdetails.getId());
	}
	
	//3
	@Test
	void testIdOne() {
		stockdetails.setId("1");
		assertEquals("1",stockdetails.getId());
	}
	
	//4
	@Test
	void testSetStockIdOne() {
		stockdetails.setStockId(101);
		assertEquals(101, stockdetails.getStockId());
	}

	//5
	@Test
	void testSetStockIdTwo() {
		stockdetails.setStockId(102);
		assertEquals(102, stockdetails.getStockId());
	}
	
	//6
	@Test
	void testSetStockNameOne() {
		stockdetails.setStockName("S1");
		assertEquals("S1", stockdetails.getStockName());
	}
	
	//7
	@Test
	void testSetStockNameTwo() {
		stockdetails.setStockName("S2");
		assertEquals("S2", stockdetails.getStockName());
	}
	
	//8
	@Test
	void testSetStockCountOne() {
		stockdetails.setStockCount(10);
		assertEquals(10, stockdetails.getStockCount());
	}
	
	//9
	@Test
	void testSetStockCountTwo() {
		stockdetails.setStockCount(20);
		assertEquals(20, stockdetails.getStockCount());
	}
	
	//10
	@Test
	void testStockDetails() {
		StockDetails stockdetails=new StockDetails();
	}

}
