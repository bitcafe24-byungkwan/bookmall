package bookmall.vo;

public class CartVo {
	private Long memberIdx;
	private Long bookIdx;
	private Integer cnt;
	private String memberPhoneNumber;
	private String bookTitle;
	private Integer price;

	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}
	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public Long getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(Long memberIdx) {
		this.memberIdx = memberIdx;
	}
	public Long getBookIdx() {
		return bookIdx;
	}
	public void setBookIdx(Long bookIdx) {
		this.bookIdx = bookIdx;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "CartVo [memberIdx=" + memberIdx + ", bookIdx=" + bookIdx + ", cnt=" + cnt + ", memberPhoneNumber="
				+ memberPhoneNumber + ", bookTitle=" + bookTitle + ", price=" + price + "]";
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

	
}
