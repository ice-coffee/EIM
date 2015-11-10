
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*±¸×¢:ÓÃ»§µÇÂ¼¼ÇÂ¼±í
	*/
    public class UserLoginInfo implements Serializable
    {
        public UserLoginInfo()
        { }
		
		
		/**
		*±àºÅ
		*/
		private String   _id;//±àºÅ
		/**
		*Âß¼­±àºÅ
		*/
		private String   _userLoginId;//Âß¼­±àºÅ
		/**
		*µÇÂ¼ÓÃ»§
		*/
		private String   _userId;//µÇÂ¼ÓÃ»§
		/**
		*µÇÂ¼Ê±¼ä
		*/
		private String   _date;//µÇÂ¼Ê±¼ä
		/**
		*µÇÂ¼ip
		*/
		private String   _iP;//µÇÂ¼ip
		/**
		*ÃèÊö
		*/
		private String   _describe;//ÃèÊö
		private  OfUser  _ofUser;
		
		//list FK
		
		
		
		
		/**
		*±àºÅ
		*/
		public String getId()
		{
		
			 return _id; 
		}
		/**
		*±àºÅ
		*/
		public void  setId (String  Id )
		{
			_id = Id ;
		}
		
		
		/**
		*Âß¼­±àºÅ
		*/
		public String getUserLoginId()
		{
		
			 return _userLoginId; 
		}
		/**
		*Âß¼­±àºÅ
		*/
		public void  setUserLoginId (String  UserLoginId )
		{
			_userLoginId = UserLoginId ;
		}
		
		
		/**
		*µÇÂ¼ÓÃ»§
		*/
		public String getUserId()
		{
		
			 return _userId; 
		}
		/**
		*µÇÂ¼ÓÃ»§
		*/
		public void  setUserId (String  UserId )
		{
			_userId = UserId ;
		}
		
		
		/**
		*µÇÂ¼Ê±¼ä
		*/
		public String getDate()
		{
		
			 return _date; 
		}
		/**
		*µÇÂ¼Ê±¼ä
		*/
		public void  setDate (String  Date )
		{
			_date = Date ;
		}
		
		
		/**
		*µÇÂ¼ip
		*/
		public String getIP()
		{
		
			 return _iP; 
		}
		/**
		*µÇÂ¼ip
		*/
		public void  setIP (String  IP )
		{
			_iP = IP ;
		}
		
		
		/**
		*ÃèÊö
		*/
		public String getDescribe()
		{
		
			 return _describe; 
		}
		/**
		*ÃèÊö
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
 
	
		



