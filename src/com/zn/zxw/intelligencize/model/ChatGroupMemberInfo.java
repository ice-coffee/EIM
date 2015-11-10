
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*备注:用户加入了哪些组，判断是否收听组信息
	*/
    public class ChatGroupMemberInfo implements Serializable
    {
        public ChatGroupMemberInfo()
        { }
		
		
		/**
		*编号
		*/
		private String   _id;//编号
		/**
		*逻辑编号
		*/
		private String   _chatGroupMemberId;//逻辑编号
		/**
		*所属组Id
		*/
		private String   _groupId;//所属组Id
		/**
		*成员
		*/
		private String   _memberId;//成员
		/**
		*创建人
		*/
		private String   _createUser;//创建人
		/**
		*成员状态
		*/
		private String   _state;//成员状态
		/**
		*预留字段
		*/
		private String   _field;//预留字段
		private  OfUser  _ofUser;
		private  ChatGroupInfo  _chatGroupInfo;
		
		//list FK
 private List<ChatAcceptInfo> _chatAcceptInfos;
		
		
		
		
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
		public String getChatGroupMemberId()
		{
		
			 return _chatGroupMemberId; 
		}
		/**
		*逻辑编号
		*/
		public void  setChatGroupMemberId (String  ChatGroupMemberId )
		{
			_chatGroupMemberId = ChatGroupMemberId ;
		}
		
		
		/**
		*所属组Id
		*/
		public String getGroupId()
		{
		
			 return _groupId; 
		}
		/**
		*所属组Id
		*/
		public void  setGroupId (String  GroupId )
		{
			_groupId = GroupId ;
		}
		
		
		/**
		*成员
		*/
		public String getMemberId()
		{
		
			 return _memberId; 
		}
		/**
		*成员
		*/
		public void  setMemberId (String  MemberId )
		{
			_memberId = MemberId ;
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
		*成员状态
		*/
		public String getState()
		{
		
			 return _state; 
		}
		/**
		*成员状态
		*/
		public void  setState (String  State )
		{
			_state = State ;
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
		
	
		
		
		
		public OfUser  getOfUser()
		{
		return _ofUser;
		}
		
		public void  setOfUser(OfUser  OfUser)
		{
		 _ofUser =OfUser;
		
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
     		public List< ChatAcceptInfo>  getChatAcceptInfos()
		{
		return _chatAcceptInfos;
		}
		
		public void  setChatAcceptInfos(List<ChatAcceptInfo>  ChatAcceptInfos)
		{
		 _chatAcceptInfos =ChatAcceptInfos;
		
		}
    }
 
	
		



