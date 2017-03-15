package com.fafe.core;

public enum StockMarket {

	MILAN("MI"), NYSE("NYSE");

	private final String acr;

	StockMarket(String acr) {
		this.acr = acr;
	}

	public String getAcr() {
		return acr;
	}

	public static StockMarket getStockMarketFromAcr(String mkt) throws Exception {
		for (StockMarket elem : StockMarket.values()) {
			if (elem.getAcr().equalsIgnoreCase(mkt)) {
				return elem;
			}
		}
		throw new Exception ("StockMarket enum not found");
	}
}
