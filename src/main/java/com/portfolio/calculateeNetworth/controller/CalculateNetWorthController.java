package com.portfolio.calculateeNetworth.controller;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.calculateeNetworth.exception.SellServiceNotFoundException;
import com.portfolio.calculateeNetworth.model.MutualFund;
import com.portfolio.calculateeNetworth.model.Portfolio;
import com.portfolio.calculateeNetworth.model.StockDetails;
import com.portfolio.calculateeNetworth.model.UserData;
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
public class CalculateNetWorthController {
		
		static Logger logger = LoggerFactory.getLogger(CalculateNetWorthController.class);
		
		@Autowired 
		private QuoteRepo sharedetailsrepo;
		
		@Autowired 
		private MutualFundRepository mutualfundrepo;
		
		@Autowired
		private SellService sellservice;	
		
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
		public double getAsset(@RequestHeader("Authorization") String token,@PathVariable(name = "portfolio_id") long portfolio_id) throws SellServiceNotFoundException
		{        UserData userVO=sellservice.isSessionValid(token);
			logger.debug("Inside the method for retrieving the total networth of the particular portfolio ID");
			if(userVO!=null) {
				logger.info("Valid Token");
				logger.info(userVO.getUserid());
			logger.info("Handling/calculateNetworth... request");
			double result = sellservice.getAssetService(portfolio_id,token);
			if(result>0.0)
			{  
				logger.info("Assets calculated successfully");
				return result;
			}
			else 
			{
				throw new SellServiceNotFoundException("NetWorth is Calculated"); 
			}}
			return 0.0;
			
		}
		/*
		 * Author: Saravanan R
		 * Date: 25-06-2021
		 * Description: Function to get assets of the particular user */
		@GetMapping("/getAssets/{portfolio_id}")
		public Portfolio sellAssest(@RequestHeader("Authorization") String token,
				@PathVariable(name = "portfolio_id") long portfolio_ids) throws SellServiceNotFoundException {
			UserData userVO = sellservice.isSessionValid(token);

			try {
				if (userVO != null) {
					logger.info("Valid Token");
					logger.info("Handling/getAssets... request");
					return sellservice.getAssetDetails(portfolio_ids, token);
				}

			} catch (Exception e) {
				logger.error(e.getLocalizedMessage(), e);
				e.printStackTrace();
			}
			return null;

		}
		

		/*
		 * Author: Saravanan R
		 * Date: 25-06-2021
		 * Description: Function to sell assets of the particular user */
		@PostMapping("/sellAssets")
		public double sellAssets(@RequestHeader("Authorization") String token,@RequestBody List<Portfolio> portfolios) throws SellServiceNotFoundException
		{     UserData userVO=sellservice.isSessionValid(token);
			logger.debug("Inside the method for retrieving the total details of the particular portfolio ID and sell the assets");
			if(userVO!=null) {
				logger.info("Valid Token");
				logger.info(userVO.getUserid());
			logger.info("Handling/SellAssets... request");
			logger.info(userVO.getUserid());
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
						long result = pmf.getMutualFundUnits()-mf.getMutualFundUnits();
						if(result<10)
						{
							throw new SellServiceNotFoundException("Stock Count can't be deleted as it falls below the default value");
						}
						pmf.setMutualFundUnits(result);
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
						long result = pmf.getStockCount()-mf.getStockCount();
						if(result<10)
						{
							throw new SellServiceNotFoundException("MutualFund Count can't be deleted as it falls below the default value");
						}
						pmf.setStockCount(result);
						pmf.setPortfolio(portfolio);
						sharedetailsrepo.save(pmf);
						break;
					}
				}
			}
			portfolio.setMutualFund(portfolioMFDetails);
			portfolio.setStockDetails(portfoliostockdetails);
			logger.info("Assets sold successfully");
			return getAsset(token,portfolio.getPortfolio_id());
		}
		return 0.0;	
	}
		
}


