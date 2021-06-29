package com.portfolio.calculateeNetworth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
/*
 * Author: Saravanan R
 * Date: 23-06-2021
 * Description: Model class to implement the stock details*/
@Entity
@Table(name="stock_details")//To create StockDetails table 
public class StockDetails {
	
	@Id
	@GeneratedValue(generator = "id_generator")
	@GenericGenerator(name = "id_generator", strategy = "com.portfolio.calculateeNetworth.util.ShareIdGenerator")
	private String id;
	@Column(name="stock_id" , columnDefinition = "BIGINT")
	private long stockId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "portfolio_id")
	private Portfolio portfolio;
	@Override
	public String toString() {
		return "StockDetails [id=" + id + ", stockId=" + stockId + ", portfolio=" + portfolio + ", stockName="
				+ stockName + ", stockCount=" + stockCount + "]";
	}
	@Column(name="stock_name")
	private String stockName;
	@Column(name="stock_count" , columnDefinition = "BIGINT")
    private long stockCount;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Portfolio getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}
	public StockDetails(String id, long stockId, Portfolio portfolio, String stockName, long stockCount) {
		super();
		this.id = id;
		this.stockId = stockId;
		this.portfolio = portfolio;
		this.stockName = stockName;
		this.stockCount = stockCount;
	}
	public StockDetails() {
		super();
		// TODO Auto-generated constructor stub
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
	public long getStockId() {
		return stockId;
	}
	public void setStockId(long stockId) {
		this.stockId = stockId;
	}
	
	


}
