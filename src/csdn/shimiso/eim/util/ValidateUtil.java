package csdn.shimiso.eim.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.widget.EditText;
import android.widget.TextView;

/**
 * ���ڱ��ʽ��֤�����ࣨ��֤���֤�����ƺŵȣ�
 * 
 * @author iStar
 * 
 */
public class ValidateUtil {

	/**
	 * ��֤str�Ƿ�Ϊ��ȷ�����֤��ʽ
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isIdentityCard(EditText view) {
		boolean flag = true;
		String licenc = view.getText().toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		/*
		 * { 11:"����",12:"���",13:"�ӱ�",14:"ɽ��",15:"���ɹ�",
		 * 21:"����",22:"����",23:"������",31:"�Ϻ�",32:"����",
		 * 33:"�㽭",34:"����",35:"����",36:"����",37:"ɽ��",41:"����",
		 * 42:"����",43:"����",44:"�㶫",45:"����",46:"����",50:"����",
		 * 51:"�Ĵ�",52:"����",53:"����",54:"����",61:"����",62:"����",
		 * 63:"�ຣ",64:"����",65:"�½�",71:"̨��",81:"���",82:"����",91:"����" }
		 */
		String provinces = "11,12,13,14,15,21,22,23,31,32,33,34,35,36,37,41,42,43,44,45,46,50,51,52,53,54,61,62,63,64,65,71,81,82,91";

