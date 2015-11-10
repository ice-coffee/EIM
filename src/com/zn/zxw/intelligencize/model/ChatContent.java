package com.zn.zxw.intelligencize.model;

/**
 * 
 * @author zxw
 *
 */
public class ChatContent {
	
	 public ChatContent(String id, String title, String content,
			String sendDate, String acceptDate, String sendUser,
			String acceptUser, byte[] image) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.sendDate = sendDate;
		this.acceptDate = acceptDate;
		this.sendUser = sendUser;
		this.acceptUser = acceptUser;
		this.image = image;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public String getAcceptDate() {
		return acceptDate;
	}
	public void setAcceptDate(String acceptDate) {
		this.acceptDate = acceptDate;
	}
	public String getSendUser() {
		return sendUser;
	}
	public void setSendUser(String sendUser) {
		this.sendUser = sendUser;
	}
	public String getAcceptUser() {
		return acceptUser;
	}
	public void setAcceptUser(String acceptUser) {
		this.acceptUser = acceptUser;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public ChatContent (){}
	 
	
	 private     String id;
	 private     String title;
	 private    String content;
	 private    String sendDate;
	 private    String acceptDate;
	 private   String sendUser;
	 private   String acceptUser;
	 private   byte[] image;
}
