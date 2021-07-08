package com.portfolio.calculateeNetworth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.portfolio.calculateeNetworth.controller.CalculateNetWorthController;
import com.portfolio.calculateeNetworth.exception.SellServiceNotFoundException;
import com.portfolio.calculateeNetworth.model.MutualFund;
import com.portfolio.calculateeNetworth.model.MutualVO;
import com.portfolio.calculateeNetworth.model.Portfolio;
import com.portfolio.calculateeNetworth.model.StockDetails;
import com.portfolio.calculateeNetworth.model.StockVO;
import com.portfolio.calculateeNetworth.model.UserData;
import com.portfolio.calculateeNetworth.repository.MutualFundRepository;
import com.portfolio.calculateeNetworth.repository.PortfolioRepository;
import com.portfolio.calculateeNetworth.repository.QuoteRepo;
import java.util.Set;
@Configurable
@Service
public class SellService {

	static Logger logger = LoggerFactory.getLogger(CalculateNetWorthController.class);
	
	@Autowired
	private PortfolioRepository portfoliorepo;
	
	@Autowired MutualFundRepository mutualFundRepository;
	@Autowired QuoteRepo quotaRepo;
	@Autowired private RestTemplate restTemplate;
	
	/*
	 * Author: Saravanan R
	 * Date: 24-06-2021
	 * Description: Service class to find the calculate networth of the particular user"*/
	public double getAssetService(long portfolio_id,String token) throws SellServiceNotFoundException,NullPointerException
	{
		logger.info("Inside the method for retrieving the total networth of the particular portfolio ID");
		logger.info("Handling/calculateNetworth... request");
		Portfolio portfolio = portfoliorepo.findById(portfolio_id).get();
		Set<MutualFund> mutualfunds = portfolio.getMutualFund();
		Set<StockDetails> stockdetails = portfolio.getStockDetails();
		double networth=0.0;
		for(StockDetails sd:stockdetails)
		{  
			logger.info("StockDetails{}",sd);
			HttpHeaders httpHeaders=new HttpHeaders();
			httpHeaders.add("Authorization", token);
			HttpEntity<?> httpEntity= new HttpEntity<>(httpHeaders);
			@SuppressWarnings("unused")
			String url="http://localhost:8082/dailySharePrice/name/"+sd.getStockName();
			logger.info(url);
			ResponseEntity<String> response=restTemplate.exchange(url,HttpMethod.GET,httpEntity,String.class );
			logger.info("stocknaresp{}",response.getBody());
			String stockReponse=response.getBody();
			StockVO stockVo = JSONUtils.convertToObject(response.getBody(), StockVO.class); 
			double temp = stockVo.getStockValue();
			logger.info("response{} sd stock {} temp{}",stockVo,sd,temp);
			networth = networth + sd.getStockCount()*temp;
			logger.info("networth{}",networth);
		}
		for(MutualFund mf:mutualfunds)
		{
			HttpHeaders httpHeaders=new HttpHeaders();
			httpHeaders.add("Authorization", token);
			HttpEntity<?> httpEntity= new HttpEntity<>(httpHeaders);
			@SuppressWarnings("unused")
			ResponseEntity<String> response=restTemplate.exchange("http://localhost:8083/mutualFundNav/name/"+mf.getMutualFundName(),HttpMethod.GET,httpEntity,String.class );
			logger.info(" mutual fund resp{}",response.getBody());
			String mutual=response.getBody();
			MutualVO mutualVO = JSONUtils.convertToObject(response.getBody(), MutualVO.class); 
			double temp = mutualVO.getMutualFundValue();
			logger.info("response{} sd MutualFund {} temp{}",mutualVO,mf,temp);
			networth = networth + mf.getMutualFundUnits()*temp;
			logger.info("networth{}",networth);
		}
		logger.info("Networth calculated and returned successfully");
		return networth;
	}

	public UserData isSessionValid(String token) throws SellServiceNotFoundException,NullPointerException {
		// TODO Auto-generated method stub
		logger.info("Inside isSessionValid Method {}",token);
		try {
			HttpHeaders httpHeaders=new HttpHeaders();
			httpHeaders.add("Authorization", token);
			HttpEntity<?> httpEntity= new HttpEntity<>(httpHeaders);
			@SuppressWarnings("unused")
			ResponseEntity<String> response=restTemplate.exchange("http://localhost:8081/validate",HttpMethod.GET,httpEntity,String.class );
			
			  String mutual = response.getBody(); UserData userVO =
			  JSONUtils.convertToObject(response.getBody(), UserData.class); String
			 value=userVO.getUserid();
			 
			logger.info("Token is valid");
			return userVO;
		  } catch (Exception e) {
			  e.printStackTrace();
			  
			  logger.info("Token is invalid");
			  System.out.print(false);
			  throw new SellServiceNotFoundException("invalid token");		  
		}
	}
	public Portfolio getAssetDetails(long portfolio_id,String token) throws SellServiceNotFoundException,NullPointerException
	{
		logger.info("getAsset started");
		Portfolio portfolio = portfoliorepo.findById(portfolio_id).get();
		Set<MutualFund> mutualfunds = mutualFundRepository.findByPortfolio(portfolio);
		Set<StockDetails> stockdetails = quotaRepo.findByPortfolio(portfolio);
		portfolio.setMutualFund(mutualfunds);
		portfolio.setStockDetails(stockdetails);
		return portfolio;
	}

}

