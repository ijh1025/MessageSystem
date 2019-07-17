package com.message;

public class MessageDTO {
	private int num;
	private String send_name;
	private String receive_email;
	private String content;
	private String day;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSend_name() {
		return send_name;
	}
	public void setSend_name(String send_name) {
		this.send_name = send_name;
	}
	public String getReceive_email() {
		return receive_email;
	}
	public void setReceive_email(String receive_email) {
		this.receive_email = receive_email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public MessageDTO(int num, String send_name, String receive_email, String content, String day) {
		super();
		this.num = num;
		this.send_name = send_name;
		this.receive_email = receive_email;
		this.content = content;
		this.day = day;
	}
	
	public MessageDTO(String send_name, String receive_email, String content) {
		super();
		this.send_name = send_name;
		this.receive_email = receive_email;
		this.content = content;
	}
	@Override
	public String toString() {
		return "MessageDTO [num=" + num + ", send_name=" + send_name + ", receive_email=" + receive_email + ", content="
				+ content + ", day=" + day + "]";
	}
	
	
}
