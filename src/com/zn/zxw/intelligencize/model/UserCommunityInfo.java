
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:�û�������������
	*/
    public class UserCommunityInfo implements Serializable
    {
        public UserCommunityInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�������
		*/
		private String   _communityId;//�������
		/**
		*�û����
		*/
		private String   _userId;//�û����
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
		*�������
		*/
		public String getCommunityId()
		{
		
			 return _communityId; 
		}
		/**
		*�������
		*/
		public void  setCommunityId (String  CommunityId )
		{
			_communityId = CommunityId ;
		}
		
		
		/**
		*�û����
		*/
		public String getUserId()
		{
		
			 return _userId; 
		}
		/**
		*�û����
		*/
		public void  setUserId (String  UserId )
		{
			_userId = UserId ;
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
 
	
		



