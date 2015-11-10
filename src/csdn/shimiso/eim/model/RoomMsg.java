package csdn.shimiso.eim.model;

public class RoomMsg {
	public String cnt;
	public String time;
	public int type;
	public String from;
	public String icon;
	
	public void setCnt(String Cnt){
		cnt=Cnt;
	}
	public String getCnt(){
		return cnt;
	}
	
	public void setTime(String Time){
		time=Time;
	}
	public String getTime(){
		return time;
	}
	public void setType(int Type){
		type=Type;
	}
	public int getType(){
		return type;
	}
	public void setFrom(String From){
		from=From;
	}
	public String getFrom(){
		return from;
	}
	public void setIcon(String Icon){
		icon=Icon;
	}
	public String getIcon(){
		return icon;
	}
	
}