		Pattern pattern = Pattern.compile("^[1-9]\\d{14}");
		Matcher matcher = pattern.matcher(licenc);
		Pattern pattern2 = Pattern.compile("^[1-9]\\d{16}[\\d,x,X]$");
		Matcher matcher2 = pattern2.matcher(licenc);
		// �����ж�
		if (!matcher.find() && !matcher2.find()) {
			view.setError("���֤�ű���Ϊ15��18λ���֣����һλ����ΪX��");
			flag = false;
		} else {
			// �жϳ�����
			if (provinces.indexOf(licenc.substring(0, 2)) == -1) {
				view.setError("���֤��ǰ��λ����ȷ��");
				flag = false;
			}

			// �жϳ�������
			if (licenc.length() == 15) {
				String birth = "19" + licenc.substring(6, 8) + "-"
						+ licenc.substring(8, 10) + "-"
						+ licenc.substring(10, 12);
				try {
					Date birthday = sdf.parse(birth);
					if (!sdf.format(birthday).equals(birth)) {
						view.setError("�������ڷǷ���");
						flag = false;
					}
					if (birthday.after(new Date())) {
						view.setError("�������ڲ����ڽ���֮��");
						flag = false;
					}
				} catch (ParseException e) {
					view.setError("�������ڷǷ���");
					flag = false;
				}
			} else if (licenc.length() == 18) {
				String birth = licenc.substring(6, 10) + "-"
						+ licenc.substring(10, 12) + "-"
						+ licenc.substring(12, 14);
				try {
					Date birthday = sdf.parse(birth);
					if (!sdf.format(birthday).equals(birth)) {
						view.setError("�������ڷǷ���");
						flag = false;
					}
					if (birthday.after(new Date())) {
						view.setError("�������ڲ����ڽ���֮��");
						flag = false;
					}
				} catch (ParseException e) {
					view.setError("�������ڷǷ���");
					flag = false;
				}
			} else {
				view.setError("���֤��λ������ȷ����ȷ�ϣ�");
				flag = false;
			}
		}
		if (!flag) {
			view.requestFocus();
		}
		return flag;
	}

	/**
	 * ��Ϊ��ʱ����֤str�Ƿ�Ϊ��ȷ�����֤��ʽ
	 * 
	 * @param str
	 * @return
	 */
	public static boolean maybeIsIdentityCard(EditText view) {
		boolean flag = true;
		String licenc = view.getText().toString();
		if (!licenc.equals("")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			/*
			 * { 11:"����",12:"���",13:"�ӱ�",14:"ɽ��",15:"���ɹ�",
			 * 21:"����",22:"����",23:"������",31:"�Ϻ�",32:"����",
			 * 33:"�㽭",34:"����",35:"����",36:"����",37:"ɽ��",41:"����",
			 * 42:"����",43:"����",44:"�㶫",45:"����",46:"����",50:"����",
			 * 51:"�Ĵ�",52:"����",53:"����",54:"����",61:"����",62:"����",
			 * 63:"�ຣ",64:"����",65:"�½�",71:"̨��",81:"���",82:"����",91:"����" }
			 */
			String provinces = "11,12,13,14,15,21,22,23,31,32,33,34,35,36,37,41,42,43,44,45,46,50,51,52,53,54,61,62,63,64,65,71,81,82,91";

			Pattern pattern = Pattern.compile("^[1-9]\\d{14}");
			Matcher matcher = pattern.matcher(licenc);
			Pattern pattern2 = Pattern.compile("^[1-9]\\d{16}[\\d,x,X]$");
			Matcher matcher2 = pattern2.matcher(licenc);
			// �����ж�
			if (!matcher.find() && !matcher2.find()) {
				view.setError("���֤�ű���Ϊ15��18λ���֣����һλ����ΪX��");
				flag = false;
			} else {
				// �жϳ�����
				if (provinces.indexOf(licenc.substring(0, 2)) == -1) {
					view.setError("���֤��ǰ��λ����ȷ��");
					flag = false;
				}

				// �жϳ�������
				if (licenc.length() == 15) {
					String birth = "19" + licenc.substring(6, 8) + "-"
							+ licenc.substring(8, 10) + "-"
							+ licenc.substring(10, 12);
					try {
						Date birthday = sdf.parse(birth);
						if (!sdf.format(birthday).equals(birth)) {
							view.setError("�������ڷǷ���");
							flag = false;
						}
						if (birthday.after(new Date())) {
							view.setError("�������ڲ����ڽ���֮��");
							flag = false;
						}
					} catch (ParseException e) {
						view.setError("�������ڷǷ���");
						flag = false;
					}
				} else if (licenc.length() == 18) {
					String birth = licenc.substring(6, 10) + "-"
							+ licenc.substring(10, 12) + "-"
							+ licenc.substring(12, 14);
					try {
						Date birthday = sdf.parse(birth);
						if (!sdf.format(birthday).equals(birth)) {
							view.setError("�������ڷǷ���");
							flag = false;
						}
						if (birthday.after(new Date())) {
							view.setError("�������ڲ����ڽ���֮��");
							flag = false;
						}
					} catch (ParseException e) {
						view.setError("�������ڷǷ���");
						flag = false;
					}
				} else {
					view.setError("���֤��λ������ȷ����ȷ�ϣ�");
					flag = false;
				}
			}
			if (!flag) {
				view.requestFocus();
			}
		}
		return flag;
	}

	/**
	 * ��֤str�Ƿ�Ϊ��ȷ�����֤��ʽ
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isIdentityCard(String licenc) {
		boolean flag = true;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		/*
		 * { 11:"����",12:"���",13:"�ӱ�",14:"ɽ��",15:"���ɹ�",
		 * 21:"����",22:"����",23:"������",31:"�Ϻ�",32:"����",
		 * 33:"�㽭",34:"����",35:"����",36:"����",37:"ɽ��",41:"����",
		 * 42:"����",43:"����",44:"�㶫",45:"����",46:"����",50:"����",
		 * 51:"�Ĵ�",52:"����",53:"����",54:"����",61:"����",62:"����",
		 * 63:"�ຣ",64:"����",65:"�½�",71:"̨��",81:"���",82:"����",91:"����" }
		 */
		String provinces = "11,12,13,14,15,21,22,23,31,32,33,34,35,36,37,41,42,43,44,45,46,50,51,52,53,54,61,62,63,64,65,71,81,82,91";

		Pattern pattern = Pattern.compile("^[1-9]\\d{14}");
		Matcher matcher = pattern.matcher(licenc);
		Pattern pattern2 = Pattern.compile("^[1-9]\\d{16}[\\d,x,X]$");
		Matcher matcher2 = pattern2.matcher(licenc);
		// �����ж�
		if (!matcher.find() && !matcher2.find()) {
			flag = false;
		} else {
			// �жϳ�����
			if (provinces.indexOf(licenc.substring(0, 2)) == -1) {
				flag = false;
			}

			// �жϳ�������
			if (licenc.length() == 15) {
				String birth = "19" + licenc.substring(6, 8) + "-"
						+ licenc.substring(8, 10) + "-"
						+ licenc.substring(10, 12);
				try {
					Date birthday = sdf.parse(birth);
					if (!sdf.format(birthday).equals(birth)) {
						flag = false;
					}
					if (birthday.after(new Date())) {
						flag = false;
					}
				} catch (ParseException e) {
					flag = false;
				}
			} else if (licenc.length() == 18) {
				String birth = licenc.substring(6, 10) + "-"
						+ licenc.substring(10, 12) + "-"
						+ licenc.substring(12, 14);
				try {
					Date birthday = sdf.parse(birth);
					if (!sdf.format(birthday).equals(birth)) {
						flag = false;
					}
					if (birthday.after(new Date())) {
						flag = false;
					}
				} catch (ParseException e) {
					flag = false;
				}
			} else {
				flag = false;
			}
		}

		return flag;
	}

	/**
	 * ��֤str�Ƿ�Ϊ��ȷ�ĳ��ƺ�
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isPlateNo(EditText view) {
		String no = view.getText().toString().trim();
		if (no == null || no.equals("")) {
			return false;
		}
		String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String[] str1 = { "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "³", "ԥ", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "ũ", "̨", "��",
				"��", "WJ", "��", "��", "��", "��", "δ", "��", "��", "��", "î", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"�ӱ�", "ɽ��", "����", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��V", "ʹ" };

		if (no.equals("�³�")) {
			return true;
		}

		if (no.length() == 7) {
			int h = 0;
			for (int r = 0; r < no.length(); r++) {
				if (str.indexOf(no.charAt(r)) != -1) {
					h++;
				}
			}
			if (h == 7) {
				return true;
			}
		}
		if (no.length() > 1) {

			String jq1 = no.substring(0, 1);
			String jq2 = no.substring(0, 2);

			for (int k = 0; k < str1.length; k++) {
				if (str1[k].equals(jq1)) {
					if (no.length() <= 8) {
						return true;
					}
				}
				if (str1[k].equals(jq2)) {
					if (no.length() <= 8) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean isEmpty(TextView w, String displayStr) {
		if (StringUtil.empty(w.getText().toString().trim())) {
			w.setError(displayStr + "����Ϊ�գ�");
			w.setFocusable(true);
			w.requestFocus();
			return true;
		}
		return false;
	}

	public static boolean isNum(TextView w, String displayStr) {
		if (!StringUtil.num(w.getText().toString().trim())) {
			w.setError(displayStr + "����Ϊ�����Ҵ���0��");
			w.setFocusable(true);
			w.requestFocus();
			return true;
		}
		return false;
	}

	public static boolean isEmail(String strEmail) {
		String strPattern = "^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
		Pattern p = Pattern.compile(strPattern);
		Matcher m = p.matcher(strEmail);
		return m.matches();
	}

	public static boolean isDouble(TextView w, String displayStr) {
		if (!StringUtil.decimal(w.getText().toString().trim())) {
			w.setError(displayStr + "����Ϊ�����Ҵ���0��");
			w.setFocusable(true);
			w.requestFocus();
			return true;
		}
		return false;
	}

	// ���Կ�,�ǿ�ʱ������ȷ
	public static boolean maybeAccountNumberEmpty(TextView w) {
		if (!StringUtil.empty(w.getText().toString().trim())) {
			return ValidateUtil.isAccountNumber(w);
		}
		return true;
	}

	// ���Կ�,�ǿ�ʱ������ȷ
	public static boolean maybeMobileEmpty(TextView w) {
		if (!StringUtil.empty(w.getText().toString().trim())) {
			return ValidateUtil.isMobileNumber(w);
		}
		return true;
	}

	public static boolean isArea(TextView w) {
		if (!RegexUtil.isArea(w.getText().toString().trim())) {
			w.setError("����зǷ��ַ���");
			w.setFocusable(true);
			return false;
		}
		return true;
	}

	public static boolean isMobileNumber(TextView w) {
		if (!RegexUtil.isMobileNumber(w.getText().toString().trim())) {
			w.setError("�ֻ�����Ϊ11λ���֣�");
			w.setFocusable(true);
			return false;
		}
		return true;
	}

	/** �����ʺ�Ϊ16-21λ������ */
	public static boolean isAccountNumber(TextView w) {
		if (!RegexUtil.isAccountNumber(w.getText().toString().trim())) {
			w.setError("�����ʺű���Ϊ16-21λ�����֣�");
			w.setFocusable(true);
			return false;
		}
		return true;
	}

}
