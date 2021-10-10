package com.leemanni.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.leemanni.dao.StocksDAO;
import com.leemanni.mybatis.MySession;
import com.leemanni.vo.UserStocksVO;

/**
 * @author cjffy
 * 유저의 종목을 관여하는 Service 클래스
 */
public class StocksService {
	private static StocksService instance = new StocksService();
	public StocksService() {;}
	public static StocksService getInstance() {
		return instance;
	}
	
	/**
	 * @param vo
	 * 주식 1종목을 넘겨받아서 StocksDAO 에 넘겨서 insert() 메소드 호출
	 */
	public void insert(UserStocksVO vo) {
//		System.out.println("StocksService ==> UserStocksVO");
		SqlSession mapper = MySession.getSession();
		
		StocksDAO.getInstance().insert(mapper, vo);
		mapper.commit();
		mapper.close();
	}
	
	public ArrayList<UserStocksVO> selectList() {
		SqlSession mapper = MySession.getSession();
		ArrayList<UserStocksVO> list= StocksDAO.getInstance().selectList(mapper);
		mapper.close();
		return list;
	}
}
