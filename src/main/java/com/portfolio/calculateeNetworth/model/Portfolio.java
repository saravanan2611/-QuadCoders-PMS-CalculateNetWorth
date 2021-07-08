package com.portfolio.calculateeNetworth.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/*
 * Author: Saravanan R
 * Date: 23-06-2021
 * Description: Model class to implement portfolio details*/
@Entity
@Table(name = "portfolio")
public class Portfolio {
	
	@Id
	@Column(columnDefinition = "BIGINT")
	private long portfolio_id;
	@OneToMany(mappedBy = "portfolio", fetch = FetchType.EAGER)
	   @JsonManagedReference
	private Set<StockDetails> stockDetails;
	@OneToMany(mappedBy = "portfolio" , fetch = FetchType.EAGER)
	 @JsonManagedReference
	private Set<MutualFund> mutualFund;
	/*@Override
	public String toString() {
		return "Portfolio [portfolio_id=" + portfolio_id + ", stockDetails=" + stockDetails + ", mutualFund="
				+ mutualFund + "]";
	}
*/
	public Portfolio() {
		super();
	}

	public Portfolio(long portfolio_id, Set<StockDetails> stockDetails, Set<MutualFund> mutualFund) {
		super();
		this.portfolio_id = portfolio_id;
		this.stockDetails = stockDetails;
		this.mutualFund = mutualFund;
	}

	public long getPortfolio_id() {
		return portfolio_id;
	}

	public void setPortfolio_id(long portfolio_id) {
		this.portfolio_id = portfolio_id;
	}

	public Set<StockDetails> getStockDetails() {
		return stockDetails;
	}

	public void setStockDetails(Set<StockDetails> stockDetails) {
		this.stockDetails = stockDetails;
	}

	public Set<MutualFund> getMutualFund() {
		return mutualFund;
	}

	public void setMutualFund(Set<MutualFund> mutualFund) {
		this.mutualFund = mutualFund;
	}



}
