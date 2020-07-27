package com.ict.model;

public class Paging {
	/*
	
	* 페이징 기법
	
	- 전체 정보에서 원하는 일부 정보를 가져오는 기법
	- 해당 페이지의 시작 번호 및 끝 번호 구하기
	- 시작 블록 및 끝 블록 구하기
	
	- 게시글 < 페이지 < 블록
	*/
	
	private int nowPage = 1;			// nowPage 		: 현재 페이지
	private int nowBlock = 1;			// nowBlock 	: 현재 블록
	private int totalRecord = 0;		// totalRecord 	: 전체 게시글의 수
	private int totalPage = 0;			// totalPage 	: 전체 페이지의 수
	private int blockPage = 0;			// blockPage 	: 전체 블록의 수
	private int numPerPage = 5;			// numPerPage 	: 한 페이지 당 게시글의 수
	private int pagePerBlock = 3;		// pagePerBlock	: 한 블록 당 페이지의 수
	
	private int begin = 0;				// begin 		: 시작 번호
	private int end = 0;				// end 			: 끝 번호
	private int beginBlock = 0;			// beginBlock 	: 시작 블록
	private int endBlock = 0;			// endBlock		: 끝 블록
	
	// getter&setter
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getNowBlock() {
		return nowBlock;
	}
	public void setNowBlock(int nowBlock) {
		this.nowBlock = nowBlock;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getBlockPage() {
		return blockPage;
	}
	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}
	public int getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
	public int getPagePerBlock() {
		return pagePerBlock;
	}
	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getBeginBlock() {
		return beginBlock;
	}
	public void setBeginBlock(int beginBlock) {
		this.beginBlock = beginBlock;
	}
	public int getEndBlock() {
		return endBlock;
	}
	public void setEndBlock(int endBlock) {
		this.endBlock = endBlock;
	}
	
	
	
	
}
