package csdn.shimiso.eim.util;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.SecureRandom;

/**
 * <p>
 * Title:UUID����������
 * </p>
 * 
 * @author zhoushengyu
 * @version 1.0
 */
public class UUIDPK implements Serializable {
	public String POID;

	/**
	 * ����޲εĹ��캯���Ǳ���Ҫ�еġ�
	 */
	public UUIDPK() {
	}

	/**
	 * @author zhoushengyu
	 * @function:
	 * @param id
	 *            POID��ֵ��
	 * @return
	 * @throws
	 */
	public UUIDPK(String id) {
		POID = id;
	}

	public String toString() {
		return POID;
	}

	public boolean equals(Object other) {
		boolean result = false;
		if (other == this) {
			return true;
		}
		if (!(other instanceof UUIDPK)) {
			return false;
		}

		result = POID == null ? ((UUIDPK) other).POID == null : POID
				.equals(((UUIDPK) other).POID);

		return result;
	}

	public int hashCode() {
		return POID == null ? 0 : POID.hashCode();
	}

	// --------����ΪUUID�����ɺ���---------

	/**
	 * @author zhoushengyu
	 * @function: ��UUID�Ĳ������Ʋ���һ��32λ����Hex�ַ�����
	 * @param obj
	 *            ����UUID��thirdPartʱ����Ҫʹ�õĶ����ʵ�����á�
	 * @return
	 * @throws
	 */

	public static String getUUID(Object obj) {
		String uuid = "";
		uuid = firstPart() + secondPart() + thirdPart(obj) + fourthPart();
		return uuid;
	}

	/**
	 * @author zhoushengyu
	 * @function: ���ص�ǰʱ�䣨���룩��ʾ��long�����֣�Hex��ʽ���ĵ�8λ��
	 * @param
	 * @return ���ص�ǰʱ�䣨���룩��ʾ��long�����֣�Hex��ʽ���ĵ�8λ
	 * @throws
	 */
	private static String firstPart() {
		long tmp = 0L;
		String tmpHex = null;
		tmp = System.currentTimeMillis();
		tmpHex = Long.toHexString(tmp);
		return tmpHex.substring(tmpHex.length() - 8);
	}

	/**
	 * @author zhoushengyu
	 * @function: �ײ�IP��ַ��ʾ��32λ������Hex�ַ�����
	 * @param
	 * @return �ײ�IP��ַ��ʾ��32λ������Hex�ַ�����
	 * @throws
	 */
	private static String secondPart() {
		String sndPart = "";
		int tmpIp = 0;
		int tmp = 0;
		InetAddress localIPAddr = null;
		try {
			localIPAddr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			// ���������ܷ�����
		}
		byte[] ipParts = localIPAddr.getAddress();
		// 0
		tmp = ipParts[0];
		/** IP��ַ�ĵ�0�Σ�tmp����24λ */
		tmpIp = tmp << 24;
		// 1
		tmp = ipParts[1];
		tmp = tmp << 16;
		tmpIp = tmpIp ^ tmp;
		// 2
		tmp = ipParts[2];
		tmp = tmp << 8;
		tmpIp = tmpIp ^ tmp;
		// 3
		tmp = ipParts[3];
		tmpIp = tmpIp ^ tmp;
		sndPart = Integer.toHexString(tmpIp);
		return getEightHex(sndPart);
	}

	/**
	 * @author zhoushengyu
	 * @function: ���ö����HashCode���Hex��ʽ���ַ�����
	 * @param obj
	 *            ʹ�ø�������hashCode��
	 * @return ���ö����HashCode���Hex��ʽ���ַ�����
	 * @throws
	 */
	private static String thirdPart(Object obj) {
		String tmpHex = "";
		tmpHex = Integer.toHexString(obj.hashCode());
		return getEightHex(tmpHex);
	}

	/**
	 * @author zhoushengyu
	 * @function: SecureRandom������������һ�����ڶ�ͬһ�������Ķ�����õ�Ψһֵ��
	 * @param
	 * @return ��һ�����ڶ�ͬһ�������Ķ�����õ�Ψһֵ��
	 * @throws
	 */
	private static String fourthPart() {
		String tmpHex = "";
		SecureRandom sr = new SecureRandom();
		tmpHex = Integer.toHexString(sr.nextInt());
		return getEightHex(tmpHex);
	}

	/**
	 * @author zhoushengyu
	 * @function: �Ѵ��ݹ������ַ����ӹ���8λ����
	 * @param part
	 *            Ҫ������ַ�����
	 * @return ����ַ�������8λ������8λ�����ַ�����ǰ��λ��0�������򷵻�ԭ�ַ�����
	 * @throws
	 */
	private static String getEightHex(String part) {
		if (part.length() >= 8) {
			return part;
		}
		switch (part.length()) {
		case (0): {
			part = "00000000";
			break;
		}
		case (1): {
			part = "0000000" + part;
			break;
		}
		case (2): {
			part = "000000" + part;
			break;
		}
		case (3): {
			part = "00000" + part;
			break;
		}
		case (4): {
			part = "0000" + part;
			break;
		}
		case (5): {
			part = "000" + part;
			break;
		}
		case (6): {
			part = "00" + part;
			break;
		}
		case (7): {
			part = "0" + part;
			break;
		}
		}
		return part;
	}
}
