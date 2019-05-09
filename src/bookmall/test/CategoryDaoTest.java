package bookmall.test;

import bookmall.BookmallSetting;
import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		
		BookmallSetting.reset("category");
		insert("여행");
		insert("역사");
		insert("종교");
		getListTest();
	}
	
	public static void insert(String category) {
		CategoryVo vo = new CategoryVo();
		vo.setCategory(category);
		new CategoryDao().insert(vo);
	}
	
	public static void getListTest() {
		new CategoryDao().viewList();
	
	}

}
