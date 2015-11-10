package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:�ɷ����⣬������һ������
	*/
    public class ChatGroupInfo implements Serializable
    {
        public ChatGroupInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�߼����
		*/
		private String   _chatGroup;//�߼����
		/**
		*����
		*/
		private String   _name;//����
		/**
		*������
		*/
		private String   _createUser;//������
		/**
		*��״̬
		*/
		private String   _state;//��״̬
		/**
		*������
		*/
		private String   _describe;//������
		/**
		*��������
		*/
		private String   _typeId;//��������
		/**
		*Ԥ���ֶ�
		*/
		private String   _field;//Ԥ���ֶ�
		private  TypeMenuInfo  _typeMenuInfo;
		private  OfUser  _ofUser;
		
		//list FK
 private List<ActivitySchemeInfo> _activitySchemeInfos;
 private List<ChatContentInfo> _chatContentInfos;
 private List<ChatGroupFileInfo> _chatGroupFileInfos;
 private List<ChatGroupMemberInfo> _chatGroupMemberInfos;
		
		
		
		
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
		public String getChatGroup()
		{
		
			 return _chatGroup; 
		}
		/**
		*�߼����
		*/
		public void  setChatGroup (String  ChatGroup )
		{
			_chatGroup = ChatGroup ;
		}
		
		
		/**
		*����
		*/
		public String getName()
		{
		
			 return _name; 
		}
		/**
		*����
		*/
		public void  setName (String  Name )
		{
			_name = Name ;
		}
		
		
		/**
		*������
		*/
		public String getCreateUser()
		{
		
			 return _createUser; 
		}
		/**
		*������
		*/
		public void  setCreateUser (String  CreateUser )
		{
			_createUser = CreateUser ;
		}
		
		
		/**
		*��״̬
		*/
		public String getState()
		{
		
			 return _state; 
		}
		/**
		*��״̬
		*/
		public void  setState (String  State )
		{
			_state = State ;
		}
		
		
		/**
		*������
		*/
		public String getDescribe()
		{
		
			 return _describe; 
		}
		/**
		*������
		*/
		public void  setDescribe (String  Describe )
		{
			_describe = Describe ;
		}
		
		
		/**
		*��������
		*/
		public String getTypeId()
		{
		
			 return _typeId; 
		}
		/**
		*��������
		*/
		public void  setTypeId (String  TypeId )
		{
			_typeId = TypeId ;
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
		
	
		
		
		
		public TypeMenuInfo  getTypeMenuInfo()
		{
		return _typeMenuInfo;
		}
		
		public void  setTypeMenuInfo(TypeMenuInfo  TypeMenuInfo)
		{
		 _typeMenuInfo =TypeMenuInfo;
		
		}
		
		public OfUser  getOfUser()
		{
		return _ofUser;
		}
		
		public void  setOfUser(OfUser  OfUser)
		{
		 _ofUser =OfUser;
		
		}
		
		
				//list FK
     		public List< ActivitySchemeInfo>  getActivitySchemeInfos()
		{
		return _activitySchemeInfos;
		}
		
		public void  setActivitySchemeInfos(List<ActivitySchemeInfo>  ActivitySchemeInfos)
		{
		 _activitySchemeInfos =ActivitySchemeInfos;
		
		}
       		public List< ChatContentInfo>  getChatContentInfos()
		{
		return _chatContentInfos;
		}
		
		public void  setChatContentInfos(List<ChatContentInfo>  ChatContentInfos)
		{
		 _chatContentInfos =ChatContentInfos;
		
		}
       		public List< ChatGroupFileInfo>  getChatGroupFileInfos()
		{
		return _chatGroupFileInfos;
		}
		
		public void  setChatGroupFileInfos(List<ChatGroupFileInfo>  ChatGroupFileInfos)
		{
		 _chatGroupFileInfos =ChatGroupFileInfos;
		
		}
       		public List< ChatGroupMemberInfo>  getChatGroupMemberInfos()
		{
		return _chatGroupMemberInfos;
		}
		
		public void  setChatGroupMemberInfos(List<ChatGroupMemberInfo>  ChatGroupMemberInfos)
		{
		 _chatGroupMemberInfos =ChatGroupMemberInfos;
		
		}
    }
 
	
		



