package 과제.과제7;

import java.util.ArrayList;

public class Controller {

	ArrayList<Account> AccountList = new ArrayList<>();
	
	
	//계좌 자동생성
	public Account addAccount(int bankNo,String password, String name) {
		int random1 = (int)((Math.random()*10)+1);
		int random2 = (int)((Math.random()*10)+1);
	
		Account account = null;

		
		AccountList.add(account);
		
	}
}
