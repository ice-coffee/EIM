package csdn.shimiso.eim.model;

import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;
import csdn.shimiso.eim.comm.Constant;
import csdn.shimiso.eim.util.DateUtil;

public class IMMessage implements Parcelable, Comparable<IMMessage> {
	public static final String IMMESSAGE_KEY = "immessage.key";
	public static final String KEY_TIME = "immessage.time";
	public static final int SUCCESS = 0;
	public static final int ERROR = 1;
	private int type;
	private String content;
	private String time;
	private String path;
	
	/**
	 * ���ڱ��أ���ʾ��˭����
	 */
	private String fromSubJid;
	/**
	 * 0:���� 1������
	 */
	private int msgType = 0;

	public IMMessage() {
		this.type = SUCCESS;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getFromSubJid() {
		return fromSubJid;
	}

	public void setFromSubJid(String fromSubJid) {
		this.fromSubJid = fromSubJid;
	}

	public int getMsgType() {
		return msgType;
	}

	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(type);
		dest.writeString(content);
		dest.writeString(time);
		dest.writeString(fromSubJid);
		dest.writeInt(msgType);
	}

	public static final Parcelable.Creator<IMMessage> CREATOR = new Parcelable.Creator<IMMessage>() {

		@Override
		public IMMessage createFromParcel(Parcel source) {
			IMMessage message = new IMMessage();
			message.setType(source.readInt());
			message.setContent(source.readString());
			message.setTime(source.readString());
			message.setFromSubJid(source.readString());
			message.setMsgType(source.readInt());
			message.setPath(source.readString());
			return message;
		}

		@Override
		public IMMessage[] newArray(int size) {
			return new IMMessage[size];
		}

	};

	/**
	 * ����Ϣ�Ĺ��췽��.
	 * 
	 * @param content
	 * @param time
	 */
	public IMMessage(String content, String time, String withSb, int msgType,String path) {
		super();
		this.content = content;
		this.time = time;
		this.msgType = msgType;
		this.fromSubJid = withSb;
		this.path=path;
	}

	/**
	 * shimiso ��ʱ�併������
	 */
	@Override
	public int compareTo(IMMessage oth) {
		if (null == this.getTime() || null == oth.getTime()) {
			return 0;
		}
		String format = null;
		String time1 = "";
		String time2 = "";
		if (this.getTime().length() == oth.getTime().length()
				&& this.getTime().length() == 23) {
			time1 = this.getTime();
			time2 = oth.getTime();
			format = Constant.MS_FORMART;
		} else {
			time1 = this.getTime().substring(0, 19);
			time2 = oth.getTime().substring(0, 19);
		}
		Date da1 = DateUtil.str2Date(time1, format);
		Date da2 = DateUtil.str2Date(time2, format);
		if (da1.before(da2)) {
			return -1;
		}
		if (da2.before(da1)) {
			return 1;
		}

		return 0;
	}
}
