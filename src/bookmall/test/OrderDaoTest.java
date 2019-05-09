package bookmall.test;


import bookmall.BookmallSetting;
import bookmall.dao.OrderDao;

import bookmall.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		
		BookmallSetting.reset("orders");
		
		insert("abc네집","01012345678");
		//insert("zyx네집","01099990000");
		getListTest();
		
	}

	public static void insert(String address, String memberPhoneNumber) {
		OrderVo vo = new OrderVo();
		vo.setMemberPhoneNumber(memberPhoneNumber);
		vo.setAddress(address);
		
		new OrderDao().insert(vo);
		
	}
	
	public static void getListTest() {
		new OrderDao().viewList();	
	}


}
