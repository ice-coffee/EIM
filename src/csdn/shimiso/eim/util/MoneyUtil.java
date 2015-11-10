package csdn.shimiso.eim.util;

import java.math.BigDecimal;

/**
 * �������� ����Ҵ�д��λ���й涨�á�Ԫ�� ����ͷ����������������򲻸� ��Ϊ��ʱ��д�ǣ��磺�����֣� �������뵽��
 * Ϊ�����ж��ɻ�һ��Դ�д���Ԥ�ڽϸߣ��� ��������һ�����λΪԪ��������ҼԲǰ�Լӡ���Ԫ��
 * 
 * ����ת�� ���������������ֵ��ֻ��ʾһ���㣬������ʾ ��(��)ǰ����󲻼��㣬���ڡ���Ϊһ������λ�� ���磺ʰ��Ǫ �� ʰ���㷡Ǫ ��˳Щ��
 * ��Ϊ����������λ��ֻҪ��λ��������ʾ���磺Ҽ���ڣ� ��Ϊ�����λ������֮������з���ֵ����ʾ�� ���硰Ҽ�ڡ�������ʾΪ��Ҽ���򡱣�
 * 
 * Ϊ���ٱ��ܸĵĿ����ԣ�ʮ��λ�ܷ�Ҽ������������ϰ�߶�����һ�� ��ʮ��λ���ڵ�һλ����Ҽ�����硰ʰԪ���ǡ�ҼʰԪ���� ʮ��λ��ǰ�����Ƿ񲻷�Ҽ����̫ȷ����
 * �硰��Ǫ��ҼʰԪ�����ǡ���Ǫ��ʰԪ������ �á�ʰ�򡱲��á�Ҽʰ�򡱣���Ϊÿ��������λ���н�λ��λ��ʰ��Ǫ���ڣ�
 * ������ʹ���ǰû�и����ܸĵ�ǰ׺�硰����ҡ�����Ҳ�Ѵܸ�Щ ��Ϊ����Ҫ�����������ֲ��ҸĶ������ֱ����λ���ܴܸĳ�
 * ���硰ʰ�򡱿ɸĳɡ���ʰ�򡱣�����Ҽʰ������Ҫ�ĳɡ�Ҽ��Ҽʰ�򡱣�
 */
public class MoneyUtil {

	static String HanDigiStr[] = new String[] { "��", "Ҽ", "��", "��", "��", "��",
			"½", "��", "��", "��" };

	static String HanDiviStr[] = new String[] { "", "ʰ", "��", "Ǫ", "��", "ʰ",
			"��", "Ǫ", "��", "ʰ", "��", "Ǫ", "��", "ʰ", "��", "Ǫ", "��", "ʰ", "��",
			"Ǫ", "��", "ʰ", "��", "Ǫ" };

	static String PositiveIntegerToHanStr(String NumStr) { // �����ַ���������������ֻ����ǰ���ո�(�����Ҷ���)��������ǰ����
		String RMBStr = "";
		boolean lastzero = false;
		boolean hasvalue = false; // �ڡ����λǰ����ֵ���
		int len, n;
		len = NumStr.length();
		if (len > 15)
			return "��ֵ����!";
		for (int i = len - 1; i >= 0; i--) {
			if (NumStr.charAt(len - i - 1) == ' ')
				continue;
			n = NumStr.charAt(len - i - 1) - '0';
			if (n < 0 || n > 9)
				return "���뺬�������ַ�!";
			if (n != 0) {
				if (lastzero)
					RMBStr += HanDigiStr[0]; // ���������������ֵ��ֻ��ʾһ����
				// ��������ǰ���㲻��������
				// if( !( n==1 && (i%4)==1 && (lastzero || i==len-1) ) ) //
				// ��ʮ��λǰ����Ҳ����Ҽ���ô���
				if (!(n == 1 && (i % 4) == 1 && i == len - 1)) // ʮ��λ���ڵ�һλ����Ҽ��
					RMBStr += HanDigiStr[n];
				RMBStr += HanDiviStr[i]; // ����ֵ��ӽ�λ����λΪ��
				hasvalue = true; // �����λǰ��ֵ���
			} else {
				if ((i % 8) == 0 || ((i % 8) == 4 && hasvalue)) // ����֮������з���ֵ����ʾ��
					RMBStr += HanDiviStr[i]; // ���ڡ�����
			}
			if (i % 8 == 0)
				hasvalue = false; // ���λǰ��ֵ��Ƿ��ڸ�λ
			lastzero = (n == 0) && (i % 4 != 0);
		}

		if (RMBStr.length() == 0)
			return HanDigiStr[0]; // ������ַ���"0"������"��"
		return RMBStr;
	}

	public static String NumToRMBStr(double val) {
		String SignStr = "";
		String TailStr = "";
		long fraction, integer;
		int jiao, fen;

		if (val < 0) {
			val = -val;
			SignStr = "��";
		}
		if (val > 99999999999999.999 || val < -99999999999999.999)
			return "��ֵλ������!";
		// �������뵽��
		long temp = Math.round(val * 100);
		integer = temp / 100;
		fraction = temp % 100;
		jiao = (int) fraction / 10;
		fen = (int) fraction % 10;
		if (jiao == 0 && fen == 0) {
			TailStr = "��";
		} else {
			TailStr = HanDigiStr[jiao];
			if (jiao != 0)
				TailStr += "��";
			if (integer == 0 && jiao == 0) // ��Ԫ��д�㼸��
				TailStr = "";
			if (fen != 0)
				TailStr += HanDigiStr[fen] + "��";
		}

		// ��һ�п����ڷ�������ڳ��ϣ�0.03ֻ��ʾ�����֡������ǡ���Ԫ���֡�
		// if( !integer ) return SignStr+TailStr;

		return "��" + SignStr + PositiveIntegerToHanStr(String.valueOf(integer))
				+ "Ԫ" + TailStr;
	}

	/**
	 * ���ܣ�ȡ��ָ��С��λ����ֵ
	 * 
	 * @param d
	 *            �������ֵ
	 * @param num
	 *            Ҫ������С��λ
	 * @return ������������ֵ
	 */
	public static Double DoubleNumUtil(Double d, int num) {
		if (d != null) {
			double d1 = d.doubleValue();
			double d2 = new BigDecimal(d1).setScale(num,
					BigDecimal.ROUND_HALF_UP).doubleValue();
			d = new Double(d2);
		}
		return d;
	}

	/**
	 * ת���ַ�Ϊ���֣�����ת��ʱ����0
	 * 
	 * @param s
	 *            ����
	 * @return
	 */
	public static Double parseDouble(String s) {
		Double d;
		try {
			d = Double.valueOf(s);
		} catch (Exception e) {
			d = new Double(0);
		}
		return d;
	}

	/**
	 * ת���ַ�Ϊ���֣�����ת��ʱ����0
	 * 
	 * @param s
	 *            ����
	 * @return
	 */
	public static Integer parseInteger(String s) {
		Integer i;
		try {
			i = Integer.valueOf(s);
		} catch (Exception e) {
			i = new Integer(0);
		}
		return i;
	}

}
