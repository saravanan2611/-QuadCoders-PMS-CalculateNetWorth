package com.portfolio.calculateeNetworth.model;

import com.sun.istack.NotNull;

public class MutualfundsMicroDTO {

	@NotNull
	private String mutualFundId;
	@NotNull
	private String mutualFundName;
	@NotNull
	private String mutualFundValue;
	public MutualfundsMicroDTO() {
		super();
	}
	public MutualfundsMicroDTO(String mutualFundId, String mutualFundName, String mutualFundValue) {
		super();
		this.mutualFundId = mutualFundId;
		this.mutualFundName = mutualFundName;
		this.mutualFundValue = mutualFundValue;
	}
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
	public String getMutualFundValue() {
		return mutualFundValue;
	}
	public void setMutualFundValue(String mutualFundValue) {
		this.mutualFundValue = mutualFundValue;
	}
}
