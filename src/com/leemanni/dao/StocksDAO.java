package com.leemanni.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.leemanni.vo.LoginVO;
import com.leemanni.vo.UserStocksVO;

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
	
	
	/**
	 * @param mapper
	 * @param vo
	 * @return
	 * 
	 * @from logInService
	 * 사용자id pw 일치여부 확인
	 * 
	 */
	public boolean checkLogin(SqlSession mapper, LoginVO vo) {
//		System.out.println("StocksDAO ==> checkLogin");
		int correct = (int) mapper.selectOne("checkLogin", vo);
//		System.out.println(correct);
		return correct == 1 ? true : false; 
	}
	
	public void insert(SqlSession mapper, UserStocksVO vo) {
//		System.out.println("StocksDAO ==> insert");
		mapper.insert("insert", vo);
	}
	
	
	/**
	 * @param mapper
	 * @return
	 * 보유 자산 목록을 불러오는 메소드
	 */
	public ArrayList<UserStocksVO> selectList(SqlSession mapper) {
		return (ArrayList<UserStocksVO>) mapper.selectList("selectList");
	}
	
	
	/**
	 * @param name
	 * 선택된 주식 1건을 삭제하는 메소드
	 */
	public void delete(SqlSession mapper, String name) {
		System.out.println("StocksDAO==>delete");
		mapper.delete("delete", name);
	}
}
























