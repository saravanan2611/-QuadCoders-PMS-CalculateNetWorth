package com.portfolio.calculateeNetworth.exception;

import com.portfolio.calculateeNetworth.model.MutualfundsMicroDTO;
import com.portfolio.calculateeNetworth.model.Portfolio;
import com.portfolio.calculateeNetworth.model.StockDetailsDTO;

public class MasterClass {
	
	public static MutualfundsMicroDTO getMutualfundsMicroDTO()
	{
		MutualfundsMicroDTO mutualfund = new MutualfundsMicroDTO();
		mutualfund.setMutualFundId("100");
		mutualfund.setMutualFundName("MF1");
		mutualfund.setMutualFundValue("1000");
		return mutualfund;
		
	}
	/*public static StockDetailsDTO getStockDetailsDTO()
	{
		StockDetailsDTO stockDetails = new StockDetailsDTO();
		Portfolio port = new Portfolio();
		port.setPortfolio_id(100);
		stockDetails.setId("101");
		stockDetails.setStockId(1);
		stockDetails.setPortfolio(port.getPortfolio_id());
		stockDetails.setStockName("S3");
		stockDetails.setStockCount(1000);
		return stockDetails;
		
		
	}*/
}
