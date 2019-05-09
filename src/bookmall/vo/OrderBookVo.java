package bookmall.vo;

public class OrderBookVo {
	private String orderDate;
	private String orderIdx;
	private Long bookIdx;
	private String bookName;
	private Integer cnt;
	
	
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderIdx() {
		return orderIdx;
	}
	public void setOrderIdx(String orderIdx) {
		this.orderIdx = orderIdx;
	}
	public Long getBookIdx() {
		return bookIdx;
	}
	public void setBookIdx(Long bookIdx) {
		this.bookIdx = bookIdx;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}


	
}
