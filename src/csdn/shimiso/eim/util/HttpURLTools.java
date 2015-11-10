package csdn.shimiso.eim.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;

/**
 * java.net.URL������
 * 
 * @author shimiso
 */
public class HttpURLTools {

	/**
	 * 
	 * ʹ��HTTP��POST�����ύxml����.
	 * 
	 * @param xml
	 *            �ύ��xml����
	 * @param urlPath
	 *            ����·��
	 * @return
	 * @author shimiso
	 * @update Feb 7, 2012 7:04:15 PM
	 */
	public static InputStream postXml(String xml, String urlPath) {
		try {
			URL url = new URL(urlPath);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			byte[] buff = xml.getBytes("UTF-8");
			conn.setConnectTimeout(10 * 1000);
			conn.setDoOutput(true); // �������
			conn.setUseCaches(false); // ��������
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Connection", "Keep-Alive");// ά�ֳ�����
			conn.setRequestProperty("Charset", "UTF-8");
			conn.setRequestProperty("Content-Length",
					String.valueOf(buff.length));
			conn.setRequestProperty("content-type", "text/html");
			DataOutputStream outStream = new DataOutputStream(
					conn.getOutputStream());
			outStream.write(buff);
			outStream.flush();
			outStream.close();
			if (conn.getResponseCode() == 200) {
				// printResponse(conn);
				return conn.getInputStream();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ʹ��HTTP��POST�����ύ�ı�.
	 * 
	 * @param urlPath
	 *            ����·��
	 * @param params
	 *            �������
	 * @param encoding
	 *            �����������
	 * @return ����InputStream
	 * @throws Exception
	 * @author shimiso
	 * @update May 19, 2011 12:33:44 AM
	 */
	public static InputStream postForm(String urlPath,
			Map<String, String> params, String encoding) {
		try {
			StringBuilder sb = new StringBuilder();
			for (Map.Entry<String, String> entry : params.entrySet()) {
				sb.append(entry.getKey()).append("=")
						.append(URLEncoder.encode(entry.getValue(), encoding));
				sb.append("&");
			}
			sb.deleteCharAt(sb.length() - 1);
			byte[] data = sb.toString().getBytes();
			URL url = new URL(urlPath);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(6 * 1000);
			conn.setDoOutput(true);// ����post������������������
			conn.setUseCaches(false);// ������Cache
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Connection", "Keep-Alive");// ά�ֳ�����
			conn.setRequestProperty("Charset", "UTF-8");
			conn.setRequestProperty("Content-Length",
					String.valueOf(data.length));
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			DataOutputStream dataOutStream = new DataOutputStream(
					conn.getOutputStream());
			dataOutStream.write(data);
			dataOutStream.flush();
			dataOutStream.close();
			if (conn.getResponseCode() == 200) {
				printResponse(conn);
				return conn.getInputStream();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * ʹ��HTTP��POST���������ϴ��ļ�.
	 * 
	 * @param filePath
	 *            �ļ�·��
	 * @param urlPath
	 *            ����·��
	 * @author shimiso
	 * @update Feb 7, 2012 6:13:29 PM
	 */
	public static void postFile(String urlPath, String filePath) {
		try {
			URL url = new URL(urlPath);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setChunkedStreamingMode(1024 * 1024);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("Charsert", "UTF-8");
			File file = new File(filePath);
			conn.setRequestProperty("Content-Type", "multipart/form-data;file="
					+ java.net.URLEncoder.encode(file.getName(), "UTF-8"));

			OutputStream out = new DataOutputStream(conn.getOutputStream());
			DataInputStream in = new DataInputStream(new FileInputStream(file));
			int bytes = 0;
			byte[] bufferOut = new byte[1024];
			while ((bytes = in.read(bufferOut)) != -1) {
				out.write(bufferOut, 0, bytes);
			}
			in.close();
			out.flush();
			out.close();
			printResponse(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * ʹ��HttpClient����һ��get��ʽ�ĳ���������.
	 * 
	 * @param urlpath
	 * @return
	 * @author shimiso
	 * @update 2012-6-29 ����11:58:14
	 */
	public static HttpResponse sendHttpGet(String urlpath) {
		HttpClient httpclient = new DefaultHttpClient();
		try {
			HttpGet httpget = new HttpGet(urlpath);
			httpclient.getParams().setParameter(
					CoreConnectionPNames.CONNECTION_TIMEOUT, 20000); // ��������ʱʱ��
			httpclient.getParams().setParameter(
					CoreConnectionPNames.SO_TIMEOUT, 20000); // ��ȡ��ʱ
			HttpResponse response = httpclient.execute(httpget);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * ʹ��HttpClient����һ��post��ʽ������.
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @author shimiso
	 * @update 2012-6-29 ����11:58:30
	 */
	public static HttpResponse sendHttpPost(String url,
			Map<String, String> params) {
		try {
			List<NameValuePair> param = new ArrayList<NameValuePair>(); // ����
			if (params != null) {
				Iterator<Entry<String, String>> iterator = params.entrySet()
						.iterator();
				while (iterator.hasNext()) {
					Entry<String, String> entry = iterator.next();
					param.add(new BasicNameValuePair(entry.getKey(), entry
							.getValue()));
				}
			}

			HttpPost request = new HttpPost(url);
			HttpEntity entity = new UrlEncodedFormEntity(param, "UTF-8");
			request.setEntity(entity);
			HttpClient client = new DefaultHttpClient();
			client.getParams().setParameter(
					CoreConnectionPNames.CONNECTION_TIMEOUT, 20000); // ��������ʱʱ��
			client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
					20000); // ��ȡ��ʱ
			HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return response;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * ��ȡ������Ϣ.
	 * 
	 * @param conn
	 * @author shimiso
	 * @update Feb 7, 2012 6:18:42 PM
	 */
	public static String printResponse(HttpURLConnection conn) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append("\n" + line);
			}
			System.out.println("==>" + sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
