
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:Ȩ�ޱ�
	*/
    public class PrivilegeInfo implements Serializable
    {
        public PrivilegeInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*Ȩ������
		*/
		private String   _privilegeName;//Ȩ������
		/**
		*����Id
		*/
		private int   _parentId;//����Id
		/**
		*�ɲ�������
		*/
		private String   _operate;//�ɲ�������
		/**
		*Ȩ������
		*/
		private String   _describle;//Ȩ������
		
		//list FK
 private List<RolePrivilegeInfo> _rolePrivilegeInfos;
		
		
		
		
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
		*Ȩ������
		*/
		public String getPrivilegeName()
		{
		
			 return _privilegeName; 
		}
		/**
		*Ȩ������
		*/
		public void  setPrivilegeName (String  PrivilegeName )
		{
			_privilegeName = PrivilegeName ;
		}
		
		
		/**
		*����Id
		*/
		public int getParentId()
		{
		
			 return _parentId; 
		}
		/**
		*����Id
		*/
		public void  setParentId (int  ParentId )
		{
			_parentId = ParentId ;
		}
		
		
		/**
		*�ɲ�������
		*/
		public String getOperate()
		{
		
			 return _operate; 
		}
		/**
		*�ɲ�������
		*/
		public void  setOperate (String  Operate )
		{
			_operate = Operate ;
		}
		
		
		/**
		*Ȩ������
		*/
		public String getDescrible()
		{
		
			 return _describle; 
		}
		/**
		*Ȩ������
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
 
	
		



