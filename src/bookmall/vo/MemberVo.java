package bookmall.vo;

public class MemberVo {
	private Long idx;
	private String phoneNumber;
	private String email;
	private String pwd;
	@Override
	public String toString() {
		return "MemberVo [idx=" + idx + ", phoneNumber=" + phoneNumber + ", email=" + email + ", pwd=*]";
	}
	public Long getIdx() {
		return idx;
	}
	public void setIdx(Long idx) {
		this.idx = idx;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	
	
}
