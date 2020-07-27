package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.BVO;
import com.ict.db.DAO;

public class DeleteOkCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		BVO bvo = (BVO)request.getSession().getAttribute("bvo");
		String b_idx = bvo.getB_idx();
		String cPage = request.getParameter("cPage");

		// 원 게시물에 달린 댓글이 있으면 삭제 시 오류 발생 >>> 댓글 모두 삭제 필요
		int res = DAO.getC_AllDelete(b_idx);
		
		int result = DAO.getDelete(bvo.getB_idx());
		
		return "/MyController?cmd=list&cPage=" + cPage;
	}
}
