package com.portfolio.calculateeNetworth.service;


import com.portfolio.calculateeNetworth.controller.CalculateNetWorthController;
import com.portfolio.calculateeNetworth.model.MutualFund;
import com.portfolio.calculateeNetworth.model.StockDetails;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class SellServiceTest {

	SellService service = new SellService();
	CalculateNetWorthController control;

	@Test
	public void testfindByStockNameNegative() {
		StockDetails stock = new StockDetails();
		assertEquals("StockNameNotFound", null, stock.getStockName());
	}
	@Test
	public void testMutualFundByNameNegative() {
		MutualFund mutual = new MutualFund();
		assertEquals("StockNameNotFound", null, mutual.getMutualFundName());
	}

	//@SuppressWarnings("deprecation")
	//@Test
	


}
