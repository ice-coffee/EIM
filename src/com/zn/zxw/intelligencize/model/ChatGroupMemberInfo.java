
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:�û���������Щ�飬�ж��Ƿ���������Ϣ
	*/
    public class ChatGroupMemberInfo implements Serializable
    {
        public ChatGroupMemberInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�߼����
		*/
		private String   _chatGroupMemberId;//�߼����
		/**
		*������Id
		*/
		private String   _groupId;//������Id
		/**
		*��Ա
		*/
		private String   _memberId;//��Ա
		/**
		*������
		*/
		private String   _createUser;//������
		/**
		*��Ա״̬
		*/
		private String   _state;//��Ա״̬
		/**
		*Ԥ���ֶ�
		*/
		private String   _field;//Ԥ���ֶ�
		private  OfUser  _ofUser;
		private  ChatGroupInfo  _chatGroupInfo;
		
		//list FK
 private List<ChatAcceptInfo> _chatAcceptInfos;
		
		
		
		
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
		public String getChatGroupMemberId()
		{
		
			 return _chatGroupMemberId; 
		}
		/**
		*�߼����
		*/
		public void  setChatGroupMemberId (String  ChatGroupMemberId )
		{
			_chatGroupMemberId = ChatGroupMemberId ;
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
		*��Ա
		*/
		public String getMemberId()
		{
		
			 return _memberId; 
		}
		/**
		*��Ա
		*/
		public void  setMemberId (String  MemberId )
		{
			_memberId = MemberId ;
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
		*��Ա״̬
		*/
		public String getState()
		{
		
			 return _state; 
		}
		/**
		*��Ա״̬
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
 
	
		



