
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*备注:组内用户发出的信息，需要确认所有成员都已收到
	*/
    public class ChatAcceptInfo implements Serializable
    {
        public ChatAcceptInfo()
        { }
		
		
		/**
		*编号
		*/
		private String   _id;//编号
		/**
		*逻辑编号
		*/
		private String   _chatAcceptId;//逻辑编号
		/**
		*成员Id
		*/
		private String   _memberId;//成员Id
		/**
		*发送内容编号
		*/
		private String   _contentId;//发送内容编号
		/**
		*接收时间
		*/
		private String   _acceptDate;//接收时间
		/**
		*是否收到(0=否,1=是)
		*/
		private int   _ifAccept;//是否收到(0=否,1=是)
		/**
		*预留字段
		*/
		private String   _field;//预留字段
		private  ChatContentInfo  _chatContentInfo;
		private  ChatGroupMemberInfo  _chatGroupMemberInfo;
		
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
		*逻辑编号
		*/
		public String getChatAcceptId()
		{
		
			 return _chatAcceptId; 
		}
		/**
		*逻辑编号
		*/
		public void  setChatAcceptId (String  ChatAcceptId )
		{
			_chatAcceptId = ChatAcceptId ;
		}
		
		
		/**
		*成员Id
		*/
		public String getMemberId()
		{
		
			 return _memberId; 
		}
		/**
		*成员Id
		*/
		public void  setMemberId (String  MemberId )
		{
			_memberId = MemberId ;
		}
		
		
		/**
		*发送内容编号
		*/
		public String getContentId()
		{
		
			 return _contentId; 
		}
		/**
		*发送内容编号
		*/
		public void  setContentId (String  ContentId )
		{
			_contentId = ContentId ;
		}
		
		
		/**
		*接收时间
		*/
		public String getAcceptDate()
		{
		
			 return _acceptDate; 
		}
		/**
		*接收时间
		*/
		public void  setAcceptDate (String  AcceptDate )
		{
			_acceptDate = AcceptDate ;
		}
		
		
		/**
		*是否收到(0=否,1=是)
		*/
		public int getIfAccept()
		{
		
			 return _ifAccept; 
		}
		/**
		*是否收到(0=否,1=是)
		*/
		public void  setIfAccept (int  IfAccept )
		{
			_ifAccept = IfAccept ;
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
		
	
		
		
		
		public ChatContentInfo  getChatContentInfo()
		{
		return _chatContentInfo;
		}
		
		public void  setChatContentInfo(ChatContentInfo  ChatContentInfo)
		{
		 _chatContentInfo =ChatContentInfo;
		
		}
		
		public ChatGroupMemberInfo  getChatGroupMemberInfo()
		{
		return _chatGroupMemberInfo;
		}
		
		public void  setChatGroupMemberInfo(ChatGroupMemberInfo  ChatGroupMemberInfo)
		{
		 _chatGroupMemberInfo =ChatGroupMemberInfo;
		
		}
		
		
				//list FK
  }
 
	
		



