
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:����һЩС���ļ�
	*/
    public class ChatGroupFileInfo implements Serializable
    {
        public ChatGroupFileInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�߼����
		*/
		private String   _chatGroupFileId;//�߼����
		/**
		*������Id
		*/
		private String   _groupId;//������Id
		/**
		*�ļ��ϴ���
		*/
		private String   _uPUser;//�ļ��ϴ���
		/**
		*�ϴ�ʱ��
		*/
		private String   _uPDate;//�ϴ�ʱ��
		/**
		*�ļ�����
		*/
		private String   _fileName;//�ļ�����
		/**
		*�ļ�
		*/
		private byte[]   _file;//�ļ�
		/**
		*�ļ�״̬
		*/
		private String   _state;//�ļ�״̬
		/**
		*Ԥ���ֶ�
		*/
		private String   _field;//Ԥ���ֶ�
		private  ChatGroupInfo  _chatGroupInfo;
		
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
		*�߼����
		*/
		public String getChatGroupFileId()
		{
		
			 return _chatGroupFileId; 
		}
		/**
		*�߼����
		*/
		public void  setChatGroupFileId (String  ChatGroupFileId )
		{
			_chatGroupFileId = ChatGroupFileId ;
		}
		
		
		/**
		*������Id
		*/
		public String getGroupId()
		{
		
			 return _groupId; 
		}
		/**
		*������Id
		*/
		public void  setGroupId (String  GroupId )
		{
			_groupId = GroupId ;
		}
		
		
		/**
		*�ļ��ϴ���
		*/
		public String getUPUser()
		{
		
			 return _uPUser; 
		}
		/**
		*�ļ��ϴ���
		*/
		public void  setUPUser (String  UPUser )
		{
			_uPUser = UPUser ;
		}
		
		
		/**
		*�ϴ�ʱ��
		*/
		public String getUPDate()
		{
		
			 return _uPDate; 
		}
		/**
		*�ϴ�ʱ��
		*/
		public void  setUPDate (String  UPDate )
		{
			_uPDate = UPDate ;
		}
		
		
		/**
		*�ļ�����
		*/
		public String getFileName()
		{
		
			 return _fileName; 
		}
		/**
		*�ļ�����
		*/
		public void  setFileName (String  FileName )
		{
			_fileName = FileName ;
		}
		
		
		/**
		*�ļ�
		*/
		public byte[] getFile()
		{
		
			 return _file; 
		}
		/**
		*�ļ�
		*/
		public void  setFile (byte[]  File )
		{
			_file = File ;
		}
		
		
		/**
		*�ļ�״̬
		*/
		public String getState()
		{
		
			 return _state; 
		}
		/**
		*�ļ�״̬
		*/
		public void  setState (String  State )
		{
			_state = State ;
		}
		
		
		/**
		*Ԥ���ֶ�
		*/
		public String getField()
		{
		
			 return _field; 
		}
		/**
		*Ԥ���ֶ�
		*/
		public void  setField (String  Field )
		{
			_field = Field ;
		}
		
	
		
		
		
		public ChatGroupInfo  getChatGroupInfo()
		{
		return _chatGroupInfo;
		}
		
		public void  setChatGroupInfo(ChatGroupInfo  ChatGroupInfo)
		{
		 _chatGroupInfo =ChatGroupInfo;
		
		}
		
		
				//list FK
  }
 
	
		



