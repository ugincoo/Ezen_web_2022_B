package model.dto;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MemberDto {
	private int mno ;	
    private String mid;		
    private String mpw	;
    private String mimg;
    private String memail;
    private int mpoint;	// 보유포인트 : db테이블에는 존재하지 않음
    
    //이메일 전송 메소드
    public boolean sendEmail(String toEmail,String contentHTML) {
    	//1. 보내는 사람의 정보
    	String fromEmail = "네이버@naver.com";
    	String Emailpwd = "이메일 비밀번호";
    	
    	//2. 호스팅설정 [ 네이버기준 ]
    	Properties properties =new Properties();
    	properties.put("mail.smtp.host","smtp.naver.com");
    	properties.put("mail.smtp.port",587);
    	properties.put("mail.smtp.auth",true);
    	properties.put("mail.smtp.ssl.protocols","TLSv1.2");
    	
    	//3. 인증처리 
    		// [ Session : import javax.mail.Session; ]
    		// Session.getDefaultInstance( '설정' , new Authenticator() {} );
    		// [ Authenticator :  import javax.mail ]
    		// [ PasswordAuthentication : import javax.mail ]
    		//  new PasswordAuthentication( "인증할계정주소" , "비밀번호" );
    	Session session = Session.getDefaultInstance(
    			properties, new Authenticator() {
    				//패스워드 인증 함수를 오버라이딩
    				@Override
    				protected PasswordAuthentication getPasswordAuthentication() {
    					return new PasswordAuthentication( fromEmail, Emailpwd);
    				}
				});
    			try {
    				
    				MimeMessage message = new MimeMessage(session);
    				message.setFrom(new InternetAddress(fromEmail));
    				message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
    				//내용 구성
    				message.setSubject( "MEOW Community 회원가입 메일 인증코드 ");
    				message.setText(contentHTML);
    				//전송
    				Transport.send(message);
    				return true;	//메일 전송 성공
    			}catch (Exception e) {
					System.out.println(e);
				}
    	return false; // 메일 전송 실패 
    }
    
    
	public MemberDto() {}
	
	public MemberDto(int mno, String mid, String mpw, String mimg, String memail) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpw = mpw;
		this.mimg = mimg;
		this.memail = memail;
	}
	

	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpw=" + mpw + ", mimg=" + mimg + ", memail=" + memail
				+ "]";
	}
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMimg() {
		return mimg;
	}
	public void setMimg(String mimg) {
		this.mimg = mimg;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
    
	
	public int getMpoint() {
		return mpoint;
	}


	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}


    
    
    
}
