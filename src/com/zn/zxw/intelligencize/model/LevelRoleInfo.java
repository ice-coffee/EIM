
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:��Ա�ȼ���Ӧ�Ľ�ɫ
	*/
    public class LevelRoleInfo implements Serializable
    {
        public LevelRoleInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�ȼ�Id
		*/
		private String   _lid;//�ȼ�Id
		/**
		*��ɫid
		*/
		private String   _rid;//��ɫid
		private  LevelInfo  _levelInfo;
		private  RoleInfo  _roleInfo;
		
		//list FK
		
		
		
		
		/**
		*���
		*/
		public String getId()
		{
		
			 return _id; 
		}
		/**
		*���
		*/
		public void  setId (String  Id )
		{
			_id = Id ;
		}
		
		
		/**
		*�ȼ�Id
		*/
		public String getLid()
		{
		
			 return _lid; 
		}
		/**
		*�ȼ�Id
		*/
		public void  setLid (String  Lid )
		{
			_lid = Lid ;
		}
		
		
		/**
		*��ɫid
		*/
		public String getRid()
		{
		
			 return _rid; 
		}
		/**
		*��ɫid
		*/
		public void  setRid (String  Rid )
		{
			_rid = Rid ;
		}
		
	
		
		
		
		public LevelInfo  getLevelInfo()
		{
		return _levelInfo;
		}
		
		public void  setLevelInfo(LevelInfo  LevelInfo)
		{
		 _levelInfo =LevelInfo;
		
		}
		
		public RoleInfo  getRoleInfo()
		{
		return _roleInfo;
		}
		
		public void  setRoleInfo(RoleInfo  RoleInfo)
		{
		 _roleInfo =RoleInfo;
		
		}
		
		
				//list FK
  }
 
	
		



