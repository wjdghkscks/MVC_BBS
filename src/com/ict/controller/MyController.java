package com.ict.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.C_deleteCommand;
import com.ict.model.C_writeCommand;
import com.ict.model.Command;
import com.ict.model.DeleteCommand;
import com.ict.model.DeleteOkCommand;
import com.ict.model.ListCommand;
import com.ict.model.OnelistCommand;
import com.ict.model.UpdateCommand;
import com.ict.model.UpdateOkCommand;
import com.ict.model.WriteCommand;
import com.ict.model.WriteOkCommand;

@WebServlet("/MyController")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String cmd = request.getParameter("cmd");
		Command comm = null;
		
		switch (cmd) {
			case "list"			: comm = new ListCommand(); 		break;
			case "write"		: comm = new WriteCommand();		break;
			case "write_ok"		: comm = new WriteOkCommand();		break;
			case "onelist"		: comm = new OnelistCommand();		break;
			case "update"		: comm = new UpdateCommand();		break;
			case "update_ok"	: comm = new UpdateOkCommand();		break;
			case "delete"		: comm = new DeleteCommand();		break;
			case "delete_ok"	: comm = new DeleteOkCommand();		break;
			case "c_write"		: comm = new C_writeCommand();		break;
			case "c_delete"		: comm = new C_deleteCommand();		break;
		}
		
		String path = comm.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}

}
