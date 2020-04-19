package com.generic;

public enum AllMyPageTitle {

	MARKET("Stock Market Data - Dow Jones, Nasdaq, S&P 500 - CNNMoney"),
	TECH("Tech News - Latest Technology Headlines and Trends on CNN Business - CNN"),
	MEDIA("Media News - Latest Headlines on CNN Business - CNN"),
	SUCCESS("Careers - News for Entrepreneurs and Leaders on CNN Business - CNN"),
	PERSPECTICVES("Analysis – CNN Business - CNN"), 
	VIDEOS("Videos - CNN Business - CNN");
	private String title;//can not go out

	public String getTitle() {
		return title;
	}

	private	AllMyPageTitle(String title){//can not go out 
		this.title =title;
		
		}
}
