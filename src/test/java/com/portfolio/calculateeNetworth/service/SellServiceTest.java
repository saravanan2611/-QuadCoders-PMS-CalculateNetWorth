package com.portfolio.calculateeNetworth.service;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.Before;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.portfolio.calculateeNetworth.controller.DailySharePriceController;
import com.portfolio.calculateeNetworth.exception.SellServiceNotFoundException;
public class SellServiceTest {
	
	SellService service;
	DailySharePriceController control;
	
	@Before
	public void beforemandatory()
	{
		service = new SellService();
	}
	//@SuppressWarnings("deprecation")
	//@Test
	
	/*@Test(expected=NullPointerException.class)
	void PackageAndDeliveryTestForIntegral() throws Exception {
		DailySharePriceController pdc = new DailySharePriceController();
		double actualResult=0;
		try {
			actualResult = pdc.getAsset(101);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
		}
		double expectedResult = 130000.0;
		Assertions.assertEquals(expectedResult, actualResult);
	}
*/
}
