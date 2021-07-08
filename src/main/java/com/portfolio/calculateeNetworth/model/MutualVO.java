package com.portfolio.calculateeNetworth.model;

import javax.persistence.Column;

public class MutualVO {

	private String mutualFundId;
	public String getMutualFundId() {
		return mutualFundId;
	}
	public void setMutualFundId(String mutualFundId) {
		this.mutualFundId = mutualFundId;
	}
	public String getMutualFundName() {
		return mutualFundName;
	}
	public void setMutualFundName(String mutualFundName) {
		this.mutualFundName = mutualFundName;
	}
	public double getMutualFundValue() {
		return mutualFundValue;
	}
	public void setMutualFundValue(double mutualFundValue) {
		this.mutualFundValue = mutualFundValue;
	}
	private String mutualFundName;
	private double mutualFundValue;
	
}
