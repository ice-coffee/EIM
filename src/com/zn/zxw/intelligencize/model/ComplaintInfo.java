
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:��¼Ͷ����Ϣ��Ͷ���Ƿ�ɹ����Ƿ������
	*/
    public class ComplaintInfo implements Serializable
    {
        public ComplaintInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�߼����
		*/
		private String   _complaintId;//�߼����
		/**
		*Ͷ������
		*/
		private String   _communityId;//Ͷ������
		/**
		*Ͷ����
		*/
		private String   _userId;//Ͷ����
		/**
		*Ͷ������
		*/
		private String   _content;//Ͷ������
		/**
		*Ͷ������
		*/
		private String   _typeID;//Ͷ������
		/**
		*״̬
		*/
		private String   _state;//״̬
		/**
		*������
		*/
		private String   _result;//������
		/**
		*Ͷ��������
		*/
		private String   _describe;//Ͷ��������
		/**
		*Ԥ���ֶ�
		*/
		private String   _field;//Ԥ���ֶ�
		private  OfUser  _ofUser;
		private  CommunityInfo  _communityInfo;
		
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
		public String getComplaintId()
		{
		
			 return _complaintId; 
		}
		/**
		*�߼����
		*/
		public void  setComplaintId (String  ComplaintId )
		{
			_complaintId = ComplaintId ;
		}
		
		
		/**
		*Ͷ������
		*/
		public String getCommunityId()
		{
		
			 return _communityId; 
		}
		/**
		*Ͷ������
		*/
		public void  setCommunityId (String  CommunityId )
		{
			_communityId = CommunityId ;
		}
		
		
		/**
		*Ͷ����
		*/
		public String getUserId()
		{
		
			 return _userId; 
		}
		/**
		*Ͷ����
		*/
		public void  setUserId (String  UserId )
		{
			_userId = UserId ;
		}
		
		
		/**
		*Ͷ������
		*/
		public String getContent()
		{
		
			 return _content; 
		}
		/**
		*Ͷ������
		*/
		public void  setContent (String  Content )
		{
			_content = Content ;
		}
		
		
		/**
		*Ͷ������
		*/
		public String getTypeID()
		{
		
			 return _typeID; 
		}
		/**
		*Ͷ������
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
		*������
		*/
		public String getResult()
		{
		
			 return _result; 
		}
		/**
		*������
		*/
		public void  setResult (String  Result )
		{
			_result = Result ;
		}
		
		
		/**
		*Ͷ��������
		*/
		public String getDescribe()
		{
		
			 return _describe; 
		}
		/**
		*Ͷ��������
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
		
	
		
		
		
		public OfUser  getOfUser()
		{
		return _ofUser;
		}
		
		public void  setOfUser(OfUser  OfUser)
		{
		 _ofUser =OfUser;
		
		}
		
		public CommunityInfo  getCommunityInfo()
		{
		return _communityInfo;
		}
		
		public void  setCommunityInfo(CommunityInfo  CommunityInfo)
		{
		 _communityInfo =CommunityInfo;
		
		}
		
		
				//list FK
  }
 
	
		



