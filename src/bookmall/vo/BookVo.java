package bookmall.vo;

public class BookVo {
	private Long idx;
	private Long idxCategory;
	private String title;
	private Integer price;
	private String categoryName;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Long getIdx() {
		return idx;
	}
	public void setIdx(Long idx) {
		this.idx = idx;
	}
	public Long getIdxCategory() {
		return idxCategory;
	}
	public void setIdxCategory(Long idxCategory) {
		this.idxCategory = idxCategory;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BookVo [도서번호 : " + idx + ", 종류번호 : " + idxCategory + ", 제목 : " + title + ", 가격 : " + price
				+ ", 종류 : " + categoryName + "]";
	}
	
	
}
