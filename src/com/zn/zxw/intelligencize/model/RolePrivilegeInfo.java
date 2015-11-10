
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*备注:角色权限表
	*/
    public class RolePrivilegeInfo implements Serializable
    {
        public RolePrivilegeInfo()
        { }
		
		
		/**
		*编号
		*/
		private String   _id;//编号
		/**
		*权限Id
		*/
		private String   _pid;//权限Id
		/**
		*角色Id
		*/
		private String   _rid;//角色Id
		private  PrivilegeInfo  _privilegeInfo;
		private  RoleInfo  _roleInfo;
		
		//list FK
		
		
		
		
		/**
		*编号
		*/
		public String getId()
		{
		
			 return _id; 
		}
		/**
		*编号
		*/
		public void  setId (String  Id )
		{
			_id = Id ;
		}
		
		
		/**
		*权限Id
		*/
		public String getPid()
		{
		
			 return _pid; 
		}
		/**
		*权限Id
		*/
		public void  setPid (String  Pid )
		{
			_pid = Pid ;
		}
		
		
		/**
		*角色Id
		*/
		public String getRid()
		{
		
			 return _rid; 
		}
		/**
		*角色Id
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
 
	
		



