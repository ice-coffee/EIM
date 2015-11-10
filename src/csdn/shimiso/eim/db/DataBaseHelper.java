package csdn.shimiso.eim.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * SQLite���ݿ�İ�����
 * 
 * ����������չ��,��Ҫ�е����ݿ��ʼ���Ͱ汾����ʹ��,��������ȫ�ɺ��ĸ������
 * 
 * @author shimiso
 * 
 */
public class DataBaseHelper extends SDCardSQLiteOpenHelper {

	public DataBaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE [im_msg_his] ([_id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, [content] TEXT, [msg_from] NVARCHAR, [msg_to] NVARCHAR, [msg_time] TEXT, [msg_type] INTEGER);");
		db.execSQL("CREATE TABLE [im_notice]  ([_id] INTEGER NOT NULL  PRIMARY KEY AUTOINCREMENT, [type] INTEGER, [title] NVARCHAR, [content] TEXT, [notice_from] NVARCHAR, [notice_to] NVARCHAR, [notice_time] TEXT, [status] INTEGER);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

	@Override
	public void onOpen(SQLiteDatabase db) {
		super.onOpen(db);
	}
}
