
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:�����û���������Ϣ����Ҫȷ�����г�Ա�����յ�
	*/
    public class ChatAcceptInfo implements Serializable
    {
        public ChatAcceptInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�߼����
		*/
		private String   _chatAcceptId;//�߼����
		/**
		*��ԱId
		*/
		private String   _memberId;//��ԱId
		/**
		*�������ݱ��
		*/
		private String   _contentId;//�������ݱ��
		/**
		*����ʱ��
		*/
		private String   _acceptDate;//����ʱ��
		/**
		*�Ƿ��յ�(0=��,1=��)
		*/
		private int   _ifAccept;//�Ƿ��յ�(0=��,1=��)
		/**
		*Ԥ���ֶ�
		*/
		private String   _field;//Ԥ���ֶ�
		private  ChatContentInfo  _chatContentInfo;
		private  ChatGroupMemberInfo  _chatGroupMemberInfo;
		
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
		public String getChatAcceptId()
		{
		
			 return _chatAcceptId; 
		}
		/**
		*�߼����
		*/
		public void  setChatAcceptId (String  ChatAcceptId )
		{
			_chatAcceptId = ChatAcceptId ;
		}
		
		
		/**
		*��ԱId
		*/
		public String getMemberId()
		{
		
			 return _memberId; 
		}
		/**
		*��ԱId
		*/
		public void  setMemberId (String  MemberId )
		{
			_memberId = MemberId ;
		}
		
		
		/**
		*�������ݱ��
		*/
		public String getContentId()
		{
		
			 return _contentId; 
		}
		/**
		*�������ݱ��
		*/
		public void  setContentId (String  ContentId )
		{
			_contentId = ContentId ;
		}
		
		
		/**
		*����ʱ��
		*/
		public String getAcceptDate()
		{
		
			 return _acceptDate; 
		}
		/**
		*����ʱ��
		*/
		public void  setAcceptDate (String  AcceptDate )
		{
			_acceptDate = AcceptDate ;
		}
		
		
		/**
		*�Ƿ��յ�(0=��,1=��)
		*/
		public int getIfAccept()
		{
		
			 return _ifAccept; 
		}
		/**
		*�Ƿ��յ�(0=��,1=��)
		*/
		public void  setIfAccept (int  IfAccept )
		{
			_ifAccept = IfAccept ;
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
 
	
		



