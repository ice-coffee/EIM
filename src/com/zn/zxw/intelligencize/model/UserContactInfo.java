
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:�û���ϵ��ʽ��ϸ��
	*/
    public class UserContactInfo implements Serializable
    {
        public UserContactInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�û����
		*/
		private String   _userId;//�û����
		/**
		*����
		*/
		private int   _order;//����
		/**
		*��ַ
		*/
		private String   _userAddress;//��ַ
		/**
		*�绰
		*/
		private String   _userTel;//�绰
		/**
		*����
		*/
		private String   _userName;//����
		/**
		*����
		*/
		private String   _describe;//����
		private  OfUser  _ofUser;
		
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
		*����
		*/
		public int getOrder()
		{
		
			 return _order; 
		}
		/**
		*����
		*/
		public void  setOrder (int  Order )
		{
			_order = Order ;
		}
		
		
		/**
		*��ַ
		*/
		public String getUserAddress()
		{
		
			 return _userAddress; 
		}
		/**
		*��ַ
		*/
		public void  setUserAddress (String  UserAddress )
		{
			_userAddress = UserAddress ;
		}
		
		
		/**
		*�绰
		*/
		public String getUserTel()
		{
		
			 return _userTel; 
		}
		/**
		*�绰
		*/
		public void  setUserTel (String  UserTel )
		{
			_userTel = UserTel ;
		}
		
		
		/**
		*����
		*/
		public String getUserName()
		{
		
			 return _userName; 
		}
		/**
		*����
		*/
		public void  setUserName (String  UserName )
		{
			_userName = UserName ;
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
 
	
		



