package com.zn.zxw.intelligencize.model;
/**
 * 一个消息的JavaBean
 * 
 * @author way
 * 
 */
public class ChatMsgEntity{
	private int image;//头像
	private String date;//消息日期
	private String message;//消息内容
	private byte[] mesImage;//发送图片
	private boolean isComMeg = true;// 是否为收到的消息
	public int getImage() {
		return image;
	}

	public void setImage(int im) {
		this.image=im;
	}

	public String getDate() {
		return date;
	}

	public void setMesImage(byte[] image){
		mesImage=image;
	}
	
	public byte[] getMesImage(){
		return mesImage;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean getMsgType() {
		return isComMeg;
	}

	public void setMsgType(boolean isComMsg) {
		isComMeg = isComMsg;
	}

	public ChatMsgEntity() {
	}

	public ChatMsgEntity( String date, String text,int im, boolean isComMsg,byte[] mesImage) {
		super();
		this.image = im;
		this.date = date;
		this.message = text;
		this.isComMeg = isComMsg;
		this.mesImage=mesImage;
	}

}