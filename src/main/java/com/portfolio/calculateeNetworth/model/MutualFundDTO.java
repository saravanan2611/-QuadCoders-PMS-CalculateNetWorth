package com.portfolio.calculateeNetworth.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class MutualFundDTO {
	
	private String id;
	private long mutual_fund_id; 
	private Portfolio portfolio;
	private String mutualFundName;
	private long mutualFundUnits;
	
	public MutualFundDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MutualFundDTO(String id, long mutual_fund_id, Portfolio portfolio, String mutualFundName,
			long mutualFundUnits) {
		super();
		this.id = id;
		this.mutual_fund_id = mutual_fund_id;
		this.portfolio = portfolio;
		this.mutualFundName = mutualFundName;
		this.mutualFundUnits = mutualFundUnits;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getMutual_fund_id() {
		return mutual_fund_id;
	}
	public void setMutual_fund_id(long mutual_fund_id) {
		this.mutual_fund_id = mutual_fund_id;
	}
	public Portfolio getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}
	public String getMutualFundName() {
		return mutualFundName;
	}
	public void setMutualFundName(String mutualFundName) {
		this.mutualFundName = mutualFundName;
	}
	public long getMutualFundUnits() {
		return mutualFundUnits;
	}
	public void setMutualFundUnits(long mutualFundUnits) {
		this.mutualFundUnits = mutualFundUnits;
	}

	
}
