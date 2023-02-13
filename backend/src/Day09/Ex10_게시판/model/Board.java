package Day09.Ex10_게시판.model;

import java.util.Date;

/*
	클래스 model 클래스 만들기
		1. 필드 선정[ 모든 필드는private ]
		2. 생성자 [ 1.깡통 2. 풀 ]
		3. 메소드 [ 1.toString 2.Getters & Setters ]
 */
public class Board {
	//1. 필드
	private String title;
	private String content;
	private String writer;
	private String password;
	private Date date;
	private int view;
	//ArrayList< reply > list = new ArrayList<>(); 
	//2. 
		//1. 깡통
	public Board() {
		super();
	}
		//2. 풀
	public Board(String title, String content, String writer, String password, Date date, int view) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.password = password;
		this.date = date;
		this.view = view;		
	}
	//3. 메소드
	@Override
	public String toString() {
		return title +"\t"+writer+"\t"+view+"\t"+date;
	}
	//3-1 getter & setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	
	
	
}
