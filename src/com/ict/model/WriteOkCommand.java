package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.BVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class WriteOkCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			// 파일 저장 위치
			String path = request.getServletContext().getRealPath("/upload");
			
			MultipartRequest mr = new MultipartRequest(
						request,
						path,
						100 * 1024 * 1024,
						"UTF-8",
						new DefaultFileRenamePolicy());
			
			// 파라미터 값 받기
			BVO bvo = new BVO();
			bvo.setSubject(mr.getParameter("subject"));
			bvo.setWriter(mr.getParameter("writer"));
			bvo.setContent(mr.getParameter("content"));
			bvo.setPwd(mr.getParameter("pwd"));

			// 파일 처리
			if(mr.getFile("file_name") != null) {
				bvo.setFile_name(mr.getFilesystemName("file_name"));
			} else {
				bvo.setFile_name("");
			}
			
			int result = DAO.getWrite(bvo);
			
			if(result > 0) {
				return "/MyController?cmd=list";
			} else {
				return "/MyController?cmd=write";
			}
		} catch (Exception e) {
		}
		return null;
	}
}
