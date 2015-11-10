
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*备注:权限表
	*/
    public class PrivilegeInfo implements Serializable
    {
        public PrivilegeInfo()
        { }
		
		
		/**
		*编号
		*/
		private String   _id;//编号
		/**
		*权限名称
		*/
		private String   _privilegeName;//权限名称
		/**
		*父级Id
		*/
		private int   _parentId;//父级Id
		/**
		*可操作内容
		*/
		private String   _operate;//可操作内容
		/**
		*权限描述
		*/
		private String   _describle;//权限描述
		
		//list FK
 private List<RolePrivilegeInfo> _rolePrivilegeInfos;
		
		
		
		
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
		*权限名称
		*/
		public String getPrivilegeName()
		{
		
			 return _privilegeName; 
		}
		/**
		*权限名称
		*/
		public void  setPrivilegeName (String  PrivilegeName )
		{
			_privilegeName = PrivilegeName ;
		}
		
		
		/**
		*父级Id
		*/
		public int getParentId()
		{
		
			 return _parentId; 
		}
		/**
		*父级Id
		*/
		public void  setParentId (int  ParentId )
		{
			_parentId = ParentId ;
		}
		
		
		/**
		*可操作内容
		*/
		public String getOperate()
		{
		
			 return _operate; 
		}
		/**
		*可操作内容
		*/
		public void  setOperate (String  Operate )
		{
			_operate = Operate ;
		}
		
		
		/**
		*权限描述
		*/
		public String getDescrible()
		{
		
			 return _describle; 
		}
		/**
		*权限描述
		*/
		public void  setDescrible (String  Describle )
		{
			_describle = Describle ;
		}
		
	
		
		
		
		
				//list FK
     		public List< RolePrivilegeInfo>  getRolePrivilegeInfos()
		{
		return _rolePrivilegeInfos;
		}
		
		public void  setRolePrivilegeInfos(List<RolePrivilegeInfo>  RolePrivilegeInfos)
		{
		 _rolePrivilegeInfos =RolePrivilegeInfos;
		
		}
    }
 
	
		



