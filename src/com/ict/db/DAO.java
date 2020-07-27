package com.ict.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import oracle.jdbc.OracleConnection.CommitOption;

// DB 처리 클래스
public class DAO {

	// MyBatis 는 SqlSession 클래스를 사용
	private static SqlSession ss;
	
	// Singleton 패턴
	private synchronized static SqlSession getSession() {
		if (ss == null) {
			// [Auto commit X]
			//	> Transaction 처리 시 개발자가 수동으로 commit 
			// ss = DBService.getFactory().openSession(false);
			ss = DBService.getFactory().openSession();
			
			// [Auto commit O]
			// ss = DBService.getFactory().openSession(true);
			
			// SELECT 쿼리는 commit 이 필요 없음
			// INSERT, UPDATE, DELETE 는 commit 필요
		}
		return ss;
	}
	
// ↓↓↓ SqlSession 을 이용하여 DB 처리 ↓↓↓
	
// list - SELECT
	public static List<BVO> getList(){
		
		List<BVO> list = null;
		
		list = getSession().selectList("list");
		
		return list;
	}
	
// 리스트(시작번호, 끝번호) - SELECT
	public static List<BVO> getList(int begin, int end){
		
		List<BVO> list = null;
		
	// 파라미터 값이 여러개이므로 vo 또는 Map 을 생성
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		list = getSession().selectList("p_list", map);
		
		return list;
	}

// write - INSERT
	public static int getWrite(BVO vo) {
		
		int result = 0;
		
		result = getSession().insert("write", vo);
		
		ss.commit();
		
		return result;
	}

// HitUp - UPDATE
	public static int getHitUp(String b_idx) {
		
		int result = 0;
		
		result = getSession().update("hitup", b_idx);
		
		ss.commit();
		
		return result;
		
	}

// Onelist - SELECT
	public static BVO getOnelist(String b_idx) {
		
		BVO bvo = null;
		
		bvo = getSession().selectOne("onelist", b_idx);
		
		return bvo;
		
	}
	
// delete - DELETE
	public static int getDelete(String b_idx) {
		
		int result = 0;
		
		result = getSession().delete("delete", b_idx);
		
		ss.commit();
		
		return result;
		
	}
	
// update - UPDATE
	public static int getUpdate(BVO bvo) {
		
		int result = 0;
		
		result = getSession().update("update", bvo);
		
		ss.commit();
		
		return result;
	}

// comment - SELECT
	public static List<CVO> getClist(String b_idx) {
		List<CVO> c_list = null;
		
		c_list = getSession().selectList("c_list", b_idx);
		
		return c_list;
	}
	
// comment write - INSERT
	public static int getC_Insert(CVO cvo) {
		
		int result = 0;
		
		result = getSession().insert("c_write", cvo);
		
		ss.commit();
		
		return result;
	}
	
// comment delete - DELETE
	public static int getC_delete(String c_idx) {
		
		int result = 0;
		
		result = getSession().delete("c_delete", c_idx);
		
		ss.commit();
		
		return result;
	}
	
// 게시글 삭제를 위해 관련 댓글 전체 삭제 - DELETE
	public static int getC_AllDelete(String b_idx) {
		
		int res = 0;
		
		res = getSession().delete("c_alldelete", b_idx);
		
		ss.commit();
		
		return res;
	}
	
// 전체 게시글의 수 (totalRecord) 구하기
	public static int getCount() {
		
		int result = 0;
		
		result = getSession().selectOne("count");
		
		return result;
	}
	
}
