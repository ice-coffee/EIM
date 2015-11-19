package csdn.shimiso.eim.comm;

public class Constant {
	/**
	 * ���е�action�ļ����ı���Ҫ��"ACTION_"��ͷ
	 * 
	 */

	/**
	 * ��������ɾ����ACTION��KEY
	 */
	public static final String ROSTER_DELETED = "roster.deleted";
	public static final String ROSTER_DELETED_KEY = "roster.deleted.key";

	/**
	 * �������и��µ�ACTION��KEY
	 */
	public static final String ROSTER_UPDATED = "roster.updated";
	public static final String ROSTER_UPDATED_KEY = "roster.updated.key";

	/**
	 * �����������ӵ�ACTION��KEY
	 */
	public static final String ROSTER_ADDED = "roster.added";
	public static final String ROSTER_ADDED_KEY = "roster.added.key";

	/**
	 * �������г�Ա״̬�иı��ACTION��KEY
	 */
	public static final String ROSTER_PRESENCE_CHANGED = "roster.presence.changed";
	public static final String ROSTER_PRESENCE_CHANGED_KEY = "roster.presence.changed.key";

	/**
	 * �յ�������������
	 */
	public static final String ROSTER_SUBSCRIPTION = "roster.subscribe";
	public static final String ROSTER_SUB_FROM = "roster.subscribe.from";
	public static final String NOTICE_ID = "notice.id";

	public static final String NEW_MESSAGE_ACTION = "roster.newmessage";

	/**
	 * �ҵ���Ϣ
	 */
	public static final String MY_NEWS = "my.news";
	public static final String MY_NEWS_DATE = "my.news.date";

	/**
	 * ������������
	 */
	public static final String LOGIN_SET = "eim_login_set";// ��¼����
	public static final String USERNAME = "username";// �˻�
	public static final String PASSWORD = "password";// ����
	public static final String XMPP_HOST = "xmpp_host";// ��ַ
	public static final String XMPP_PORT = "xmpp_port";// �˿�
	public static final String XMPP_SEIVICE_NAME = "xmpp_service_name";// ������
	public static final String IS_AUTOLOGIN = "isAutoLogin";// �Ƿ��Զ���¼
	public static final String IS_NOVISIBLE = "isNovisible";// �Ƿ�����
	public static final String IS_REMEMBER = "isRemember";// �Ƿ��ס�˻�����
	public static final String IS_FIRSTSTART = "isFirstStart";// �Ƿ��״�����
	/**
	 * ��¼��ʾ
	 */
	public static final int LOGIN_SECCESS = 0;// �ɹ�
	public static final int HAS_NEW_VERSION = 1;// �����°汾
	public static final int IS_NEW_VERSION = 2;// ��ǰ�汾Ϊ����
	public static final int LOGIN_ERROR_ACCOUNT_PASS = 3;// �˺Ż����������
	public static final int SERVER_UNAVAILABLE = 4;// �޷����ӵ�������
	public static final int LOGIN_ERROR = 5;// ����ʧ��

	public static final String XMPP_CONNECTION_CLOSED = "xmpp_connection_closed";// �����ж�

	public static final String LOGIN = "login"; // ��¼
	public static final String RELOGIN = "relogin"; // ���µ�¼

	/**
	 * �����б� ����
	 */
	public static final String ALL_FRIEND = "���к���";// ���к���
	public static final String NO_GROUP_FRIEND = "δ�������";// ���к���
	/**
	 * ϵͳ��Ϣ
	 */
	public static final String ACTION_SYS_MSG = "action_sys_msg";// ��Ϣ���͹ؼ���
	public static final String MSG_TYPE = "broadcast";// ��Ϣ���͹ؼ���
	public static final String SYS_MSG = "sysMsg";// ϵͳ��Ϣ�ؼ���
	public static final String SYS_MSG_DIS = "ϵͳ��Ϣ";// ϵͳ��Ϣ
	public static final String ADD_FRIEND_QEQUEST = "��������";// ϵͳ��Ϣ�ؼ���
	/**
	 * ����ĳ���������ص�״ֵ̬
	 */
	public static final int SUCCESS = 0;// ����
	public static final int FAIL = 1;// ������
	public static final int UNKNOWERROR = 2;// ����Ī���Ĵ���.
	public static final int NETWORKERROR = 3;// �������
	/***
	 * ��ҵͨѶ¼�����û������û���ȥ������Ա�е����������Ƿ��������֯
	 */
	public static final int containsZz = 0;
	/***
	 * �������������ϵ���б�xml��ҳ����
	 */
	public static final String currentpage = "1";// ��ǰ�ڼ�ҳ
	public static final String pagesize = "1000";// ��ǰҳ������

	/***
	 * ��������xml��������
	 */
	public static final String add = "00";// ����
	public static final String rename = "01";// ����
	public static final String remove = "02";// ����

	/**
	 * ������
	 */
	/**
	 * ������״̬acttion
	 * 
	 */
	public static final String ACTION_RECONNECT_STATE = "action_reconnect_state";
	/**
	 * ����������״̬�Ĺػ��ӣ��ķŵ�intent�Ĺؼ���
	 */
	public static final String RECONNECT_STATE = "reconnect_state";
	/**
	 * ����������״̬ �ɹ�success/�±�fail
	 */
	public static final boolean RECONNECT_STATE_SUCCESS = true;
	public static final boolean RECONNECT_STATE_FAIL = false;
	/**
	 * �Ƿ����ߵ�SharedPreferences����
	 */
	public static final String PREFENCE_USER_STATE = "prefence_user_state";
	public static final String IS_ONLINE = "is_online";
	/**
	 * ��ȷ������
	 */
	public static final String MS_FORMART = "yyyy-MM-dd HH:mm:ss";

}
