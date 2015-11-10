package csdn.shimiso.eim.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import android.util.Log;

public class UnZipUtil {
	private String _zipFile;
	private String _location;

	public UnZipUtil(String zipFile, String location) {
		_zipFile = zipFile;
		_location = location;

		_dirChecker("");
	}

	public void unzip() {
		try {
			FileInputStream fin = new FileInputStream(_zipFile);
			ZipInputStream zin = new ZipInputStream(fin);
			ZipEntry ze = null;
			while ((ze = zin.getNextEntry()) != null) {
				Log.v("Decompress", "Unzipping " + ze.getName());

				if (ze.isDirectory()) {
					_dirChecker(ze.getName());
				} else {
					FileOutputStream fout = new FileOutputStream(_location
							+ ze.getName());
					for (int c = zin.read(); c != -1; c = zin.read()) {
						fout.write(c);
					}

					zin.closeEntry();
					fout.close();
				}

			}
			zin.close();
		} catch (Exception e) {
			Log.e("Decompress", "unzip", e);
		}

	}

	private void _dirChecker(String dir) {
		File f = new File(_location + dir);

		if (!f.isDirectory()) {
			f.mkdirs();
		}
	}

	// unZipfileName需要解压的zip文件全路经
	public static void unZip(String unZipfileName, String mDestPath) {
		FileOutputStream fileOut;
		ZipInputStream zipIn;
		ZipEntry zipEntry;
		File file;
		int readedBytes;
		byte buf[] = new byte[4096];
		try {
			zipIn = new ZipInputStream(new BufferedInputStream(
					new FileInputStream(unZipfileName)));
			while ((zipEntry = zipIn.getNextEntry()) != null) {
				file = new File(mDestPath + zipEntry.getName());
				if (zipEntry.isDirectory()) {
					file.mkdirs();
				} else {
					// 如果指定文件的目录不存在,则创建之.
					File parent = file.getParentFile();
					if (!parent.exists()) {
						parent.mkdirs();
					}
					fileOut = new FileOutputStream(file);
					while ((readedBytes = zipIn.read(buf)) > 0) {
						fileOut.write(buf, 0, readedBytes);
					}
					fileOut.close();
				}
				zipIn.closeEntry();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}