
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*±¸×¢:½ÇÉ«±í
	*/
    public class RoleInfo implements Serializable
    {
        public RoleInfo()
        { }
		
		
		/**
		*±àºÅ
		*/
		private String   _id;//±àºÅ
		/**
		*½ÇÉ«Ãû³Æ
		*/
		private String   _name;//½ÇÉ«Ãû³Æ
		/**
		*½ÇÉ«ÃèÊö
		*/
		private String   _describle;//½ÇÉ«ÃèÊö
		
		//list FK
 private List<LevelRoleInfo> _levelRoleInfos;
 private List<RolePrivilegeInfo> _rolePrivilegeInfos;
 private List<UserRoleInfo> _userRoleInfos;
		
		
		
		
		/**
		*±àºÅ
		*/
		public String getId()
		{
		
			 return _id; 
		}
		/**
		*±àºÅ
		*/
		public void  setId (String  Id )
		{
			_id = Id ;
		}
		
		
		/**
		*½ÇÉ«Ãû³Æ
		*/
		public String getName()
		{
		
			 return _name; 
		}
		/**
		*½ÇÉ«Ãû³Æ
		*/
		public void  setName (String  Name )
		{
			_name = Name ;
		}
		
		
		/**
		*½ÇÉ«ÃèÊö
		*/
		public String getDescrible()
		{
		
			 return _describle; 
		}
		/**
		*½ÇÉ«ÃèÊö
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
 
	
		



