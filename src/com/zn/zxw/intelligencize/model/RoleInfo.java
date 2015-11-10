
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:��ɫ��
	*/
    public class RoleInfo implements Serializable
    {
        public RoleInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*��ɫ����
		*/
		private String   _name;//��ɫ����
		/**
		*��ɫ����
		*/
		private String   _describle;//��ɫ����
		
		//list FK
 private List<LevelRoleInfo> _levelRoleInfos;
 private List<RolePrivilegeInfo> _rolePrivilegeInfos;
 private List<UserRoleInfo> _userRoleInfos;
		
		
		
		
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
		*��ɫ����
		*/
		public String getName()
		{
		
			 return _name; 
		}
		/**
		*��ɫ����
		*/
		public void  setName (String  Name )
		{
			_name = Name ;
		}
		
		
		/**
		*��ɫ����
		*/
		public String getDescrible()
		{
		
			 return _describle; 
		}
		/**
		*��ɫ����
		*/
		public void  setDescrible (String  Describle )
		{
			_describle = Describle ;
		}
		
	
		
		
		
		
				//list FK
     		public List< LevelRoleInfo>  getLevelRoleInfos()
		{
		return _levelRoleInfos;
		}
		
		public void  setLevelRoleInfos(List<LevelRoleInfo>  LevelRoleInfos)
		{
		 _levelRoleInfos =LevelRoleInfos;
		
		}
       		public List< RolePrivilegeInfo>  getRolePrivilegeInfos()
		{
		return _rolePrivilegeInfos;
		}
		
		public void  setRolePrivilegeInfos(List<RolePrivilegeInfo>  RolePrivilegeInfos)
		{
		 _rolePrivilegeInfos =RolePrivilegeInfos;
		
		}
       		public List< UserRoleInfo>  getUserRoleInfos()
		{
		return _userRoleInfos;
		}
		
		public void  setUserRoleInfos(List<UserRoleInfo>  UserRoleInfos)
		{
		 _userRoleInfos =UserRoleInfos;
		
		}
    }
 
	
		



