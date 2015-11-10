package csdn.shimiso.eim.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.widget.EditText;
import android.widget.TextView;

/**
 * 正在表达式验证工具类（验证身份证、车牌号等）
 * 
 * @author iStar
 * 
 */
public class ValidateUtil {

	/**
	 * 验证str是否为正确的身份证格式
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isIdentityCard(EditText view) {
		boolean flag = true;
		String licenc = view.getText().toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		/*
		 * { 11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",
		 * 21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",
		 * 33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",
		 * 42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",
		 * 51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",
		 * 63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外" }
		 */
		String provinces = "11,12,13,14,15,21,22,23,31,32,33,34,35,36,37,41,42,43,44,45,46,50,51,52,53,54,61,62,63,64,65,71,81,82,91";

		Pattern pattern = Pattern.compile("^[1-9]\\d{14}");
		Matcher matcher = pattern.matcher(licenc);
		Pattern pattern2 = Pattern.compile("^[1-9]\\d{16}[\\d,x,X]$");
		Matcher matcher2 = pattern2.matcher(licenc);
		// 粗略判断
		if (!matcher.find() && !matcher2.find()) {
			view.setError("身份证号必须为15或18位数字（最后一位可以为X）");
			flag = false;
		} else {
			// 判断出生地
			if (provinces.indexOf(licenc.substring(0, 2)) == -1) {
				view.setError("身份证号前两位不正确！");
				flag = false;
			}

			// 判断出生日期
			if (licenc.length() == 15) {
				String birth = "19" + licenc.substring(6, 8) + "-"
						+ licenc.substring(8, 10) + "-"
						+ licenc.substring(10, 12);
				try {
					Date birthday = sdf.parse(birth);
					if (!sdf.format(birthday).equals(birth)) {
						view.setError("出生日期非法！");
						flag = false;
					}
					if (birthday.after(new Date())) {
						view.setError("出生日期不能在今天之后！");
						flag = false;
					}
				} catch (ParseException e) {
					view.setError("出生日期非法！");
					flag = false;
				}
			} else if (licenc.length() == 18) {
				String birth = licenc.substring(6, 10) + "-"
						+ licenc.substring(10, 12) + "-"
						+ licenc.substring(12, 14);
				try {
					Date birthday = sdf.parse(birth);
					if (!sdf.format(birthday).equals(birth)) {
						view.setError("出生日期非法！");
						flag = false;
					}
					if (birthday.after(new Date())) {
						view.setError("出生日期不能在今天之后！");
						flag = false;
					}
				} catch (ParseException e) {
					view.setError("出生日期非法！");
					flag = false;
				}
			} else {
				view.setError("身份证号位数不正确，请确认！");
				flag = false;
			}
		}
		if (!flag) {
			view.requestFocus();
		}
		return flag;
	}

	/**
	 * 不为空时，验证str是否为正确的身份证格式
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
			 * { 11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",
			 * 21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",
			 * 33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",
			 * 42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",
			 * 51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",
			 * 63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外" }
			 */
			String provinces = "11,12,13,14,15,21,22,23,31,32,33,34,35,36,37,41,42,43,44,45,46,50,51,52,53,54,61,62,63,64,65,71,81,82,91";

			Pattern pattern = Pattern.compile("^[1-9]\\d{14}");
			Matcher matcher = pattern.matcher(licenc);
			Pattern pattern2 = Pattern.compile("^[1-9]\\d{16}[\\d,x,X]$");
			Matcher matcher2 = pattern2.matcher(licenc);
			// 粗略判断
			if (!matcher.find() && !matcher2.find()) {
				view.setError("身份证号必须为15或18位数字（最后一位可以为X）");
				flag = false;
			} else {
				// 判断出生地
				if (provinces.indexOf(licenc.substring(0, 2)) == -1) {
					view.setError("身份证号前两位不正确！");
					flag = false;
				}

				// 判断出生日期
				if (licenc.length() == 15) {
					String birth = "19" + licenc.substring(6, 8) + "-"
							+ licenc.substring(8, 10) + "-"
							+ licenc.substring(10, 12);
					try {
						Date birthday = sdf.parse(birth);
						if (!sdf.format(birthday).equals(birth)) {
							view.setError("出生日期非法！");
							flag = false;
						}
						if (birthday.after(new Date())) {
							view.setError("出生日期不能在今天之后！");
							flag = false;
						}
					} catch (ParseException e) {
						view.setError("出生日期非法！");
						flag = false;
					}
				} else if (licenc.length() == 18) {
					String birth = licenc.substring(6, 10) + "-"
							+ licenc.substring(10, 12) + "-"
							+ licenc.substring(12, 14);
					try {
						Date birthday = sdf.parse(birth);
						if (!sdf.format(birthday).equals(birth)) {
							view.setError("出生日期非法！");
							flag = false;
						}
						if (birthday.after(new Date())) {
							view.setError("出生日期不能在今天之后！");
							flag = false;
						}
					} catch (ParseException e) {
						view.setError("出生日期非法！");
						flag = false;
					}
				} else {
					view.setError("身份证号位数不正确，请确认！");
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
	 * 验证str是否为正确的身份证格式
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isIdentityCard(String licenc) {
		boolean flag = true;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		/*
		 * { 11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",
		 * 21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",
		 * 33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",
		 * 42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",
		 * 51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",
		 * 63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外" }
		 */
		String provinces = "11,12,13,14,15,21,22,23,31,32,33,34,35,36,37,41,42,43,44,45,46,50,51,52,53,54,61,62,63,64,65,71,81,82,91";

		Pattern pattern = Pattern.compile("^[1-9]\\d{14}");
		Matcher matcher = pattern.matcher(licenc);
		Pattern pattern2 = Pattern.compile("^[1-9]\\d{16}[\\d,x,X]$");
		Matcher matcher2 = pattern2.matcher(licenc);
		// 粗略判断
		if (!matcher.find() && !matcher2.find()) {
			flag = false;
		} else {
			// 判断出生地
			if (provinces.indexOf(licenc.substring(0, 2)) == -1) {
				flag = false;
			}

			// 判断出生日期
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
	 * 验证str是否为正确的车牌号
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
		String[] str1 = { "京", "津", "冀", "晋", "蒙", "辽", "吉", "黑", "沪", "苏",
				"浙", "皖", "闽", "赣", "鲁", "豫", "鄂", "湘", "粤", "桂", "琼", "渝",
				"川", "贵", "云", "藏", "陕", "甘", "青", "宁", "新", "农", "台", "中",
				"武", "WJ", "亥", "戌", "酉", "申", "未", "午", "巳", "辰", "卯", "寅",
				"丑", "子", "葵", "壬", "辛", "庚", "己", "戊", "丁", "丙", "乙", "甲",
				"河北", "山西", "北京", "北", "南", "兰", "沈", "济", "成", "广", "海", "空",
				"军", "京V", "使" };

		if (no.equals("新车")) {
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
			w.setError(displayStr + "不能为空！");
			w.setFocusable(true);
			w.requestFocus();
			return true;
		}
		return false;
	}

	public static boolean isNum(TextView w, String displayStr) {
		if (!StringUtil.num(w.getText().toString().trim())) {
			w.setError(displayStr + "必须为整数且大于0！");
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
			w.setError(displayStr + "必须为数字且大于0！");
			w.setFocusable(true);
			w.requestFocus();
			return true;
		}
		return false;
	}

	// 可以空,非空时必须正确
	public static boolean maybeAccountNumberEmpty(TextView w) {
		if (!StringUtil.empty(w.getText().toString().trim())) {
			return ValidateUtil.isAccountNumber(w);
		}
		return true;
	}

	// 可以空,非空时必须正确
	public static boolean maybeMobileEmpty(TextView w) {
		if (!StringUtil.empty(w.getText().toString().trim())) {
			return ValidateUtil.isMobileNumber(w);
		}
		return true;
	}

	public static boolean isArea(TextView w) {
		if (!RegexUtil.isArea(w.getText().toString().trim())) {
			w.setError("面积有非法字符！");
			w.setFocusable(true);
			return false;
		}
		return true;
	}

	public static boolean isMobileNumber(TextView w) {
		if (!RegexUtil.isMobileNumber(w.getText().toString().trim())) {
			w.setError("手机号码为11位数字！");
			w.setFocusable(true);
			return false;
		}
		return true;
	}

	/** 银行帐号为16-21位的数字 */
	public static boolean isAccountNumber(TextView w) {
		if (!RegexUtil.isAccountNumber(w.getText().toString().trim())) {
			w.setError("银行帐号必须为16-21位的数字！");
			w.setFocusable(true);
			return false;
		}
		return true;
	}

}
