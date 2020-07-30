package com.ict.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.BVO;

public class ListCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		// List<BVO> list = DAO.getList();
		
	// 페이징 기법
		
	// 1. Paging 객체 생성
		
		Paging paging = new Paging();
		
	// 2. 전체 게시물의 수 구하기
		
		int count = DAO.getCount();
		paging.setTotalRecord(count);
		
	// 3. totalRecord (전체 게시물의 수) 를 활용하여 setter
		
		// totalPage() : 전체 페이지의 수
		if(paging.getTotalRecord() <= paging.getNumPerPage()) {
			paging.setTotalPage(1);
		} else {
			paging.setTotalPage(paging.getTotalRecord()/paging.getNumPerPage());
			if(paging.getTotalRecord() % paging.getNumPerPage() != 0) {
				paging.setTotalPage(paging.getTotalPage() + 1);
			} else {
				
			}
		}
		
		/* nowPage() : 현재 페이지
			- "list.jsp" 로부터 cPage 라는 파라미터에 현재 페이지 값이 들어있어야 함
			- 최초 "list.jsp" 접속 시 cPage = 1 (현재 페이지 1)
			- 이후 cPage 가 nowPage() 가 됨	>>> cPage = nowPage() */
		String cPage = request.getParameter("cPage");
		if (cPage == null) {
			// 맨 처음에만 cPage 의 값이 null
			paging.setNowPage(1);
		} else {
			paging.setNowPage(Integer.parseInt(cPage));
		}
		 
	// 4. 현재 페이지의 시작 번호와 끝 번호 구하기
		paging.setBegin( (paging.getNowPage() - 1) * paging.getNumPerPage() + 1 );
		paging.setEnd( (paging.getBegin() - 1) + paging.getNumPerPage() );
		
	// 5. 시작 번호 및 끝 번호를 활용하여 DB에서 게시물 출력
		List<BVO> list = DAO.getList(paging.getBegin(), paging.getEnd());
		
	// 6. 현재 페이지의 시작 블럭과 끝 블럭 구하기
		paging.setBeginBlock((int)((paging.getNowPage()-1)/paging.getPagePerBlock()) * paging.getPagePerBlock() + 1);
		paging.setEndBlock( paging.getBeginBlock() + paging.getPagePerBlock() - 1 );
		
	// endBlock 이 totalPage 보다 큰 경우, 불필요한 endBlock 이 생성되는 문제 발생
	// 따라서 endBlock > totalPage 인 경우, endBlock 을 totalPage 로 변경
		if (paging.getEndBlock() > paging.getTotalPage()) {
			paging.setEndBlock(paging.getTotalPage());
		}
		
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		
		return "view/list.jsp";
	}
}
