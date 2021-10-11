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
	
	/**
	 * @return list
	 * 개인별 총 자산을 가져와주기 위해 DAO 요청하는 메소드
	 */
	public ArrayList<UserStocksVO> selectList() {
		SqlSession mapper = MySession.getSession();
		ArrayList<UserStocksVO> list= StocksDAO.getInstance().selectList(mapper);
		// 데이터 재 가공 => 수익률, 총 평가자산 계산
		calculate(list);
		mapper.close();
		return list;
	}
	
	/**
	 * @param list
	 * selectList 메소드 실행중 DB에 없는 수익률, 자산가치 를 계산하기 위한 메소드
	 */
	private void calculate(ArrayList<UserStocksVO> list) {
		for (int i = 0; i < list.size(); i++) {
			UserStocksVO vo = new UserStocksVO(list.get(i).getName(),
											   list.get(i).getOwnStocks(),
											   list.get(i).getP_price(),
											   list.get(i).getC_price()
			);
			list.set(i, vo);
		}
	}
	
	/**
	 * @param name
	 * 선택된 종목 1건을 삭제하는 요청을 DAO 에 하는 메소드
	 */
	public void delete(String name) {
		SqlSession mapper = MySession.getSession();
		StocksDAO.getInstance().delete(mapper, name);
		mapper.commit();
		mapper.close();
	}
	
	/**
	 * @param name
	 * DAO에 수정할 종목 1건을 가져오는 요청을 함
	 * @return 
	 */
	public UserStocksVO getVO(String name) {
		SqlSession mapper = MySession.getSession();
		UserStocksVO vo =  StocksDAO.getInstance().getVO(mapper, name);
//		System.out.println(vo);
		mapper.close();
		return vo;
	}
	
	public void update(UserStocksVO vo) {
		SqlSession mapper = MySession.getSession();
		StocksDAO.getInstance().update(mapper, vo);
		mapper.commit();
		mapper.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
