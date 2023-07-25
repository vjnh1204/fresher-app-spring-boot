package com.vinh.fresherApp;


public class FresherReportScore {
	
	Long totalFresher;
	Float fresherScore;
	
	
	public FresherReportScore(Float fresherScore,Long totalFresher) {
		super();
		this.totalFresher = totalFresher;
		this.fresherScore = fresherScore;
	}
	public Long getTotalFresher() {
		return totalFresher;
	}
	public void setTotalFresher(Long totalFresher) {
		this.totalFresher = totalFresher;
	}
	public Float getFresherScore() {
		return fresherScore;
	}
	public void setFresherScore(Float fresherScore) {
		this.fresherScore = fresherScore;
	}
	
	
}
