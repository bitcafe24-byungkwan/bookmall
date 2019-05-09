package bookmall.vo;

public class CategoryVo {
	private Long idx;
	private String category;
	public Long getIdx() {
		return idx;
	}
	public void setIdx(Long idx) {
		this.idx = idx;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "CategoryVo [idx=" + idx + ", category=" + category + "]";
	}
	
}
