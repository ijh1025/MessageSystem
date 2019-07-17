package com.member;

public class MemberDTO {
	private String email;
	private String pw;
	private String tel;
	private String add;
	private int admin;
	public MemberDTO(String email, String pw, String tel, String add) {
		super();
		this.email = email;
		this.pw = pw;
		this.tel = tel;
		this.add = add;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public MemberDTO(String email, String pw, String tel, String add, int admin) {
		super();
		this.email = email;
		this.pw = pw;
		this.tel = tel;
		this.add = add;
		this.admin = admin;
	}
	public MemberDTO(String email, String pw) {
		super();
		this.email = email;
		this.pw = pw;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	@Override
	public String toString() {
		return "MemberDTO [email=" + email + ", pw=" + pw + ", tel=" + tel + ", add=" + add + "]";
	}
	
	
}
