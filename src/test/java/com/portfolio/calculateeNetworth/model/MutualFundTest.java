package com.portfolio.calculateeNetworth.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//Total : 9
public class MutualFundTest {
	
	MutualFund mutualFund=new MutualFund();
	
	//1
	@Test
	void testIdOne() {
		mutualFund.setId("1");
		assertEquals("1",mutualFund.getId());
	}
	
	//2
	@Test
	void testIdTwo() {
		mutualFund.setId("2");
		assertEquals("2",mutualFund.getId());
	}
	
	//3
	@Test
	void testSetMutualFundIdOne() {
		mutualFund.setMutual_fund_id(101);
		assertEquals(101, mutualFund.getMutual_fund_id());
	}

	//4
	@Test
	void testSetMutualFundIdTwo() {
		mutualFund.setMutual_fund_id(102);
		assertEquals(102, mutualFund.getMutual_fund_id());
	}
	
	//5
	@Test
	void testSetMutualFundNameOne() {
		mutualFund.setMutualFundName("MF1");
		assertEquals("MF1", mutualFund.getMutualFundName());
	}
	
	//6
	@Test
	void testSetMutualFundNameTwo() {
		mutualFund.setMutualFundName("MF2");
		assertEquals("MF2", mutualFund.getMutualFundName());
	}
	
	//7
	@Test
	void testSetMutualFundUnitsOne() {
		mutualFund.setMutualFundUnits(10);
		assertEquals(10, mutualFund.getMutualFundUnits());
	}
	
	//8
	@Test
	void testSetMutualFundUnitsTwo() {
		mutualFund.setMutualFundUnits(20);
		assertEquals(20, mutualFund.getMutualFundUnits());
	}
	
	//9
	@Test
	void testMutualFundDetails() {
		MutualFund mfd=new MutualFund();
	}
	
	//10
	@Test
	public void testMutualFundDetailsTrue()
	{
		mutualFund.setMutualFundUnits(20);
		assertNotEquals(1001.0,mutualFund.getMutualFundUnits());
	}
	
}
