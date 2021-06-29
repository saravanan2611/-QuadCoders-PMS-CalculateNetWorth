package com.portfolio.calculateeNetworth.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="mutual_funds_mtwo")
public class MutualfundsMicro
{
	
	@Id
	@Column(name="mutual_fund_id" )
	private String mutualFundId;
	@Column(name="mutual_fund_name")
	private String mutualFundName;
	@Column(name="mutual_fund_value")
	private double mutualFundValue;
	
	@Override
	public String toString() {
		return "MutualfundsMicro [mutualFundId=" + mutualFundId + ", mutualFundName=" + mutualFundName
				+ ", mutualFundValue=" + mutualFundValue + "]";
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
	
	public double getMutualFundValue() {
		return mutualFundValue;
	}
	
	public void setMutualFundValue(double mutualFundValue) {
		this.mutualFundValue = mutualFundValue;
	}
	
}
