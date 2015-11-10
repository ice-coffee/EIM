package csdn.shimiso.eim.activity;

import android.test.AndroidTestCase;

/**
 * 
 * Junit测试类.
 * 
 * @author shimiso
 */
public class ModelTest extends AndroidTestCase {

	public void testSave() {
		/*
		 * NoticeManager noticeManager=NoticeManager.getInstance(getContext());
		 * List<ChartNotice>
		 * list=noticeManager.getUnReadChartNoticeListByType(Notice.CHAT_MSG);
		 * for(ChartNotice c:list){ // String
		 * nickName=ContacterManager.getNickname(c.getFrom(),
		 * ConnectionUtils.getConnection());
		 * 
		 * }
		 */

		/*
		 * DBManager manager=DBManager.getInstance(getContext()); SQLiteTemplate
		 * st=SQLiteTemplate.getInstance(manager, false); int a=
		 * st.getCount("select _id from im_notice where status=0", null);
		 * Log.i("TTTTTTTTTTTTTT", ""+a); // DBManager
		 * manager=DBManager.getInstance(getContext()); // SQLiteTemplate
		 * st=SQLiteTemplate.getInstance(manager, false);
		 * 
		 * // NoticeManager
		 * noticeManager=NoticeManager.getInstance(getContext()); // Notice
		 * notice=new Notice(); // notice.setTitle("11111111111"); //
		 * notice.setContent("22222222222222222"); //
		 * notice.setFrom("3333333333333"); // noticeManager.saveNotice(notice);
		 * 
		 * 
		 * // ContentValues contentValues=new ContentValues(); //
		 * contentValues.put("title", "张三"); // contentValues.put("content",
		 * "123"); // st.insert("im_notice", contentValues);
		 * 
		 * // long a=st.getCount("select * from person where _id>?", new
		 * String[]{"0"});
		 * 
		 * 
		 * // List<Person> list=st.queryForList(new RowMapper<Person>(){ // //
		 * @Override // public Person mapRow(Cursor cursor, int rowNum) { //
		 * Person p=new Person(); //
		 * p.setId(cursor.getString(cursor.getColumnIndex("_id"))); //
		 * p.setName(cursor.getString(cursor.getColumnIndex("name"))); //
		 * p.setAge(cursor.getInt(cursor.getColumnIndex("age"))); // return p;
		 * // } // // }, "select * from person", 0, 10);
		 * 
		 * // List<Person> list=st.queryForList(new RowMapper<Person>(){ // //
		 * @Override // public Person mapRow(Cursor cursor, int rowNum) { //
		 * Person p=new Person(); //
		 * p.setId(cursor.getString(cursor.getColumnIndex("_id"))); //
		 * p.setName(cursor.getString(cursor.getColumnIndex("name"))); //
		 * p.setAge(cursor.getInt(cursor.getColumnIndex("age"))); // return p;
		 * // } // // }, "person", new String[]{"_id","name","age"},
		 * "_id>? and age=?", new String[]{"5","22"}, null, null, null, "0,10");
		 * 
		 * 
		 * // Person p=st.queryForObject(new RowMapper<Person>(){ // //
		 * @Override // public Person mapRow(Cursor cursor, int rowNum) { //
		 * Person p=new Person(); //
		 * p.setId(cursor.getString(cursor.getColumnIndex("_id"))); //
		 * p.setName(cursor.getString(cursor.getColumnIndex("name"))); //
		 * p.setAge(cursor.getInt(cursor.getColumnIndex("age"))); // return p;
		 * // } // // }, "select * from person where _id=?", new String[]{"1"});
		 * 
		 * // st.deleteByIds("person", new Object[]{"1","2","3","4"});
		 * 
		 * // st.deleteById("person", "5");
		 * 
		 * // st.deleteByField("person", "name", "张三7");
		 * 
		 * 
		 * // ContentValues contentValues=new ContentValues(); //
		 * contentValues.put("name", "李四"); // contentValues.put("age", "999");
		 * // st.updateById("person", "8", contentValues);
		 * 
		 * // boolean a1=st.isExistsById("person", "7"); // boolean
		 * a2=st.isExistsByField("person", "name", "张三7"); // boolean
		 * a3=st.isExistsBySQL("select * from person where _id=?", new
		 * String[]{"7"});
		 * 
		 * 
		 * Log.d("TTTTTTTTTTTT","");
		 */

	}
}

class Person {
	private String id;
	private String name;
	private int age;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
