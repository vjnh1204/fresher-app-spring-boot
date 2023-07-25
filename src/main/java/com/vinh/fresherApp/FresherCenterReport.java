package com.vinh.fresherApp;

public class FresherCenterReport {
	
	String centerName;
	Long totalFresher;
	
	public FresherCenterReport(String centerName, Long totalFresher) {
		super();
		this.centerName = centerName;
		this.totalFresher = totalFresher;
	}
	
	public String getCenterName() {
		return centerName;
	}
	
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	
	public Long getTotalFresher() {
		return totalFresher;
	}
	
	public void setTotalFresher(Long totalFresher) {
		this.totalFresher = totalFresher;
	}
	
}
