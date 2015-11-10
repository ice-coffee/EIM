package csdn.shimiso.eim.util;

import java.math.BigDecimal;

/**
 * 基本考虑 人民币大写单位银行规定用“元” 无零头金额后跟“整”，有则不跟 角为零时不写角（如：零叁分） 四舍五入到分
 * 为减少判读疑惑（一般对大写金额预期较高）和 体现人民币基本单位为元，金额低于壹圆前仍加“零元”
 * 
 * 整数转换 若干零后若跟非零值，只显示一个零，否则不显示 万(亿)前有零后不加零，因亿、万为一完整单位， （如：拾万贰仟 比 拾万零贰仟 更顺些）
 * 亿为汉语计数最大单位，只要进位到总是显示（如：壹亿亿） 万为次最大单位，亿万之间必须有非零值方显示万 （如“壹亿”不可显示为“壹亿万”）
 * 
 * 为减少被窜改的可能性，十进位总发壹音，这和下面的习惯读法不一样 （十进位处于第一位不发壹音，如“拾元”非“壹拾元”， 十进位处前有零是否不发壹音不太确定，
 * 如“叁仟零壹拾元”还是“叁仟零拾元”？） 用“拾万”不用“壹拾万”，因为每个整数进位后都有进位单位（拾佰仟万亿）
 * 这样即使金额前没有附防窜改的前缀如“人民币”字样也难窜改些 因为至少要加添两个汉字并且改动后数字必须进位才能窜改成
 * （如“拾万”可改成“叁拾万”，而“壹拾万”至少要改成“壹佰壹拾万”）
 */
public class MoneyUtil {

	static String HanDigiStr[] = new String[] { "零", "壹", "贰", "叁", "肆", "伍",
			"陆", "柒", "捌", "玖" };

	static String HanDiviStr[] = new String[] { "", "拾", "佰", "仟", "万", "拾",
			"佰", "仟", "亿", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰",
			"仟", "万", "拾", "佰", "仟" };

	static String PositiveIntegerToHanStr(String NumStr) { // 输入字符串必须正整数，只允许前导空格(必须右对齐)，不宜有前导零
		String RMBStr = "";
		boolean lastzero = false;
		boolean hasvalue = false; // 亿、万进位前有数值标记
		int len, n;
		len = NumStr.length();
		if (len > 15)
			return "数值过大!";
		for (int i = len - 1; i >= 0; i--) {
			if (NumStr.charAt(len - i - 1) == ' ')
				continue;
			n = NumStr.charAt(len - i - 1) - '0';
			if (n < 0 || n > 9)
				return "输入含非数字字符!";
			if (n != 0) {
				if (lastzero)
					RMBStr += HanDigiStr[0]; // 若干零后若跟非零值，只显示一个零
				// 除了亿万前的零不带到后面
				// if( !( n==1 && (i%4)==1 && (lastzero || i==len-1) ) ) //
				// 如十进位前有零也不发壹音用此行
				if (!(n == 1 && (i % 4) == 1 && i == len - 1)) // 十进位处于第一位不发壹音
					RMBStr += HanDigiStr[n];
				RMBStr += HanDiviStr[i]; // 非零值后加进位，个位为空
				hasvalue = true; // 置万进位前有值标记
			} else {
				if ((i % 8) == 0 || ((i % 8) == 4 && hasvalue)) // 亿万之间必须有非零值方显示万
					RMBStr += HanDiviStr[i]; // “亿”或“万”
			}
			if (i % 8 == 0)
				hasvalue = false; // 万进位前有值标记逢亿复位
			lastzero = (n == 0) && (i % 4 != 0);
		}

		if (RMBStr.length() == 0)
			return HanDigiStr[0]; // 输入空字符或"0"，返回"零"
		return RMBStr;
	}

	public static String NumToRMBStr(double val) {
		String SignStr = "";
		String TailStr = "";
		long fraction, integer;
		int jiao, fen;

		if (val < 0) {
			val = -val;
			SignStr = "负";
		}
		if (val > 99999999999999.999 || val < -99999999999999.999)
			return "数值位数过大!";
		// 四舍五入到分
		long temp = Math.round(val * 100);
		integer = temp / 100;
		fraction = temp % 100;
		jiao = (int) fraction / 10;
		fen = (int) fraction % 10;
		if (jiao == 0 && fen == 0) {
			TailStr = "整";
		} else {
			TailStr = HanDigiStr[jiao];
			if (jiao != 0)
				TailStr += "角";
			if (integer == 0 && jiao == 0) // 零元后不写零几分
				TailStr = "";
			if (fen != 0)
				TailStr += HanDigiStr[fen] + "分";
		}

		// 下一行可用于非正规金融场合，0.03只显示“叁分”而不是“零元叁分”
		// if( !integer ) return SignStr+TailStr;

		return "￥" + SignStr + PositiveIntegerToHanStr(String.valueOf(integer))
				+ "元" + TailStr;
	}

	/**
	 * 功能：取得指定小数位的数值
	 * 
	 * @param d
	 *            传入的数值
	 * @param num
	 *            要保留的小数位
	 * @return 四舍五入后的数值
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
	 * 转换字符为数字，不能转换时返回0
	 * 
	 * @param s
	 *            数字
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
	 * 转换字符为数字，不能转换时返回0
	 * 
	 * @param s
	 *            数字
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
