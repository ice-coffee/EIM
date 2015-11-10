package csdn.shimiso.eim.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimestampTool {

	/**
	 * ������ת��ʱ��
	 */
	public static String getTimeMillisToDate(long l) {
		Timestamp d = new Timestamp(l);
		return d.toString().substring(0, 19);
	}

	/**
	 * ��ǰʱ��
	 * 
	 * @return Timestamp
	 */
	public static Timestamp crunttime() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * ��ȡ��ǰʱ����ַ���
	 * 
	 * @return String ex:2006-07-07
	 */
	public static String getCurrentDate() {
		Timestamp d = crunttime();
		return d.toString().substring(0, 10);
	}

	/**
	 * ��ȡ��ǰʱ����ַ���
	 * 
	 * @return String ex:2006-07-07 22:10:10
	 */
	public static String getCurrentDateTime() {
		Timestamp d = crunttime();
		return d.toString().substring(0, 19);
	}

	public static String getWeekDay() {
		Calendar date = Calendar.getInstance();
		date.setTime(crunttime());
		return new SimpleDateFormat("EEEE").format(date.getTime());
	}

	/**
	 * ��ȡָ��ʱ����ַ���,ֻ������
	 * 
	 * @param t
	 *            Timestamp
	 * @return String ex:2006-07-07
	 */
	public static String getStrDate(Timestamp t) {
		return t.toString().substring(0, 10);
	}

	/**
	 * ��ȡָ��ʱ����ַ���
	 * 
	 * @param t
	 *            Timestamp
	 * @return String ex:2006-07-07 22:10:10
	 */
	public static String getStrDateTime(Timestamp t) {
		return t.toString().substring(0, 19);
	}

	/**
	 * ��õ�ǰ���ڵ�ǰ������
	 * 
	 * @param days
	 * @return String
	 */
	public static String getStrIntervalDate(String days) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -Integer.parseInt(days));
		String strBeforeDays = sdf.format(cal.getTime());
		return strBeforeDays;
	}

	/**
	 * ��ʽ��ʱ��
	 * 
	 * @param dt
	 *            String -> yyyy-MM-dd hh:mm:ss
	 * @return java.util.Date.Date -> yyyy-MM-dd hh:mm:ss
	 */
	public static Date parseDateTime(String dt) {
		Date jDt = new Date();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (dt.length() > 10) {
				jDt = sdf.parse(dt);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jDt;
	}

	/**
	 * ��ʽ��ʱ��yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 *            java.util.Date
	 * @return String -> yyyy-MM-dd HH:mm:ss
	 */
	public static String parseDateTime(Date date) {
		String s = null;
		if (date != null) {
			try {
				SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				s = f.format(date);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return s;
	}

	/**
	 * ��ʽ������
	 * 
	 * @param dt
	 *            String -> yyyy-MM-dd
	 * @return java.util.Date.Date -> yyyy-MM-dd
	 */
	public static Date parseDate(String dt) {
		Date jDt = new Date();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if (dt.length() >= 8) {
				jDt = sdf.parse(dt);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jDt;
	}

	/**
	 * ��ʽ��ʱ��yyyy-MM-dd
	 * 
	 * @param date
	 *            java.util.Date
	 * @return String -> yyyy-MM-dd
	 */
	public static String parseDate(Date date) {
		String s = null;
		try {
			if (date != null) {
				SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
				s = f.format(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * 
	 * @param dt
	 * @return String
	 */
	public static String getLongDateFromShortDate(String dt) {
		String strDT = dt;
		try {
			if (strDT != null && strDT.length() <= 10) {
				strDT = dt.trim() + " 00:00:00";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return strDT;
	}

	/**
	 * 
	 * @param dt
	 * @return String
	 */
	public static String getShortDateToHHMM(String dt) {
		String jDt = dt;
		try {
			if (jDt != null && jDt.length() <= 10) {
				jDt = jDt + " 00:00";
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			jDt = sdf.parse(jDt).toLocaleString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jDt;
	}

	/**
	 * 
	 * @param dateStr
	 * @return String
	 */
	public static String formatDateToHHMM(String dateStr) {
		String resultDate = null;
		try {
			if (dateStr.length() > 10) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss");
				Date date = sdf.parse(dateStr);
				resultDate = sdf.format(date);
			} else
				resultDate = dateStr;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return resultDate;
	}

	/**
	 * �������� ��ʽ:2006-07-05
	 * 
	 * @param str
	 * @return Timestamp
	 */
	public static Timestamp date(String str) {
		Timestamp tp = null;
		if (str.length() <= 10) {
			String[] string = str.trim().split("-");
			int one = Integer.parseInt(string[0]) - 1900;
			int two = Integer.parseInt(string[1]) - 1;
			int three = Integer.parseInt(string[2]);
			tp = new Timestamp(one, two, three, 0, 0, 0, 0);
		}
		return tp;
	}

	// ��ȡָ������֮��������ַ��� �� 2007-04-15 ��һ�� ���� 2007-04-16
	public static String getNextDay(String strDate, int day) {
		if (strDate != null && !strDate.equals("")) {
			Calendar cal1 = Calendar.getInstance();
			String[] string = strDate.trim().split("-");
			int one = Integer.parseInt(string[0]) - 1900;
			int two = Integer.parseInt(string[1]) - 1;
			int three = Integer.parseInt(string[2]);
			cal1.setTime(new Date(one, two, three));
			cal1.add(Calendar.DAY_OF_MONTH, day);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			return formatter.format(cal1.getTime());
		} else {
			return null;
		}
	}

	// ��ȡָ������֮��������ַ��� �� 2007-02-28 ��һ�� ���� 2008-02-29 �������꣩
	public static String getNextYear(String strDate, int year) {
		Calendar cal1 = Calendar.getInstance();
		String[] string = strDate.trim().split("-");
		int one = Integer.parseInt(string[0]) - 1900;
		int two = Integer.parseInt(string[1]) - 1;
		int three = Integer.parseInt(string[2]);
		cal1.setTime(new Date(one, two, three));
		cal1.add(Calendar.YEAR, year);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(cal1.getTime());
	}

	/**
	 * ����ʱ������� ��ʽ:2006-07-05 22:10:10
	 * 
	 * @param str
	 * @return Timestamp
	 */
	public static Timestamp datetime(String str) {
		Timestamp tp = null;
		if (str != null && str.length() > 10) {
			String[] string = str.trim().split(" ");
			String[] date = string[0].split("-");
			String[] time = string[1].split(":");
			int date1 = Integer.parseInt(date[0]) - 1900;
			int date2 = Integer.parseInt(date[1]) - 1;
			int date3 = Integer.parseInt(date[2]);
			int time1 = Integer.parseInt(time[0]);
			int time2 = Integer.parseInt(time[1]);
			int time3 = Integer.parseInt(time[2]);
			tp = new Timestamp(date1, date2, date3, time1, time2, time3, 0);
		}
		return tp;
	}

	/**
	 * �������ں�ʱ��(û����) ��ʽ:2006-07-05 22:10
	 * 
	 * @param str
	 * @return Timestamp
	 */
	public static Timestamp datetimeHm(String str) {
		Timestamp tp = null;
		if (str.length() > 10) {
			String[] string = str.trim().split(" ");
			String[] date = string[0].split("-");
			String[] time = string[1].split(":");
			int date1 = Integer.parseInt(date[0]) - 1900;
			int date2 = Integer.parseInt(date[1]) - 1;
			int date3 = Integer.parseInt(date[2]);
			int time1 = Integer.parseInt(time[0]);
			int time2 = Integer.parseInt(time[1]);
			tp = new Timestamp(date1, date2, date3, time1, time2, 0, 0);
		}
		return tp;
	}

	/**
	 * ��õ�ǰϵͳ�����뱾��һ��������
	 * 
	 * @return int
	 */
	private static int getMondayPlus() {
		Calendar calendar = Calendar.getInstance();
		// ��ý�����һ�ܵĵڼ��죬����˳�����������ǵ�һ�죬����һ�ǵڶ���......
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // �������ǵ�һ��
		return (dayOfWeek == 1) ? -6 : 2 - dayOfWeek;
	}

	/**
	 * ��þ൱ǰʱ������ĳ���ڵ���һ������ ���� 0-������һ���� -1-������һ���� 1-������һ����
	 * 
	 * @param week
	 *            int
	 * @return java.util.Date
	 */
	public static Date getMondayOfWeek(int week) {
		int mondayPlus = getMondayPlus(); // �����һ��������
		GregorianCalendar current = new GregorianCalendar();
		current.add(GregorianCalendar.DATE, mondayPlus + 7 * week);
		return current.getTime();
	}

	/**
	 * ���ĳ��ǰ���ĳһ��
	 * 
	 * @param date
	 *            java.util.Date
	 * @param day
	 *            int
	 * @return java.util.Date
	 */
	public static Date getDay(Date date, int day) {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(date);
		c.add(GregorianCalendar.DATE, day);
		return c.getTime();
	}

	/**
	 * ��þ൱ǰ�ܵ�ǰ��ĳһ�ܵ�����
	 * 
	 * @param week
	 *            int
	 * @return String[]
	 */
	public static String[] getDaysOfWeek(int week) {
		String[] days = new String[7];
		Date monday = getMondayOfWeek(week); // ��þ౾��ǰ����ĳ����һ
		Timestamp t = new Timestamp(monday.getTime());
		days[0] = getStrDate(t);
		for (int i = 1; i < 7; i++) {
			t = new Timestamp(getDay(monday, i).getTime());
			days[i] = getStrDate(t);
		}
		return days;
	}

	/***
	 * MCC��UTCʱ��ת����MCC��UTC���ǵ������
	 * 
	 * @param utc
	 * @return java.util.Date
	 */
	public static Date mccUTC2Date(long utc) {
		Date d = new Date();
		d.setTime(utc * 1000); // ת�ɺ���
		return d;
	}

	// ����ʱ���ʽ�ַ���ת��Ϊʱ�� yyyy-MM-dd HH:mm:ss
	public static Date strToDateLong(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = (Date) formatter.parse(strDate, pos);
		if (strtodate == null) {
			formatter = new SimpleDateFormat("yyyy-MM-dd");
			strtodate = (Date) formatter.parse(strDate, pos);
		}
		return strtodate;
	}

	// �� yyyy-MM-dd HH:mm ��ʽ�ַ���ת��Ϊʱ��
	public static Date strToDateTime(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = (Date) formatter.parse(strDate, pos);
		if (strtodate == null) {
			formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			strtodate = (Date) formatter.parse(strDate, pos);
		}
		return strtodate;
	}

	// ����������ַ������������ַ��� 2006-07-07 22:10 2006-07-07
	public static String getStrDate(String str) {
		if (str.length() > 10) {
			String[] string = str.trim().split(" ");
			return string[0];
		} else {
			return getCurrentDate();
		}
	}

	// ��ȡ��ǰʱ����ַ��� 2006-07-07 22:10:10 2006-07-07_221010
	public static String getStrDateTime() {
		Timestamp d = crunttime();
		return d.toString().substring(0, 19).replace(":", "").replace(" ", "_");
	}

	// ���������ַ��������ؽ��죬���������
	public static String getDayOrDate(String str) {
		if (str != null && !str.equals("")) {
			if (getNextDay(str, 0).equals(getCurrentDate())) {
				str = "����";
			} else if (getNextDay(str, 1).equals(getCurrentDate())) {
				str = "����";
			}
		}
		return str;
	}

	// ���ص�ǰ�����������ڣ�2��Ӧ����һ
	public static int getMonOfWeek() {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(new Date());
		return cal1.get(Calendar.DAY_OF_WEEK);
	}

	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
	}

	/**
	 * ��ȡ��ǰ����֮ǰ�������ַ��� �� 2007-04-15 ǰ5�� ���� 2006-11-15
	 */
	public static String getPreviousMonth(int month) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(new Date());
		cal1.add(Calendar.MONTH, -month);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(cal1.getTime());

	}

	public static String getStrYear(int year) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(new Date());
		cal1.add(Calendar.YEAR, -year);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		return formatter.format(cal1.getTime()) + "���";
	}

	/**
	 * �Ƚ���������ǰ�� ���Դ��ڻ����
	 * 
	 * @param starDate
	 * @param endDate
	 * @return
	 */
	public static boolean compareTwoDays(String starDate, String endDate) {
		Calendar cal_start = Calendar.getInstance();
		Calendar cal_end = Calendar.getInstance();
		cal_start.setTime(parseDate(starDate));
		cal_end.setTime(parseDate(endDate));
		return cal_end.after(cal_start);
	}

	public static int getDaysBetween(java.util.Calendar d1,
			java.util.Calendar d2) {
		if (d1.after(d2)) { // swap dates so that d1 is start and d2 is end
			java.util.Calendar swap = d1;
			d1 = d2;
			d2 = swap;
		}
		int days = d2.get(java.util.Calendar.DAY_OF_YEAR)
				- d1.get(java.util.Calendar.DAY_OF_YEAR);
		int y2 = d2.get(java.util.Calendar.YEAR);
		if (d1.get(java.util.Calendar.YEAR) != y2) {
			d1 = (java.util.Calendar) d1.clone();
			do {
				days += d1.getActualMaximum(java.util.Calendar.DAY_OF_YEAR);
				d1.add(java.util.Calendar.YEAR, 1);
			} while (d1.get(java.util.Calendar.YEAR) != y2);
		}
		return days;
	}

	// �õ���������֮�����
	public static int dateDiffYear(String starDate, String endDate) {
		int result = 0;
		Calendar d1 = Calendar.getInstance();
		Calendar d2 = Calendar.getInstance();
		d1.setTime(parseDate(starDate));
		d2.setTime(parseDate(endDate));

		// ���ڴ�С��ת
		if (d1.after(d2)) { // swap dates so that d1 is start and d2 is end
			java.util.Calendar swap = d1;
			d1 = d2;
			d2 = swap;
		}
		int yy = d2.get(Calendar.YEAR) - d1.get(Calendar.YEAR);
		int mm = d2.get(Calendar.MONTH) - d1.get(Calendar.MONTH);
		if (mm < 0) {
			result = yy - 1;
		}
		if (mm > 0) {
			result = yy;
		}
		if (mm == 0) {
			if ((d2.getTimeInMillis() - d1.getTimeInMillis()) >= 0) {
				result = yy;
			} else {
				result = yy - 1;
			}
		}
		return result;
	}

	// ��ȡ����
	public static int getAgeByBirth(String starDate) {
		return dateDiffYear(starDate, getCurrentDate());
	}
}
