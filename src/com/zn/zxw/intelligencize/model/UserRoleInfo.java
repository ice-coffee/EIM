
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:�û���ɫ
	*/
    public class UserRoleInfo implements Serializable
    {
        public UserRoleInfo()
        { }
		
		
		/**
		*�û�id
		*/
		private String   _uid;//�û�id
		/**
		*��ɫid
		*/
		private String   _rid;//��ɫid
		private  OfUser  _ofUser;
		private  RoleInfo  _roleInfo;
		
		//list FK
		
		
		
		
		/**
		*�û�id
		*/
		public String getUid()
		{
		
			 return _uid; 
		}
		/**
		*�û�id
		*/
		public void  setUid (String  Uid )
		{
			_uid = Uid ;
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
		
	
		
		
		
		public OfUser  getOfUser()
		{
		return _ofUser;
		}
		
		public void  setOfUser(OfUser  OfUser)
		{
		 _ofUser =OfUser;
		
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
 
	
		



