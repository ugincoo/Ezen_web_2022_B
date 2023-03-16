package model.dto;

import java.util.ArrayList;

public class PageDto {

	private int page; 		//현재 페이지
	private int listsize; 	// 페이지당 표시할 개수
	private int startrow; 	//현재페이지에서 시작되는 게시물번호
	private int totalsize; 	//총 게시물 수 
	private int totalpage; 	//총 페이지 수 
	private int btnsizw;	//페이지별 최대 페이징 버튼 수
	private int startbtn;	//페이지별 시작 페이징 버튼 번호
	private int endbtn;		//페이지별 끝 페이징 버튼 번호
	
	//!! : 게시물 목록
	ArrayList<BoardDto> boardList ; // 출ㄺ할 데이터[게시물] 리스트

	public PageDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageDto(int page, int listsize, int startrow, int totalsize, int totalpage, int btnsizw, int startbtn,
			int endbtn, ArrayList<BoardDto> boardList) {
		super();
		this.page = page;
		this.listsize = listsize;
		this.startrow = startrow;
		this.totalsize = totalsize;
		this.totalpage = totalpage;
		this.btnsizw = btnsizw;
		this.startbtn = startbtn;
		this.endbtn = endbtn;
		this.boardList = boardList;
	}

	@Override
	public String toString() {
		return "PageDto [page=" + page + ", listsize=" + listsize + ", startrow=" + startrow + ", totalsize="
				+ totalsize + ", totalpage=" + totalpage + ", btnsizw=" + btnsizw + ", startbtn=" + startbtn
				+ ", endbtn=" + endbtn + ", boardList=" + boardList + "]";
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getListsize() {
		return listsize;
	}

	public void setListsize(int listsize) {
		this.listsize = listsize;
	}

	public int getStartrow() {
		return startrow;
	}

	public void setStartrow(int startrow) {
		this.startrow = startrow;
	}

	public int getTotalsize() {
		return totalsize;
	}

	public void setTotalsize(int totalsize) {
		this.totalsize = totalsize;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getBtnsizw() {
		return btnsizw;
	}

	public void setBtnsizw(int btnsizw) {
		this.btnsizw = btnsizw;
	}

	public int getStartbtn() {
		return startbtn;
	}

	public void setStartbtn(int startbtn) {
		this.startbtn = startbtn;
	}

	public int getEndbtn() {
		return endbtn;
	}

	public void setEndbtn(int endbtn) {
		this.endbtn = endbtn;
	}

	public ArrayList<BoardDto> getBoardList() {
		return boardList;
	}

	public void setBoardList(ArrayList<BoardDto> boardList) {
		this.boardList = boardList;
	}
	
	
	
}
