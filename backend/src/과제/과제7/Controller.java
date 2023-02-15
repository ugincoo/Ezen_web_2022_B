package 과제.과제7;

import java.util.ArrayList;
import 
public class Controller {

	ArrayList<Account> AccountList = new ArrayList<>();
	
	
	//계좌 자동생성
	public Account addAccount(int bank_Ch,String password, String name) {
		int random1 = (int)((Math.random()*10)+1);
		int random2 = (int)((Math.random()*10)+1);
	
		Account account = null;
		String Accountno = account.getBankno()+"-"+random1+"-"+random2;
		if(bank_Ch==1) {
			account = new Shinhan(account, password, name, 0);
		
		AccountList.add(account);
		
	}
}
