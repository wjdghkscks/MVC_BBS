package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String cPage = request.getParameter("cPage");
		
		request.setAttribute("cPage", cPage);
		
		return "view/update.jsp";
	}
}
