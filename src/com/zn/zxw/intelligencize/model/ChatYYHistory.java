package com.zn.zxw.intelligencize.model;

/**
 * 
 * @author YY
 * 
 */
public class ChatYYHistory {
	private String Accept;
	private String Head;
	private String User;
	private String Time;

	// private byte[] image;

	public ChatYYHistory() {
		
	}

	public ChatYYHistory(String user,String accept,String time,String head ) {
		User=user;
		
		Accept = accept;
		Time=time;
		Head=head;
		
	}
	public void setUser(String User) {
		this.User= User;
	}
	public String getUser() {
		return User;
	}
	public String getAccept() {
		return Accept;
	}
	public void setAccept(String Accept) {
		this.Accept = Accept;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String Time) {
		this.Time = Time;
	}
	public String getHead() {
		return Head;
	}
	public void setHead(String Head) {
		this.Head = Head;
	}
	
}
