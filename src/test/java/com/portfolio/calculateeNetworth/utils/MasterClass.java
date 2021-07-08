package com.portfolio.calculateeNetworth.utils;

import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.calculateeNetworth.model.MutualFundDTO;
import com.portfolio.calculateeNetworth.model.StockDetails;
import com.portfolio.calculateeNetworth.model.Portfolio;
import com.portfolio.calculateeNetworth.model.StockDetails;
import com.portfolio.calculateeNetworth.model.StockDetailsDTO;

public class MasterClass 
{
	public static StockDetails getStockDetails()
	{
		StockDetails stockDetails = new StockDetails();
		Portfolio port = new Portfolio();
		port.setPortfolio_id(10001);
		port.setStockDetails(port.getStockDetails());
		port.setMutualFund(port.getMutualFund());
		stockDetails.setId("101");
		stockDetails.setStockId(1);
		stockDetails.setPortfolio(port);
		stockDetails.setStockName("S3");
		stockDetails.setStockCount(1000);
		return stockDetails;	
	}

	public static StockDetailsDTO getStockDetailsDTO()
	{
		StockDetailsDTO stockDetails = new StockDetailsDTO();
		Portfolio port = new Portfolio();
		port.setPortfolio_id(10001);
		port.setStockDetails(port.getStockDetails());
		port.setMutualFund(port.getMutualFund());
		stockDetails.setId("101");
		stockDetails.setStockId(1);
		stockDetails.setPortfolio(port);
		stockDetails.setStockName("S3");
		stockDetails.setStockCount(1000);
		return stockDetails;	
	}
	
	public static MutualFundDTO getMutualFundDTO() {

		MutualFundDTO mutualFund = new MutualFundDTO();
		Portfolio port = new Portfolio();
		port.setPortfolio_id(10001);
		port.setStockDetails(port.getStockDetails());
		port.setMutualFund(port.getMutualFund());
		mutualFund.setId("101");
		mutualFund.setMutual_fund_id(1);
		mutualFund.setPortfolio(port);
		mutualFund.setMutualFundName("MF3");
		mutualFund.setMutualFundUnits(1000);
		return mutualFund;
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
