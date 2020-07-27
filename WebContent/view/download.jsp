<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");

	String path = request.getParameter("path");
	String file_name = request.getParameter("file_name");
	
	// 실제 위치
	String r_path = getServletContext().getRealPath("/upload");
	
	// 다운로드가 가능하도록 클라이언트(웹브라우저)의 문서 타입 변경
	response.setContentType("application/x-msdownload");
	
	// http 헤더 정보를 첨부 파일이 존재하는 것으로 변경 (다운로드 form 생성)
	response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(file_name, "UTF-8"));
	
	// 실제 바이트 스트림을 이용하여 다운로드
	File file = new File(r_path + "/" + new String(file_name.getBytes("UTF-8")));
	
	int b;
	FileInputStream fis = null;
	BufferedInputStream bis = null;
	BufferedOutputStream bos = null;
	
	try {
		fis = new FileInputStream(file);
		bis = new BufferedInputStream(fis);
		bos = new BufferedOutputStream(response.getOutputStream());
		
		while((b = bis.read()) != -1) {
			bos.write(b);
			bos.flush();
		}
		
		out.clear();
		out = pageContext.pushBody();
	} catch(Exception e) {
		
	} finally {
		try {
			bos.close();
			bis.close();
			fis.close();
		} catch(Exception e2) {
			
		}
	}
	
	
%>
