package com.zn.zxw.intelligencize.model;

public class MucHistory {
	
	String userAccount;
	String mhRoomName;
	String friendAccount;
	String mhInfo;
	String mhTime;
	String mhType;
	
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getMhRoomName() {
		return mhRoomName;
	}
	public void setMhRoomName(String mhRoomName) {
		this.mhRoomName = mhRoomName;
	}
	public String getFriendAccount() {
		return friendAccount;
	}
	public void setFriendAccount(String friendAccount) {
		this.friendAccount = friendAccount;
	}
	public String getMhInfo() {
		return mhInfo;
	}
	public void setMhInfo(String mhInfo) {
		this.mhInfo = mhInfo;
	}
	public String getMhTime() {
		return mhTime;
	}
	public void setMhTime(String mhTime) {
		this.mhTime = mhTime;
	}
	public String getMhType() {
		return mhType;
	}
	public void setMhType(String mhType) {
		this.mhType = mhType;
	}
	@Override
	public String toString() {
		return "MucHistory [userAccount=" + userAccount + ", mhRoomName="
				+ mhRoomName + ", friendAccount=" + friendAccount + ", mhInfo="
				+ mhInfo + ", mhTime=" + mhTime + ", mhType=" + mhType + "]";
	}
	
}
