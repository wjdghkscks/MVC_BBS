package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.CVO;
import com.ict.db.DAO;

public class C_writeCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		CVO cvo = new CVO();
		cvo.setWriter(request.getParameter("writer"));
		cvo.setContent(request.getParameter("content"));
		cvo.setPwd(request.getParameter("pwd"));
		cvo.setB_idx(request.getParameter("b_idx"));
		
		int result = DAO.getC_Insert(cvo);
		
		return "MyController?cmd=onelist&b_idx=" + cvo.getB_idx();
	}
}
