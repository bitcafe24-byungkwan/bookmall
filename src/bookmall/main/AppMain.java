package bookmall.main;

import bookmall.BookmallSetting;
import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.dao.OrderBookDao;
import bookmall.dao.OrderDao;
import bookmall.test.BookDaoTest;
import bookmall.test.CartDaoTest;
import bookmall.test.CategoryDaoTest;
import bookmall.test.MemberDaoTest;
import bookmall.test.OrderBookDaoTest;
import bookmall.test.OrderDaoTest;


public class AppMain {

	public static void main(String[] args) {		
		
		refresh();
		
		// 1. 회원리스트
		System.out.println("회원리스트");
		new MemberDao().viewList();
		System.out.println();

		// 2. 카테고리 리스트
		System.out.println("카테고리 리스트");
		new CategoryDao().viewList();		
		System.out.println();

		// 3. 상품 리스트
		System.out.println("상품리스트");
		new BookDao().viewList();
		System.out.println();
		
		// 4. 카트 리스트
		System.out.println("카트 리스트");
		new CartDao().viewCartList();
		System.out.println();
		
		// 5. 주문리스트
		System.out.println("주문리스트");
		new OrderDao().viewList();
		System.out.println();
		
		// 6. 주문도서리스트
		System.out.println("주문도서 리스트");
		new OrderBookDao().viewOrderBookList();
		System.out.println();
	}
	
	
	
	private static void refresh()
	{
		
		
		BookmallSetting.reset("order_book");
		BookmallSetting.reset("cart");
		
		BookmallSetting.reset("book");
		
		BookmallSetting.reset("category");
		
		BookmallSetting.reset("orders");
		BookmallSetting.reset("member");

		

		CategoryDaoTest.insert("여행");
		CategoryDaoTest.insert("역사");
		CategoryDaoTest.insert("종교");
		
		BookDaoTest.insert("교토의밤산책자",15000,"여행");
		BookDaoTest.insert("노예의역사",17000,"역사");
		BookDaoTest.insert("오늘기도노트",7000,"종교");
		
		MemberDaoTest.insert("01012345678","abc@naver.com","hello");
		MemberDaoTest.insert("01099990000","zyx@hanmail.net","hi");
		
		CartDaoTest.insert("01012345678","교토의밤산책자",2);
		CartDaoTest.insert("01012345678","노예의역사",1);		
		CartDaoTest.insert("01099990000","교토의밤산책자",1);
		CartDaoTest.insert("01099990000","오늘기도노트",2);
		
		OrderDaoTest.insert("abc네집", "01012345678");
		
		OrderBookDaoTest.insert("교토의밤산책자",1);
		OrderBookDaoTest.insert("노예의역사",2);
		
	}
}
