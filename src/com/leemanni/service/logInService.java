package com.leemanni.service;

import org.apache.ibatis.session.SqlSession;

import com.leemanni.dao.StocksDAO;
import com.leemanni.mybatis.MySession;
import com.leemanni.vo.LoginVO;

/**
 * @author cjffy
 * 1. id + pw 로그인 체크
 * 2. 보유 주식 dao 와 연결하는 
 * Service 클래스
 */
public class logInService {
	private static logInService instance = new logInService();
	public logInService() {;}
	public static logInService getInstance() {
		return instance;
	}
	
	public boolean checkLogin(LoginVO vo) {
		System.out.println("StocksService ==> checkLogin");
		SqlSession mapper = MySession.getSession();
		boolean correct = StocksDAO.getInstance().checkLogin(mapper, vo);
		mapper.close();
		return correct;
	}
	
}
