package bookmall.test;


import bookmall.BookmallSetting;
import bookmall.dao.BookDao;

import bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		
		BookmallSetting.reset("book");
	
		insert("교토의밤산책자",15000,"여행");
		insert("노예의역사",17000,"역사");
		insert("오늘기도노트",7000,"종교");
		
		getListTest();
		
		
	}

	public static void insert(String title, Integer price, String category) {
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setPrice(price);
		vo.setCategoryName(category);
		new BookDao().insert(vo);
	}
	public static void getListTest() {
		new BookDao().viewList();
	
	}


}
