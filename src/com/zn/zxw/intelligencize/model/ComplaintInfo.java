
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*备注:记录投诉信息，投诉是否成功，是否处理完成
	*/
    public class ComplaintInfo implements Serializable
    {
        public ComplaintInfo()
        { }
		
		
		/**
		*编号
		*/
		private String   _id;//编号
		/**
		*逻辑编号
		*/
		private String   _complaintId;//逻辑编号
		/**
		*投诉社区
		*/
		private String   _communityId;//投诉社区
		/**
		*投诉人
		*/
		private String   _userId;//投诉人
		/**
		*投诉内容
		*/
		private String   _content;//投诉内容
		/**
		*投诉类型
		*/
		private String   _typeID;//投诉类型
		/**
		*状态
		*/
		private String   _state;//状态
		/**
		*处理结果
		*/
		private String   _result;//处理结果
		/**
		*投诉人评语
		*/
		private String   _describe;//投诉人评语
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
		*逻辑编号
		*/
		public String getComplaintId()
		{
		
			 return _complaintId; 
		}
		/**
		*逻辑编号
		*/
		public void  setComplaintId (String  ComplaintId )
		{
			_complaintId = ComplaintId ;
		}
		
		
		/**
		*投诉社区
		*/
		public String getCommunityId()
		{
		
			 return _communityId; 
		}
		/**
		*投诉社区
		*/
		public void  setCommunityId (String  CommunityId )
		{
			_communityId = CommunityId ;
		}
		
		
		/**
		*投诉人
		*/
		public String getUserId()
		{
		
			 return _userId; 
		}
		/**
		*投诉人
		*/
		public void  setUserId (String  UserId )
		{
			_userId = UserId ;
		}
		
		
		/**
		*投诉内容
		*/
		public String getContent()
		{
		
			 return _content; 
		}
		/**
		*投诉内容
		*/
		public void  setContent (String  Content )
		{
			_content = Content ;
		}
		
		
		/**
		*投诉类型
		*/
		public String getTypeID()
		{
		
			 return _typeID; 
		}
		/**
		*投诉类型
		*/
		public void  setTypeID (String  TypeID )
		{
			_typeID = TypeID ;
		}
		
		
		/**
		*状态
		*/
		public String getState()
		{
		
			 return _state; 
		}
		/**
		*状态
		*/
		public void  setState (String  State )
		{
			_state = State ;
		}
		
		
		/**
		*处理结果
		*/
		public String getResult()
		{
		
			 return _result; 
		}
		/**
		*处理结果
		*/
		public void  setResult (String  Result )
		{
			_result = Result ;
		}
		
		
		/**
		*投诉人评语
		*/
		public String getDescribe()
		{
		
			 return _describe; 
		}
		/**
		*投诉人评语
		*/
		public void  setDescribe (String  Describe )
		{
			_describe = Describe ;
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
 
	
		



