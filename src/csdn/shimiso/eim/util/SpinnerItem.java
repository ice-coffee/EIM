package csdn.shimiso.eim.util;

/**
 * spinnerʵ��ȡVALUEֵ��TEXTֵ����дtoString��ʵ��
 * 
 */
public class SpinnerItem {

	private String ID = "";
	private String Value = "";

	public SpinnerItem() {
		ID = "";
		Value = "";
	}

	public SpinnerItem(String _ID, String _Value) {
		ID = _ID;
		Value = _Value;
	}

	@Override
	public String toString() { // ΪʲôҪ��дtoString()�أ���Ϊ����������ʾ���ݵ�ʱ����������������Ķ������ַ���������£�ֱ�Ӿ�ʹ�ö���.toString()
		// TODO Auto-generated method stub
		return Value;
	}

	public String getID() {
		return ID;
	}

	public String getValue() {
		return Value;
	}
}
