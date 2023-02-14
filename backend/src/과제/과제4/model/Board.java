package 과제.과제4.model;

public class Board {
	//필드
	public String title;
	public String content;
	public String writer;
	public int view = 0 ;
	//생성자
		//1.깡통
	public Board () {}
		//2.
	public Board(String title, String content, String writer) {
	this.title = title;
	this.content = content;
	this.writer = writer;
}
	public Board(String title, String content, String writer, int view) {
		
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.view = view;
	}
	//메소드
	@Override
	public String toString() {
		return "Board [title=" + title + ", content=" + content + ", writer=" + writer + ", view=" + view + "]";
	}

	
}
