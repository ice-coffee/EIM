
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:��֯����������Ѱ��Ѱ�ﶼ�����������
	*/
    public class ActivitySchemeInfo implements Serializable
    {
        public ActivitySchemeInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�߼����
		*/
		private String   _activitySchemeId;//�߼����
		/**
		*�����
		*/
		private String   _communityId;//�����
		/**
		*������
		*/
		private String   _userId;//������
		/**
		*�����
		*/
		private String   _content;//�����
		/**
		*�����
		*/
		private String   _typeID;//�����
		/**
		*״̬
		*/
		private String   _state;//״̬
		/**
		*����
		*/
		private String   _result;//����
		/**
		*ͼƬ
		*/
		private String   _pictureId;//ͼƬ
		/**
		*������
		*/
		private String   _groupId;//������
		/**
		*����
		*/
		private String   _describe;//����
		/**
		*Ԥ���ֶ�
		*/
		private String   _field;//Ԥ���ֶ�
		private  TypeMenuInfo  _typeMenuInfo;
		private  OfUser  _ofUser;
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
		public String getActivitySchemeId()
		{
		
			 return _activitySchemeId; 
		}
		/**
		*�߼����
		*/
		public void  setActivitySchemeId (String  ActivitySchemeId )
		{
			_activitySchemeId = ActivitySchemeId ;
		}
		
		
		/**
		*�����
		*/
		public String getCommunityId()
		{
		
			 return _communityId; 
		}
		/**
		*�����
		*/
		public void  setCommunityId (String  CommunityId )
		{
			_communityId = CommunityId ;
		}
		
		
		/**
		*������
		*/
		public String getUserId()
		{
		
			 return _userId; 
		}
		/**
		*������
		*/
		public void  setUserId (String  UserId )
		{
			_userId = UserId ;
		}
		
		
		/**
		*�����
		*/
		public String getContent()
		{
		
			 return _content; 
		}
		/**
		*�����
		*/
		public void  setContent (String  Content )
		{
			_content = Content ;
		}
		
		
		/**
		*�����
		*/
		public String getTypeID()
		{
		
			 return _typeID; 
		}
		/**
		*�����
		*/
		public void  setTypeID (String  TypeID )
		{
			_typeID = TypeID ;
		}
		
		
		/**
		*״̬
		*/
		public String getState()
		{
		
			 return _state; 
		}
		/**
		*״̬
		*/
		public void  setState (String  State )
		{
			_state = State ;
		}
		
		
		/**
		*����
		*/
		public String getResult()
		{
		
			 return _result; 
		}
		/**
		*����
		*/
		public void  setResult (String  Result )
		{
			_result = Result ;
		}
		
		
		/**
		*ͼƬ
		*/
		public String getPictureId()
		{
		
			 return _pictureId; 
		}
		/**
		*ͼƬ
		*/
		public void  setPictureId (String  PictureId )
		{
			_pictureId = PictureId ;
		}
		
		
		/**
		*������
		*/
		public String getGroupId()
		{
		
			 return _groupId; 
		}
		/**
		*������
		*/
		public void  setGroupId (String  GroupId )
		{
			_groupId = GroupId ;
		}
		
		
		/**
		*����
		*/
		public String getDescribe()
		{
		
			 return _describe; 
		}
		/**
		*����
		*/
		public void  setDescribe (String  Describe )
		{
			_describe = Describe ;
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
 
	
		



