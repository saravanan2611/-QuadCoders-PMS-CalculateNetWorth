package com.portfolio.calculateeNetworth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.calculateeNetworth.controller.DailySharePriceController;
import com.portfolio.calculateeNetworth.exception.SellServiceNotFoundException;
import com.portfolio.calculateeNetworth.model.MutualFund;
import com.portfolio.calculateeNetworth.model.MutualfundsMicro;
import com.portfolio.calculateeNetworth.model.Portfolio;
import com.portfolio.calculateeNetworth.model.StockDetails;
import com.portfolio.calculateeNetworth.model.StockDetailsMicro;
import com.portfolio.calculateeNetworth.repository.PortfolioRepository;

import java.util.Set;

@Service
public class SellService {

	static Logger logger = LoggerFactory.getLogger(DailySharePriceController.class);
	
	@Autowired
	private PortfolioRepository portfoliorepo;
	
	@Autowired
	private MutualFundService mfservice;
	
	@Autowired
	private StockDetailsService service;
	
	/*
	 * Author: Saravanan R
	 * Date: 24-06-2021
	 * Description: Service class to find the calculate networth of the particular user"*/
	public double getAssetService(long portfolio_id) throws SellServiceNotFoundException
	{
		logger.debug("Inside the method for retrieving the total networth of the particular portfolio ID");
		logger.info("Handling/calculateNetworth... request");
		Portfolio portfolio = portfoliorepo.findById(portfolio_id).get();
		Set<MutualFund> mutualfunds = portfolio.getMutualFund();
		Set<StockDetails> stockdetails = portfolio.getStockDetails();
		double networth=0.0;
		StockDetailsMicro stockValue;
		MutualfundsMicro mutualfundValue;
		for(StockDetails sd:stockdetails)
		{
			stockValue = service.findByStockName(sd.getStockName());
			double temp = stockValue.getStockValue();
			networth = networth + sd.getStockCount()*temp;
		}
		for(MutualFund mf:mutualfunds)
		{
			mutualfundValue = mfservice.getMutualFundByName(mf.getMutualFundName());
			double temp = mutualfundValue.getMutualFundValue();
			networth = networth + mf.getMutualFundUnits()*temp;
		}
		logger.info("Networth calculated and returned successfully");
		return networth;
	}	
}
