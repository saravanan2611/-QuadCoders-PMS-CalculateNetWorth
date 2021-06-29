package com.portfolio.calculateeNetworth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.portfolio.calculateeNetworth.model.StockDetails;
import com.portfolio.calculateeNetworth.model.StockDetailsMicro;
import com.portfolio.calculateeNetworth.repository.SharePriceRepo;

@Service
public class StockDetailsService {

	@Autowired
	private SharePriceRepo repos;
	
	public StockDetailsMicro findByStockName(String stockName) {
		return repos.findByStockName(stockName);
	}
}
