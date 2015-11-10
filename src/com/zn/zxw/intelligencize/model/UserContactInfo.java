
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*备注:用户联系方式明细表
	*/
    public class UserContactInfo implements Serializable
    {
        public UserContactInfo()
        { }
		
		
		/**
		*编号
		*/
		private String   _id;//编号
		/**
		*用户编号
		*/
		private String   _userId;//用户编号
		/**
		*排序
		*/
		private int   _order;//排序
		/**
		*地址
		*/
		private String   _userAddress;//地址
		/**
		*电话
		*/
		private String   _userTel;//电话
		/**
		*姓名
		*/
		private String   _userName;//姓名
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
		*排序
		*/
		public int getOrder()
		{
		
			 return _order; 
		}
		/**
		*排序
		*/
		public void  setOrder (int  Order )
		{
			_order = Order ;
		}
		
		
		/**
		*地址
		*/
		public String getUserAddress()
		{
		
			 return _userAddress; 
		}
		/**
		*地址
		*/
		public void  setUserAddress (String  UserAddress )
		{
			_userAddress = UserAddress ;
		}
		
		
		/**
		*电话
		*/
		public String getUserTel()
		{
		
			 return _userTel; 
		}
		/**
		*电话
		*/
		public void  setUserTel (String  UserTel )
		{
			_userTel = UserTel ;
		}
		
		
		/**
		*姓名
		*/
		public String getUserName()
		{
		
			 return _userName; 
		}
		/**
		*姓名
		*/
		public void  setUserName (String  UserName )
		{
			_userName = UserName ;
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
 
	
		



