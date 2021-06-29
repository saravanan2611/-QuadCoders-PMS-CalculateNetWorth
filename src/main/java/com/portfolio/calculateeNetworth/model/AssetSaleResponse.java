package com.portfolio.calculateeNetworth.model;

public class AssetSaleResponse {

	private boolean SaleStatus;
	private long Networth;
	public boolean isSaleStatus() {
		return SaleStatus;
	}
	public void setSaleStatus(boolean saleStatus) {
		SaleStatus = saleStatus;
	}
	public long getNetworth() {
		return Networth;
	}
	public void setNetworth(long networth) {
		Networth = networth;
	}
	
}
