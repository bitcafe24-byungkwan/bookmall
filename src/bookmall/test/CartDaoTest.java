package bookmall.test;


import bookmall.BookmallSetting;
import bookmall.dao.CartDao;
import bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		
		BookmallSetting.reset("cart");
	
		insert("01012345678","교토의밤산책자",2);
		insert("01012345678","노예의역사",1);
		
		insert("01099990000","교토의밤산책자",1);
		insert("01099990000","오늘기도노트",2);
		
		getListTest();
		getCartListTest();
		
	}

	public static void insert(String memPhon, String bookTitle, Integer cnt) {
		CartVo vo = new CartVo();
		vo.setMemberPhoneNumber(memPhon);
		vo.setBookTitle(bookTitle);
		vo.setCnt(cnt);
		new CartDao().insert(vo);
	}
	public static void getListTest() {
		new CartDao().viewList();
	
	}
	public static void getCartListTest() {
		new CartDao().viewCartList();
	
	}


}
