package com.leemanni.dao;

import org.apache.ibatis.session.SqlSession;

import com.leemanni.vo.LoginVO;

/**
 * @author cjffy
 * 1. 로그인
 * 2. 보유 주식 확인 등의 
 * DB 연결을 위한 DAO 클래스
 */
public class StocksDAO {
	private static StocksDAO instance = new StocksDAO();
	public StocksDAO() {;}
	public static StocksDAO getInstance() {
		return instance;
	}
	
	
	public boolean checkLogin(SqlSession mapper, LoginVO vo) {
//		System.out.println("StocksDAO ==> checkLogin");
		int correct = (int) mapper.selectOne("checkLogin", vo);
//		System.out.println(correct);
		return correct == 1 ? true : false; 
	}
}
