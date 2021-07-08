package com.portfolio.calculateeNetworth.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 * Author: Saravanan R
 * Date: 23-06-2021
 * Description: Model class to implement MutualFund Details*/

@ToString
@Entity
@Table(name="mutual_funds")
public class MutualFund {
	
	@Id
	@GeneratedValue(generator = "mutualfundidgenerator")
	@GenericGenerator(name = "mutualfundidgenerator", strategy = "com.portfolio.calculateeNetworth.util.MutualFundIdGenerator")
	private String id;
	@Column(name="mutual_fund_id" , columnDefinition = "BIGINT")
	private long mutual_fund_id; 
	@ManyToOne(fetch = FetchType.EAGER)
	 @JsonBackReference
	@JoinColumn(name = "portfolio_id")
	private Portfolio portfolio;
	@Column(name="mutual_fund_name")
	private String mutualFundName;
	@Column(name="mutual_fund_units" , columnDefinition = "BIGINT")
	private long mutualFundUnits;
	
	public MutualFund(String id, long mutual_fund_id, Portfolio portfolio, String mutualFundName, long mutualFundUnits) {
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
	public MutualFund() {
		super();
	}
	public String getMutualFundName() {
		return mutualFundName;
	}
	@Override
	public String toString() {
		return "MutualFund [id=" + id + ", mutual_fund_id=" + mutual_fund_id + ", portfolio=" + portfolio
				+ ", mutualFundName=" + mutualFundName + ", mutualFundUnits=" + mutualFundUnits + "]";
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
