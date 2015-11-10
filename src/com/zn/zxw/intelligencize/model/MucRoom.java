package com.zn.zxw.intelligencize.model;


/**
 * @author 
 *
 */
public class MucRoom {
	
	String name;
	String jid;
	int occupants;
	String description;
	String subject;
	String pwd;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getJid() {
		return jid;
	}
	public void setJid(String jid) {
		this.jid = jid;
	}
	public int getOccupants() {
		return occupants;
	}
	public void setOccupants(int occupants) {
		this.occupants = occupants;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "MucRoom [name=" + name + ", jid=" + jid + ", occupants="
				+ occupants + ", description=" + description + ", subject="
				+ subject + "]";
	}
	
	

}
