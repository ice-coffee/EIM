
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*备注:登录IP黑白名单
	*/
    public class UserIPApproveInfo implements Serializable
    {
        public UserIPApproveInfo()
        { }
		
		
		/**
		*编号
		*/
		private String   _id;//编号
		/**
		*认证用户
		*/
		private String   _userId;//认证用户
		/**
		*认证时间
		*/
		private String   _date;//认证时间
		/**
		*认证IP
		*/
		private String   _iP;//认证IP
		/**
		*黑白名单(0=黑名单，1=白名单)
		*/
		private int   _roll;//黑白名单(0=黑名单，1=白名单)
		/**
		*描述
		*/
		private String   _describe;//描述
		private  OfUser  _ofUser;
		
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
		*认证用户
		*/
		public String getUserId()
		{
		
			 return _userId; 
		}
		/**
		*认证用户
		*/
		public void  setUserId (String  UserId )
		{
			_userId = UserId ;
		}
		
		
		/**
		*认证时间
		*/
		public String getDate()
		{
		
			 return _date; 
		}
		/**
		*认证时间
		*/
		public void  setDate (String  Date )
		{
			_date = Date ;
		}
		
		
		/**
		*认证IP
		*/
		public String getIP()
		{
		
			 return _iP; 
		}
		/**
		*认证IP
		*/
		public void  setIP (String  IP )
		{
			_iP = IP ;
		}
		
		
		/**
		*黑白名单(0=黑名单，1=白名单)
		*/
		public int getRoll()
		{
		
			 return _roll; 
		}
		/**
		*黑白名单(0=黑名单，1=白名单)
		*/
		public void  setRoll (int  Roll )
		{
			_roll = Roll ;
		}
		
		
		/**
		*描述
		*/
		public String getDescribe()
		{
		
			 return _describe; 
		}
		/**
		*描述
		*/
		public void  setDescribe (String  Describe )
		{
			_describe = Describe ;
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
  }
 
	
		



