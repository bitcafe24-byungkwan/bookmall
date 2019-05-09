package bookmall.test;


import bookmall.BookmallSetting;
import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		
		BookmallSetting.reset("member");
	
		insert("01012345678","abc@naver.com","hello");
		insert("01099990000","zyx@hanmail.net","hi");
		getListTest();
		
	}

	public static void insert(String phoneNumber, String email, String pwd) {
		MemberVo vo = new MemberVo();
		vo.setPhoneNumber(phoneNumber);
		vo.setEmail(email);
		vo.setPwd(pwd);
		new MemberDao().insert(vo);
	}
	
	public static void getListTest() {
		new MemberDao().viewList();
	
	}


}
