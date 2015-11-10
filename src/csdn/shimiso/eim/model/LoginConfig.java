package csdn.shimiso.eim.model;

/**
 * 
 * ��¼����.
 * 
 * @author shimiso
 */
public class LoginConfig {

	private String xmppHost;// ��ַ
	private Integer xmppPort;// �˿�
	private String xmppServiceName;// ����������
	private String username;// �û���
	private String password;// ����
	private String sessionId;// �Ựid
	private boolean isRemember;// �Ƿ��ס����
	private boolean isAutoLogin;// �Ƿ��Զ���¼
	private boolean isNovisible;// �Ƿ����ص�¼
	private boolean isOnline;// �û����ӳɹ�connection
	private boolean isFirstStart;// �Ƿ��״�����

	public boolean isOnline() {
		return isOnline;
	}

	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

	public String getXmppHost() {
		return xmppHost;
	}

	public void setXmppHost(String xmppHost) {
		this.xmppHost = xmppHost;
	}

	public Integer getXmppPort() {
		return xmppPort;
	}

	public void setXmppPort(Integer xmppPort) {
		this.xmppPort = xmppPort;
	}

	public String getXmppServiceName() {
		return xmppServiceName;
	}

	public void setXmppServiceName(String xmppServiceName) {
		this.xmppServiceName = xmppServiceName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public boolean isRemember() {
		return isRemember;
	}

	public void setRemember(boolean isRemember) {
		this.isRemember = isRemember;
	}

	public boolean isAutoLogin() {
		return isAutoLogin;
	}

	public void setAutoLogin(boolean isAutoLogin) {
		this.isAutoLogin = isAutoLogin;
	}

	public boolean isNovisible() {
		return isNovisible;
	}

	public void setNovisible(boolean isNovisible) {
		this.isNovisible = isNovisible;
	}

	public boolean isFirstStart() {
		return isFirstStart;
	}

	public void setFirstStart(boolean isFirstStart) {
		this.isFirstStart = isFirstStart;
	}

}
