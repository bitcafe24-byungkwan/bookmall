package bookmall.vo;

public class OrderVo {
	private String Date;
	private Long idx;
	private String address;
	private Long memberIdx;
	private String memberPhoneNumber;
	private String orderNumber;
	
	@Override
	public String toString() {
		return "OrderVo [주문번호 : " + orderNumber +", 배송지 : " + address + ", 회원번호 : " + memberIdx
				+ ", 전화번호 : " + memberPhoneNumber + ", 주문상태 : " + status
				+ "]";
	}
	public Long getMemberIdx() {
		return memberIdx;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public void setMemberIdx(Long memberIdx) {
		this.memberIdx = memberIdx;
	}
	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}
	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}
	private String status;
	
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public Long getIdx() {
		return idx;
	}
	public void setIdx(Long idx) {
		this.idx = idx;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
