package com.demo.utility;

import java.io.IOException;
import java.math.BigDecimal;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockStats;

public class YahooFinanceAPI {

//	public YahooFinanceAPI() {
//		
//	}

	public static Stock getStock (String _stock) 
	{
		try {
			return YahooFinance.get(_stock);
		} catch (IOException e) {
			// 
			System.out.println("YahooFinance.get didn't work"+ e);
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getPrice (String stock)
	{
		
		return getStock(stock).getQuote().getPrice().toString();
	}
	 
	public static String getQuoteChange(String stock)
	{
		return getStock(stock).getQuote().getChangeInPercent().toString();
	}
	
	
	public static String getDividend (String stock)
	{
		return getStock(stock).getDividend().getAnnualYieldPercent().toString();
	}
	 

	public static String getStockExchange (String stock)
	{
		return getStock(stock).getStockExchange().toString();
	}
	 
	public static String getStockName (String stock)
	{
		return getStock(stock).getName().toString();
	}
	
	
	private static StockStats getStockStats (String stock)
	{
		StockStats ss = getStock(stock).getStats();	
		
		return ss;
	}
	public static String getEPS(String stock)
	{
		return getStockStats(stock).getEps().toString();
		
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   //System.out.println("the value of ibm stock is:" + YahooFinanceAPI.getStock("IBM"));
   System.out.println("the value of ibm stock dividendis:" + YahooFinanceAPI.getEPS("IBM"));
	}

}

