
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:��ɫȨ�ޱ�
	*/
    public class RolePrivilegeInfo implements Serializable
    {
        public RolePrivilegeInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*Ȩ��Id
		*/
		private String   _pid;//Ȩ��Id
		/**
		*��ɫId
		*/
		private String   _rid;//��ɫId
		private  PrivilegeInfo  _privilegeInfo;
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
		*Ȩ��Id
		*/
		public String getPid()
		{
		
			 return _pid; 
		}
		/**
		*Ȩ��Id
		*/
		public void  setPid (String  Pid )
		{
			_pid = Pid ;
		}
		
		
		/**
		*��ɫId
		*/
		public String getRid()
		{
		
			 return _rid; 
		}
		/**
		*��ɫId
		*/
		public void  setRid (String  Rid )
		{
			_rid = Rid ;
		}
		
	
		
		
		
		public PrivilegeInfo  getPrivilegeInfo()
		{
		return _privilegeInfo;
		}
		
		public void  setPrivilegeInfo(PrivilegeInfo  PrivilegeInfo)
		{
		 _privilegeInfo =PrivilegeInfo;
		
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
 
	
		



