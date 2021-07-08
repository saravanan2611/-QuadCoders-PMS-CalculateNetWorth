package com.portfolio.calculateeNetworth.utils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.calculateeNetworth.model.MutualFundDTO;
import com.portfolio.calculateeNetworth.model.StockDetails;
import com.portfolio.calculateeNetworth.model.Portfolio;
import com.portfolio.calculateeNetworth.model.StockDetailsDTO;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class JSONUtils 
{
    public static byte[] toJson(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
    
    public static StockDetailsDTO getStockDetailsDTO(String id, long stockId, Portfolio portfolio, String stockName, long stockCount)
	{
		StockDetailsDTO stockDetails = new StockDetailsDTO();
		stockDetails.setId(id);
		stockDetails.setStockId(stockId);
		stockDetails.setPortfolio(portfolio);
		stockDetails.setStockName(stockName);
		stockDetails.setStockCount(stockCount);
		return stockDetails;	
	}
    
    public static MutualFundDTO getMutualFundDTO(String id, long mutual_fund_id, Portfolio portfolio, String mutualFundName,long mutualFundUnits)
    {
    	MutualFundDTO mutualFund = new MutualFundDTO();
    	mutualFund.setId(id);
    	mutualFund.setMutual_fund_id(mutual_fund_id);
    	mutualFund.setPortfolio(portfolio);
    	mutualFund.setMutualFundName(mutualFundName);
    	mutualFund.setMutualFundUnits(mutualFundUnits);
		return mutualFund;
    	
    }
}