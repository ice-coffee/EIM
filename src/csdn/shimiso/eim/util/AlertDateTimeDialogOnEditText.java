package csdn.shimiso.eim.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import csdn.shimiso.eim.R;

/**
 * 在editText上点击获取日期和时间字符串
 * 
 * @author Administrator
 * 
 */

public class AlertDateTimeDialogOnEditText implements OnTouchListener {
	private Context mContext;
	private EditText etDate;
	private String title;

	public AlertDateTimeDialogOnEditText(Context mContext, EditText etDate,
			String title) {
		this.mContext = mContext;
		this.etDate = etDate;
		this.title = title;
	}

	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
			LayoutInflater inflater = LayoutInflater.from(mContext);
			LinearLayout layout = (LinearLayout) inflater.inflate(
					R.layout.datetime_dialog, null);
			final DatePicker datePicker = (DatePicker) layout
					.findViewById(R.id.date);
			final TimePicker timePicker = (TimePicker) layout
					.findViewById(R.id.time);
			AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
			dialog.setTitle(title);
			dialog.setView(layout);
			String strDate = etDate.getText().toString().trim();
			if (strDate != null && !strDate.equals("")) {
				String[] sdte = strDate.split(" ")[0].split("-");
				datePicker.init(Integer.parseInt(sdte[0]),
						Integer.parseInt(sdte[1]) - 1,
						Integer.parseInt(sdte[2]), null);
				String[] times = strDate.split(" ")[1].split(":");
				timePicker.setCurrentHour(Integer.parseInt(times[0]));
				timePicker.setCurrentMinute(Integer.parseInt(times[1]));
			}
			dialog.setPositiveButton(R.string.confirm,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							String strDamTime = datePicker.getYear() + "-"
									+ (datePicker.getMonth() + 1) + "-"
									+ datePicker.getDayOfMonth();
							strDamTime += " " + timePicker.getCurrentHour()
									+ ":" + timePicker.getCurrentMinute();
							etDate.setText(strDamTime);
						}
					});
			dialog.setNegativeButton(R.string.cancel,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							dialog.cancel();
						}
					});
			dialog.create().show();
		}
		return false;
	}
}