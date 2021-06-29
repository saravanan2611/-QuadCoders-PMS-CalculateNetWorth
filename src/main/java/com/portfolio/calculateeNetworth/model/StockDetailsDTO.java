package com.portfolio.calculateeNetworth.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import com.sun.istack.NotNull;

import lombok.NonNull;

public class StockDetailsDTO 
{
	
	@NotNull
	private String id;
	
	@NotNull
	private long stockId;
	
	@NotNull
	private Portfolio portfolio;
	
	@NotNull
	private String stockName;
	
	@NotNull
	private long stockCount;

	public StockDetailsDTO() {
		super();
	}

	public StockDetailsDTO(String id, long stockId, Portfolio portfolio, String stockName, long stockCount) {
		super();
		this.id = id;
		this.stockId = stockId;
		this.portfolio = portfolio;
		this.stockName = stockName;
		this.stockCount = stockCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getStockId() {
		return stockId;
	}

	public void setStockId(long stockId) {
		this.stockId = stockId;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public long getStockCount() {
		return stockCount;
	}

	public void setStockCount(long stockCount) {
		this.stockCount = stockCount;
	}
	
}
