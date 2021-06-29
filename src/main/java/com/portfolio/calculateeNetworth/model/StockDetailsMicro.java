package com.portfolio.calculateeNetworth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="stock_details_micro")//To create StockDetails table 
public class StockDetailsMicro {
	
	@Id
	@GeneratedValue
	@Column(name="stock_id")
	private String stockId;//primary key 
	@Column(name="stock_name")
	private String stockName;
	@Column(name="stock_value")
    private double stockValue;
	
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public double getStockValue() {
		return stockValue;
	}
	public void setStockValue(double stockValue) {
		this.stockValue = stockValue;
	}

	@Override
	public String toString() {
		return "StockDetails [stockId=" + stockId + ", stockName=" + stockName + ", stockValue=" + stockValue + "]";
	}
	


}
