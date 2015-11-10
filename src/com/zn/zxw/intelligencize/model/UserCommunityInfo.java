
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*备注:用户与社区关联表
	*/
    public class UserCommunityInfo implements Serializable
    {
        public UserCommunityInfo()
        { }
		
		
		/**
		*编号
		*/
		private String   _id;//编号
		/**
		*社区编号
		*/
		private String   _communityId;//社区编号
		/**
		*用户编号
		*/
		private String   _userId;//用户编号
		/**
		*预留字段
		*/
		private String   _field;//预留字段
		private  OfUser  _ofUser;
		private  CommunityInfo  _communityInfo;
		
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
		*社区编号
		*/
		public String getCommunityId()
		{
		
			 return _communityId; 
		}
		/**
		*社区编号
		*/
		public void  setCommunityId (String  CommunityId )
		{
			_communityId = CommunityId ;
		}
		
		
		/**
		*用户编号
		*/
		public String getUserId()
		{
		
			 return _userId; 
		}
		/**
		*用户编号
		*/
		public void  setUserId (String  UserId )
		{
			_userId = UserId ;
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
 
	
		



