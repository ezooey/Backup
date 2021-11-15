package member.vo;

public class Member {
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String department;
	private String phone;
	private String address;
	private String email;
	private String memberType;
	private String status;
	
	public Member() {}
	
	public Member(String memberId, String memberPwd, String memberName, String department, String phone, String address,
			String email, String memberType, String status) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.department = department;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.memberType = memberType;
		this.status = status;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName=" + memberName
				+ ", department=" + department + ", phone=" + phone + ", address=" + address + ", email=" + email
				+ ", memberType=" + memberType + ", status=" + status + "]";
	}
	
}
