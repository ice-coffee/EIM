package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*备注:可发起话题，拉朋友一起聊天
	*/
    public class ChatGroupInfo implements Serializable
    {
        public ChatGroupInfo()
        { }
		
		
		/**
		*编号
		*/
		private String   _id;//编号
		/**
		*逻辑编号
		*/
		private String   _chatGroup;//逻辑编号
		/**
		*组名
		*/
		private String   _name;//组名
		/**
		*创建人
		*/
		private String   _createUser;//创建人
		/**
		*组状态
		*/
		private String   _state;//组状态
		/**
		*组描述
		*/
		private String   _describe;//组描述
		/**
		*话题类型
		*/
		private String   _typeId;//话题类型
		/**
		*预留字段
		*/
		private String   _field;//预留字段
		private  TypeMenuInfo  _typeMenuInfo;
		private  OfUser  _ofUser;
		
		//list FK
 private List<ActivitySchemeInfo> _activitySchemeInfos;
 private List<ChatContentInfo> _chatContentInfos;
 private List<ChatGroupFileInfo> _chatGroupFileInfos;
 private List<ChatGroupMemberInfo> _chatGroupMemberInfos;
		
		
		
		
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
		*逻辑编号
		*/
		public String getChatGroup()
		{
		
			 return _chatGroup; 
		}
		/**
		*逻辑编号
		*/
		public void  setChatGroup (String  ChatGroup )
		{
			_chatGroup = ChatGroup ;
		}
		
		
		/**
		*组名
		*/
		public String getName()
		{
		
			 return _name; 
		}
		/**
		*组名
		*/
		public void  setName (String  Name )
		{
			_name = Name ;
		}
		
		
		/**
		*创建人
		*/
		public String getCreateUser()
		{
		
			 return _createUser; 
		}
		/**
		*创建人
		*/
		public void  setCreateUser (String  CreateUser )
		{
			_createUser = CreateUser ;
		}
		
		
		/**
		*组状态
		*/
		public String getState()
		{
		
			 return _state; 
		}
		/**
		*组状态
		*/
		public void  setState (String  State )
		{
			_state = State ;
		}
		
		
		/**
		*组描述
		*/
		public String getDescribe()
		{
		
			 return _describe; 
		}
		/**
		*组描述
		*/
		public void  setDescribe (String  Describe )
		{
			_describe = Describe ;
		}
		
		
		/**
		*话题类型
		*/
		public String getTypeId()
		{
		
			 return _typeId; 
		}
		/**
		*话题类型
		*/
		public void  setTypeId (String  TypeId )
		{
			_typeId = TypeId ;
		}
		
		
		/**
		*预留字段
		*/
		public String getField()
		{
		
			 return _field; 
		}
		/**
		*预留字段
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
 
	
		



