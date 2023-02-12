package 과제.과제4.model;

public class Board {
	//필드
	String content;
	String writer;
	String view;
	//생성자
	//깡통
	public Board () {}
	public Board(String content, String writer, String view) {

		this.content = content;
		this.writer = writer;
		this.view = view;
	}
	//메소드
	@Override
	public String toString() {
		return "Borad [content=" + content + ", Write=" + writer + ", view=" + view + "]";
	}
	
}
