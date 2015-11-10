package csdn.shimiso.eim.util;

/**
 * spinner实现取VALUE值和TEXT值，重写toString简单实现
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
	public String toString() { // 为什么要重写toString()呢？因为适配器在显示数据的时候，如果传入适配器的对象不是字符串的情况下，直接就使用对象.toString()
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
