package bookmall.test;


import bookmall.BookmallSetting;
import bookmall.dao.CartDao;
import bookmall.dao.OrderBookDao;
import bookmall.vo.CartVo;
import bookmall.vo.OrderBookVo;

public class OrderBookDaoTest {

	public static void main(String[] args) {
		
		BookmallSetting.reset("order_book");
		
		//
		//최대 idx에 주문 내용 등록
		// ->주문 리스트 1개일때만 됨
		insert("교토의밤산책자",2);
		insert("노예의역사",1);
		
		getBookOrderListTest();
		
	}

	public static void insert(String bookTitle, Integer cnt) {
		OrderBookVo vo = new OrderBookVo();
		vo.setBookName(bookTitle);		
		vo.setCnt(cnt);
		new OrderBookDao().insert(vo);
	}

	public static void getBookOrderListTest() {
		new OrderBookDao().viewOrderBookList();
	
	}


}
