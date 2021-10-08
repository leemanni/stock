package com.leemanni.service;

public class StocksService {
	private static StocksService instance = new StocksService();
	public StocksService() {;}
	public static StocksService getInstance() {
		return instance;
	}
	
	
}
