package com.ict.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.BVO;
import com.ict.db.CVO;

public class OnelistCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		String b_idx = request.getParameter("b_idx");
		String cPage= request.getParameter("cPage");
		
		// 조회수 - 1 UPDATE
		int result = DAO.getHitUp(b_idx);
		
		// 내용 가져오기 - SELECT
		BVO bvo = DAO.getOnelist(b_idx);
		
		// 수정/삭제를 위해 세션에 저장
		request.getSession().setAttribute("bvo", bvo);
		
		// 댓글 처리 - b_idx 를 외래키로 갖고 있는 자료들을 불러옴
		List<CVO> c_list = DAO.getClist(b_idx);
		request.setAttribute("c_list", c_list);
		request.setAttribute("cPage", cPage);
		
		return "view/onelist.jsp";
	}
}
