package com.generic;

enum TitlePage {
	// This will call enum constructor with one
	// String argument
	MARKET("Stock Market Data - Dow Jones, Nasdaq, S&P 500 - CNNMoney"),
	TECH("Tech News - Latest Technology Headlines and Trends on CNN Business - CNN"),
	MEDIA("Media News - Latest Headlines on CNN Business - CNN"),
	SUCCESS("Careers - News for Entrepreneurs and Leaders on CNN Business - CNN"),
	PERSPECTICVES("Analysis – CNN Business - CNN"), 
	VEIDEOS("Videos - CNN Business - CNN");

	// declaring private variable for getting values
	private String action;

	// getter method
	public String getAction() {
		return this.action;
	}

	// enum constructor - cannot be public or protected
	private TitlePage(String action) {
		this.action = action;
	}
}
