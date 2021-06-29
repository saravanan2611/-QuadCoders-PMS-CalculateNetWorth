package com.portfolio.calculateeNetworth.controller;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.calculateeNetworth.exception.SellServiceNotFoundException;
import com.portfolio.calculateeNetworth.model.MutualFund;
import com.portfolio.calculateeNetworth.model.Portfolio;
import com.portfolio.calculateeNetworth.model.StockDetails;
import com.portfolio.calculateeNetworth.repository.MutualFundRepository;
import com.portfolio.calculateeNetworth.repository.QuoteRepo;
import com.portfolio.calculateeNetworth.service.SellService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//import ch.qos.logback.classic.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class DailySharePriceController {
		
		static Logger logger = LoggerFactory.getLogger(DailySharePriceController.class);
		
		@Autowired 
		private QuoteRepo sharedetailsrepo;
		
		@Autowired 
		private MutualFundRepository mutualfundrepo;
		
		@Autowired
		private SellService sellservice;
		
		/*@Autowired
		private RestTemplate restTemplate;
		*/
		
		@ApiOperation(value="Return networth of customer")
		@ApiResponses(
				value= {
						@ApiResponse(code = 100, message="100 is success")
				})
		/*
		 * Author: Saravanan R
		 * Date: 24-06-2021
		 * Description: Function to return the networth of the particular user*/
		@GetMapping("/calculateNetworth/{portfolio_id}")
		public double getAsset(@PathVariable(name = "portfolio_id") long portfolio_id) throws SellServiceNotFoundException
		{
			logger.debug("Inside the method for retrieving the total networth of the particular portfolio ID");
			logger.info("Handling/calculateNetworth... request");
			double result = sellservice.getAssetService(portfolio_id);
			if(result>0.0)
			{
				logger.info("Assets calculated successfully");
				return result;
			}
			else 
			{
				throw new SellServiceNotFoundException("NetWorth is Calculated"); 
			}
		}
		/*
		 * Author: Saravanan R
		 * Date: 25-06-2021
		 * Description: Function to sell assets of the particular user */
		@PostMapping("/SellAssets")
		public double sellAssets(@RequestBody List<Portfolio> portfolios) throws SellServiceNotFoundException
		{
			logger.debug("Inside the method for retrieving the total details of the particular portfolio ID and sell the assets");
			logger.info("Handling/SellAssets... request");
			Portfolio portfolio = portfolios.get(0);
			Portfolio selldetails = portfolios.get(1);
			Set<StockDetails> portfoliostockdetails = portfolio.getStockDetails();
			Set<StockDetails> sellStockDetails = selldetails.getStockDetails();
			Set<MutualFund> portfolioMFDetails= portfolio.getMutualFund();
			Set<MutualFund> sellMFDetails = selldetails.getMutualFund();
			for(MutualFund mf : sellMFDetails)
			{
				for(MutualFund pmf : portfolioMFDetails) 
				{
					if(mf.getId().equals(pmf.getId())) 
					{
						pmf.setMutualFundUnits(pmf.getMutualFundUnits()-mf.getMutualFundUnits());
						pmf.setPortfolio(portfolio);
						mutualfundrepo.save(pmf);
						break;
						
					}
				}
			}
			for(StockDetails mf : sellStockDetails)
			{
				for(StockDetails pmf : portfoliostockdetails) 
				{
					if(mf.getId().equals(pmf.getId()))
					{
						pmf.setStockCount(pmf.getStockCount()-mf.getStockCount());
						pmf.setPortfolio(portfolio);
						sharedetailsrepo.save(pmf);
						break;
					}
				}
			}
			portfolio.setMutualFund(portfolioMFDetails);
			portfolio.setStockDetails(portfoliostockdetails);
			logger.info("Assets sold successfully");
			return getAsset(portfolio.getPortfolio_id());
		}
	}


