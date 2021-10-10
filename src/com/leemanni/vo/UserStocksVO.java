package com.leemanni.vo;

/**
 * @author cjffy
 *	회원별 보유 주식 1건의 데이터를 기억하는 클래스
 */
public class UserStocksVO {
	private String name;
	private int ownStocks;
	private int p_price;	// 구매 가격
	private int c_price;	// 현재 가격
	private float ratio;		// 수익률(DB x)
	private int totalPrice;	// 자산가치(DB x)
	private int p_totalPrice;	// 자산가치(DB x)
	
	
	public UserStocksVO() {;}


	public UserStocksVO(String name, int ownStocks, int p_price, int c_price) {
		this.name = name;
		this.ownStocks = ownStocks;
		this.p_price = p_price;
		this.c_price = c_price;
		calculate(ownStocks, p_price, c_price);
	}
	/**
	 * @param ownStocks
	 * @param p_price
	 * @param c_price
	 * @result 수익률 및 자산 가치 계산
	 * 	
	 */
	private void calculate(int ownStocks, int p_price, int c_price) {
		totalPrice = ownStocks * c_price;
		p_totalPrice = ownStocks * p_price;
		ratio = (float)(c_price - p_price) / p_price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getOwnStocks() {
		return ownStocks;
	}


	public void setOwnStocks(int ownStocks) {
		this.ownStocks = ownStocks;
	}


	public int getP_price() {
		return p_price;
	}


	public void setP_price(int p_price) {
		this.p_price = p_price;
	}


	public int getC_price() {
		return c_price;
	}


	public void setC_price(int c_price) {
		this.c_price = c_price;
	}


	public float getRatio() {
		return ratio;
	}


	public void setRatio(float ratio) {
		this.ratio = ratio;
	}


	public int getTotaPrice() {
		return totalPrice;
	}


	public void setTotaPrice(int totaPrice) {
		this.totalPrice = totaPrice;
	}


	public int getP_totalPrice() {
		return p_totalPrice;
	}


	public void setP_totalPrice(int p_totalPrice) {
		this.p_totalPrice = p_totalPrice;
	}


	@Override
	public String toString() {
		return "UserStocksVO [name=" + name + ", ownStocks=" + ownStocks + ", p_price=" + p_price + ", c_price="
				+ c_price + ", ratio=" + ratio + ", totaPrice=" + totalPrice + "]";
	}
	
	
	
	
}
